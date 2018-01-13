import Data.Database;
import Data.RMI.MutatieRMI;
import Repository.HibernateProductRepository;
import Shared.Interfaces.IMutatieBeheer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateTest {

    private Repository.HibernateProductRepository productRepo;

    public HibernateTest(){
        productRepo = new HibernateProductRepository();
    }

    @Test
    public void testConnection(){
        boolean open = Database.SESSION.isOpen();

        Assert.assertTrue(open);
    }

    @Test
    public void testProductRepo(){
        productRepo = new HibernateProductRepository();
        productRepo.findAll();
    }

    @Test
    public void testIMutatie(){

        IMutatieBeheer mutatieBeheer = new MutatieRMI().getMutatieBeheer();

        Assert.assertNotNull(mutatieBeheer);
    }
}
