package Repository;


import Data.AbstractHibernateRepository;
import Shared.Models.Product;

public class HibernateProductRepository extends AbstractHibernateRepository<Product> {

    public HibernateProductRepository() {
        setMyObject(Product.class);
    }
}
