package main.java.Data.RMI;

import main.java.Shared.Interfaces.IVoorraadBeheer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class VoorraadRMI {

    private IVoorraadBeheer voorraadBeheer;

    public VoorraadRMI() {
        try{
            String rmi_registy = "rmi://localhost:6001/";

            Context namingContext = new InitialContext();

            String urlService = rmi_registy + "voorraadbeheer";
            System.out.println(namingContext.lookup(urlService).toString());

            this.voorraadBeheer = (IVoorraadBeheer) namingContext.lookup(urlService);
        } catch (NamingException e){
            e.printStackTrace();
        }
    }

    public IVoorraadBeheer getVoorraadBeheer(){
        return this.voorraadBeheer;
    }
}
