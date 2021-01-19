package application.model.dao;

import application.model.dao.connection.NewConnectionPool;
import application.model.exception.MySQLException;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class JdbcDao<T, K> implements GenericDao<T, K> {protected NewConnectionPool connectionPool;
    {
        try {
            connectionPool = NewConnectionPool.getConnectionPool();
        } catch (SQLException e) {
            throw new MySQLException();
        }
    }
    protected Connection connection;

    protected JdbcDao() throws MySQLException{
        this.connection = connectionPool.getConnection();
    }

    public void closeConnection() {
        connectionPool.closeConnection(connection);
    }
}



