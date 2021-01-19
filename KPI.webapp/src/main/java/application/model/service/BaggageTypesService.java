package application.model.service;

import application.model.dao.imp.BaggageTypeDao;
import application.model.entity.BaggageType;
import application.model.exception.EmptyListException;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchDirectionException;


import java.util.List;

public class BaggageTypesService {

    public List<BaggageType> allBaggageTypes() throws MySQLException, EmptyListException{
        BaggageTypeDao dao = new BaggageTypeDao();
        List<BaggageType> baggageTypes = dao.getAll();
        dao.closeConnection();
        if(baggageTypes == null|| baggageTypes.size()==0) throw new EmptyListException("No baggage types");
        //System.out.println(baggageTypes);
        return baggageTypes;
    }

    public BaggageType getByName(BaggageType baggageType) throws MySQLException {
        BaggageTypeDao dao = new BaggageTypeDao();
        BaggageType getBaggageType = dao.getByName(baggageType);
        if (getBaggageType == null)
            throw new NoSuchDirectionException();
        dao.closeConnection();
        //System.out.println(getBaggageType);
        return getBaggageType;
    }

    /*public static void main(String[] args) throws MySQLException {
        BaggageTypesService service = new BaggageTypesService();
        service.allBaggageTypes();
    }
    public static void main(String[] args) throws MySQLException {
        BaggageTypesService service = new BaggageTypesService();
        BaggageType getBT = new BaggageType("Документи");
        service.getByName(getBT);
    }*/


}
