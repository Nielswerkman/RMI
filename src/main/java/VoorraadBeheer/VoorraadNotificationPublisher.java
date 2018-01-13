package VoorraadBeheer;



import Shared.Interfaces.RemoteListener;
import Shared.Interfaces.RemotePublisher;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class VoorraadNotificationPublisher extends UnicastRemoteObject implements RemotePublisher {

    private ArrayList<RemoteListener> listeners;


    public VoorraadNotificationPublisher() throws RemoteException {
        listeners = new ArrayList<RemoteListener>();
    }

    public void addListener(RemoteListener listener) throws RemoteException {
        listeners.add(listener);
    }

    public void removeListener(RemoteListener listener) throws RemoteException {
        listeners.remove(listener);
    }

    public void send() {
        for(RemoteListener l : listeners){
            try {
                l.triggerUpdateVoorraad();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
