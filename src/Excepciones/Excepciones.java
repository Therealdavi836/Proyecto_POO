/**
 *@title: Excepciones.java
 * @description: Excepciones para el proyecto CadenaSuministros
 * @date: 29 de noviembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas 
 */

package Excepciones;

import java.util.regex.Pattern;

public class Excepciones extends Exception{
    
    public Excepciones(){
    }
    
    public Excepciones(String message){
        super(message);
    }
    
    public void ValidarTexto(String Cadena) throws Excepciones{
    
        String condicion = "^[A-Za-z\\s]*"; //Con o sin espacios
        //String condicion = "^[A-Za-z\\s]$"; //Con espacios
        //String condicion = "^[A-Za-z]$"; //Sin espacios
        
        boolean validacion = Pattern.matches(condicion, Cadena);
        
        if(!validacion){
            throw new Excepciones("El texto ingresado: '" + Cadena + "' no es valido.");
        }
    }
    
    public void ValidarNombreUsuario(String Usuario) throws Excepciones{
    
        String condicion = "^[A-Za-z\\s]{3,10}$"; //Con espacios
        //String condicion = "^[A-Za-z]{3,10}$"; //Sin espacios
        
        boolean validacion = Pattern.matches(condicion, Usuario);
        
        if(!validacion){
            throw new Excepciones("El nombre del usuario: '" + Usuario + "'no es valido");
        }
    }
    
    public void ValidarNombreProducto(String producto) throws Excepciones{
        
        String condicion = "^[A-Za-z\\s]{3,}$"; //con espacios y minimo 3 caracteres 
    
        boolean validacion = Pattern.matches(condicion, producto);
        if(!validacion){
            throw new Excepciones("El nombre del producto: '" + producto + "' no es valido");
        }
    }
    
    public void ValidarContrasena(String contrasena) throws Excepciones{
    
        String condicion = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$$"; //Debe comenzar con mayuscula
        //String condicion = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[-@#$%^&+=]).{8,}$"; //La letra mayuscula puede estar entre los demás caracteres
        
        boolean validacion = Pattern.matches(condicion, contrasena);
        if(!validacion){
            throw new Excepciones("La contraseña insertada: '" + contrasena + "' no esa valida");
        }
    }
    
    public void ValidarDireccion(String direccion) throws Excepciones{
    
        String condicion = "(Calle|Carrera)\\s*\\d+[A-Za-z]?\\s*#\\s*\\d{1,2}-\\d{1,2}"; //Con o Sin espacios
        //String condicion = "(Calle|Carrera)\\s\\d+[A-Za-z]?\\s#\\s\\d{1,2}-\\d{1,2}"; //Con espacios
        
        boolean validacion = Pattern.matches(condicion, direccion);
        if(!validacion){
            throw new Excepciones("La direccion insertada: '" + direccion + "' no es valida");
        }
    }
    
    public void ValidarFecha(String fecha) throws Excepciones{
    
        //String condicion = "^(?:(?:0?[1-9]|1\\d|2[0-8])/(?:0?[1-9]|1[0-2])|(?:29|30)/(?:0?[13-9]|1[0-2])|31/(?:0?[13578]|1[02]))/(?:19|20)\\d{2}$|^(?:29/0?2/(?:19|20)(?:[02468][048]|[13579][26])|29/0?2/1(?:9|8)[0480])$";
        String condicion = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$";
        
        boolean validacion = Pattern.matches(condicion, fecha);
        if(!validacion){
            throw new Excepciones("la fecha es incorrecta");
        }
    }
    
    public void ValidarCorreo(String correo) throws Excepciones{
    
        String condicion = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        boolean validacion = Pattern.matches(condicion, correo);
        if(!validacion){
            throw new Excepciones("El correo ingresado: '" + correo + "'no es valido");
        }
    }
}
