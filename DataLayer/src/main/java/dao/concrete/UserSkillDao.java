package dao.concrete;

import dao.abstrct.AbstractDao;
import model.UserSkill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSkillDao extends AbstractDao<UserSkill> {
    @Override
    protected UserSkill getEntityByResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int userId = rs.getInt("user_id");
        int skillId = rs.getInt("skill_id");
        int power = rs.getInt("power");
        UserDao userDao = new UserDao();
        SkillDao skillDao = new SkillDao();
        return new UserSkill(id, userDao.get(userId), skillDao.get(skillId), power);
    }

    @Override
    protected PreparedStatement setPreparedStatementWithoutId(UserSkill obj, PreparedStatement stmt) throws SQLException {
        stmt.setInt(1, obj.getUser().getId());
        stmt.setInt(2, obj.getSkill().getId());
        stmt.setInt(3, obj.getPower());
        return stmt;
    }

    @Override
    protected String[] getEntityFields() {
        return new String[]{
                "user_id",
                "skill_id",
                "power"
        };
    }

    @Override
    protected String getTableName() {
        return "user_skill";
    }
}
