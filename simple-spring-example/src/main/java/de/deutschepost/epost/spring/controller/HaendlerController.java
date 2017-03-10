package de.deutschepost.epost.spring.controller;

import de.deutschepost.epost.spring.model.Haendler;
import de.deutschepost.epost.spring.repositories.HaendlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by afischer on 09/03/2017.
 */
@RestController
@RequestMapping("deliverer")
public class HaendlerController {

    @Autowired
    HaendlerRepository haendlerRepository;

    /**
     * HTTPHeaders
     * setLocation(...)
     * weist den HttpHeader an die "Location" in Form einer Url mit auszugeben
     *
     *
     * Class UriComponentsBuilder
     *
     * uriBuilder.buildAndExpand(dbHaendler.getIdHaendler()).toUri()
     *  * findet die Ursprungs-URI heraus (z.B. http://localhost:8080), baut eine Uri-Komponenteninstanz und
     *    gibt diese als URI zurück
     * uriBuilder.path("/deliverer/show/{id}").buildAndExpand[...]
     *  * hängt einen String-Path an den gegebenen Pfad des Builders
     *
     *
     *  ResponseEntity<T> extends HttpEntity<T>
     *  verpackt Response, Header und StatusCode
     *
     *  ResponseEntity.ok(haendler)
     *  ok(...) ist statisch
     *  ist ein Shortcut um eine ResponseEntity aus dem gegebenen Body zu schaffen
     *  der HttpStatus wird hierbei auf OK gesetzt
     *  A shortcut for creating a {@code ResponseEntity} with the given body and
     * the status set to {@linkplain HttpStatus#OK OK}.
     *
     */


    @RequestMapping(method = RequestMethod.POST, value = "/registration")
    public ResponseEntity<Void> saveNewHaendler(@RequestBody Haendler haendler, UriComponentsBuilder uriBuilder) {
        System.out.println("Creating Haendler "+haendler.getFirmenname());

        Haendler dbHaendler = haendlerRepository.save(haendler);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriBuilder.path("/deliverer/show/{id}").buildAndExpand(dbHaendler.getIdHaendler()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



    @RequestMapping(method = RequestMethod.GET, value = "/show/{id}")
    public ResponseEntity<Haendler> giveBackHaendler(@PathVariable("id") Long id) {
        Haendler haendler = haendlerRepository.findOne(id);
        if(haendler == null) {
            return new ResponseEntity<Haendler>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(haendler);  // ok ist static
    }


    /**
     * @ResponseBody und RequestBody
     *
     * @ResponseBody sorgt dafür, dass der Response den Body für das HTTP-Response darstellt, typischerweise als JSON oder XML
     * den Return-Type für den @ResponseBody muss man bei @RequestMapping mit produce angeben
     * man kann mithilfe von @ResponseBody Objekt-Entitys als Response zurückgeben - allerdings kann man an diesen Response keine
     * Statusmeldung hängen, daher ist als Rückgabetyp ResponseEntity<T> besser geeignet
     *
     * @RequestBody sorgt dafür, dass ein Methoden-Parameter an den Wert des HTTP-Request-Bodys gebunden wird
     * mit einem HttpMessageConverter wird eine HTTP-Anfrage in ein Objekt und ein Objekt in ein HTTP-Response-Body
     * umgewandelt
     *
     *
     */

    @RequestMapping(method = RequestMethod.GET, value = "/overview", produces = MediaType.APPLICATION_JSON_VALUE)  // MediaType richtig??
    @ResponseBody
    public Iterable<Haendler> ueberblick() {
        return haendlerRepository.findAll();
    }


//    @RequestMapping(method = RequestMethod.GET, value = "/show/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Haendler giveBackHaendler(@PathVariable("id") Long id) {
//        Haendler haendler = haendlerRepository.findOne(id);
//        if(haendler == null) {
//            return null;
//            // Statusmeldung nicht möglich -> besser anstatt Haendler ResponseEntity<Haendler> verwenden
//        }
//        return haendler;  // ok ist static
//    }


}
