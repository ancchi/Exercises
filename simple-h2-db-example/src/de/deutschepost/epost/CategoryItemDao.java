package de.deutschepost.epost;

import java.sql.*;
import java.util.*;

/**
 * Created by afischer on 24/01/2017.
 */
public class CategoryItemDao extends AbstractDao<CategoryItem> {

    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    Connection con;



    @Override
    public CategoryItem findById(Long id) {   // Sinn der Methode: auf alles zugreifen können

        con = getConnection();
        CategoryItem categoryItem =  new CategoryItem();

        try {
            String queryString = "SELECT * FROM CATEGORY " +
                    "INNER JOIN TODO_LIST ON CATEGORY.ID_CAT = TODO_LIST.ID_CAT AND CATEGORY.ID_CAT= ?";
            preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            List<TodoListItem> todoListItems = new ArrayList<>();

            while(resultSet.next()) {
                categoryItem.setIdCat(resultSet.getLong("CATEGORY.id_cat"));
                categoryItem.setCategory(resultSet.getString("CATEGORY.cat"));
                categoryItem.setCreatedAt(resultSet.getTimestamp("CATEGORY.created_at"));
                categoryItem.setModifiedAT(resultSet.getTimestamp("CATEGORY.modified_at"));

                TodoListItem todoListItem = new TodoListItem(
                        resultSet.getLong("todo_list.id_todo"),
                        resultSet.getString("todo_list.task"),
                        resultSet.getBoolean("todo_list.done"),
                        resultSet.getTimestamp("todo_list.created_at"),
                        resultSet.getTimestamp("todo_list.modified_at"),
                        resultSet.getLong("todo_list.id_cat")

                );

                todoListItems.add(todoListItem);   // Liste TodoListItems
                categoryItem.setTodoListItems(todoListItems);  // Liste wird mit Setter an CategoryItems übergeben und kann dann über sie abgerufen werden

                // Liste mit dazugehörigen todolist-items füllen

            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }


//        CategoryItem category  = findById(1L);
//
//        category.getTodoListItems();
//
//        System.out.println(category.getCategory());
//
//        for (TodoListItem todoListItem : category.getTodoListItems()) {
//            System.out.println(todoListItem.getTask());
//        }




        return categoryItem;
    }



    @Override
    public List<CategoryItem> findAll() {

        con = getConnection();
        List<CategoryItem> catList = new ArrayList<CategoryItem>();

        try {
            String query = "SELECT * FROM category";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                CategoryItem item = new CategoryItem(
                        resultSet.getLong("id_cat"),
                        resultSet.getString("cat"),
                        resultSet.getTimestamp("modified_at"),
                        resultSet.getTimestamp("created_at")
                );
                catList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

        return catList;
    }

    @Override
    public CategoryItem save(CategoryItem entity) {
        con = getConnection();
        CategoryItem savedItem = null;

        try {
            String save = "INSERT INTO category (cat, created_at, modified_at) VALUES (?, ?, ?)";
            preparedStatement = con.prepareStatement(save);
            preparedStatement.setString(1, entity.getCategory());
            preparedStatement.setTimestamp(2, entity.getCreatedAt());
            preparedStatement.setTimestamp(3, entity.getModifiedAT());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return savedItem;
    }

    @Override
    public void update(CategoryItem entity) {
        con = getConnection();

        try {

            String updateString = "UPDATE category SET cat = ?, modified_at = ? WHERE id_cat = ?";
            preparedStatement = con.prepareStatement(updateString);
            preparedStatement.setString(1, entity.getCategory());
            preparedStatement.setTimestamp(2, entity.getModifiedAT());
            preparedStatement.setLong(3, entity.getIdCat());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }


    }

    @Override
    public void delete(long id) {

        con = getConnection();

        try {

            String deleteString = "DELETE FROM category WHERE id_cat = ?";
            preparedStatement = con.prepareStatement(deleteString);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

    }


    public List<TodoListItem> findTodosForOneCategory(String category) {

        con = getConnection();
        List<TodoListItem> todoListItems = new ArrayList<>();

        try {
            String todoCatQuery = "SELECT todo_list.task, todo_list.done from TODO_LIST, CATEGORY WHERE Category.Cat = ? AND category.id_cat = todo_list.id_cat";
            preparedStatement = con.prepareStatement(todoCatQuery);
            preparedStatement.setString(1, category);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                TodoListItem todoListItem = new TodoListItem(
                  resultSet.getString("todo_list.task"),
                        resultSet.getBoolean("todo_list.done")
                );
                todoListItems.add(todoListItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

        return todoListItems;
    }

    public void closeConn() {
        try {
            if(resultSet != null)
                resultSet.close();
            if(preparedStatement != null)
                preparedStatement.close();
            if(con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
