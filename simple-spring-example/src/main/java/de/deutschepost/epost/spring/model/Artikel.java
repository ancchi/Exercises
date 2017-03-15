package de.deutschepost.epost.spring.model;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

/**
 * Created by afischer on 09/03/2017.
 */
@Entity
@Table(name = "ARTIKEL")
public class Artikel {

    @Id
    @Column(name = "ID_ARTIKEL", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idArtikel;

    @Column(name = "EIGENSCHAFT", nullable = false)
    private String eigenschaft;

    @Column(name = "ARTIKEL_NAME", nullable = false)
    private String artikelName;


    public long getIdArtikel() {
        return idArtikel;
    }

    public void setIdArtikel(long idArtikel) {
        this.idArtikel = idArtikel;
    }

    public String getEigenschaft() {
        return eigenschaft;
    }

    public void setEigenschaft(String eigenschaft) {
        this.eigenschaft = eigenschaft;
    }

    public String getArtikelName() {
        return artikelName;
    }

    public void setArtikelName(String artikelName) {
        this.artikelName = artikelName;
    }
}
