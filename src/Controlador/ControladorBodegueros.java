/**
 *@title: ControladorBodegueros.java
 * @description: Controlador de usuarios bodegueros para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Controlador;

//Importaciones de clases y apis de java
import java.util.ArrayList;
import java.util.Collections;
import Modelo.Bodegueros;

//Clase controlador
public class ControladorBodegueros implements ICRUD {
    //Arreglo 
    public static ArrayList<Bodegueros> arregloBodegueros = new ArrayList<>();
    
    //Metodo insertar objetos
    @Override
    public boolean insertar(Object obj) {
        boolean inserto = true;
        Bodegueros bode = (Bodegueros)obj;
        
        if(arregloBodegueros.isEmpty()){
            inserto = arregloBodegueros.add(bode);
            return inserto;
        } else{
            for(Bodegueros bode1: arregloBodegueros){
                if(bode1.equals(bode)){
                    inserto = true;
                    return inserto;
                }
            }
        }
        if(inserto){
            inserto = arregloBodegueros.add(bode);
            return inserto;
        }
        
        return inserto;
    }

    //Metodo modificar uno, por obejto
    @Override
    public Object modificar(Object obj) {
        ordenar();
        Bodegueros bode = (Bodegueros)obj;
        int pos = Collections.binarySearch(arregloBodegueros, bode);
        if(pos > -1){
            bode = arregloBodegueros.set(pos, bode);
        }else{
            return null;
        }
        return bode; //Devuelve true o false
    }

    //Metodo consultar un objeto unicamente, uno, por objeto
    @Override
    public Object consultarUno(Object obj) {
        Collections.sort(arregloBodegueros);
        Bodegueros bode = (Bodegueros)obj;
        int pos = Collections.binarySearch(arregloBodegueros, bode);
        if(pos<0){
            bode = null;
        }else{
            bode = arregloBodegueros.get(pos);
        }
        return bode; //Devuelve true o false
    }

    //Metodo de impresion de todos los objetos existentes 
    @Override
    public void consultarGeneral() {
        for(Bodegueros bode: arregloBodegueros)
        {
            System.out.println("\n"+bode.toString());
        }
    }

    //Metodo de eliminacion de objetos, uno por objeto
    @Override
    public boolean borrar(Object obj) {
        boolean borro = false;
        Bodegueros bode = (Bodegueros)obj;
        ordenar();
        int pos = Collections.binarySearch(arregloBodegueros, bode);
        if(pos <= -1)
            return borro;
        else{
            bode = arregloBodegueros.get(pos);
            borro = arregloBodegueros.remove(bode);
            return borro;
        }
    }

    //Metodo de ordenamiento pot sort 
    @Override
    public void ordenar() {
        Collections.sort(arregloBodegueros);
    }
    
    
    @Override
    public void ordenar(int x, int y) {
        //Ordenamiento por quicksort
        Bodegueros pivote = arregloBodegueros.get(x);
        
        int i = x;
        int j = y;
        Bodegueros aux;
        
        while(i < j){
            while(arregloBodegueros.get(i).getNombre().compareToIgnoreCase(pivote.getNombre()) < 1 && i < j) i++;
            while(arregloBodegueros.get(j).getNombre().compareToIgnoreCase(pivote.getNombre())>= 1) j--;
            
            if (i <= j){
                aux = arregloBodegueros.get(i);
                arregloBodegueros.set(i, arregloBodegueros.get(j));
                arregloBodegueros.set(j, aux);
            }
        }
        arregloBodegueros.set(x, arregloBodegueros.get(j));
        arregloBodegueros.set(j, pivote);
        
        if(x <= j-1){
            ordenar(x, j-1);
        }
        if(j+1 <= y){
            ordenar(j+1, y);
        }
    }
    
    public void burbuja(){
        //Ordenamiento por burbuja 
        Bodegueros pivote = new Bodegueros();
        
        for (int i = 0; i < arregloBodegueros.size(); i++) {                  
            for (int j = i; j < arregloBodegueros.size(); j++) {             
                if (arregloBodegueros.get(i).getApellido().compareToIgnoreCase(arregloBodegueros.get(j).getApellido()) >= 0){
                    pivote = arregloBodegueros.get(i);
                    arregloBodegueros.set(i, arregloBodegueros.get(j));
                    arregloBodegueros.set(j, pivote);
                }
            }
        }
    }
    
    public static ArrayList<Bodegueros> mergeSort(ArrayList<Bodegueros> arregloBodeguero){
        //Ordenamiento por mergesort
        if(arregloBodeguero == null || arregloBodeguero.size() <= 1){
            return arregloBodeguero;
        }
         int medio = arregloBodeguero.size() / 2;
         int x = 0;
         int y = 0;
         ArrayList<Bodegueros> resultado = new ArrayList<>();
         ArrayList<Bodegueros> mitad1 = new ArrayList<>(arregloBodeguero.subList(0, medio));
         ArrayList<Bodegueros> mitad2 = new ArrayList<>(arregloBodeguero.subList(medio, arregloBodeguero.size()));
         
         mitad1 = mergeSort(mitad1);
         mitad2 = mergeSort(mitad2);
         
         while(x < mitad1.size() && y < mitad2.size()){
             Bodegueros bodegueroE1 = mitad1.get(x);
             Bodegueros bodegueroE2 = mitad2.get(y);
             
             if(Float.compare(bodegueroE1.getTelefono(), bodegueroE2.getTelefono()) < 0){
                 resultado.add(bodegueroE1);
                 x++;
             } else {
                 resultado.add(bodegueroE2);
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
