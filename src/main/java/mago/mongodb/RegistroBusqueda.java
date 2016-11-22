package mago.mongodb;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.List;


// Aca indicamos cual es la collection donde vamos a guardar los documentos
@Entity("registro")
@javax.persistence.Entity
public class RegistroBusqueda {

    @Id
    private ObjectId mongoId;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String query;

    private Long tiempo;

    @Embedded
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<POI> pois;

    public ObjectId getMongoId() {
        return mongoId;
    }

    public void setMongoId(ObjectId mongoId) {
        this.mongoId = mongoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Long getTiempo() {
        return tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
    }

    public List<POI> getPois() {
        return pois;
    }

    public void setPois(List<POI> pois) {
        this.pois = pois;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ID: ").append(this.getMongoId()).append("\n");
        sb.append("Query: ").append(this.getQuery()).append("\n");
        sb.append("Tiempo: ").append(this.getTiempo()).append("\n");

        for (POI poi : pois) {
            sb.append("POI: ").append(poi.getNombre()).append("\n");
        }

        return sb.toString();
    }
}
