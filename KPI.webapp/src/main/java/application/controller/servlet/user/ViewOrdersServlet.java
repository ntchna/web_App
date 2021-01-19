package application.controller.servlet.user;


import application.controller.command.imp.LoginCommand;
import application.controller.command.imp.ViewOrdersCommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ViewUserOrdersServlet",urlPatterns = {"/userOrders"})
public class ViewOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ViewOrdersCommand command = new ViewOrdersCommand();
        String path = command.execute(req,resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/user/orders.jsp");
        requestDispatcher.forward(req, resp);
    }

}
