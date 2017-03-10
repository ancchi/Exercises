package de.deutschepost.epost.spring.controller;

import de.deutschepost.epost.spring.model.Artikel;
import de.deutschepost.epost.spring.model.Haendler;
import de.deutschepost.epost.spring.repositories.ArtikelRepository;
import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by afischer on 09/03/2017.
 */


@RestController
@RequestMapping("article")
public class ArtikelController {


    @Autowired
    ArtikelRepository artikelRepository;


    @RequestMapping(method = RequestMethod.POST, value = "/newArticle")
    public ResponseEntity<Artikel> saveNewArticle(@RequestBody Artikel artikel, UriComponentsBuilder uriCB)  {
        Artikel dbArtikel = artikelRepository.save(artikel);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriCB.path("article/one/{id}").buildAndExpand(dbArtikel.getIdArtikel()).toUri());
        return new ResponseEntity<Artikel>(httpHeaders, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/one/{id}")  // Pfad + id von Input
    public ResponseEntity<Artikel> doSomething(@PathVariable("id") Long id) {
        Artikel artikel = artikelRepository.findOne(id);
        if(artikel == null) {
            return new ResponseEntity<Artikel>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(artikel);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<Iterable<Artikel>> giveAllOut() {
        Iterable<Artikel> artikelList = artikelRepository.findAll();
        if(artikelList == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(artikelList);
    }


}
