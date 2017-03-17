package de.deutschepost.epost.springproject.controllers;

import de.deutschepost.epost.springproject.models.Purchase;
import de.deutschepost.epost.springproject.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by afischer on 16/03/2017.
 */
@RestController
@RequestMapping("/order")
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    // WORKS!!
    @RequestMapping(method = RequestMethod.POST, value = "/newOrder")
    public ResponseEntity<Void> createNewPurchase(@RequestBody Purchase purchase) {

        java.util.Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        purchase.setPurchaseDate(sqlDate);

        purchaseRepository.save(purchase);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    // WORKS!!
    @RequestMapping(method = RequestMethod.GET, value = "/showPurchases")
    public ResponseEntity<Iterable<Purchase>> showAllPurchases() {

        Iterable<Purchase> purchaseIterable = purchaseRepository.findAll();

        return ResponseEntity.ok(purchaseIterable);
    }

    // Works!!
    @RequestMapping(method = RequestMethod.GET, value = "/specialPurchase/{orderId}")
    public ResponseEntity<Purchase>  purchasePerId(@PathVariable("orderId") Long orderId) {

        Purchase purchase = purchaseRepository.findOne(orderId);


        return ResponseEntity.ok(purchase);
    }

}
