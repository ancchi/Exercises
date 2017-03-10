package de.deutschepost.epost.spring.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by afischer on 09/03/2017.
 */
@Entity
@Table(name = "KUNDE")
public class Kunde {

    @Id
    @Column(name = "ID_KUNDE", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idKunde;

    @Column(name = "NAME_KUNDE", nullable = false)
    private String nameKunde;

    @Column(name = "VORNAME_KUNDE", nullable = false)
    private String vornameKunde;

    @ManyToMany
    @JoinTable(name = "HAENDLER_KUNDE", joinColumns = {@JoinColumn(name="ID_HAENDLER")}, inverseJoinColumns = {@JoinColumn(name="ID_KUNDE")})
    List<Haendler> listHaendler;

    @OneToMany(mappedBy = "kunde")
    List<Bestellung> listBestellung;



    public long getIdKunde() {
        return idKunde;
    }

    public void setIdKunde(long idKunde) {
        this.idKunde = idKunde;
    }

    public String getNameKunde() {
        return nameKunde;
    }

    public void setNameKunde(String nameKunde) {
        this.nameKunde = nameKunde;
    }

    public String getVornameKunde() {
        return vornameKunde;
    }

    public void setVornameKunde(String vornameKunde) {
        this.vornameKunde = vornameKunde;
    }

    public List<Haendler> getListHaendler() {
        return listHaendler;
    }

    public void setListHaendler(List<Haendler> listHaendler) {
        this.listHaendler = listHaendler;
    }

    public List<Bestellung> getListBestellung() {
        return listBestellung;
    }

    public void setListBestellung(List<Bestellung> listBestellung) {
        this.listBestellung = listBestellung;
    }

}
