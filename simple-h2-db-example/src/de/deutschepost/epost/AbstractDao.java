package de.deutschepost.epost;

import java.sql.Connection;
import java.sql.SQLException;

abstract class AbstractDao<T> implements DataAccessObject<T> {  // wo wird hier das Generic genutzt?

    private ConnectionFactory connectionFactory;

    AbstractDao() {
        this.connectionFactory = ConnectionFactory.getInstance();
    } // wird doch schon im Konstruktor von TodoListApp aufgerufen ????

    public Connection getConnection(){
        try {
            return connectionFactory.getConnection(); // wird doch schon im Konstruktor von TodoListApp aufgerufen ???
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
