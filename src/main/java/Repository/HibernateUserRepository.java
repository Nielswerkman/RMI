package Repository;


import Data.AbstractHibernateRepository;
import Shared.Models.User;

public class HibernateUserRepository extends AbstractHibernateRepository<User> {

    public HibernateUserRepository() {
        setMyObject(User.class);
    }
}
