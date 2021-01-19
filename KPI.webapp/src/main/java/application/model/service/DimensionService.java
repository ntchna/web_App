package application.model.service;

import application.model.dao.imp.DimensionDao;
import application.model.entity.Dimension;
import application.model.exception.EmptyListException;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchDimensionException;

import java.util.List;

public class DimensionService {

    public List<Dimension> allDimencions() throws MySQLException, EmptyListException {
        DimensionDao dao = new DimensionDao();
        List<Dimension> dimensions = dao.getAll();
        dao.closeConnection();
        if(dimensions == null|| dimensions.size()==0) throw new EmptyListException("No dimensions");
        System.out.println(dimensions);
        return dimensions;
    }

    public Dimension getByTypeName(String name) throws MySQLException {
        DimensionDao dao = new DimensionDao();
        Dimension dimension = dao.getByName(name);
        if(dimension !=null){
            return dimension;}
        else throw new NoSuchDimensionException();
    }

    public Dimension getByDimName(double name) throws MySQLException {
        DimensionDao dao = new DimensionDao();
        Dimension dimension = dao.getByName(name);
        if(dimension !=null){
            return dimension;}
        else throw new NoSuchDimensionException();
    }
}
