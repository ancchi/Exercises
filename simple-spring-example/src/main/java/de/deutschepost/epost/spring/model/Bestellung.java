package de.deutschepost.epost.spring.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by afischer on 09/03/2017.
 */
@Entity
@Table(name = "BESTELLUNG")
public class Bestellung {


    @Id
    @Column(name = "ID_BESTELLUNG", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBestellung;

    @Column(name = "DATE", nullable = false)
    private Date date;

    @OneToMany(mappedBy = "bestellung")
    private List<Artikel> listArtikel;

    @ManyToOne
    private Kunde kunde;



    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public long getIdBestellung() {
        return idBestellung;
    }

    public void setIdBestellung(long idBestellung) {
        this.idBestellung = idBestellung;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Artikel> getListArtikel() {
        return listArtikel;
    }

    public void setListArtikel(List<Artikel> listArtikel) {
        this.listArtikel = listArtikel;
    }


}
