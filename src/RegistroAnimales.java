import Clasificacion.ClaseBiologica;
import Clasificacion.Habitat;
import Clasificacion.TipoAlimentacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistroAnimales {
    private final List<Animal> animales = new ArrayList<>();

    public void agregar(Animal animal) {
        animales.add(animal);
    }

    public List<Animal> getAnimales() {
        return Collections.unmodifiableList(animales);
    }

    public List<Animal> filtrarPorHabitat(Habitat habitat) {
        List<Animal> res = new ArrayList<>();
        for (Animal a : animales) {
            if (a.getHabitat() == habitat) res.add(a);
        }
        return res;
    }

    public List<Animal> filtrarPorClase(ClaseBiologica clase) {
        List<Animal> res = new ArrayList<>();
        for (Animal a : animales) {
            if (a.getClase() == clase) res.add(a);
        }
        return res;
    }

    public List<Animal> filtrarPorAlimentacion(TipoAlimentacion ali) {
        List<Animal> res = new ArrayList<>();
        for (Animal a : animales) {
            if (a.getAlimentacion() == ali) res.add(a);
        }
        return res;
    }
}
