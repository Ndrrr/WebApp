package dao.concrete;

import dao.abstrct.AbstractDao;
import model.Skill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class SkillDao extends AbstractDao<Skill> {

    @Override
    protected Skill getEntityByResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Skill(id, name);
    }

    @Override
    protected PreparedStatement setPreparedStatementWithoutId(Skill s, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, s.getName());
        return stmt;
    }

    @Override
    protected String[] getEntityFields() {
        return new String[]{
                "name"
        };
    }

    @Override
    protected String getTableName() {
        return "skill";
    }
}
