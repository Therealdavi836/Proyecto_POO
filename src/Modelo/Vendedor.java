/**
 *@title: Vendedor.java
 * @description: Clase vendedor para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//paquete
package Modelo;

//Subclase modelo 
public class Vendedor extends Usuario{
    //Atributos
    private String fechaIngreso;
    private int sueldo;

    //Constructor completo 
    public Vendedor(String fechaIngreso, int sueldo, int cedula, String nombre, String apellido, String direccion, int telefono, String email, String fechanacimiento, String contrasena) {
        super(cedula, nombre, apellido, direccion, telefono, email, fechanacimiento, contrasena);
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
    }

    //Constructor vacio 
    public Vendedor() {
    }

    //Metodos getter
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public int getSueldo() {
        return sueldo;
    }

    //Metodos setter 
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    //Metodo toString 
    @Override
    public String toString(){
        return "\n"+super.toString() + "  \nVendedor{" + "fechaIngreso: " + fechaIngreso + ", sueldo: " + sueldo + '}';
    }
}
