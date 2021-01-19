package application.model.dao.imp;

import application.model.dao.JdbcDao;
import application.model.entity.Direction;
import application.model.exception.MySQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectionDao extends JdbcDao<Direction, Integer> {

    public DirectionDao() throws MySQLException {
        super();
    }

    @Override
    public Direction getByName(double name) throws MySQLException {
        return null;
    }


    @Override
    public void save(Direction direction) throws MySQLException {

    }

    @Override
    public Direction getByID(Integer integer) {
        return null;
    }

    @Override
    public Direction getByName(Direction direction) throws MySQLException {
        final String getDirectionByName = "SELECT dir, price " +
                "FROM public.direction " +
                "WHERE dir = ?;";
        Direction getDirection = null;
        try(PreparedStatement ps = connection.prepareStatement(getDirectionByName)){
            ps.setString(1, direction.getName());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                direction = new Direction(
                        resultSet.getString("dir"),
                        resultSet.getDouble("price")
                );
            }}catch (SQLException e){
            throw new MySQLException();
        }
        //System.out.println(direction);
        return direction;
    }


    @Override
    public Direction getByName(String name) throws MySQLException {
        final String getDirectionByName = "SELECT dir, price " +
                "FROM public.direction " +
                "WHERE dir = ?;";
        Direction direction = null;
        try(PreparedStatement ps = connection.prepareStatement(getDirectionByName)){
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                direction = new Direction(
                        resultSet.getString("dir"),
                        resultSet.getDouble("price")
                );
            }}catch (SQLException e){
            throw new MySQLException();
        }
        //System.out.println(direction);
        return direction;
    }

    @Override
    public List<Direction> getAll() throws MySQLException {
        String getAllDirections = "SELECT dir, price " +
                "FROM public.direction;";
        List<Direction> directions = new ArrayList<>();
        try( ResultSet resultSet = connection.createStatement().executeQuery(getAllDirections)){
            while (resultSet.next()) {
                directions.add(new Direction(
                        resultSet.getString("dir"),
                        resultSet.getDouble("price")
                ));
            }
        }catch (SQLException e){
            throw new MySQLException();
        }
        return directions;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Direction direction) {

    }

    @Override
    public void close() {

    }
}
