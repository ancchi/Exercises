package de.deutschepost.epost.spring.repositories;

import de.deutschepost.epost.spring.model.Bestellung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by afischer on 09/03/2017.
 */

@Repository
public interface BestellungRepository extends CrudRepository<Bestellung, Long> {

}
