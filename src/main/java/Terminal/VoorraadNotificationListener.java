package Terminal;

import Shared.Interfaces.RemoteListener;
import Shared.Interfaces.RemotePublisher;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VoorraadNotificationListener extends UnicastRemoteObject implements RemoteListener {


    public VoorraadNotificationListener() throws RemoteException {

        try {
            String rmi_registry = "rmi://localhost:6003/";

            Context namingContext = new InitialContext();

            String urlService = rmi_registry + "voorraadnotificationpublisher";

            // Get our RemotePublisher via RMI
            RemotePublisher publisher = (RemotePublisher) namingContext.lookup(urlService);

            // Add the listener to the Publisher
            publisher.addListener(this);

            System.out.println(namingContext.lookup(urlService).toString());
        } catch (NamingException e) {
            System.out.println("NamingContext could not be created.");
            e.printStackTrace();
        }

    }

    public void triggerUpdateVoorraad() throws RemoteException {
        Main.updateVoorraadLijst();
    }
}
