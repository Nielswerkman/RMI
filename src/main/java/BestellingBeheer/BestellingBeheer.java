package main.java.BestellingBeheer;

import main.java.Repository.HibernateProductRepository;
import main.java.Shared.Interfaces.IVoorraadBeheer;
import main.java.Shared.Interfaces.IVoorraadBestelBeheer;
import main.java.Shared.Models.Product;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BestellingBeheer extends UnicastRemoteObject implements IVoorraadBestelBeheer {

    private HibernateProductRepository productRepo = new HibernateProductRepository();

    public BestellingBeheer() throws RemoteException{
    }

    public boolean ProductBestellen(Product product, int aantalKeer) {
        Product current = productRepo.findOne(product.getId());
        current.setAantal((current.getCE() * aantalKeer));
        return productRepo.update(current);
    }


}
