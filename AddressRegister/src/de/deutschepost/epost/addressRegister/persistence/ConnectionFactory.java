package de.deutschepost.epost.addressRegister.persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    static final private String driverClasseName = "org.h2.Driver";
    static final private String connectionUrl = "jdbc:h2:file:./work/AddressDB;FILE_LOCK=FS";
    static final private String dbUser = "sa";
    static final private String dbPwd = "";

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClasseName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        // Attempts to establish a connection to the given database URL
        return DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
