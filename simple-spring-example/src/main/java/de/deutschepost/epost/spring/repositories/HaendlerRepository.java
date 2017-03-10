package de.deutschepost.epost.spring.repositories;

import de.deutschepost.epost.spring.model.Haendler;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by afischer on 09/03/2017.
 */

@Repository
public interface HaendlerRepository extends CrudRepository<Haendler, Long> {
}
