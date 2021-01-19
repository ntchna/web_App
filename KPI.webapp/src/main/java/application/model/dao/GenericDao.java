package application.model.dao;

import application.model.exception.MySQLException;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, K> {

    void save(T t) throws MySQLException;

    T getByID(K k) throws MySQLException;

    T getByName(T t) throws MySQLException;

    T getByName(double name) throws MySQLException;

    T getByName(String name) throws MySQLException;

    List<T> getAll() throws MySQLException;

    void deleteById(K id);

    void update(T t);

    void close();


}