package de.deutschepost.epost.springproject.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by afischer on 16/03/2017.
 */
@Entity
@Table(name = "PURCHASE")
public class Purchase {


    @Id
    @Column(name = "PURCHASE", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPurchase;

    @Column(name = "PURCHASE", nullable = false)
    private Date purchaseDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PURCHASE_ARTICLE", joinColumns = {@JoinColumn (name = "ID_PURCHASE")}, inverseJoinColumns = {@JoinColumn(name = "ID_Article")})
    private List<Article> articleList;

    public long getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(long idPurchase) {
        this.idPurchase = idPurchase;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }


}
