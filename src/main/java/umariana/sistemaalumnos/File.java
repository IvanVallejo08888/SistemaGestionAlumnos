/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.sistemaalumnos;
import java.io.*;
/**
 *
 * @author Mflass
 */
public class File {
    // ruta del archivo: ./java/data/ReporteAlumno.txt
    
    public void EscribirArchivo(String nombre, String apellido, int cedula, int edad, int semestre){
        try(BufferedWriter texto = new BufferedWriter(new FileWriter("./java/data/ReporteAlumno.txt"))){
            texto.write(cedula + "," + nombre + "," + apellido + "," + edad + "," + semestre);
            texto.newLine();
            
            System.out.println("se ha escrito correctamente");
        }catch(IOException e){
            System.out.println("Error al escribir en el archivo: "+ e.getMessage());
        }
    }
    
    public void LeerArchivo(){
        try(BufferedReader lector = new BufferedReader(new FileReader("./java/data/ReporteAlumno.txt"))){
            String linea;
            while((linea = lector.readLine()) != null){
                String[] datos = linea.split(",");
                System.out.println("Cedula: "+datos[0]+" | Nombre: "+datos[1]+" | Apellido: "+datos[2]+" | Edad: "+datos[3]+" | Semestre: "+datos[4]);
                
            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo: "+ e.getMessage());
        }
    }
    
    
    
    
}
