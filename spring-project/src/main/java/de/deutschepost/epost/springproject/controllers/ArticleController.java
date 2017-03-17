package de.deutschepost.epost.springproject.controllers;

import de.deutschepost.epost.springproject.models.Article;
import de.deutschepost.epost.springproject.models.Purchase;
import de.deutschepost.epost.springproject.repositories.ArticleRepository;
import de.deutschepost.epost.springproject.repositories.PurchaseRepository;
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
    @Autowired
    PurchaseRepository purchaseRepository;



    // Works !!
    @RequestMapping(method = RequestMethod.GET, value = "/show")
    public ResponseEntity<Iterable<Article>> showSalesPitch () {  // sales pitch = Verkaufsangebot
        Iterable<Article> articleIterable = articleRepository.findAll();
        return ResponseEntity.ok(articleIterable);
    }

     // works!!
    @RequestMapping(method = RequestMethod.POST, value = "/{orderId}/newArticle")
    public ResponseEntity<Void> newPurchase(@PathVariable("orderId") Long orderId, @RequestBody Article article) {
        Purchase dbPurchase;
        Article dbArticle;

        if(purchaseRepository.findOne(orderId) == null) {
            return new ResponseEntity<Void>(HttpStatus.FAILED_DEPENDENCY);
        } else {
            dbArticle = articleRepository.save(article);

            dbPurchase = purchaseRepository.findOne(orderId);
            dbPurchase.getArticleList().add(article);
            purchaseRepository.save(dbPurchase);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }





}
