package mago.mongodb;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aleoz on 12/2/16.
 */
public class App_Grupo3 {

    public static void main(String[] args) {
        App_Grupo3.crear();
        App_Grupo3.recuperar();
    }

    public static void crear() {
        RegistroBusqueda registroBusqueda = new RegistroBusqueda();
        registroBusqueda.setQuery("Carousel");
        registroBusqueda.setTiempo(1234L);

        POI p1 = new POI();
        p1.setLatitud(111L);
        p1.setLongitud(222L);
        p1.setNombre("Libreria Carousel");
        p1.setPalabrasClave(Arrays.asList("Libreria", "Comercio"));

        POI p2 = new POI();
        p2.setLatitud(333L);
        p2.setLongitud(444L);
        p2.setNombre("Kiosco Carousel");
        p2.setPalabrasClave(Arrays.asList("Kiosco", "Comercio"));

        registroBusqueda.setPois(Arrays.asList(p1, p2));
        MySQLConnection.getInstance().save(registroBusqueda);
    }

    public static void recuperar() {
        List<POI> pois;
        System.out.println("========= 'Libreria' ==============");
        pois = MySQLConnection.getInstance().getPOIByPalabraClave("Libreria");
        for (POI poi : pois) {
            System.out.println(poi.getNombre());
        }

        System.out.println("========= 'Kiosco' ==============");
        pois = MySQLConnection.getInstance().getPOIByPalabraClave("Kiosco");
        for (POI poi : pois) {
            System.out.println(poi.getNombre());
        }

        System.out.println("========= 'Comercio' ==============");
        pois = MySQLConnection.getInstance().getPOIByPalabraClave("Comercio");
        for (POI poi : pois) {
            System.out.println(poi.getNombre());
        }
    }

}
