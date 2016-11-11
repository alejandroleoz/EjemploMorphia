package mago.mongodb;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by aleoz on 11/11/16.
 */
public class MongoDBConnection {

    private static MongoDBConnection instance = null;
    private final Datastore datastore;

    public static MongoDBConnection getInstance() {
        if (instance == null) {
            instance = new MongoDBConnection();
        }
        return instance;
    }

    private MongoDBConnection(){
        final Morphia morphia = new Morphia();

        // tell Morphia where to find your classes
        // can be called multiple times with different packages or classes
        morphia.mapPackage("org.mongodb.morphia.example");

        // create the Datastore connecting to the default port on the local host
        this.datastore = morphia.createDatastore(new MongoClient(), "morphia_example");
        datastore.ensureIndexes();
    }

    public Datastore getDatastore() {
        return this.datastore;
    }
}
