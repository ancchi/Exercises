package de.deutschepost.epost.spring.repositories;

import de.deutschepost.epost.spring.model.Artikel;
import de.deutschepost.epost.spring.model.Bestellung;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by afischer on 09/03/2017.
 */

@Repository
public interface BestellungRepository extends CrudRepository<Bestellung, Long> {

    // Lese die Artikel aus der Artikelliste aus, die zu einer bestimmten Bestellung gehören und packe sie in die List<Artikel>
    @Query(value = "SELECT * FROM ARTIKEL, BESTELLUNG WHERE ARTIKEL.BESTELLUNG_ID_BESTELLUNG = :idBestellung", nativeQuery = true)
    Iterable<Artikel> articlesOfAnOrder(Long idBestellung);

}
