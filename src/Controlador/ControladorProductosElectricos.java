/**
 *@title: ControladorProductosElectricos.java
 * @description: Controlador de productos electricos para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Controlador;

//Importaciones de clases y apis de java
import Modelo.ProductosElectricos;
import java.util.ArrayList;
import java.util.Collections;
        
//Clase controlador
public class ControladorProductosElectricos implements ICRUD {
    //Arreglo
    public static ArrayList<ProductosElectricos> arregloProductosElectricos = new ArrayList <>();
    
    //Metodo insertar objetos
    @Override
    public boolean insertar(Object obj) {
        boolean inserto = true;
        ProductosElectricos objpe = (ProductosElectricos)obj;
        
        if(arregloProductosElectricos.isEmpty()){
            inserto = arregloProductosElectricos.add(objpe);
            return inserto;
        } else{
            for(ProductosElectricos objpe1: arregloProductosElectricos){
                if(objpe1.equals(objpe)){
                    inserto = false;
                    return inserto;
                }
            }
        }
        if(inserto){
            inserto = arregloProductosElectricos.add(objpe);
            return inserto;
        }
        
        return inserto;
    }

    //Metodo modificar uno, por objeto
    @Override
    public Object modificar(Object obj) {
        ordenar();
        ProductosElectricos objppe = (ProductosElectricos)obj;
        int pos = Collections.binarySearch(arregloProductosElectricos, objppe);
        if(pos > -1){
            objppe = arregloProductosElectricos.set(pos, objppe);
        }else{
            return null;
        }
        return objppe; //Devuelve true o false
    }

    //Metodo consultar uno unicamente, uno, por objeto 
    @Override
    public Object consultarUno(Object obj) {
        Collections.sort(arregloProductosElectricos);
        ProductosElectricos objppe = (ProductosElectricos)obj;
        int pos = Collections.binarySearch(arregloProductosElectricos, objppe);
        if (pos<0) {
            objppe = null;
        }else{
            objppe = arregloProductosElectricos.get(pos);
        }
        return objppe;
    }

    //Metodo de impresion de todos los objetos existentes 
    @Override
    public void consultarGeneral() {
         for(ProductosElectricos ppe: arregloProductosElectricos)
        {
          System.out.println("\n"+ppe.toString());
        }
    }

    //Metodo de eliminacion de objetos, uno por objeto
    @Override
    public boolean borrar(Object obj) {
        //UNO, POR OBJETO
        boolean borro = false;
        ProductosElectricos objppe = (ProductosElectricos)obj;
        ordenar();
        int pos = Collections.binarySearch(arregloProductosElectricos, objppe);
        if(pos <= -1)
            return borro;
        else{
            objppe = arregloProductosElectricos.get(pos);
            borro = arregloProductosElectricos.remove(objppe);
            return borro;
        }
    }

    //Metodo de ordenamiento por sort
    @Override
    public void ordenar() {
        Collections.sort(arregloProductosElectricos);
    }
    
    
    @Override
    public void ordenar(int x, int y) {
        //Ordenamiento por quicksort
        ProductosElectricos pivote = arregloProductosElectricos.get(x);
        
        int i = x;
        int j = y;
        ProductosElectricos aux;
        
        while(i < j){
            while(arregloProductosElectricos.get(i).getNombre().compareToIgnoreCase(pivote.getNombre()) < 1 && i < j) i++;
            while(arregloProductosElectricos.get(j).getNombre().compareToIgnoreCase(pivote.getNombre())>= 1) j--;
            
            if (i <= j){
                aux = arregloProductosElectricos.get(i);
                arregloProductosElectricos.set(i, arregloProductosElectricos.get(j));
                arregloProductosElectricos.set(j, aux);
            }
        }
        arregloProductosElectricos.set(x, arregloProductosElectricos.get(j));
        arregloProductosElectricos.set(j, pivote);
        
        if(x <= j-1){
            ordenar(x, j-1);
        }
        if(j+1 <= y){
            ordenar(j+1, y);
        }
    
    }
    
    public void burbuja(){
        //Ordenamiento por burbuja
        ProductosElectricos pivote = new ProductosElectricos();
        for(int i= 0; i < arregloProductosElectricos.size(); i++){
            for(int j = i ; j < arregloProductosElectricos.size(); j++){
                if(arregloProductosElectricos.get(i).getMarca().compareToIgnoreCase(arregloProductosElectricos.get(j).getMarca()) >= 0){
                    pivote = arregloProductosElectricos.get(i);
                    arregloProductosElectricos.set(i, arregloProductosElectricos.get(j));
                    arregloProductosElectricos.set(j, pivote);
                }
            }
        }
    }
    
    public static ArrayList<ProductosElectricos> mergeSort(ArrayList<ProductosElectricos> arregloProductoElectrico){
        //Ordenamiento por mergesort
        if(arregloProductoElectrico == null || arregloProductoElectrico.size() <= 1){
            return arregloProductoElectrico;
        }
         int medio = arregloProductoElectrico.size() / 2;
         int x = 0;
         int y = 0;
         ArrayList<ProductosElectricos> resultado = new ArrayList<>();
         ArrayList<ProductosElectricos> mitad1 = new ArrayList<>(arregloProductoElectrico.subList(0, medio));
         ArrayList<ProductosElectricos> mitad2 = new ArrayList<>(arregloProductoElectrico.subList(medio, arregloProductoElectrico.size()));
         
         mitad1 = mergeSort(mitad1);
         mitad2 = mergeSort(mitad2);
         
         while(x < mitad1.size() && y < mitad2.size()){
             ProductosElectricos productoE1 = mitad1.get(x);
             ProductosElectricos productoE2 = mitad2.get(y);
             
             if(Float.compare(productoE1.getCostodeventa(), productoE2.getCostodeventa()) < 0){
                 resultado.add(productoE1);
                 x++;
             } else {
                 resultado.add(productoE2);
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
