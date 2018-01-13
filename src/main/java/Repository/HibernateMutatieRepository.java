package Repository;


import Data.AbstractHibernateRepository;
import Shared.Models.Mutatie;

public class HibernateMutatieRepository extends AbstractHibernateRepository<Mutatie> {

    public HibernateMutatieRepository() {
        setMyObject(Mutatie.class);
    }
}
