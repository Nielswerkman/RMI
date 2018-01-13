package main.java.VoorraadBeheer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class VoorraadBeheerServer {

    public static VoorraadNotificationPublisher voorraadNotificationPublisher;

    public static void main(String[] args) throws RemoteException {
        voorraadNotificationPublisher = new VoorraadNotificationPublisher();
        Registry registry = LocateRegistry.createRegistry(6003);
        registry.rebind("voorraadbeheer", new VoorraadBeheer());
        System.out.println("voorraadbeheer server started");

        registry.rebind("voorraadnotificationpublisher",voorraadNotificationPublisher);
        System.out.println("voorraadnotificationpublisher Started!!");
    }
}
