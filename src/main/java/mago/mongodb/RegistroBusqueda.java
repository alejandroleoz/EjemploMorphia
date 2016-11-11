package mago.mongodb;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.List;


// Aca indicamos cual es la collection donde vamos a guardar los documentos
@Entity("registro")
public class RegistroBusqueda {

    @Id
    private ObjectId id;

    private String query;

    private Long tiempo;

    @Embedded
    private List<POI> pois;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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
        sb.append("ID: ").append(this.getId()).append("\n");
        sb.append("Query: ").append(this.getQuery()).append("\n");
        sb.append("Tiempo: ").append(this.getTiempo()).append("\n");

        for (POI poi : pois) {
            sb.append("POI: ").append(poi.getNombre()).append("\n");
        }

        return sb.toString();
    }
}
