package dao.concrete;

import dao.abstrct.AbstractDao;
import model.Country;

import java.sql.*;


public final class CountryDao extends AbstractDao<Country> {
    @Override
    protected Country getEntityByResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");
        String code = rs.getString("code");
        return new Country(id, name, nationality, code);
    }

    @Override
    protected PreparedStatement setPreparedStatementWithoutId(Country c, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getNationality());
        stmt.setString(3, c.getCode());
        return stmt;
    }

    @Override
    protected String[] getEntityFields() {
        return new String[]{
                "name",
                "nationality",
                "code"
        };
    }

    @Override
    protected String getTableName() {
        return "country";
    }
}
