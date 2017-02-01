package de.deutschepost.epost.addressRegister.main;

import de.deutschepost.epost.addressRegister.menue.Menue;
import de.deutschepost.epost.addressRegister.persistence.ConnectionFactory;

import org.h2.tools.RunScript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

public class AddressRegisterApp {



        public AddressRegisterApp() throws SQLException, FileNotFoundException {

            ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
            final Connection connection = connectionFactory.getConnection();

            createSchema(connection);
            insertData(connection);

            // TODO Start des Menues
            Menue menue = new Menue();
            menue.menueStart();

//            Scanner keyReader = new Scanner(System.in);
//            Menue menue = new Menue();
//
//            while (true) {
//                menue.showMenue();
//                String input = keyReader.next();
//                menue.menueSelection(input);
//            }


            /**
             * Testabfragen
             */

//            // find by ID  - DONE
//            final Address addressByID = new SearchDao().findById(2);
//            System.out.println("\n" + addressByID);
//            System.out.println(addressByID.getLastName() + ", " + addressByID.getPrename());
//
//            // save Input - DONE
//
//            final Address addressToSave  = new Address("Luise", "Liszt", "Listenstrasse", "44a", "DE45634", "Listenburg");
//            final SearchDao searchDao = new SearchDao();
//            searchDao.save(addressToSave);
//
//            // update - DONE
//            final Address newAddress = new Address(3, "Horsti", "Franz", "Neuestraße", "89c", "DE45897", "Neustadt");
//            final SearchDao searchDao1 = new SearchDao();
//            searchDao1.update(newAddress);
//
//            // delete - DONE
//            new SearchDao().delete(6);
//
//
//            // global Search in the tables
//            String term = "au";
//            List<Address> globalHits = new SearchDao().search(term);
//            System.out.println("\n\nGlobale Suche nach " + term);
//            for(Address hit : globalHits) {
//                System.out.println(hit);
//            }
//
//
//            // find all - DONE
//            final List<Address> addressList = new SearchDao().findAll();
//            System.out.println("\n");
//            for(Address output : addressList) {
//                System.out.println(output);
//            }
//




        }





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

//    public void menueStart() throws FileNotFoundException, SQLException {
//        Scanner keyReader = new Scanner(System.in);
//        Menue menue = new Menue();
//
//        while (true) {
//            menue.showMenue();
//            String input = keyReader.next();
//            try {
//                menue.menueSelection(input);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void main(String[] args) throws FileNotFoundException, SQLException {

        new AddressRegisterApp();

    }

}
