package com.mycompany.sistemaalumnos;
import java.util.Scanner;

/**
 *
 * @author Mflass
 */
public class SistemaAlumnos {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        GestionarAlumnos gestionar = new GestionarAlumnos();
        int opcion = 0;
        do {
            System.out.println("====== Menú de opciones ======\n"
                    + "1.	Agregar un alumno\n"
                    + "2.	Listar todos los alumnos\n"
                    + "3.	Modificar alumnos \n"
                    + "4.	Eliminar un alumno \n"
                    + "5.	Generar un reporte de alumnos registrados (Reporte en pantalla de impresión)\n"
                    + "6.	Salir del programa\n"
                    + "============================");
            opcion = Integer.parseInt(lector.nextLine());

            switch (opcion) {
                case 1 ->
                    gestionar.agregarAlumno();
                case 2 ->
                    gestionar.listarAlumnos();
                case 3 ->
                    gestionar.ModificarAlumno();
                case 4 ->
                    gestionar.EliminarAlumno();
                case 5 ->
                    System.out.println("5");
                case 6 -> 
                    System.out.println("Saliendo del programa...");
            }

        } while (opcion != 6);

    }

}
