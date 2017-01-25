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
import java.util.Scanner;
//import org.joda.time.DateTime;

public class TodoListApp {

    private TodoListApp() throws SQLException, FileNotFoundException {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance(); // wozu die Instanz?
        final Connection connection = connectionFactory.getConnection();

        createSchema(connection);  // Schema der Datenbank
        insertData(connection);    // Einfügen in Datenbank

        Date date = new Date();                               // java.util.Date
        Timestamp timestamp = new Timestamp(date.getTime());  // java.sql.Timestamp

        /**
         * TodoListItemDao
         */

//

//        // TODO Input implementieren
//        InputData input = new InputData();
//        String todoItem = input.inputTodo();
//        boolean status = input.inputStatus();

//        // saving
//        String todoItem = "Ein Glas holen.";
//        boolean status = true;
//        TodoListItem saveEntity = new TodoListItem(todoItem, status, timestamp, timestamp, 7);
//        final TodoListItem savedItem = new TodoListItemDao().save(saveEntity);
////        System.out.println("\nNeue gespeicherte Entity: \n" + savedItem + "\n");
//
//        // find by id
//        System.out.println("");
//        long id = 1;
//        final TodoListItem byID = new TodoListItemDao().findById(id);
//        System.out.println("Eintrag für ID " + id + ": \n" + byID + "\n");
////
//        // update
//        TodoListItem updateEntity = new TodoListItem(6, "Den Eintrag ändern.", true, timestamp, timestamp, 2);
//        final TodoListItemDao updateItemTodo = new TodoListItemDao();
//        updateItemTodo.update(updateEntity);
//
//
//        // delete
//        long deleteID = 9;  // nur id (Interface und Implementierung)
//        final TodoListItemDao deleteItem = new TodoListItemDao();
//        deleteItem.delete(deleteID);
//
//        // findall
//        final List<TodoListItem> all3 = new TodoListItemDao().findAll();
//        System.out.println("\nAusgabe der gesamten TODO-Tabelle:");
//        for (TodoListItem todoListItem : all3) {
//            System.out.println(todoListItem);
//        }




        /**
         * CategoryDao
         */

        // find by id
//        long idCat = 2;
//        final CategoryItem categoryItem = new CategoryItemDao().findById(idCat);
//        System.out.print("\nKategorie für die id " + idCat + ":");
//        System.out.println(" " + categoryItem);

//
//        // save
//        final CategoryItem entity = new CategoryItem("Arbeit", timestamp, timestamp);
//        final CategoryItem savedItemCat = new CategoryItemDao().save(entity);
//
//        // update
//        final CategoryItem entity1 = new CategoryItem(4, "Was ganz anderes", timestamp, timestamp);
//        CategoryItemDao updateItemCat = new CategoryItemDao();
//        updateItemCat.update(entity1);
//
//        // delete
//        long idCat = 6;
//        CategoryItemDao deleteItemCat = new CategoryItemDao();
//        deleteItem.delete(id);
//
//        // find all
//        final List<CategoryItem> catList = new CategoryItemDao().findAll();
//        System.out.println("\nAlle Kategorien:\n");
//        for (CategoryItem category : catList) {
//            System.out.println(category);
//        }

//        // findTodosForOneCategory  - alles -> 1. Möglichkeit -> Abfrage ohne explizite JOINs
        String category = "Politik";
        final List<TodoListItem> todoIsItDoneList = new CategoryItemDao().findTodosForOneCategory(category);
        System.out.println("\nTasks für die Kategorie " + category + ":");
        for(TodoListItem todoListItem : todoIsItDoneList) {
            String done;
            if (todoListItem.isDone() == true) {
                done = "erledigt";
            } else {
                done = "offen";
            }
            System.out.println(todoListItem.getTask() + ", " + done);
        }



        // findByID - 2. Möglichkeit -> Abfrage mit expliziten JOINs
        CategoryItem categoryItem  = new CategoryItemDao().findById(2L);

        //category.getTodoListItems();

        System.out.println("\n" + categoryItem.getCategory());

        for (TodoListItem todoListItem : categoryItem.getTodoListItems()) {
            String done;
            if (todoListItem.isDone() == true) {
                done = "erledigt";
            } else {
                done = "offen";
            }
            System.out.println(todoListItem.getTask() + ", " + done);
        }


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
