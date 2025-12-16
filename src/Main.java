import Clasificacion.ClaseBiologica;
import Clasificacion.Habitat;
import Clasificacion.TipoAlimentacion;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RegistroAnimales registro = new RegistroAnimales();
        ArbolDecisionClasificador clasificador = new ArbolDecisionClasificador();

        int op;
        do {
            System.out.println("\n=== MENÚ - CLASIFICADOR DE ANIMALES ===");
            System.out.println("1) Agregar animal");
            System.out.println("2) Ver TODOS");
            System.out.println("3) Ver SOLO por HÁBITAT");
            System.out.println("4) Ver SOLO por CLASE BIOLÓGICA");
            System.out.println("5) Ver SOLO por ALIMENTACIÓN");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            op = leerEntero(sc);

            switch (op) {
                case 1 -> {
                    Animal a = clasificador.registrarYClasificar(sc);
                    registro.agregar(a);
                    System.out.println("Guardado: " + a);
                }
                case 2 -> mostrarLista("TODOS", registro.getAnimales());
                case 3 -> menuHabitat(sc, registro);
                case 4 -> menuClase(sc, registro);
                case 5 -> menuAlimentacion(sc, registro);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (op != 0);

        sc.close();
    }

    // ------- Submenús -------

    private static void menuHabitat(Scanner sc, RegistroAnimales registro) {
        System.out.println("\n--- Filtrar por HÁBITAT ---");
        System.out.println("1) ACUATICO");
        System.out.println("2) AEREO");
        System.out.println("3) TERRESTRE");
        System.out.print("Elige: ");

        int op = leerEntero(sc);
        Habitat h = switch (op) {
            case 1 -> Habitat.ACUATICO;
            case 2 -> Habitat.AEREO;
            case 3 -> Habitat.TERRESTRE;
            default -> null;
        };

        if (h == null) {
            System.out.println("Opción inválida.");
            return;
        }

        List<Animal> filtrados = registro.filtrarPorHabitat(h);
        mostrarLista("HÁBITAT = " + h, filtrados);
    }

    private static void menuClase(Scanner sc, RegistroAnimales registro) {
        System.out.println("\n--- Filtrar por CLASE BIOLÓGICA ---");
        System.out.println("1) MAMIFERO");
        System.out.println("2) AVE");
        System.out.println("3) PEZ");
        System.out.println("4) REPTIL");
        System.out.println("5) ANFIBIO");
        System.out.println("6) INVERTEBRADO");
        System.out.print("Elige: ");

        int op = leerEntero(sc);
        ClaseBiologica c = switch (op) {
            case 1 -> ClaseBiologica.MAMIFERO;
            case 2 -> ClaseBiologica.AVE;
            case 3 -> ClaseBiologica.PEZ;
            case 4 -> ClaseBiologica.REPTIL;
            case 5 -> ClaseBiologica.ANFIBIO;
            case 6 -> ClaseBiologica.INVERTEBRADO;
            default -> null;
        };

        if (c == null) {
            System.out.println("Opción inválida.");
            return;
        }

        List<Animal> filtrados = registro.filtrarPorClase(c);
        mostrarLista("CLASE = " + c, filtrados);
    }

    private static void menuAlimentacion(Scanner sc, RegistroAnimales registro) {
        System.out.println("\n--- Filtrar por ALIMENTACIÓN ---");
        System.out.println("1) HERBIVORO");
        System.out.println("2) CARNIVORO");
        System.out.println("3) OMNIVORO");
        System.out.println("4) CARRONERO");
        System.out.print("Elige: ");

        int op = leerEntero(sc);
        TipoAlimentacion a = switch (op) {
            case 1 -> TipoAlimentacion.HERBIVORO;
            case 2 -> TipoAlimentacion.CARNIVORO;
            case 3 -> TipoAlimentacion.OMNIVORO;
            case 4 -> TipoAlimentacion.CARRONERO;
            default -> null;
        };

        if (a == null) {
            System.out.println("Opción inválida.");
            return;
        }

        List<Animal> filtrados = registro.filtrarPorAlimentacion(a);
        mostrarLista("ALIMENTACIÓN = " + a, filtrados);
    }

    // ------- Helpers -------

    private static void mostrarLista(String titulo, List<Animal> lista) {
        System.out.println("\n=== " + titulo + " ===");
        if (lista.isEmpty()) {
            System.out.println("(No hay registros)");
            return;
        }
        int i = 1;
        for (Animal a : lista) {
            System.out.println(i + ") " + a);
            i++;
        }
    }

    private static int leerEntero(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }
}

