package main.java.Terminal;

import main.java.Repository.HibernateProductRepository;
import main.java.Shared.Interfaces.RemoteListener;
import main.java.Shared.Models.Product;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VoorraadNotificationListener extends UnicastRemoteObject implements RemoteListener{


    public VoorraadNotificationListener() throws RemoteException {
    }

    public void triggerUpdateVoorraad() throws RemoteException {
        Main.updateVoorraadLijst();
    }
}
