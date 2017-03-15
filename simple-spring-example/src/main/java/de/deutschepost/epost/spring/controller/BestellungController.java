package de.deutschepost.epost.spring.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import de.deutschepost.epost.spring.model.Bestellung;
import de.deutschepost.epost.spring.repositories.BestellungRepository;
import jdk.nashorn.internal.parser.JSONParser;
import org.eclipse.jetty.plus.annotation.Injection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Date;

/**
 * Created by afischer on 09/03/2017.
 */

@RestController
@RequestMapping(value = {"/order", "article/{articleId}/order/{orderId}"/* für Suche */}) // TODO ausprobieren, wenn POST-Methode & Einträge in Tabelle vorhanden


public class BestellungController {

    @Autowired
    BestellungRepository bestellungRepository;


//    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
//    public ResponseEntity<Bestellung> oneOrder(@PathVariable("id") Long id) {
//        Bestellung bestellung = bestellungRepository.findOne(id);
//        bestellung.setListArtikel(bestellungRepository.articlesOfAnOrder(id));  // Liste der Artikel mit der ID
//        if(bestellung == null) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//        return ResponseEntity.ok(bestellung);
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/overview")
    public ResponseEntity<Iterable<Bestellung>> ueberblick() {

        Iterable<Bestellung> listBestellung = bestellungRepository.findAll();
        if(listBestellung == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(listBestellung);
    }


    // Datum wird automatisch vergeben - json-body ist leer ~ {}
    @RequestMapping(method = RequestMethod.POST, value = "/newOrder")
    public ResponseEntity<Void> orderSomething( @RequestBody Bestellung bestellung, UriComponentsBuilder uriCompBuilder) {

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // aktuelles Datums


        bestellung.setDate(sqlDate);
        Bestellung dbBestellung = bestellungRepository.save(bestellung);


        HttpHeaders httpHeaders = new HttpHeaders();
       //httpHeaders.setLocation(uriCompBuilder.path("order/{id}").buildAndExpand(dbBestellung.getIdBestellung()).toUri());

        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }
}
