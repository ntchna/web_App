package application.model.service;

import application.model.dao.imp.DimensionDao;
import application.model.dao.imp.DirectionDao;
import application.model.dao.imp.OrderDao;
import application.model.dao.imp.WeightDao;
import application.model.entity.*;
import application.model.exception.*;

import java.util.List;


public class OrderService {

    public String addOrder(Order newOrder) throws BookedUsernameException, MySQLException {
        OrderDao dao = new OrderDao();
        dao.save(newOrder);
        dao.closeConnection();
        System.out.println(newOrder);
        return newOrder +"Your order was completed!";
    }

    public List<Order> getAllOrders() throws EmptyListException, MySQLException {
        OrderDao dao = new OrderDao();
        List<Order> orders = dao.getAll();
        dao.closeConnection();
        System.out.println(orders);
        if(orders == null|| orders.size()==0) throw new EmptyListException("No orders");
        return orders;
    }

    public Order getOrder(Integer userID) throws MySQLException {
        OrderDao dao = new OrderDao();
        Order order = dao.getByID(userID);
        if(order!=null){
            System.out.println(order);
            return order;}
        else throw new NoSuchOrderException();
    }

    public Order calculate(Order order) throws MySQLException {
        DirectionDao directionDao = new DirectionDao();
        Direction direction = directionDao.getByName(order.getDirection());
        DimensionDao dimensionDao = new DimensionDao();
        Dimension dimension = dimensionDao.getByName(order.getDimencionID().getName());
        WeightDao weightDao = new WeightDao();
        Weight weight = weightDao.getByName(order.getWeight().getName());
        double amount = direction.getPrice()+(direction.getPrice()* dimension.getPrice())+(direction.getPrice()*weight.getPrice());
        System.out.println(direction.getPrice());
        System.out.println(dimension.getPrice());
        System.out.println(weight.getPrice());
        System.out.println(amount);
        return order;
    }
    /*
    public static void main(String[] args) throws MySQLException {
        OrderService service = new OrderService();
        service.getAllOrders();

    }

    public static void main(String[] args) throws MySQLException {
        OrderService service = new OrderService();
        service.getOrder(1);}

    public static void main(String[] args) throws MySQLException {
        OrderService service = new OrderService();
        service.calculate(service.getOrder(1));
    }

    public static void main(String[] args) throws MySQLException {
        OrderService service = new OrderService();
        User user = new User(4);
        BaggageType baggageType = new BaggageType(2);
        Dimension dimencion = new Dimension(2.4);
        Weight weight = new Weight("до 2.5 кг");
        Direction direction = new Direction("Одеса");
        Order order = new Order(user, baggageType, dimencion, weight, direction);
        service.addOrder(order);
        OrderDao dao = new OrderDao();
        Order orderdao = dao.getByID(2);
    }*/
}
