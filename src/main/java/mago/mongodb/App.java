package mago.mongodb;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.Arrays;
import java.util.List;


// http://mongodb.github.io/morphia/1.2/getting-started/quick-tour/

public class App {
    public static void main(String[] args) {

//        App.delete(MongoDBConnection.getInstance().getDatastore());
        App.crear(MongoDBConnection.getInstance().getDatastore());
        App.recuperar(MongoDBConnection.getInstance().getDatastore());

    }

    public static void crear(Datastore datastore) {
        RegistroBusqueda registroBusqueda = new RegistroBusqueda();
        registroBusqueda.setQuery("Carousel");
        registroBusqueda.setTiempo(1234L);

        POI p1 = new POI();
        p1.setLatitud(111L);
        p1.setLongitud(222L);
        p1.setNombre("Libreria Carousel");

        POI p2 = new POI();
        p2.setLatitud(333L);
        p2.setLongitud(444L);
        p2.setNombre("Kiosco Carousel");

        registroBusqueda.setPois(Arrays.asList(p1, p2));

        // persistir
        datastore.save(registroBusqueda);

        MySQLConnection.getInstance().save(registroBusqueda);
    }

    public static void delete(Datastore datastore) {
        // creo el query para borrar
        Query<RegistroBusqueda> query = datastore.createQuery(RegistroBusqueda.class);
        query = query.filter("query =", "Carousel");

        // borro
        datastore.delete(query);
    }

    public static void recuperar(Datastore datastore) {
        Query<RegistroBusqueda> query = datastore.find(RegistroBusqueda.class);
        List<RegistroBusqueda> items = query.asList();
        System.out.println("Total: " + items.size() + " registros de busquedas");

        for (RegistroBusqueda item : items) {
            System.out.println(item);
            System.out.println(" ------------------------------ ");
        }


        System.out.println("=================================");
        List<RegistroBusqueda> registros = MySQLConnection.getInstance().getAllRegistros();
        for (RegistroBusqueda registro : registros) {
            System.out.println(registro);
        }

    }
}
