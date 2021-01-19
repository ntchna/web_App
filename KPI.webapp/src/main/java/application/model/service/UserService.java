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
        return "Your registration was completed!";
    }
}
