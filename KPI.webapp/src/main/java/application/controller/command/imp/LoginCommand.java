
package application.controller.command.imp;

import application.model.entity.User;
import application.model.exception.BlockedUserException;
import application.model.exception.InvalidPasswordException;
import application.model.exception.MySQLException;
import application.model.exception.NoAccountException;
import application.model.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand extends AbstractCommand {
    private UserService service;

    public LoginCommand() {
        service = new UserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = null;
        try {
            User user = service.login(getUserData(request));
            session = request.getSession(true);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("id", user.getId());
            session.setAttribute("role", user.getRole());
        } catch (NoAccountException | InvalidPasswordException | BlockedUserException | MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), "/KPI_webapp_war/login");
        }
        return "/KPI_webapp_war/add";
    }

    private User getUserData(HttpServletRequest req) {
        String username = req.getParameter("user_name");
        String password = req.getParameter("password");
        return new User(username, password);
    }



}
