package application.model.dao.imp;

import application.model.dao.JdbcDao;
import application.model.entity.BaggageType;
import application.model.exception.MySQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaggageTypeDao extends JdbcDao<BaggageType, Integer> {

    public BaggageTypeDao() throws MySQLException {
        super();
    }

    @Override
    public BaggageType getByName(double name) throws MySQLException {
        return null;
    }



    @Override
    public void save(BaggageType baggageType) throws MySQLException {

    }


    @Override
    public BaggageType getByID(Integer id) throws MySQLException {
        final String getBaggageTypeByTD = "SELECT type_id, type_name " +
                "FROM public.bagade_type " +
                "WHERE type_id = ?;";
        BaggageType getBaggageType = null;
        try(PreparedStatement ps = connection.prepareStatement(getBaggageTypeByTD)){
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                getBaggageType = new BaggageType(
                        resultSet.getInt("type_id"),
                        resultSet.getString("Type_name")
                );
            }}catch (SQLException e){
            throw new MySQLException();
        }
        System.out.println(getBaggageType);
        return getBaggageType;
    }

    @Override
    public BaggageType getByName(BaggageType baggageType) throws MySQLException {
        final String getBaggageTypeByName = "SELECT type_id, type_name " +
                "FROM public.bagade_type " +
                "WHERE type_name = ?;";
        BaggageType getBaggageType = null;
        try(PreparedStatement ps = connection.prepareStatement(getBaggageTypeByName)){
            ps.setString(1, baggageType.getName());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                getBaggageType = new BaggageType(
                        resultSet.getInt("type_id"),
                        resultSet.getString("Type_name")
                );
            }}catch (SQLException e){
            e.printStackTrace();
            //throw new MySQLException();
        }
        //System.out.println(getBaggageType);
        return getBaggageType;
    }

    @Override
    public BaggageType getByName(String name) throws MySQLException {
        return null;
    }

    @Override
    public List<BaggageType> getAll() throws MySQLException {
        String getAllBaggageType = "SELECT type_id, type_name " +
                "FROM public.bagade_type;";
        List<BaggageType> baggageTypes = new ArrayList<>();
        try( ResultSet resultSet = connection.createStatement().executeQuery(getAllBaggageType)){
            while (resultSet.next()) {
                baggageTypes.add(new BaggageType(
                        resultSet.getInt("type_id"),
                        resultSet.getString("type_name")
                ));
            }
        }catch (SQLException e){
            throw new MySQLException();
        }
        return baggageTypes;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(BaggageType baggageType) {

    }

    @Override
    public void close() {

    }
}
