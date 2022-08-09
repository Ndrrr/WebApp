import dao.concrete.EmploymentHistoryDao;
import model.EmploymentHistory;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EmploymentHistoryDaoTest {
    @Test
    public void testGetSingleEmploymentHistory(){
        EmploymentHistoryDao employmentHistoryDao = new EmploymentHistoryDao();
        EmploymentHistory employmentHistory = employmentHistoryDao.get(1);
        System.out.println(employmentHistory);
        assertNotEquals(null, employmentHistory);
    }
    @Test
    public void testCreateNewEmploymentHistory(){
        EmploymentHistory employmentHistory = new EmploymentHistory(-1, "Google", Date.valueOf( "2019-01-01"), Date.valueOf( "2019-01-01"), "Software Engineer", 1);
        EmploymentHistoryDao employmentHistoryDao = new EmploymentHistoryDao();
        int previousSize = employmentHistoryDao.getAll().size();
        employmentHistoryDao.save(employmentHistory);
        int newSize = employmentHistoryDao.getAll().size();
        assertEquals(previousSize + 1, newSize);
    }
    @Test
    public void testDeleteEmploymentHistory(){
        EmploymentHistoryDao employmentHistoryDao = new EmploymentHistoryDao();
        var employmentHistories = employmentHistoryDao.getAll();
        int previousSize = employmentHistories.size();
        employmentHistoryDao.delete(employmentHistories.get(employmentHistories.size()-1).getId());
        int newSize = employmentHistoryDao.getAll().size();
        assertEquals(previousSize - 1, newSize);
    }
    @Test
    public void testUpdateEmploymentHistory(){
        EmploymentHistory employmentHistory = new EmploymentHistory(2, "Google", Date.valueOf( "2019-01-01"), Date.valueOf( "2019-01-01"), "Software Engineer", 1);
        EmploymentHistoryDao employmentHistoryDao = new EmploymentHistoryDao();
        employmentHistoryDao.update(employmentHistory);
    }
    @Test
    public void testGetAllEmploymentHistories() {
        EmploymentHistoryDao employmentHistoryDao = new EmploymentHistoryDao();
        List<EmploymentHistory> employmentHistories = employmentHistoryDao.getAll();
        System.out.println(employmentHistories);
    }
}
