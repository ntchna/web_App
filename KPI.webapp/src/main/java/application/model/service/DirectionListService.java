package application.model.service;

import application.model.dao.imp.DirectionDao;
import application.model.entity.Direction;
import application.model.exception.*;
import java.util.List;


public class DirectionListService {

    public List<Direction> allDirectionsList() throws MySQLException, EmptyListException {
        DirectionDao dao = new DirectionDao();
        List<Direction> directions = dao.getAll();
        dao.closeConnection();
        if(directions == null|| directions.size()==0) throw new EmptyListException("No directions");
        System.out.println(directions);
        return directions;
    }

    public Direction getByName(String name) throws MySQLException, NoSuchDirectionException {
        DirectionDao dao = new DirectionDao();
        Direction direction = dao.getByName(name);
        if (direction == null)
            throw new NoSuchDirectionException();
        dao.closeConnection();
        //System.out.println(direction);
        return direction;
    }

    public Direction getByName(Direction direction) throws MySQLException {
        DirectionDao dao = new DirectionDao();
        Direction getDirection = dao.getByName(direction);
        if (getDirection == null)
            throw new NoSuchDirectionException();
        dao.closeConnection();
        //System.out.println(getDirection);
        return getDirection;
    }

    /*public static void main(String[] args) throws MySQLException {
        DirectionListService service = new DirectionListService();
        Direction getDirection = new Direction("Одеса");
        service.getByName(getDirection);
    }*/
}
