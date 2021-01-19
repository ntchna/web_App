package application.controller.command.imp;


import application.controller.util.Pagination;
import application.model.entity.Order;
import application.model.exception.EmptyListException;
import application.model.exception.MySQLException;
import application.model.service.OrderService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewOrdersCommand extends AbstractCommand {
    private OrderService service;

    public ViewOrdersCommand() {
        this.service = new OrderService();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Order> orders = service.getAllOrders();
            new Pagination().configure(request, 3, "orders", orders);
        } catch (EmptyListException e) {
            setErrorRequest(request, response, e.getMessage(), "/login");
        } catch (MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), "/login");
        }
        return "/userOrders";
    }
}
