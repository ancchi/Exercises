package de.deutschepost.epost.spring.controller;

import de.deutschepost.epost.spring.model.Artikel;
import de.deutschepost.epost.spring.model.Bestellung;
import de.deutschepost.epost.spring.repositories.ArtikelRepository;
import de.deutschepost.epost.spring.repositories.BestellungRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


/**
 * Created by afischer on 09/03/2017.
 */


@RestController
@RequestMapping(value = {"article"})
public class ArtikelController {


    @Autowired
    ArtikelRepository artikelRepository;
    @Autowired
    BestellungRepository bestellungRepository;



    // TODO hier weiter!!!!


    @RequestMapping(method = RequestMethod.GET, value = "/order/{orderId}")
    public ResponseEntity<Iterable<Artikel>> articlePerOrder (@PathVariable("orderId") Long orderId) {
//        Bestellung bestellung = bestellungRepository.findOne(orderId);
//        Iterable<Artikel> artikelList = bestellung.getListArtikel();  // TODO Liste ist leer

        Iterable<Artikel> artikelList = bestellungRepository.articlesOfAnOrder(orderId);
        return ResponseEntity.ok(artikelList);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<Iterable<Artikel>> giveAllOut() {
        Iterable<Artikel> artikelList = artikelRepository.findAll();
        if(artikelList.toString().equals("[]")) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(artikelList);
    }

    /**
     * selbst geschriebene Querys aus ArtikelRepository
     */

    // Bestellung mit bestehender BestellungsId -> Standard, funktioniert!
    @RequestMapping(method = RequestMethod.POST, value = "order/{orderId}/newArticle" /* für die Bestellung, orderId muss aber schon existieren */ )
    public ResponseEntity<Void> saveNewArticle( @RequestBody Artikel artikel, @PathVariable("orderId") Long orderId, UriComponentsBuilder uriCB )  {

        Artikel dbArtikel;
        Bestellung bestellung = null;


        if(bestellungRepository.findOne(orderId) == null) {

            return new ResponseEntity<Void>(HttpStatus.FAILED_DEPENDENCY);

//            java.util.Date utilDate = new java.util.Date();       // TODO Bestellung anlegen, wenn ID neu!!!
//            java.sql.Date sqlDate = new Date(utilDate.getTime());
//
//            bestellung.setDate(sqlDate);
//            bestellungRepository.save(bestellung);

        } else {
            bestellung = bestellungRepository.findOne(orderId);
        }

        bestellung.getListArtikel().add(artikel); // holt Liste und fügt neuen Artikel hinzu
        dbArtikel = artikelRepository.save(artikel);
        bestellungRepository.save(bestellung);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(uriCB.path("article/{id}").buildAndExpand(dbArtikel.getIdArtikel()).toUri());  // baut URI und holt gleichzeitig die ID von Artikel

            return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);

    }




}
