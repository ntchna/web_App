package application.model.service;

import application.model.dao.imp.UserDao;
import application.model.entity.User;
import application.model.exception.*;

public class UserService {
    public User login(User unauthorizedUser) throws NoAccountException, InvalidPasswordException, BlockedUserException, MySQLException {
        UserDao dao = new UserDao();
        User user = dao.getByName(unauthorizedUser);
        if (user == null)
            throw new NoAccountException();
        else if (!user.getPassword().equals(unauthorizedUser.getPassword()))
            throw new InvalidPasswordException();
        else if (!user.isEnable()) throw new BlockedUserException();
        dao.closeConnection();
        System.out.println(user);
        return user;
    }

    public String registration(User newUser) throws BookedUsernameException, MySQLException {
        UserDao dao = new UserDao();
        User user = dao.getByName(newUser);
        if (user == null) {
            dao.save(newUser);
            dao.closeConnection();
        } else
            throw new BookedUsernameException("User with such username already exists");

        System.out.println(newUser);
        return "Your registration was completed!";
    }

    /*public User findByName(String username) throws NoSuchUserException, MySQLException {
        UserDao userDao = new UserDao();
        User user = userDao.getByName(username);
        userDao.closeConnection();
        if (user!= null && user.getUsername().equals(username))
            return user;
        else throw new NoSuchUserException("User with such username doesn`t exist");
    }

    public static void main(String[] args) throws MySQLException {
        UserService service = new UserService();
        User newuser = new User("admin1", "admin1");
        service.login(newuser);
    }
    public static void main(String[] args) throws MySQLException {
        UserService service = new UserService();
        User newuser = new User("user2", "user2", "serg", "Bortnyk");
        service.registration(newuser);
    }*/
}