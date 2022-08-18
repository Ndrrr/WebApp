package dao.abstrct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/resumeappdb";
        String username = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    T get(Integer id);
    List<T> getAll();
    void create(T t);
    void update(T t);

    void delete(Integer id);
    void delete(T t);

}
