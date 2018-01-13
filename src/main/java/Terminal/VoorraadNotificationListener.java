package Terminal;

import Shared.Interfaces.RemoteListener;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VoorraadNotificationListener extends UnicastRemoteObject implements RemoteListener {


    public VoorraadNotificationListener() throws RemoteException {
    }

    public void triggerUpdateVoorraad() throws RemoteException {
        System.out.println("Ik ga een update doen!!");
        Main.updateVoorraadLijst();
    }
}
