import Data.Database;
import Repository.HibernateProductRepository;
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
}
