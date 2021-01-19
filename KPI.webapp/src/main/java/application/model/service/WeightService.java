package application.model.service;

import application.model.dao.imp.WeightDao;
import application.model.entity.Weight;
import application.model.exception.EmptyListException;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchDimensionException;

import java.util.List;

public class WeightService {

    public List<Weight> getAllWaights() throws MySQLException {
        WeightDao dao = new WeightDao();
        List<Weight> weights = dao.getAll();
        dao.closeConnection();
        if(weights == null|| weights.size()==0) throw new EmptyListException("No weights");
        System.out.println(weights);
        return weights;
    }

    public Weight getByName(String name) throws MySQLException {
        WeightDao dao = new WeightDao();
        Weight weight = dao.getByName(name);
        if(weight!=null){
            //System.out.println(weight);
            return  weight;}
        else throw new NoSuchDimensionException();
    }

    /* public static void main(String[] args) throws MySQLException {
        WeightService service = new WeightService();
        service.getAllWaights();
    }
    public static void main(String[] args) throws MySQLException {
        WeightService service = new WeightService();
        Weight weight = new Weight("до 1 кг");
        service.getByName(weight.getName());
    }*/
}
