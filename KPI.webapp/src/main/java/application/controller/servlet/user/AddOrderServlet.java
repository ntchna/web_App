package application.controller.servlet.user;

import application.controller.command.Command;
import application.controller.command.imp.AbstractCommand;
import application.controller.command.imp.AddOrderCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddOrderServlet", urlPatterns = "/add")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher reqDisp = req.getRequestDispatcher("/jsp/user/addOrder.jsp");
        reqDisp.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AbstractCommand command = new AddOrderCommand();
        String path = command.execute(req, resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);

    }
}
