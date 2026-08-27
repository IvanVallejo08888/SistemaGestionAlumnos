package umariana.sistemaalumnos;

import java.io.*;
import java.util.ArrayList;

/**
 * Antes se llamaba "File", lo que choca con java.io.File.
 * Se renombra a Archivo para evitar el conflicto de nombres.
 */
public class Archivo {

    private static final String RUTA_ARCHIVO = "./java/data/ReporteAlumno.txt";

    public void escribirTodos(ArrayList<Alumnos> alumnos) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, false))) {
            for (Alumnos miAlumno : alumnos) {
                escritor.write(miAlumno.alineaTexto());
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void leerArchivo(ArrayList<Alumnos> alumnos) {
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) continue;
                String[] datos = linea.split(",");
                int cedula = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String apellido = datos[2];
                int edad = Integer.parseInt(datos[3]);
                int semestre = Integer.parseInt(datos[4]);

                alumnos.add(new Alumnos(cedula, nombre, apellido, edad, semestre));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
