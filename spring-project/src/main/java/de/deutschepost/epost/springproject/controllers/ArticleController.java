package de.deutschepost.epost.springproject.controllers;

import de.deutschepost.epost.springproject.models.Article;
import de.deutschepost.epost.springproject.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by afischer on 16/03/2017.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;


    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public ResponseEntity<Void> saveNewArticle(@RequestBody Article article) {

        articleRepository.save(article);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/show")
    public ResponseEntity<Iterable<Article>> showSalesPitch () {  // sales pitch = Verkaufsangebot

        Iterable<Article> articleIterable = articleRepository.findAll();

        return ResponseEntity.ok(articleIterable);

    }
}
