package Shared.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.EventListener;

public interface RemoteListener extends EventListener, Remote {
    void triggerUpdateVoorraad() throws RemoteException;
}
