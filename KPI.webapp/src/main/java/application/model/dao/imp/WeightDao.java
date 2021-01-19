package application.model.dao.imp;

import application.model.dao.JdbcDao;
import application.model.entity.Weight;
import application.model.exception.MySQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WeightDao extends JdbcDao<Weight, Integer> {
    public WeightDao() throws MySQLException {
        super();
    }


    @Override
    public void save(Weight weight) throws MySQLException {

    }

    @Override
    public Weight getByID(Integer integer) throws MySQLException {
        return null;
    }

    @Override
    public Weight getByName(Weight weight) throws MySQLException {
        return null;
    }

    @Override
    public Weight getByName(String name) throws MySQLException {
        Weight weight = null;
        String getByName = "SELECT weight, price_coef " +
                "FROM public.weight " +
                "WHERE weight = ?;";
        try(PreparedStatement ps = connection.prepareStatement(getByName)) {
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                weight = new Weight(
                        resultSet.getString("weight"),
                        resultSet.getDouble("price_coef")
                );
            }
        }catch (SQLException e){
            throw  new MySQLException();
        }
        //System.out.println(weight);
        return weight;
    }

    @Override
    public List<Weight> getAll() throws MySQLException {
        String getAllWeights = "SELECT weight, price_coef " +
                "FROM public.weight;";
        List<Weight> weights = new ArrayList<>();
        try( ResultSet resultSet = connection.createStatement().executeQuery(getAllWeights)){
            while (resultSet.next()) {
                weights.add(new Weight(
                        resultSet.getString("weight"),
                        resultSet.getDouble("price_coef")
                ));
            }
        }catch (SQLException e){
            throw new MySQLException();
        }
        //System.out.println(weights);
        return weights;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Weight weight) {

    }

    @Override
    public void close() {

    }

    @Override
    public Weight getByName(double name) throws MySQLException {
        return null;
    }
}
