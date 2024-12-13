/**
 *@title: Usuario.java
 * @description: Clase usuario para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Modelo;

//Clase padre con implementacion de interface comparador 
public class Usuario implements Comparable<Usuario>{
    //Atributos
    private int cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
    private String email;
    private String fechanacimiento;
    private String contrasena;

    //Constructor completo
    public Usuario(int cedula, String nombre, String apellido, String direccion, int telefono, String email, String fechanacimiento, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechanacimiento = fechanacimiento;
        this.contrasena = contrasena;
    }
    
    //Constructor vacio 
    public Usuario(){
    
    }
    
    //Metodos getter
    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    //Metodos setter
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", fechanacimiento=" + fechanacimiento + ", contrasena=" + contrasena + '}';
    }
    
    //Metodo hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    //Metodo equals
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if (getClass()!= obj.getClass()){
            return false;
        }
        final Usuario other = (Usuario) obj;
        return this.cedula == other.cedula;
    }
    
    //Metodo compareTo
    @Override
    public int compareTo(Usuario o) {      
        if(this.cedula == o.cedula){
                return 0;
        } else if(this.cedula > o.cedula){
                   return 1; 
        } else {
            return -1;
        }
    }
}
