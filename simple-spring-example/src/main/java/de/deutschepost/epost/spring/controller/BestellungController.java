package de.deutschepost.epost.spring.controller;

import de.deutschepost.epost.spring.model.Bestellung;
import de.deutschepost.epost.spring.repositories.BestellungRepository;
import org.eclipse.jetty.plus.annotation.Injection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by afischer on 09/03/2017.
 */

@RestController
@RequestMapping("/order")
public class BestellungController {

    @Autowired
    BestellungRepository bestellungRepository;


    @RequestMapping(method = RequestMethod.GET, value = "{/id}")
    public ResponseEntity<Bestellung> oneOrder(@PathVariable("id") Long id) {
        Bestellung bestellung = bestellungRepository.findOne(id);
        if(bestellung == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(bestellung);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/overview")
    public ResponseEntity<Iterable<Bestellung>> ueberblick() {

        Iterable<Bestellung> listBestellung = bestellungRepository.findAll();
        if(listBestellung == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(listBestellung);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/newOrder")
    public ResponseEntity<Bestellung> orderSomething(@RequestBody Bestellung bestellung) {
        Bestellung dbBestellung = bestellungRepository.save(bestellung);

        return ResponseEntity.ok(dbBestellung);
    }



}
