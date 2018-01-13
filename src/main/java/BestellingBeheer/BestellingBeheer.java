package main.java.BestellingBeheer;

import main.java.Data.RMI.VoorraadRMI;
import main.java.Repository.HibernateProductRepository;
import main.java.Shared.Interfaces.IVoorraadBeheer;
import main.java.Shared.Interfaces.IVoorraadBestelBeheer;
import main.java.Shared.Models.Product;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BestellingBeheer extends UnicastRemoteObject implements IVoorraadBestelBeheer {

    private HibernateProductRepository productRepo = new HibernateProductRepository();

    private IVoorraadBeheer voorraadBeheer;

    public BestellingBeheer() throws RemoteException{
        voorraadBeheer = new VoorraadRMI().getVoorraadBeheer();
    }

    public boolean ProductBestellen(Product product, int aantalKeer) {
        Product current = productRepo.findOne(product.getId());
        current.setAantal((current.getCE() * aantalKeer));

        boolean result = false;

        try {
            result = voorraadBeheer.updateProductVoorraad(product);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return result;
    }


}
