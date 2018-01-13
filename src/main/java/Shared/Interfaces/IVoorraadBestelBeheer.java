package main.java.Shared.Interfaces;

import main.java.Shared.Models.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVoorraadBestelBeheer extends Remote{

    boolean ProductBestellen(Product product, int aantalKeer) throws RemoteException;
}
