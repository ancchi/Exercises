package de.deutschepost.epost.servlet.persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {

    String h2DBPath;
    public ConnectionFactory(String h2DBPath) {
        try {
            Class.forName(driverClasseName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.h2DBPath = h2DBPath;
        connectionUrl = "jdbc:h2:" + h2DBPath +";";
    }



    static final private String driverClasseName = "org.h2.Driver"; //
//    static final private String connectionUrl = "jdbc:h2:file:./work/AddressDB;FILE_LOCK=FS";
//    final private String connectionUrl = "jdbc:h2:/Users/afischer/IdeaProjects/Uebungen/simple-servlet-example/out/artifacts/address_servlet/WEB-INF/database/ADdressDB;";
//final private String connectionUrl = "jdbc:h2:" + h2DBPath + ";";
        final private String connectionUrl;

    static final private String dbUser = "sa";
    static final private String dbPwd = "";

    private static ConnectionFactory connectionFactory = null;  // Singleton


//
//    private ConnectionFactory() {
//        try {
//            Class.forName(driverClasseName);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public Connection getConnection() throws SQLException {
        // Attempts to establish a connection to the given database URL
        return DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
    }

    public static ConnectionFactory getInstance(String h2DBPath) { // Übergabe des Pfads als Parameter nicht möglich, weil static

        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory(h2DBPath);
        }
        return connectionFactory; // damit wird sichergestellt, dass immer dieselbe Instanz verwendet wird
    }
}
