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
        if (preguntarSiNo(sc, "¿Vive principalmente en el agua? (si/no): ")) {
            return Habitat.ACUATICO;
        }

        else {
            if (preguntarSiNo(sc, "¿Puede volar? (si/no): ")) {
                return Habitat.AEREO;
            } else {
                return Habitat.TERRESTRE;
            }
        }

    }

    private ClaseBiologica decidirClase(Scanner sc, Habitat habitat) {

        if (habitat == Habitat.AEREO) {
            return ClaseBiologica.AVE;
        } else {
            if (preguntarSiNo(sc, "Tiene pelaje? (si/no): ")){
                return ClaseBiologica.MAMIFERO;
            } else {
                if (habitat == Habitat.ACUATICO) {
                    if (preguntarSiNo(sc, "¿Tiene branquias? (si/no): ")) {
                        return ClaseBiologica.PEZ;
                    } else {
                        if (preguntarSiNo(sc, "¿Tiene piel húmeda? (si/no): ")
                                && preguntarSiNo(sc, "¿Vive parte en agua y parte en tierra? (si/no): ")) {
                            return ClaseBiologica.ANFIBIO;
                        } else {
                            if (preguntarSiNo(sc, "¿Tiene escamas? (si/no): ")) {
                                return ClaseBiologica.REPTIL;
                            } else {
                                return ClaseBiologica.INVERTEBRADO;
                            }
                        }
                    }
                }
            }

        }

        // 3) Si es TERRESTRE: primero mamífero, luego anfibio, luego reptil, si no invertebrado
        if (preguntarSiNo(sc, "¿Tiene pelo? (si/no): ")) {
            return ClaseBiologica.MAMIFERO;
        }

        if (preguntarSiNo(sc, "¿Tiene piel húmeda? (si/no): ")
                && preguntarSiNo(sc, "¿Vive parte en agua y parte en tierra? (si/no): ")) {
            return ClaseBiologica.ANFIBIO;
        }

        if (preguntarSiNo(sc, "¿Tiene escamas? (si/no): ")) {
            return ClaseBiologica.REPTIL;
        }

        return ClaseBiologica.INVERTEBRADO;
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
