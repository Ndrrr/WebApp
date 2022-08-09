package dao.abstrct;

import dao.abstrct.Dao;
import model.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T extends Entity> implements Dao<T> {
    protected abstract T getEntityByResultSet(ResultSet rs) throws SQLException;
    protected abstract PreparedStatement setPreparedStatementWithoutId(T obj, PreparedStatement stmt) throws SQLException;
    protected abstract String[] getEntityFields();
    protected abstract String getTableName();
    @Override
    public T get(int id) {
        if(id == 0) return null;
        try (Connection conn = Dao.connect()) {
            PreparedStatement stmt = conn.prepareStatement("select * from " + getTableName() + " where id = ? limit 1");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();
            return getEntityByResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        List <T> entities = new ArrayList<>();
        try(Connection conn = Dao.connect()) {
            Statement stmt = conn.createStatement();
            stmt.execute("select * from " + getTableName());
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                entities.add(getEntityByResultSet(rs));
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(T t) {
        try(Connection conn = Dao.connect()) {
            PreparedStatement stmt = conn.prepareStatement(buildInsertQuery());
            setPreparedStatementWithoutId(t, stmt);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T t) {
        try(Connection conn = Dao.connect()) {
            PreparedStatement stmt = conn.prepareStatement(buildUpdateQuery());
            setPreparedStatementWithoutId(t,stmt);
            stmt.setInt(getEntityFields().length + 1, t.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection conn = Dao.connect()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "Delete from " +getTableName() + " where id = ?");
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T t) {
        delete(t.getId());
    }
    private String buildInsertQuery(){
        StringBuilder res = new StringBuilder();
        res.append("insert into " + getTableName() + "(");
        for(String field : getEntityFields()){
            res.append(field);
            if(field != getEntityFields()[getEntityFields().length-1]){
                res.append(", ");
            }
        }
        res.append(") values (");
        for(int i = 0; i < getEntityFields().length - 1; i++){
            res.append("?, ");
        }
        res.append("?)");
        return res.toString();
    }

    private String buildUpdateQuery(){
        StringBuilder res = new StringBuilder();
        res.append("update " + getTableName() + " set ");
        for(String field : getEntityFields()){
            res.append(field + " = ?");
            if(field != getEntityFields()[getEntityFields().length-1]){
                res.append(", ");
            }
        }
        res.append(" where id = ?");
        return res.toString();
    }
}
