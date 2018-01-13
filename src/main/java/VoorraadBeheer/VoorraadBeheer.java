package VoorraadBeheer;


import Repository.HibernateProductRepository;
import Shared.Interfaces.IVoorraadBeheer;
import Shared.Models.Product;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VoorraadBeheer extends UnicastRemoteObject implements IVoorraadBeheer {

    private HibernateProductRepository productRepo = new HibernateProductRepository();

    public VoorraadBeheer() throws RemoteException{

    }

    public List<Product> getProducten() {
        return productRepo.findAll();
    }

    public int getProductVoorraad(Product product) {
        return productRepo.findOne(product.getId()).getAantal();
    }

    public boolean updateProductVoorraad(Product product) {
        boolean result = productRepo.update(product);
        VoorraadBeheerServer.voorraadNotificationPublisher.send();
        return result;
    }
}
