package de.deutschepost.epost.springproject.models;

import javax.persistence.*;
import java.util.List;

/**
 * ein Article von derselben Art kann in mehreren Bestellungen sein und eine Purchase
 * kann mehrere Article beihnhalten -> m:n-Beziehung
 */
@Entity
@Table(name = "ARTICLE")
public class Article {

    @Id
    @Column(name = "ID_ARTICLE", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idArticle;

    @Column(name = "PROPERTY", nullable = false)
    private String property;


    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "articleList")
    private List<Purchase> purchases;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }


    public long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(long idArticle) {
        this.idArticle = idArticle;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }




}
