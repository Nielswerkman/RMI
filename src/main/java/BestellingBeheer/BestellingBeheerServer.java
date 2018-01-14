package BestellingBeheer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BestellingBeheerServer {

    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(6001);
        registry.rebind("voorraadbestelbeheer", new BestellingBeheer());
        System.out.println("Bestelbeheer is running!");
    }
}
