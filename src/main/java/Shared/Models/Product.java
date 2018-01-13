package main.java.Shared.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Product implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String naam;

    private int aantal;

    private int CE;

    private Date datum;

    public Product(String naam, int aantal, int CE, Date datum) {
        this.naam = naam;
        this.aantal = aantal;
        this.CE = CE;
        this.datum = datum;
    }

    public Product() {
    }

    //region Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public int getCE() {
        return CE;
    }

    public void setCE(int CE) {
        this.CE = CE;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }


    //endregion
}
