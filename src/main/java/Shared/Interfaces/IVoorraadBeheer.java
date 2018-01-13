package Shared.Interfaces;


import Shared.Models.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IVoorraadBeheer extends Remote {

    List<Product> getProducten() throws RemoteException;

    int getProductVoorraad(Product product) throws RemoteException;

    boolean updateProductVoorraad(Product product) throws RemoteException;

}
