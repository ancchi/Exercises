package de.deutschepost.epost.addressRegister.main;

import de.deutschepost.epost.addressRegister.model.Address;
import de.deutschepost.epost.addressRegister.persistence.SearchDao;
import de.deutschepost.epost.addressRegister.persistence.ConnectionFactory;

import org.h2.tools.RunScript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class AddressRegisterApp {


        private AddressRegisterApp() throws SQLException, FileNotFoundException {

            ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
            final Connection connection = connectionFactory.getConnection();

            createSchema(connection);
            insertData(connection);

            /**
             * Testabfragen
             */

            Address address = new SearchDao().findById(1);
            System.out.println("\n" + address);

        }


        // TODO Start des Menues

//        Scanner keyReader = new Scanner(System.in);
//        Menue menue = new Menue();
//
//        while (true) {
//            menue.showMenue();
//            String input = keyReader.next();
//            menue.menueSelection(input);
//        }



    private void createSchema(Connection connection) throws FileNotFoundException, SQLException {
        final String ddlSqlLocation = getSqlFileLocation("sql/ddl.sql");
        System.out.println("Create DB Schema from: " + ddlSqlLocation);
        RunScript.execute(connection, new FileReader(ddlSqlLocation));
    }

    private void insertData(Connection connection) throws FileNotFoundException, SQLException {
        final String exampleSqlLocation = getSqlFileLocation("sql/example-data.sql");
        System.out.println("Inserting examles from: " + exampleSqlLocation);
        RunScript.execute(connection, new FileReader(exampleSqlLocation));
    }

    private String getSqlFileLocation(String sqlFile) {
        return Paths.get(currentDirectory(), sqlFile).toFile().getAbsolutePath();
    }

    private String currentDirectory() {
        return new File("").getAbsolutePath();

    }

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        new AddressRegisterApp();
    }

}
