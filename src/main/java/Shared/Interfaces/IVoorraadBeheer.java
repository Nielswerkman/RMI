package main.java.Shared.Interfaces;

import main.java.Shared.Models.Product;

import java.rmi.Remote;
import java.util.List;

public interface IVoorraadBeheer extends Remote {

    List<Product> getProducten();

    int getProductVoorraad(Product product);

    boolean updateProductVoorraad(Product product);

}
