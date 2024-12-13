/**
 *@title: Administrador.java
 * @description: Clase y controlador de administrador para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Modelo;

//Importaciones de clases y apis de java
import Controlador.ICRUD;
import java.util.ArrayList;
import java.util.Collections;

//Clase con controlador 
public class Administrador extends Usuario implements ICRUD{
    //Arreglo
    public static ArrayList<Administrador> arregloAdministrador = new ArrayList<>();
    
    //Atributos
    private String fechaIngreso;
    private int sueldo;

    //Constructor completo
    public Administrador(String fechaIngreso, int sueldo, int cedula, String nombre, String apellido, String direccion, int telefono, String email, String fechanacimiento, String contrasena) {
        super(cedula, nombre, apellido, direccion, telefono, email, fechanacimiento, contrasena);
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
    }
    
    //Constructor vacio
    public Administrador() {
        
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
        return "\n"+super.toString() + "  \nAdministrador{" + " fechaIngreso: " + fechaIngreso + ", sueldo: " + sueldo + '}';
    }

    //CONTROLADOR IMPLEMENTADO EN LA MISMA CLASE
    
    //Metodo insertar objetos
    @Override
    public boolean insertar(Object obj) {
        boolean inserto = true;
        Administrador admi = (Administrador)obj;
        
        if(arregloAdministrador.isEmpty()){
            inserto = arregloAdministrador.add(admi);
            return inserto;
        } else{
            for(Administrador admi1: arregloAdministrador){
                if(admi1.equals(admi)){
                    inserto = true;
                    return inserto;
                }
            }
        }
        if(inserto){
            inserto = arregloAdministrador.add(admi);
            return inserto;
        }
        
        return inserto;
    }

    //Metodo modificar uno, por objeto
    @Override
    public Object modificar(Object obj) {
        ordenar();
        Administrador admi = (Administrador)obj;
        int pos = Collections.binarySearch(arregloAdministrador, admi);
        if(pos > -1){
            admi = arregloAdministrador.set(pos, admi);
        }else{
            return null;
        }
        return admi; //Devuelve true o false
    }

    //Metodo consultar un objeto unicamente, uno, por objeto
    @Override
    public Object consultarUno(Object obj) {
        Collections.sort(arregloAdministrador);
        Administrador admi = (Administrador)obj;
        int pos = Collections.binarySearch(arregloAdministrador, admi);
        if (pos<0) {
            admi = null;
        }else{
            admi = arregloAdministrador.get(pos);
        }
        return admi; //Devuelve true o false
    }

    //Metodo de impresion de todos los objetos existentes 
    @Override
    public void consultarGeneral() {
        for(Administrador admi: arregloAdministrador){
            System.out.println(admi.toString());
        }
    }

    //Metodo de eliminacion de objetos, uno por objeto
    @Override
    public boolean borrar(Object obj) {
        //UNO, POR OBJETO
        boolean borro = false;
        Administrador admi = (Administrador)obj;
        ordenar();
        int pos = Collections.binarySearch(arregloAdministrador, admi);
        if(pos <= -1)
            return borro;
        else{
            admi = arregloAdministrador.get(pos);
            borro = arregloAdministrador.remove(admi);
            return borro;
        }
    }

    //Metodo de ordenamiento por sort 
    @Override
    public void ordenar() {
        Collections.sort(arregloAdministrador);
    }
    
    @Override
    public void ordenar(int x, int y) {
        //Ordenamiento por quicksort
        Administrador pivote = arregloAdministrador.get(x);
        
        int i = x;
        int j = y;
        Administrador aux;
        
        while(i < j){
            while(arregloAdministrador.get(i).getNombre().compareToIgnoreCase(pivote.getNombre()) < 1 && i < j) i++;
            while(arregloAdministrador.get(j).getNombre().compareToIgnoreCase(pivote.getNombre())>= 1) j--;
            
            if (i <= j){
                aux = arregloAdministrador.get(i);
                arregloAdministrador.set(i, arregloAdministrador.get(j));
                arregloAdministrador.set(j, aux);
            }
        }
        arregloAdministrador.set(x, arregloAdministrador.get(j));
        arregloAdministrador.set(j, pivote);
        
        if(x <= j-1){
            ordenar(x, j-1);
        }
        if(j+1 <= y){
            ordenar(j+1, y);
        }
    }
    
    public void burbuja(){
        //Ordenamiento por burbuja 
        Administrador pivote = new Administrador();
        
        for (int i = 0; i < arregloAdministrador.size(); i++) {                  
            for (int j = i; j < arregloAdministrador.size(); j++) {             
                if (arregloAdministrador.get(i).getApellido().compareToIgnoreCase(arregloAdministrador.get(j).getApellido()) >= 0){
                    pivote = arregloAdministrador.get(i);
                    arregloAdministrador.set(i, arregloAdministrador.get(j));
                    arregloAdministrador.set(j, pivote);
                }
            }
        }
    }
    
    public static ArrayList<Administrador> mergeSort(ArrayList<Administrador> arregloAdministradores){
        //Ordenamiento por mergesort
        if(arregloAdministradores == null || arregloAdministradores.size() <= 1){
            return arregloAdministradores;
        }
         int medio = arregloAdministradores.size() / 2;
         int x = 0;
         int y = 0;
         ArrayList<Administrador> resultado = new ArrayList<>();
         ArrayList<Administrador> mitad1 = new ArrayList<>(arregloAdministradores.subList(0, medio));
         ArrayList<Administrador> mitad2 = new ArrayList<>(arregloAdministradores.subList(medio, arregloAdministradores.size()));
         
         mitad1 = mergeSort(mitad1);
         mitad2 = mergeSort(mitad2);
         
         while(x < mitad1.size() && y < mitad2.size()){
             Administrador administradorE1 = mitad1.get(x);
             Administrador administradorE2 = mitad2.get(y);
             
             if(Float.compare(administradorE1.getTelefono(), administradorE2.getTelefono()) < 0){
                 resultado.add(administradorE1);
                 x++;
             } else {
                 resultado.add(administradorE2);
                 y++;
             }
         }
         
         while(x < mitad1.size()){
             resultado.add(mitad1.get(x));
             x++;
         }
         
         while(y < mitad2.size()){
             resultado.add(mitad2.get(y));
             y++;
         }
         
         return resultado;
     }
}
