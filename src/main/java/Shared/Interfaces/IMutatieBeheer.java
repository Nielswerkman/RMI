package Shared.Interfaces;

import Shared.Models.Mutatie;
import Shared.Models.Product;
import Shared.Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public interface IMutatieBeheer extends Remote {

    List<Product> GetProductenOpDatum(Date datum) throws RemoteException;

    List<Mutatie> GetMutatiesVanDatum(Date datum) throws RemoteException;

    boolean AddMutatie(Product product, String reden, User user) throws RemoteException;

    boolean SetNewProductDatum(Product product, Date datum) throws RemoteException;

}
