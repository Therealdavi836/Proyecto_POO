/**
 *@title: Cliente.java
 * @description: Clase cliente para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Modelo;

//Subclase modelo 
public class Cliente extends Usuario{

    //Constructor con herencia 
    public Cliente(int cedula, String nombre, String apellido, String direccion, int telefono, String email, String fechanacimiento, String contrasena) {
        super(cedula, nombre, apellido, direccion, telefono, email, fechanacimiento, contrasena);
    }

    //Constructor vacio 
    public Cliente() {
    }
    
    //Metodo toString 
    @Override
    public String toString(){
        return "Cliente= " + "\n" + super.toString() + '}';
    }
}
