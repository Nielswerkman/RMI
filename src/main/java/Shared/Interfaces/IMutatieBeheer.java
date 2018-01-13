package main.java.Shared.Interfaces;

import main.java.Shared.Models.Mutatie;
import main.java.Shared.Models.Product;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;

public interface IMutatieBeheer extends Remote {

    List<Product> GetProductenOpDatum(Date datum);

    List<Mutatie> GetMutatiesVanDatum(Date datum);

    boolean AddMutatie(Product product, String reden);

    boolean SetNewProductDatum(Product product, Date datum);

}
