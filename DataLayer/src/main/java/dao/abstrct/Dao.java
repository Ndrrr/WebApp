package dao.abstrct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    static Connection connect() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/resumeappdb";
        String username = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    T get(int id);
    List<T> getAll();
    void save(T t);
    void update(T t);

    void delete(int id);
    void delete(T t);


}
