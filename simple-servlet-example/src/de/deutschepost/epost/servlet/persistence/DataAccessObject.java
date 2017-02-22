package de.deutschepost.epost.servlet.persistence;

import java.util.List;
import java.util.Optional;

/**
 * Interface
 * enthält die Standardmethoden, die in den Daos für die Abfrage gebraucht werden
 */
public interface DataAccessObject<T> {


    Optional<T> findById(long id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(long id);

    // ***Neu***
    List<T> globalSearch(String searchTerm);  // soll alles finden, egal, was man eingibt

}
