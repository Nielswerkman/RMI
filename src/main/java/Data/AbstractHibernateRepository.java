package Data;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateRepository<T extends Serializable> {

    private Class<T> myObject;

    public final void setMyObject(Class<T> myObject) {
        this.myObject = myObject;
    }

    public T findOne(int id) {
        Session session = Database.SESSION.openSession();

        T entity = session.find(myObject, id);

        session.close();

        return entity;
    }

    public List<T> findAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM " + myObject.getName());

        List result = query.getResultList();

        session.close();

        return result;
    }

    public boolean create(T entity) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        boolean result = session.save(entity) != null;

        session.getTransaction().commit();

        session.close();

        return result;
    }

    public boolean update(T entity) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        session.saveOrUpdate(entity);

        session.getTransaction().commit();

        session.close();

        return true;
    }

    public boolean delete(T entity) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        session.delete(entity);

        session.getTransaction().commit();

        session.close();

        return true;
    }

}