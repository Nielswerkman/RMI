package main.java.MutatieBeheer;

import main.java.Data.RMI.VoorraadRMI;
import main.java.Repository.HibernateMutatieRepository;
import main.java.Repository.HibernateProductRepository;
import main.java.Shared.Interfaces.IMutatieBeheer;
import main.java.Shared.Interfaces.IVoorraadBeheer;
import main.java.Shared.Models.Mutatie;
import main.java.Shared.Models.Product;
import main.java.Shared.Models.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MutatieBeheer extends UnicastRemoteObject implements IMutatieBeheer {

    private HibernateProductRepository productRepo = new HibernateProductRepository();
    private HibernateMutatieRepository mutatieRepo = new HibernateMutatieRepository();

    private IVoorraadBeheer voorraadBeheer;

    public MutatieBeheer() throws RemoteException {
        voorraadBeheer = new VoorraadRMI().getVoorraadBeheer();
    }

    public List<Product> GetProductenOpDatum(Date datum) {
        List<Product> allProducts = productRepo.findAll();
        List<Product> productenOpDatum = new ArrayList<Product>();

        for(Product p : allProducts){
            if(p.getDatum() == datum){
                productenOpDatum.add(p);
            }
        }

        return productenOpDatum;
    }

    public List<Mutatie> GetMutatiesVanDatum(Date datum) {
        List<Mutatie> allMutaties = mutatieRepo.findAll();
        List<Mutatie> mutatiesVanDatum = new ArrayList<Mutatie>();

        for(Mutatie m : allMutaties){
            if(m.getDatum() == datum){
                mutatiesVanDatum.add(m);
            }
        }

        return mutatiesVanDatum;
    }

    public boolean AddMutatie(Product product, String reden, User user) {
        Mutatie mutatie = new Mutatie(product, new Date(), reden, user);
        Product updatedProduct = productRepo.findOne(product.getId());
        updatedProduct.setAantal((updatedProduct.getAantal() - 1));
        productRepo.update(updatedProduct);
        return mutatieRepo.create(mutatie);
    }

    public boolean SetNewProductDatum(Product product, Date datum) {
        Product updatedProduct = productRepo.findOne(product.getId());
        updatedProduct.setDatum(datum);
        return productRepo.update(updatedProduct);
    }
}
