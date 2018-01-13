package main.java.MutatieBeheer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MutatieBeheerServer {



    public static void main(String[] args) throws RemoteException{
        Registry registry = LocateRegistry.createRegistry(6002);
        registry.rebind("mutatiebeheer", new MutatieBeheer());
        System.out.println("Mutatie server started");
    }



}
