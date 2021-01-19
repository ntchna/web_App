package application.model.dao.imp;

import application.model.dao.JdbcDao;
import application.model.entity.User;
import application.model.exception.MySQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends JdbcDao<User, Integer> {

    public UserDao() throws MySQLException{super();}

    @Override
    public User getByName(double name) throws MySQLException {
        return null;
    }

    @Override
    public void save(User newUser) throws MySQLException{
        String addUser = "INSERT INTO public.users( " +
                " role_, username_, password_, name_, surname_, enable_)" +
                "VALUES ( ?, ?, ?, ?, ?, ?);";
        try(PreparedStatement ps = connection.prepareStatement(addUser)) {

            ps.setInt(1, 2);
            ps.setString(2, newUser.getUsername());
            ps.setString(3, newUser.getPassword());
            ps.setString(4, newUser.getName());
            ps.setString(5, newUser.getSurname());
            ps.setBoolean(6, true);
            ps.execute();
        }catch (SQLException e){
            throw new MySQLException();
        }
        //System.out.println(newUser);
    }

    @Override
    public User getByID(Integer integer) {
        return null;
    }

    @Override
    public User getByName(User unauthorizedUser) throws MySQLException {
                String findByUsername = "SELECT user_id, role_, username_, password_, name_, surname_, enable_ " +
                        "FROM public.users " +
                        "WHERE username_ = ?";
        User user = null;
        try(PreparedStatement ps = connection.prepareStatement(findByUsername)) {
            ps.setString(1, unauthorizedUser.getUsername());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("role_"),
                        resultSet.getString("username_"),
                        resultSet.getString("password_"),
                        resultSet.getString("name_"),
                        resultSet.getString("surname_"),
                        resultSet.getBoolean("enable_")
                );
            }
        }catch (SQLException e){
            throw new MySQLException();
        }

        return user;
    }

    @Override
    public User getByName(String name) throws MySQLException {
        String findByUsername = "SELECT user_id, role_, username_, password_, name_, surname_, enable_ " +
                "FROM public.users " +
                "WHERE username_ = ?";
        User user = null;
        try(PreparedStatement ps = connection.prepareStatement(findByUsername)) {
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("role_"),
                        resultSet.getString("username_"),
                        resultSet.getString("password_"),
                        resultSet.getString("name_"),
                        resultSet.getString("surname_"),
                        resultSet.getBoolean("enable_")
                );
            }
        }catch (SQLException e){
            throw new MySQLException();
        }

        return user;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void close() {

    }
}
