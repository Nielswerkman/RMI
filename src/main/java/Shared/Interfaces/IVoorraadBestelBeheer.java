package main.java.Shared.Interfaces;

import main.java.Shared.Models.Product;

import java.rmi.Remote;

public interface IVoorraadBestelBeheer extends Remote{

    boolean ProductBestellen(Product product, int aantalKeer);
}
