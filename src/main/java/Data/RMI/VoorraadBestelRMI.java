package Data.RMI;

import Shared.Interfaces.IVoorraadBestelBeheer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class VoorraadBestelRMI {

    private IVoorraadBestelBeheer voorraadBestelBeheer;

    public VoorraadBestelRMI() {
        try{
            String rmi_registy = "rmi://localhost:6001/";

            Context namingContext = new InitialContext();

            String urlService = rmi_registy + "voorraadbestelbeheer";
            System.out.println(namingContext.lookup(urlService).toString());

            this.voorraadBestelBeheer = (IVoorraadBestelBeheer) namingContext.lookup(urlService);
        } catch (NamingException e){
            e.printStackTrace();
        }
    }

    public IVoorraadBestelBeheer getVoorraadBestelBeheer(){
        return this.voorraadBestelBeheer;
    }
}
