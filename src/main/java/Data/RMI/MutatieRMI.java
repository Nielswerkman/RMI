package Data.RMI;

import Shared.Interfaces.IMutatieBeheer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MutatieRMI {

    private IMutatieBeheer mutatieBeheer;

    public MutatieRMI() {
        try{
            String rmi_registy = "rmi://localhost:6002/";

            Context namingContext = new InitialContext();

            String urlService = rmi_registy + "mutatiebeheer";
            System.out.println(namingContext.lookup(urlService).toString());

            this.mutatieBeheer = (IMutatieBeheer) namingContext.lookup(urlService);
        } catch (NamingException e){
            e.printStackTrace();
        }
    }

    public IMutatieBeheer getMutatieBeheer(){
        return this.mutatieBeheer;
    }
}
