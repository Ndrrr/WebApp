import dao.concrete.UserDao;
import model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserDaoTest {

    @Test
    public void testGetSingleUser(){
        UserDao userDao = new UserDao();
        User user = userDao.get(1);
        System.out.println(user);
        assertNotEquals(null, user);
    }
    @Test
    public void testCreateNewUser(){
        User user = new User("John", "Doe", "doejohn@gmail.com","0712345678");
        UserDao userDao = new UserDao();
        int previousSize = userDao.getAll().size();
        userDao.save(user);
        int newSize = userDao.getAll().size();
        assertEquals(previousSize + 1, newSize);
    }
    @Test
    public void testDeleteUser(){
        UserDao userDao = new UserDao();
        var users = userDao.getAll();
        int previousSize = users.size();
        userDao.delete(users.get(users.size()-1).getId());
        int newSize = userDao.getAll().size();
        assertEquals(previousSize - 1, newSize);
    }
    @Test
    public void testUpdateUser(){
        User user = new User("John", "Doe", "doejohn@gmail.com","0712345678");
        user.setAddress("Wild Rift");
        user.setId(3);
        UserDao userDao = new UserDao();
        userDao.update(user);
    }
    @Test
    public void testGetAllUsers() {
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAll();
        System.out.println(users);
    }
}
