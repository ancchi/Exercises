package de.deutschepost.epost.addressRegister.persistence;

import java.util.List;

/**
 * Interface
 * enthält die Standardmethoden, die in den Daos für die Abfrage gebraucht werden
 */
public interface DataAccessObject<T> {


    T findById(long id);

    List<T> findAll();

    T save(T entity);

    void update(T entity);

    void delete(long id);

    // ***Neu***
    List<T> search (String searchTerm);  // soll alles finden, egal, was man eingibt

}
