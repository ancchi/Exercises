package de.deutschepost.epost;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TodoListItem {

    private Long idTodo;
    private String task;

    // mapped to database using: 1 => true
    // mapped to database using: 0 => false
    private boolean done;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Long idCat;



    public static final String FORM = "MM/dd/yyyy HH:mm:ss"; // public, um es noch woanders benutzen zu können


    public TodoListItem() {}

    public TodoListItem(String task, boolean done, Timestamp createdAt, Timestamp modifiedAt, long idCat) {
        this.task = task;
        this.done = done;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.idCat = idCat;
    }

    public TodoListItem(long idTodo, String task, boolean done, Timestamp createdAt, Timestamp modifiedAt, long idCat) {
        this.idTodo = idTodo;
        this.task = task;
        this.done = done;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.idCat = idCat;
    }

    public TodoListItem(String task, boolean done) {
        this.task = task;
        this.done = done;
    }


    public TodoListItem(String task, Timestamp createdAt, Timestamp modifiedAt) {
        this.task = task;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Long getIdTodo() {
        return idTodo;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }

    public Timestamp getCreatedAt() {return createdAt; }

    public Timestamp getModifiedAt() {return modifiedAt; }

    public void setIdTodo(Long idTodo) {
        this.idTodo = idTodo;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreatedAT() { this.createdAt = createdAt; }

    public void setModifiedAT() { this.modifiedAt = modifiedAt; }


    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoListItem that = (TodoListItem) o;

        return idTodo != null ? idTodo.equals(that.idTodo) : that.idTodo == null;
    }

    @Override
    public int hashCode() {
        return idTodo != null ? idTodo.hashCode() : 0;
    }

    @Override
    public String toString() {
        String created = new SimpleDateFormat(FORM).format(createdAt);
        String modified = new SimpleDateFormat(FORM).format(modifiedAt);
        return "TodoListItem{" +
                "idTodo=" + idTodo +
                ", task='" + task + '\'' +
                ", done=" + done +
                ", createdAT=" + created +
                ", modifiedAT=" + modified +
                ", category=" + idCat +
                '}';
    }
}
