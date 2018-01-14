package Shared.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Mutatie implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @OneToOne(targetEntity = Product.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;

    private Date datum;

    private String reden;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User creator;

    public Mutatie(Product product, Date datum, String reden, User creator) {
        this.product = product;
        this.datum = datum;
        this.reden = reden;
        this.creator = creator;
    }

    public Mutatie() {
    }

    public String mutatieTableString(){
        return product.getNaam() + " " + datum + " " + reden + " " + creator.getNaam();
    }

    @Override
    public String toString() {
        return "Mutatie{" +
                "Id=" + Id +
                ", product=" + product +
                ", datum=" + datum +
                ", reden='" + reden + '\'' +
                ", creator=" + creator +
                '}';
    }

    //region Getters & Setters

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getReden() {
        return reden;
    }

    public void setReden(String reden) {
        this.reden = reden;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }


    //endregion
}
