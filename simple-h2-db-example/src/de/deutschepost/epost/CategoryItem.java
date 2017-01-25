package de.deutschepost.epost;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by afischer on 24/01/2017.
 */
public class CategoryItem {



    private long idCat;
    private String category;
    private Timestamp createdAt;
    private Timestamp modifiedAT;
    List<TodoListItem> todoListItemList = new ArrayList<>();

    public List<TodoListItem> getTodoListItems() {
        return todoListItemList;
    }

    public void setTodoListItems(List<TodoListItem> todoListItems) {
        this.todoListItemList = todoListItems;
    }

    public CategoryItem() {

    }

    public CategoryItem(String category) {
        this.category = category;
    }

    public CategoryItem(String category, Timestamp createdAt, Timestamp modifiedAT) {
        this.category = category;
        this.createdAt = createdAt;
        this.modifiedAT = modifiedAT;
    }

    public CategoryItem(long cat, String category, Timestamp createdAt, Timestamp modifiedAT) {
        this.idCat = cat;
        this.category = category;
        this.createdAt = createdAt;
        this.modifiedAT = modifiedAT;

    }



    public long getIdCat() {
        return idCat;
    }

    public void setIdCat(long idCat) {
        this.idCat = idCat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAT() {
        return modifiedAT;
    }

    public void setModifiedAT(Timestamp modifiedAT) {
        this.modifiedAT = modifiedAT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryItem)) return false;

        CategoryItem that = (CategoryItem) o;

        if (getIdCat() != that.getIdCat()) return false;
        if (!getCategory().equals(that.getCategory())) return false;
        if (!getCreatedAt().equals(that.getCreatedAt())) return false;
        return getModifiedAT().equals(that.getModifiedAT());

    }

    @Override
    public int hashCode() {
        int result = (int) (getIdCat() ^ (getIdCat() >>> 32));
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + getModifiedAT().hashCode();
        return result;
    }

    @Override
    public String toString() {
        TodoListItem todo = new TodoListItem();
        String created = new SimpleDateFormat(todo.FORM).format(createdAt);
        String modified = new SimpleDateFormat(todo.FORM).format(modifiedAT);
        return "CategoryItem{" +
                "idCat=" + idCat +
                ", category='" + category + '\'' +
                ", createdAt=" + created +
                ", modifiedAT=" + modified +
                '}';
    }
}
