package application.controller.command.imp;

import application.model.entity.User;
import application.model.exception.BookedUsernameException;
import application.model.exception.InvalidPasswordException;
import application.model.exception.MySQLException;
import application.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.validation.Validator;
import java.io.IOException;

public class RegisterCommand extends AbstractCommand{
    private UserService service;
    public RegisterCommand(){this.service = new UserService();}

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registerResult = null;
        try {
            //application.controller.util.Validator.checkUsername(request);
            //application.controller.util.Validator.checkPassword(request);
            registerResult = service.registration(getUserData(request));
        } catch (BookedUsernameException | InvalidPasswordException e) {
            setErrorRequest(request, response, e.getMessage(), "/KPI_webapp_war/register");
        } catch (MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), "/KPI_webapp_war/register");
        }
        return "/KPI_webapp_war/userOrders";
    }

    private User getUserData(HttpServletRequest req) {
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        return new User(username, password, name, surname);
    }
}
