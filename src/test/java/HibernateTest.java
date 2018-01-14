import Data.Database;
import Data.RMI.MutatieRMI;
import Data.RMI.VoorraadBestelRMI;
import Data.RMI.VoorraadRMI;
import Repository.HibernateMutatieRepository;
import Repository.HibernateProductRepository;
import Repository.HibernateUserRepository;
import Shared.Interfaces.IMutatieBeheer;
import Shared.Interfaces.IVoorraadBeheer;
import Shared.Interfaces.IVoorraadBestelBeheer;
import Shared.Models.Mutatie;
import Shared.Models.Product;
import Shared.Models.User;
import com.sun.jmx.mbeanserver.Repository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public class HibernateTest {

    private HibernateProductRepository productRepo;
    private HibernateMutatieRepository mutatieRepo;
    private HibernateUserRepository userRepo;

    private IMutatieBeheer mutatieBeheer;
    private IVoorraadBeheer voorraadBeheer;
    private IVoorraadBestelBeheer voorraadBestelBeheer;


    @Test
    public void MasterTest(){
        Assert.assertTrue(true);
    }

    @Test
    public void testConnection(){
        boolean open = Database.SESSION.isOpen();

        Assert.assertTrue(open);
    }

    @Test
    public void testProductRepo(){
        productRepo = new HibernateProductRepository();
        List<Product> result = productRepo.findAll();
        Assert.assertNotNull(result.get(0));

    }

    @Test
    public void testMutatieRepo(){
        mutatieRepo = new HibernateMutatieRepository();
        List<Mutatie> result = mutatieRepo.findAll();
        Assert.assertNotNull(result.get(0));

    }

    @Test
    public void testUserRepo(){
        userRepo = new HibernateUserRepository();
        List<User> result = userRepo.findAll();
        Assert.assertNotNull(result.get(0));

    }

    @Test
    public void testIMutatie(){

        mutatieBeheer = new MutatieRMI().getMutatieBeheer();

        Assert.assertNotNull(mutatieBeheer);
    }

    @Test
    public void testIVoorraad(){
        voorraadBeheer = new VoorraadRMI().getVoorraadBeheer();

        Assert.assertNotNull(voorraadBeheer);
    }

    @Test
    public void testIVoorraadBestelBeheer(){
        voorraadBestelBeheer = new VoorraadBestelRMI().getVoorraadBestelBeheer();

        Assert.assertNotNull(voorraadBestelBeheer);
    }

    @Test
    public void testVoorraadBestelBeheer(){
        voorraadBestelBeheer = new VoorraadBestelRMI().getVoorraadBestelBeheer();
        productRepo = new HibernateProductRepository();

        Product p = productRepo.findOne(2);

        boolean result = false;

        try {
           result = voorraadBestelBeheer.ProductBestellen(p, 2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result);

    }

    @Test
    public void testAddMutatie(){
        mutatieBeheer = new MutatieRMI().getMutatieBeheer();
        productRepo = new HibernateProductRepository();
        userRepo = new HibernateUserRepository();

        Product p = productRepo.findOne(2);
        User u = userRepo.findAll().get(0);

        boolean result = false;

        try {
            mutatieBeheer.AddMutatie(p, "testReden", u);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result);
    }

    @Test
    public void testMutatieOnDate(){
        mutatieBeheer = new MutatieRMI().getMutatieBeheer();
        productRepo = new HibernateProductRepository();

        Product p = productRepo.findOne(2);
        Date d = new Date();
        List<Mutatie> result = null;

        try {
            result = mutatieBeheer.GetMutatiesVanDatum(d);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(result);
    }

    @Test
    public void testMutatieGetProductOnDatum(){
        mutatieBeheer = new MutatieRMI().getMutatieBeheer();

        List<Product> result = null;

        try {
            result = mutatieBeheer.GetProductenOpDatum(new Date());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(result);
    }

    @Test
    public void testMutatieDateChange(){
        mutatieBeheer = new MutatieRMI().getMutatieBeheer();
        productRepo = new HibernateProductRepository();

        Product p = productRepo.findAll().get(0);

        boolean result = false;

        try {
           result = mutatieBeheer.SetNewProductDatum(p, new Date());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result);
    }

    @Test
    public void testVoorraadGetAll(){
        voorraadBeheer = new VoorraadRMI().getVoorraadBeheer();

        List<Product> result = null;

        try {
           result = voorraadBeheer.getProducten();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(result);
    }

    @Test
    public void testVoorraadgetProductVoorraad(){
        voorraadBeheer = new VoorraadRMI().getVoorraadBeheer();

        Product p = null;

        try {
            p = voorraadBeheer.getProducten().get(0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        int result = 0;

        try {
            result = voorraadBeheer.getProductVoorraad(p);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Assert.assertNotEquals(0, result);
    }

    @Test
    public void testVoorraadUpdate(){
        voorraadBeheer = new VoorraadRMI().getVoorraadBeheer();

        Product p = null;

        try {
            p = voorraadBeheer.getProducten().get(0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        boolean result = false;

        try {
            result = voorraadBeheer.updateProductVoorraad(p);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result);
    }





}
