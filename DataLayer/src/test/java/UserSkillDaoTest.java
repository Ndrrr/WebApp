import dao.concrete.SkillDao;
import dao.concrete.UserDao;
import dao.concrete.UserSkillDao;
import model.UserSkill;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserSkillDaoTest {
    @Test
    public void testGetSingleUserSkill(){
        UserSkillDao userSkillDao = new UserSkillDao();
        UserSkill userSkill = userSkillDao.get(1);
        System.out.println(userSkill);
        assertNotEquals(null, userSkill);
    }
    @Test
    public void testCreateNewUserSkill(){
        UserDao userDao = new UserDao();
        SkillDao skillDao = new SkillDao();
        UserSkill userSkill = new UserSkill(-1, userDao.get(1), skillDao.get(1),8);
        UserSkillDao userSkillDao = new UserSkillDao();
        int previousSize = userSkillDao.getAll().size();
        userSkillDao.create(userSkill);
        int newSize = userSkillDao.getAll().size();
        assertEquals(previousSize + 1, newSize);
    }
    @Test
    public void testDeleteUserSkill(){
        UserSkillDao userSkillDao = new UserSkillDao();
        var userSkills = userSkillDao.getAll();
        int previousSize = userSkills.size();
        userSkillDao.delete(userSkills.get(userSkills.size()-1).getId());
        int newSize = userSkillDao.getAll().size();
        assertEquals(previousSize - 1, newSize);
    }
    @Test
    public void testUpdateUserSkill(){
        UserDao userDao = new UserDao();
        SkillDao skillDao = new SkillDao();
        UserSkill userSkill = new UserSkill(2, userDao.get(1), skillDao.get(1),8);
        UserSkillDao userSkillDao = new UserSkillDao();
        userSkillDao.update(userSkill);
    }
    @Test
    public void testGetAllUserSkills() {
        UserSkillDao userSkillDao = new UserSkillDao();
        List<UserSkill> userSkills = userSkillDao.getAll();
        System.out.println(userSkills);
    }
}
