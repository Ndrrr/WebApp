package dao.concrete;

import dao.abstrct.AbstractDao;
import model.EmploymentHistory;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmploymentHistoryDao extends AbstractDao<EmploymentHistory> {

    @Override
    protected EmploymentHistory getEntityByResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        int userId = rs.getInt("user_id");
        return new EmploymentHistory(id, header, beginDate, endDate, jobDescription, userId);
    }

    @Override
    protected PreparedStatement setPreparedStatementWithoutId(EmploymentHistory eh, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, eh.getHeader());
        stmt.setDate(2, eh.getBeginDate());
        stmt.setDate(3, eh.getEndDate());
        stmt.setString(4, eh.getJobDescription());
        stmt.setInt(5, eh.getUserId());
        return stmt;

    }

    @Override
    protected String[] getEntityFields() {
        return new String[]{
                "header",
                "begin_date",
                "end_date",
                "job_description",
                "user_id"
        };
    }

    @Override
    protected String getTableName() {
        return "employment_history";
    }
}
