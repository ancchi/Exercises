package de.deutschepost.epost.servlet.persistence;

import de.deutschepost.epost.servlet.servlets.SimpleServlet;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * implementiert DataAccessObject<T>
 *     stellt eine Verbindung zur Datenbank her
 */
abstract public class AbstractDao<T> implements DataAccessObject<T> {

    private ConnectionFactory connectionFactory;

//    AbstractDao() {
//        this.connectionFactory = ConnectionFactory.getInstance("ling");
//    }

    public Connection getConnection() {  // Vorschlag von IntelliJ anstat try-catch
        try {
            return connectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
}
