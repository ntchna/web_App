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
        return newOrder +"Your order was completed!";
    }

    public List<Order> getAllOrders() throws EmptyListException, MySQLException {
        OrderDao dao = new OrderDao();
        List<Order> orders = dao.getAll();
        dao.closeConnection();
        if(orders == null|| orders.size()==0) throw new EmptyListException("No orders");
        return orders;
    }

    public Order getOrder(Integer userID) throws MySQLException {
        OrderDao dao = new OrderDao();
        Order order = dao.getByID(userID);
        if(order!=null){
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
        return order;
    }
   
}
