package de.deutschepost.epost;


import java.util.List;

public interface DataAccessObject<T> {  // wo wird es genutzt?

    T findById(Long id);

    List<T> findAll();

    T save(T entity);

    void update(T entity);

    void delete (long id);
}
