package de.deutschepost.epost.spring.repositories;

import de.deutschepost.epost.spring.model.Artikel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;



/**
 * Created by afischer on 09/03/2017.
 */
@Repository
public interface ArtikelRepository extends JpaRepository<Artikel, Long> {

    /**
     * Bemerkungen:
     * 1. rot unterstrichenen Stern ignorieren - JPA wird erwartet, es soll aber native sein -> funktioniert trotzdem
     * 2. Methoden brauchen keine Zugriffsmodifikatoren, weil sie IMMER public sind
     *
     */

//    @Query(value = "SELECT * FROM ARTIKEL", nativeQuery = true)
//    List<Artikel> putOutMuch();
//
//
//    // Artikel nach Name (verwendet in ArtikelController)
//    @Query(value = "SELECT * FROM ARTIKEL WHERE LOWER(ARTIKEL_NAME) = Lower(:artikelName)", nativeQuery = true)
//    List<Artikel> putOutArticlesPerName(@Param("artikelName") String artikelName);


    // Artikel pro Bestellung
    @Query(value = "SELECT * FROM ARTIKEL, BESTELLUNG WHERE ARTIKEL.BESTELLUNG_ID_BESTELLUNG = :idBestellung ", nativeQuery = true)
    List<Artikel> putOutArticlePerOrder(Long idBestellung);



    // Artikel pro Datum
    @Query(value = "SELECT * FROM ARTIKEL WHERE LOWER(BESTELLUNG.DATE) = LOWER(:dateBestellung)", nativeQuery = true)
    List<Artikel> articlePerDate(Date dateBestellung);


}
