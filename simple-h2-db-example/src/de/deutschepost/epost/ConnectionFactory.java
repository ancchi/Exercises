package de.deutschepost.epost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    static final private String driverClassName = "org.h2.Driver";
    static final private String connectionUrl = "jdbc:h2:file:./work/TodoListDB;FILE_LOCK=FS";
    static final private String dbUser = "sa";
    static final private String dbPwd = "";

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
    }

    /**
     * wenn noch keine Instanz vorhanden ist, wird eine Instanz zurückgegeben???
     * d.h., immer wenn das Programm startet, wird eine neue Intanz erzeugt, sonst nicht???
     */

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
