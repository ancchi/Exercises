package de.deutschepost.epost.spring.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by afischer on 09/03/2017.
 */
@Entity
@Table(name = "HAENDLER")
public class Haendler {

    @Id
    @Column(name = "ID_HAENDLER", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idHaendler;

    @Column(name = "OWNER", nullable = false)
    private String owner;

    @Column(name = "FIRMEN_NAME", nullable = false)
    private String firmenName;


    @ManyToMany(mappedBy = "listHaendler")
    private List<Kunde> listKunde;



    public long getIdHaendler() {
        return idHaendler;
    }

    public void setIdHaendler(long idHaendler) {
        this.idHaendler = idHaendler;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getFirmenname() {
        return firmenName;
    }

    public void setFirmenname(String firmenname) {
        this.firmenName = firmenname;
    }


    public List<Kunde> getListKunde() {
        return listKunde;
    }

    public void setListKunde(List<Kunde> listKunde) {
        this.listKunde = listKunde;
    }


}
