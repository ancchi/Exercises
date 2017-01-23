package de.deutschepost.epost;

import org.h2.tools.RunScript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
//import org.joda.time.DateTime;

public class TodoListApp {

    private TodoListApp() throws SQLException, FileNotFoundException {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance(); // wozu die Instanz?
        final Connection connection = connectionFactory.getConnection();

        createSchema(connection);  // Schema der Datenbank
        insertData(connection);    // Einfügen in Datenbank

        /**
         * die Liste hat den Parametertyp TodoListItem, das ein Objekt mit Eigenschaften ist (id, task, done)
         * TodoListItemDao entspringt AbstractDao<ToDoListItem>
         * AbstractDao<T> implementiert DataAccessObject<T>
         *
         * ToDoListItemDao - Aufgabe: enthält die Abfragen der Datenbank
         *
         * AbstractDao<T> - Aufgabe:
         *
         * DataAccessObject - Aufgabe:
         *
         */

        final List<TodoListItem> all1 = new TodoListItemDao().findAll();
        System.out.println("\nAusgabe der gesamten Tabelle:");
        for (TodoListItem todoListItem : all1) {
            System.out.println(todoListItem);
        }

        System.out.println("");
        long id = 1;
        final TodoListItem byID = new TodoListItemDao().findById(id);
        System.out.println("Eintrag für ID " + id + ": \n" + byID + "\n");

        // saving
        Date date = new Date();                               // java.util.Date
        Timestamp timestamp = new Timestamp(date.getTime());  // java.sql.Timestamp
                                                // automatisches Inkrementieren -> '0' wird zu NULL in SQL --> ist das üblich???
        TodoListItem saveEntity = new TodoListItem(0, "Immer noch alles gut.", false, timestamp, timestamp);
        final TodoListItem savedItem = new TodoListItemDao().save(saveEntity);
        System.out.println("Neue gespeicherte Entity: \n" + savedItem + "\n");

        TodoListItem updateEntity = new TodoListItem(6, "Der Eintrag wurde geändert.", true, timestamp, timestamp);
        final TodoListItemDao updateItem = new TodoListItemDao();
        updateItem.update(updateEntity);

        final List<TodoListItem> all2 = new TodoListItemDao().findAll();
        System.out.println("\nAusgabe der gesamten Tabelle:");
        for (TodoListItem todoListItem : all2) {
            System.out.println(todoListItem);
        }

        long deleteID = 9;  // nur id (Interface und Implementierung)
        final TodoListItemDao deleteItem = new TodoListItemDao();
        deleteItem.delete(deleteID);

        final List<TodoListItem> all3 = new TodoListItemDao().findAll();
        System.out.println("\nAusgabe der gesamten Tabelle:");
        for (TodoListItem todoListItem : all3) {
            System.out.println(todoListItem);
        }

//        Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
//        System.out.println(time);

    }


    /**
     * Schema der Datenbank erstellen
     */
    private void createSchema(Connection connection) throws FileNotFoundException, SQLException {

        final String ddlSqlLocation = getSqlFileLocation("ddl.sql");

        System.out.println("Creating DB Schema from: " + ddlSqlLocation);

        RunScript.execute(connection, new FileReader(ddlSqlLocation)); // führt ddl.sql-Datei aus
    }

    /**
     * Beispielwerte in Datenbank einfügen
     */
    private void insertData(Connection connection) throws FileNotFoundException, SQLException {

        final String exampleSqlLocation = getSqlFileLocation("example-data.sql");

        System.out.println("Inserting examples from: " + exampleSqlLocation);

        RunScript.execute(connection, new FileReader(exampleSqlLocation));
    }

    private String getSqlFileLocation(String sqlFile) {
        return Paths.get(currentDirectory(), sqlFile).toFile().getAbsolutePath();
    }

    private String currentDirectory(){
        return new File("").getAbsolutePath();
    }

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        new TodoListApp();
    }
}
