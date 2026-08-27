package umariana.sistemaalumnos;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Mflass
 */
public class GestionarAlumnos {

    private final Scanner lector = new Scanner(System.in);
    private final ArrayList<Alumnos> alumnos = new ArrayList<>();
    private final Archivo reporte = new Archivo();

    public GestionarAlumnos() {
        reporte.leerArchivo(alumnos);
        System.out.println("Se cargaron " + alumnos.size() + " alumnos desde el archivo.");
    }

    public void agregarAlumno() {
        System.out.println("====== Agregar Alumno ======\n");
        System.out.println("digite el nombre del alumno:");
        String nombre = lector.nextLine();
        System.out.println("digite el apellido del alumno:");
        String apellido = lector.nextLine();

        int cedula, edad, semestre;
        try {
            System.out.println("digite la cedula del alumno:");
            cedula = Integer.parseInt(lector.nextLine());
            System.out.println("digite la edad del alumno:");
            edad = Integer.parseInt(lector.nextLine());
            System.out.println("digite el semestre del alumno:");
            semestre = Integer.parseInt(lector.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un numero valido.");
            return;
        }

        if (buscarAlumno(cedula) != null) {
            System.out.println("Ya existe un alumno registrado con esa cedula.");
            return;
        }

        try {
            alumnos.add(new Alumnos(cedula, nombre, apellido, edad, semestre));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        reporte.escribirTodos(alumnos);
        System.out.println("============================");
    }

    public void listarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("====== Listado de alumnos ======\n");
        for (Alumnos alumno : alumnos) {
            System.out.printf("Alumno: %s %s. %n", alumno.getNombre(), alumno.getApellido());
            System.out.printf("1.Cedula: %d %n2.Edad: %d anios.%n3.Semestre: %d %n",
                    alumno.getCedula(), alumno.getEdad(), alumno.getSemestre());
            System.out.println("============================");
        }
    }

    public void modificarAlumno() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("digitar cedula del estudiante: ");
        int cedula;
        try {
            cedula = Integer.parseInt(lector.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un numero valido.");
            return;
        }

        Alumnos alumno = buscarAlumno(cedula);
        if (alumno == null) {
            System.out.println("No se encontro un alumno con esa cedula.");
            return;
        }

        System.out.println("digite el nuevo nombre:");
        alumno.setNombre(lector.nextLine());
        System.out.println("digite el nuevo apellido:");
        alumno.setApellido(lector.nextLine());

        try {
            System.out.println("digite la nueva edad:");
            alumno.setEdad(Integer.parseInt(lector.nextLine()));
            System.out.println("digite el nuevo semestre:");
            alumno.setSemestre(Integer.parseInt(lector.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un numero valido.");
            return;
        }

        reporte.escribirTodos(alumnos);
        System.out.println("====== Alumno actualizado. ======");
    }

    public void eliminarAlumno() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("digitar cedula del estudiante: ");
        int cedula;
        try {
            cedula = Integer.parseInt(lector.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un numero valido.");
            return;
        }

        Alumnos alumno = buscarAlumno(cedula);
        if (alumno == null) {
            System.out.println("No se encontro un alumno con esa cedula.");
            return;
        }

        System.out.printf("==== Estudiante: %s ====%n", alumno.getNombre());
        System.out.println(alumno);
        System.out.println("confirmacion de eliminacion (si/no): ");
        String opc = lector.nextLine();
        if (opc.equalsIgnoreCase("si")) {
            alumnos.remove(alumno);
            reporte.escribirTodos(alumnos);
            System.out.println("====== Alumno eliminado. ======");
        }
    }

    public void generarReporte() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("====== Reporte de alumnos registrados ======");
        for (Alumnos alumno : alumnos) {
            System.out.println(alumno);
        }
        System.out.println("Total de alumnos: " + alumnos.size());
        System.out.println("=============================================");
    }

    private Alumnos buscarAlumno(int cedula) {
        for (Alumnos alumno : alumnos) {
            if (alumno.getCedula() == cedula) {
                return alumno;
            }
        }
        return null;
    }
}
