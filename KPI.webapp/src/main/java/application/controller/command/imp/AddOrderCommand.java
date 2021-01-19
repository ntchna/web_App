package application.controller.command.imp;

import application.controller.util.Validator;
import application.model.entity.*;
import application.model.exception.MySQLException;
import application.model.exception.WrongInputException;
import application.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddOrderCommand extends AbstractCommand{
    private OrderService service;

    public AddOrderCommand(){
        this.service = new OrderService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addResult = null;
        try {
            Order order = getOrder(request);
            addResult = service.addOrder(order);
        } catch (WrongInputException e) {
            setErrorRequest(request, response, e.getMessage(), "/add");
        } catch (MySQLException e) {
            setErrorRequest(request, response, e.getMessage(), "/add");
        }
        return "/jsp/user/orders.jsp";
    }

    private Order getOrder(HttpServletRequest req) throws WrongInputException {
        Order order = null;
        String id = String.valueOf(req.getSession().getAttribute("id"));
        User user = new User(Integer.parseInt(id));
        BaggageType baggageType = new BaggageType(getBaggageType(req));
        Dimension dimension = new Dimension(getDimension(req));
        Weight weight = new Weight(getWeight(req));
        Direction direction = new Direction(getDirection(req));
        order = new Order(user,baggageType, dimension, weight, direction);
        return order;
    }

    private int getBaggageType(HttpServletRequest req) {
        int baggageType = 3;
        String[] baggageTypes = req.getParameterValues("baggageType");
        for (String c : baggageTypes) {
            if (!c.equals("none")) baggageType = Integer.parseInt(c);
        }
        return baggageType;
    }

    private int getDimension(HttpServletRequest req) {
        int dimension = 3;
        String[] dimensions = req.getParameterValues("dimension");
        for (String c : dimensions) {
            if (!c.equals("none")) dimension = Integer.parseInt(c);
        }
        return dimension;
    }

    private String getWeight(HttpServletRequest req) {
        String weight = "до 1 кг";
        String[] weights = req.getParameterValues("weight");
        for (String c : weights) {
            if (!c.equals("none")) weight = c;
        }
        return weight;
    }

    private String getDirection(HttpServletRequest req) {
        String direction = "Полтава";
        String[] directions = req.getParameterValues("direction");
        for (String c : directions) {
            if (!c.equals("none")) direction = c;
        }
        return direction;
    }
}
