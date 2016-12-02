package mago.mongodb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MySQLConnection {

    private static MySQLConnection instance = null;

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    private MySQLConnection() {
        this.factory = Persistence.createEntityManagerFactory("Prueba_ORM");
        this.entityManager = this.factory.createEntityManager();
    }

    public void finalize() {
        this.entityManager.close();
        this.factory.close();
    }

    public static MySQLConnection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    public void save(Object o) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(o);
        this.entityManager.getTransaction().commit();
    }

    public Object get(Long id, Class clazz) {
        return this.entityManager.find(clazz, id);
    }

    public List<RegistroBusqueda> getAllRegistros(){
        return this.entityManager.createQuery("select r from RegistroBusqueda r").getResultList();
    }

    public List<POI> getPOIByPalabraClave(String palabra) {
        String queryStr = "SELECT p from POI p, IN(p.palabrasClave) pc WHERE pc like :palabra";
        Query query = this.entityManager.createQuery(queryStr).setParameter("palabra", "%" + palabra + "%");
        return query.getResultList();
    }

}
