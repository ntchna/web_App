package application.model.dao.imp;

import application.model.dao.JdbcDao;
import application.model.entity.BaggageType;
import application.model.entity.Dimension;
import application.model.exception.MySQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DimensionDao extends JdbcDao<Dimension, Integer> {

    public DimensionDao() throws MySQLException {
        super();
    }

    @Override
    public void save(Dimension dimension) throws MySQLException {

    }


    @Override
    public Dimension getByID(Integer integer) {
        return null;
    }

    @Override
    public Dimension getByName(Dimension dimension) throws MySQLException {
        return null;
    }

    @Override
    public Dimension getByName(String name) throws MySQLException {
        Dimension dimension = null;
        String getByTypeName = "SELECT *" +
                "FROM public.dimencion " +
                "INNER JOIN public.bagade_type ON dimencion.bt_id = bagade_type.type_id " +
                "WHERE type_name = ?;";
        try(PreparedStatement ps = connection.prepareStatement(getByTypeName)) {
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                dimension = new Dimension(
                        resultSet.getInt("dim_id"),
                        new BaggageType(resultSet.getString("type_name")),
                        resultSet.getDouble("dim_name"),
                        resultSet.getDouble("price")
                );
            }
        }catch (SQLException e){
            throw  new MySQLException();
        }
        System.out.println(dimension);
        return dimension;
    }

    @Override
    public Dimension getByName(double name) throws MySQLException {
        Dimension dimension = null;
        String getByDIMName = "SELECT *" +
                "FROM public.dimencion " +
                "INNER JOIN public.bagade_type ON dimencion.bt_id = bagade_type.type_id " +
                "WHERE dim_name = ?;";
        try(PreparedStatement ps = connection.prepareStatement(getByDIMName)) {
            ps.setDouble(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                dimension = new Dimension(
                        resultSet.getInt("dim_id"),
                        new BaggageType(resultSet.getString("type_name")),
                        resultSet.getDouble("dim_name"),
                        resultSet.getDouble("price")
                );
            }
        }catch (SQLException e){
            throw  new MySQLException();
        }
        //System.out.println(dimension);
        return dimension;
    }

    @Override
    public List<Dimension> getAll() throws MySQLException {
        String getAllDimebcion = "SELECT * " +
                "FROM dimencion " +
                "INNER JOIN bagade_type ON dimencion.bt_id = bagade_type.type_id;";
        List<Dimension> dimensions = new ArrayList<>();
        try( ResultSet resultSet = connection.createStatement().executeQuery(getAllDimebcion)){
            while (resultSet.next()) {
                dimensions.add(new Dimension(
                        resultSet.getInt("dim_id"),
                        new BaggageType(resultSet.getString("type_name")),
                        resultSet.getDouble("dim_name"),
                        resultSet.getDouble("price")
                ));
            }
        }catch (SQLException e){
            throw new MySQLException();
        }

        return dimensions;

    }



    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Dimension dimension) {

    }

    @Override
    public void close() {

    }
}
