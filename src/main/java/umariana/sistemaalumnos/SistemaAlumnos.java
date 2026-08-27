package umariana.sistemaalumnos;

import java.util.Scanner;

/**
 *
 * @author Mflass
 */
public class SistemaAlumnos {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        GestionarAlumnos gestionar = new GestionarAlumnos();
        int opcion;
        do {
            System.out.println("====== Menú de opciones ======\n"
                    + "1.\tAgregar un alumno\n"
                    + "2.\tListar todos los alumnos\n"
                    + "3.\tModificar alumnos \n"
                    + "4.\tEliminar un alumno \n"
                    + "5.\tGenerar un reporte de alumnos registrados (Reporte en pantalla de impresión)\n"
                    + "6.\tSalir del programa\n"
                    + "============================");

            try {
                opcion = Integer.parseInt(lector.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero de opcion valido.");
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> gestionar.agregarAlumno();
                case 2 -> gestionar.listarAlumnos();
                case 3 -> gestionar.modificarAlumno();
                case 4 -> gestionar.eliminarAlumno();
                case 5 -> gestionar.generarReporte();
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion invalida, intente de nuevo.");
            }

        } while (opcion != 6);
    }
}
