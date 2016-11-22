package mago.mongodb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

}
