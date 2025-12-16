import Clasificacion.ClaseBiologica;
import Clasificacion.Habitat;
import Clasificacion.TipoAlimentacion;

import java.util.Scanner;

public class ArbolDecisionClasificador {

    public Animal registrarYClasificar(Scanner sc) {
        System.out.print("Nombre del animal: ");
        String nombre = sc.nextLine().trim();


        Habitat habitat = decidirHabitat(sc);

        ClaseBiologica clase = decidirClase(sc, habitat);

        TipoAlimentacion alimentacion = decidirAlimentacion(sc);

        return new Animal(nombre, habitat, clase, alimentacion);
    }

    private boolean preguntarSiNo(Scanner sc, String pregunta) {
        String r;
        do {
            System.out.print(pregunta);
            r = sc.nextLine().trim().toLowerCase();
        } while (!r.equals("si") && !r.equals("no"));
        return r.equals("si");
    }

    private Habitat decidirHabitat(Scanner sc) {
        boolean viveEnAgua = preguntarSiNo(sc, "¿Vive principalmente en el agua? (si/no): ");
        if (viveEnAgua) return Habitat.ACUATICO;

        boolean puedeVolar = preguntarSiNo(sc, "¿Puede volar? (si/no): ");
        if (puedeVolar) return Habitat.AEREO;

         else return Habitat.TERRESTRE;
    }

    private ClaseBiologica decidirClase(Scanner sc, Habitat habitat) {
        boolean tienePelo = preguntarSiNo(sc, "¿Tiene pelo? (si/no): ");
        if (tienePelo) return ClaseBiologica.MAMIFERO;

        boolean tienePlumas = preguntarSiNo(sc, "¿Tiene plumas? (si/no): ");
        if (tienePlumas) return ClaseBiologica.AVE;

        boolean tieneBranquias = preguntarSiNo(sc, "¿Tiene branquias? (si/no): ");
        if (tieneBranquias && habitat == Habitat.ACUATICO) return ClaseBiologica.PEZ;

        boolean pielHumeda = preguntarSiNo(sc, "¿Tiene piel húmeda? (si/no): ");
        boolean vidaAguaYTierra = preguntarSiNo(sc, "¿Vive parte en agua y parte en tierra? (si/no): ");
        if (pielHumeda && vidaAguaYTierra) return ClaseBiologica.ANFIBIO;

        boolean tieneEscamas = preguntarSiNo(sc, "¿Tiene escamas? (si/no): ");
        if (tieneEscamas) return ClaseBiologica.REPTIL;

        else return ClaseBiologica.INVERTEBRADO;
    }


    private TipoAlimentacion decidirAlimentacion(Scanner sc) {
        boolean soloPlantas = preguntarSiNo(sc, "¿Come solo plantas? (si/no): ");
        if (soloPlantas) return TipoAlimentacion.HERBIVORO;

        boolean soloCarne = preguntarSiNo(sc, "¿Come solo carne? (si/no): ");
        if (soloCarne) return TipoAlimentacion.CARNIVORO;

        boolean plantasYCarne = preguntarSiNo(sc, "¿Come plantas y carne? (si/no): ");
        if (plantasYCarne) return TipoAlimentacion.OMNIVORO;

        else return TipoAlimentacion.CARRONERO;
    }


}
