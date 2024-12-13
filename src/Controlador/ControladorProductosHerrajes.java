/**
 *@title: ControladorProductosHerrajes.java
 * @description: Controlador de productos de herraje para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete 
package Controlador;

//Importaciones de clases y apis de java 
import Modelo.ProductosHerrajes;
import java.util.ArrayList;
import java.util.Collections;


//Clase controlador
public class ControladorProductosHerrajes implements ICRUD{
    //Arreglo
    public static ArrayList<ProductosHerrajes> arregloProductosHerrajes = new ArrayList<>();
    
    //Metodo insertar objetos
    @Override
    public boolean insertar(Object obj) {
        boolean inserto = true;
        ProductosHerrajes objph = (ProductosHerrajes)obj;
        
        if(arregloProductosHerrajes.isEmpty()){
            inserto = arregloProductosHerrajes.add(objph);
            return inserto;
        } else{
            for(ProductosHerrajes objph1: arregloProductosHerrajes){
                if(objph1.equals(objph)){
                    inserto = false;
                    return inserto;
                }
            }
        }
        if(inserto){
            inserto = arregloProductosHerrajes.add(objph);
            return inserto;
        }
        
        return inserto;
    }

    //Metodo modificar uno, por objeto
    @Override
    public Object modificar(Object obj) {
        ordenar();
        ProductosHerrajes objpph = (ProductosHerrajes)obj;
        int pos = Collections.binarySearch(arregloProductosHerrajes, objpph);
        if(pos > -1){
            objpph = arregloProductosHerrajes.set(pos, objpph);
        }else{
            return null;
        }
        return objpph; //Devuelve true o false
    }
    
    //Metodo consultar un objeto unicamente, uno, por objeto
    @Override
    public Object consultarUno(Object obj) {
        Collections.sort(arregloProductosHerrajes);
        ProductosHerrajes objpph = (ProductosHerrajes)obj;
        int pos = Collections.binarySearch(arregloProductosHerrajes, objpph);
        if (pos<0) {
            objpph = null;
        }else{
            objpph = arregloProductosHerrajes.get(pos);
        }
        return objpph; //Devuelve true o false 
    }

    //Metodo de impresion de todos los objetos existentes
    @Override
    public void consultarGeneral() {
           for(ProductosHerrajes pp: arregloProductosHerrajes)
        {
          System.out.println("\n"+pp.toString());
        }
    }
    
    //Metodo de eliminacion de objetos, uno por objeto
    @Override
    public boolean borrar(Object obj) {
        //UNO, POR OBJETO
        boolean borro = false;
        ProductosHerrajes objpph = (ProductosHerrajes)obj;
        ordenar();
        int pos = Collections.binarySearch(arregloProductosHerrajes, objpph);
        if(pos <= -1)
            return borro;
        else{
            objpph = arregloProductosHerrajes.get(pos);
            borro = arregloProductosHerrajes.remove(objpph);
            return borro;
        }
    }

    //Metodo de ordenamiento por sort 
    @Override
    public void ordenar() {
        Collections.sort(arregloProductosHerrajes);
    }

    @Override
    public void ordenar(int x, int y) {
        //Ordenamiento por quicksort
        ProductosHerrajes pivote = arregloProductosHerrajes.get(x);
        
        int i = x;
        int j = y;
        ProductosHerrajes aux;
        
        while(i < j){
            while(arregloProductosHerrajes.get(i).getNombre().compareToIgnoreCase(pivote.getNombre()) < 1 && i < j) i++;
            while(arregloProductosHerrajes.get(j).getNombre().compareToIgnoreCase(pivote.getNombre())>= 1) j--;
            
            if (i <= j){
                aux = arregloProductosHerrajes.get(i);
                arregloProductosHerrajes.set(i, arregloProductosHerrajes.get(j));
                arregloProductosHerrajes.set(j, aux);
            }
        }
        arregloProductosHerrajes.set(x, arregloProductosHerrajes.get(j));
        arregloProductosHerrajes.set(j, pivote);
        
        if(x <= j-1){
            ordenar(x, j-1);
        }
        if(j+1 <= y){
            ordenar(j+1, y);
        }

    }
    
    public void burbuja(){
        //Ordenamiento por burbuja
        ProductosHerrajes pivote = new ProductosHerrajes();
        
        for(int i= 0; i < arregloProductosHerrajes.size(); i++){
            for(int j = i ; j < arregloProductosHerrajes.size(); j++){
                if(arregloProductosHerrajes.get(i).getMarca().compareToIgnoreCase(arregloProductosHerrajes.get(j).getMarca()) >= 0){
                    pivote = arregloProductosHerrajes.get(i);
                    arregloProductosHerrajes.set(i, arregloProductosHerrajes.get(j));
                    arregloProductosHerrajes.set(j, pivote);
                }
            }
        }
    }
    
     public static ArrayList<ProductosHerrajes> mergeSort(ArrayList<ProductosHerrajes> arregloProductoHerraje){
        //Ordenamiento por mergesort
        if(arregloProductoHerraje == null || arregloProductoHerraje.size() <= 1){
            return arregloProductoHerraje;
        }
         int medio = arregloProductoHerraje.size() / 2;
         int x = 0;
         int y = 0;
         ArrayList<ProductosHerrajes> resultado = new ArrayList<>();
         ArrayList<ProductosHerrajes> mitad1 = new ArrayList<>(arregloProductoHerraje.subList(0, medio));
         ArrayList<ProductosHerrajes> mitad2 = new ArrayList<>(arregloProductoHerraje.subList(medio, arregloProductoHerraje.size()));
         
         mitad1 = mergeSort(mitad1);
         mitad2 = mergeSort(mitad2);
         
         while(x < mitad1.size() && y < mitad2.size()){
             ProductosHerrajes productoH1 = mitad1.get(x);
             ProductosHerrajes productoH2 = mitad2.get(y);
             
             if(Float.compare(productoH1.getCostodeventa(), productoH2.getCostodeventa()) < 0){
                 resultado.add(productoH1);
                 x++;
             } else {
                 resultado.add(productoH2);
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
