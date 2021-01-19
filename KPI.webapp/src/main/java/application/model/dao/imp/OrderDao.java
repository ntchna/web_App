package application.model.dao.imp;

import application.model.dao.JdbcDao;
import application.model.entity.*;
import application.model.exception.MySQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends JdbcDao<Order, Integer> {


    public OrderDao() throws MySQLException {
        super();
    }

    @Override
    public Order getByName(double name) throws MySQLException {
        return null;
    }

    @Override
    public void save(Order order) throws MySQLException {
        String addOrder = "INSERT INTO public.order_( " +
                " user_id, type_, dim_id, weight_, direction, day_of_receiving) " +
                "VALUES ( ?, ?, ?, ?, ?, ?);";
        try(PreparedStatement ps = connection.prepareStatement(addOrder)) {
            ps.setInt(1, order.getUserID().getId());
            ps.setInt(2, order.getTypeID().getId());
            ps.setDouble(3, order.getDimencionID().getName());
            ps.setString(4, order.getWeight().getName());
            ps.setString(5, order.getDirection().getName());
            ps.setDate(6, new Date(new java.util.Date().getTime()));
            ps.execute();
        }catch (SQLException e){
            throw new MySQLException();
        }

    }



    @Override
    public Order getByID(Integer id) throws MySQLException {
        String findByID = "SELECT order_id, username_, type_name, dim_name, weight, dir, day_of_receiving " +
                "                FROM order_ " +
                "                INNER JOIN users ON users.user_id = order_.user_id " +
                "                INNER JOIN bagade_type ON bagade_type.type_id = order_.type_ " +
                "                INNER JOIN dimencion ON dimencion.dim_id = order_.dim_id " +
                "                INNER JOIN weight ON weight.weight = order_.weight_ " +
                "                INNER JOIN direction ON direction.dir = order_.direction " +
                "WHERE users.user_id=?;";
        Order order = null;
        try(PreparedStatement ps = connection.prepareStatement(findByID)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                order = new Order(
                        resultSet.getInt("order_id"),
                        new User(resultSet.getString("username_")),
                        new BaggageType(resultSet.getString("type_name")),
                        new Dimension(resultSet.getDouble("dim_name")),
                        new Weight(resultSet.getString("weight")),
                        new Direction(resultSet.getString("dir")),
                        resultSet.getDate("day_of_receiving")
                );
            }
        }catch (SQLException e){
            throw new MySQLException();
        }

        return order;
    }

    @Override
    public Order getByName(Order order) {
        return null;
    }

    @Override
    public Order getByName(String name) throws MySQLException {
        return null;
    }

    @Override
    public List<Order> getAll()  {
        String findAllOrders = "SELECT * " +
                "FROM public.order_ " +
                "INNER JOIN users ON users.user_id = order_.user_id " +
                "INNER JOIN bagade_type ON bagade_type.type_id = order_.type_ " +
                "INNER JOIN dimencion ON dimencion.dim_id = order_.dim_id " +
                "INNER JOIN weight ON weight.weight = order_.weight_ " +
                "INNER JOIN direction ON direction.dir = order_.direction";
        List<Order> orders = new ArrayList<>();

        try{
            PreparedStatement ps = connection.prepareStatement(findAllOrders);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getInt("order_id"),
                        new User(resultSet.getString("username_")),
                        new BaggageType(resultSet.getString("type_name")),
                        new Dimension(resultSet.getDouble("dim_name")),
                        new Weight(resultSet.getString("weight")),
                        new Direction(resultSet.getString("dir")),
                        resultSet.getDate("day_of_receiving")

                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
            //throw new MySQLException();
        }
        return orders;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void close() {

    }
}
