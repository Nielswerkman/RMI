package main.java.Shared.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String naam;

    private String login;

    private String wachtwoord;

    public User(String naam, String login, String wachtwoord) {
        this.naam = naam;
        this.login = login;
        this.wachtwoord = wachtwoord;
    }

    public User() {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }


    //endregion
}
