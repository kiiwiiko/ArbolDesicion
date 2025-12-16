import Clasificacion.ClaseBiologica;
import Clasificacion.Habitat;
import Clasificacion.TipoAlimentacion;

public class Animal {
    private final String nombre;
    private final Habitat habitat;
    private final ClaseBiologica clase;
    private final TipoAlimentacion alimentacion;

    public Animal(String nombre, Habitat habitat, ClaseBiologica clase, TipoAlimentacion alimentacion) {
        this.nombre = nombre;
        this.habitat = habitat;
        this.clase = clase;
        this.alimentacion = alimentacion;
    }

    public String getNombre() { return nombre; }
    public Habitat getHabitat() { return habitat; }
    public ClaseBiologica getClase() { return clase; }
    public TipoAlimentacion getAlimentacion() { return alimentacion; }

    @Override
    public String toString() {
        return nombre + "  [" + habitat + " | " + clase + " | " + alimentacion + "]";
    }
}
