package de.deutschepost.epost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoListItemDao extends AbstractDao<TodoListItem>{

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Connection con;

    // TODO Timestamp-Format für Ausgabe ändern

    @Override
    public TodoListItem findById(Long id) {

        con = getConnection();

        TodoListItem idFinding = null;

        try {
//            String queryString = "SELECT * FROM todo_list WHERE id = " + id;  // Konkatenation ist unsicher!!
            String queryString = "SELECT * FROM todo_list WHERE id_todo = ?";
            preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();


            while(resultSet.next()) {
                TodoListItem item = new TodoListItem(
                        resultSet.getLong("id_todo"),
                        resultSet.getString("task"),
                        toBoolean(resultSet.getInt("done")),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("modified_at"),
                        resultSet.getLong(("id_cat"))
                );
                idFinding = item;
            }

        } catch (SQLException e) {
            e.printStackTrace();  // gibt Fehlermeldung auf dem Standard error Stream aus
        } finally {
            closeCon();
        }
        return idFinding;

    }

    @Override
    public List<TodoListItem> findAll() {

        con = getConnection();

        List<TodoListItem> items = new ArrayList<TodoListItem>();
        try {
            String queryString = "SELECT * FROM todo_list";
            preparedStatement = con.prepareStatement(queryString);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final TodoListItem item = new TodoListItem(
                        resultSet.getLong("id_todo"),
                        resultSet.getString("task"),
                        toBoolean(resultSet.getInt("done")),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("modified_at"),
                        resultSet.getLong("id_cat")
                );

                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon();
        }

        return items;
    }

    private boolean toBoolean(int value){
        return value != 0;
    }  // gibt true zurück, wenn ungleich 0

    private int booleanToInt(boolean bool) {
        // if erwartet ein Ausdruck, der zu 'true' oder 'false' evaluiert
        if(bool) {
            return 1;
        } else {
            return 0;
        }
        // return bool ? 1 : 0;  // verkürzte Schreibweise
    }

    @Override
    public TodoListItem save(TodoListItem entity) {

        con = getConnection();

        TodoListItem savedItem = null;

        // TODO setID ist überflüssig
        try {                                          // Spalten angeben, weil id weggelassen!!
            String queryString = "INSERT INTO todo_list (task, done, created_at, modified_at, id_cat) VALUES (?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(queryString);

            preparedStatement.setString(1, entity.getTask());
            preparedStatement.setBoolean(2, entity.isDone());
            preparedStatement.setTimestamp(3, entity.getCreatedAt());
            preparedStatement.setTimestamp(4, entity.getModifiedAt());
            preparedStatement.setLong(5, entity.getIdCat());
            preparedStatement.execute();

//            savedItem = findById(entity.getIdTodo());  // nur für die Ausgabe
//            System.out.println("Entity-ID: " + entity.getIdTodo()); // id ist 0 -> Ausgabe an dieser Stelle so nicht möglich

        } catch (SQLException e) {
                    e.printStackTrace();
            } finally {
            closeCon();
        }

        return savedItem;
    }



    @Override
    public void update(TodoListItem entity) {

        con = getConnection();

        try {
            String updateString = "UPDATE todo_list SET task = ?, done = ?, modified_at = ?, id_cat = ? WHERE id_todo = ?";
            preparedStatement = con.prepareStatement(updateString);
            preparedStatement.setString(1, entity.getTask());
            preparedStatement.setBoolean(2, entity.isDone());
            preparedStatement.setTimestamp(3, entity.getCreatedAt());
            preparedStatement.setLong(4, entity.getIdCat());
            preparedStatement.setLong(5, entity.getIdTodo());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon();
        }
    }

    @Override
    public void delete(long id) {   // warum als Parameter eine ganze Entity und nicht einfach eine id?
        con = getConnection();

        try {
            String deleteEntity = "DELETE FROM todo_list WHERE id_todo = ?";
            preparedStatement = con.prepareStatement(deleteEntity);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon();
        }
    }

    public void closeCon() {
        try {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
