import dao.concrete.SkillDao;
import model.Skill;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SkillDaoTest {
    @Test
    public void testGetSingleSkill(){
        SkillDao skillDao = new SkillDao();
        Skill skill = skillDao.get(1);
        System.out.println(skill);
        assertNotEquals(null, skill);
    }
    @Test
    public void testCreateNewSkill(){
        Skill skill = new Skill(-1, "Scala");
        SkillDao skillDao = new SkillDao();
        int previousSize = skillDao.getAll().size();
        skillDao.create(skill);
        int newSize = skillDao.getAll().size();
        assertEquals(previousSize + 1, newSize);
    }
    @Test
    public void testUpdateSkill(){
        Skill skill = new Skill(5, "Kotlin");
        SkillDao skillDao = new SkillDao();
        skillDao.update(skill);
    }
    @Test
    public void testDeleteSkill(){
        SkillDao skillDao = new SkillDao();
        var skills = skillDao.getAll();
        int previousSize = skills.size();
        skillDao.delete(skills.get(skills.size()-1).getId());
        int newSize = skillDao.getAll().size();
        assertEquals(previousSize - 1, newSize);
    }
    @Test
    public void testGetAllSkills() {
        SkillDao skillDao = new SkillDao();
        List<Skill> countries = skillDao.getAll();
        System.out.println(countries);
    }
}
