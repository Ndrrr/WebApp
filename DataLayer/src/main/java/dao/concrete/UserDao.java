package dao.concrete;

import dao.abstrct.AbstractDao;
import model.Country;
import model.User;

import java.sql.*;

public final class UserDao extends AbstractDao<User> {
    @Override
    protected User getEntityByResultSet(ResultSet rs) throws SQLException {
        CountryDao countryDao =  new CountryDao();
        int userId = rs.getInt("id");
        String password = rs.getString("password");
        String firstName = rs.getString("name");
        String lastName = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDescription = rs.getString("profile_description");
        String address = rs.getString("address");
        Date birthDate = rs.getDate("birthDate");
        int country_id = rs.getInt("birthplace_id");
        int nationality_id = rs.getInt("nationality_id");
        Country birthplace = countryDao.get(country_id);
        Country nationality = countryDao.get(nationality_id);
        return new User(userId,password,firstName,lastName,email,phone,profileDescription,address,birthDate,birthplace,nationality);
    }

    @Override
    protected String getTableName() {
        return "user";
    }

    @Override
    protected PreparedStatement setPreparedStatementWithoutId(User u, PreparedStatement stmt) throws SQLException{
        Country brthplc = u.getBirthplace();
        Country nationality = u.getNationality();
        stmt.setString(1, u.getPassword());
        stmt.setString(2, u.getName());
        stmt.setString(3, u.getSurname());
        stmt.setString(4, u.getEmail());
        stmt.setString(5, u.getPhone());
        stmt.setString(6, u.getProfileDescription());
        stmt.setString(7, u.getAddress());
        stmt.setDate(8, u.getBirthDate());
        stmt.setObject(9, brthplc!=null ? u.getBirthplace().getId() : null);
        stmt.setObject(10, nationality!=null ? u.getNationality().getId() : null);
        return stmt;
    }

    protected String[] getEntityFields(){
        return new String[]{
                "password", "name", "surname", "email", "phone", "profile_description", "address", "birthDate", "birthplace_id", "nationality_id"
        };
    }

}