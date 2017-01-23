package de.deutschepost.epost;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TodoListItem {

    private Long id;
    private String task;

    // mapped to database using: 1 => true
    // mapped to database using: 0 => false
    private boolean done;
    private Timestamp createdAt;
    private Timestamp modifiedAt;



    public TodoListItem(long id, String task, boolean done, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.task = task;
        this.done = done;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }



    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }

    public Timestamp getCreatedAt() {return createdAt; }

    public Timestamp getModifiedAt() {return modifiedAt; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreatedAT() { this.createdAt = createdAt; }

    public void setModifiedAT() { this.modifiedAt = modifiedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoListItem that = (TodoListItem) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        String form1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(createdAt);
        String form2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(modifiedAt);
        return "TodoListItem{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", done=" + done +
                ", createdAT=" + form1 +
                ", modifiedAT=" + form2 +
                '}';
    }
}
