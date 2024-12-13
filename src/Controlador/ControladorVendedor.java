/**
 *@title: ControladorVendedor.java
 * @description: Controlador de vendedores para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Controlador;

//Importaciones de clases y apis de java 
import Modelo.Vendedor;
import java.util.ArrayList;
import java.util.Collections;

//Clase controlador
public class ControladorVendedor implements ICRUD{
    //Arreglo 
    public static ArrayList<Vendedor> arregloVendedor = new ArrayList<>();
    
    //Metodo insertar objetos
    @Override
    public boolean insertar(Object obj) {
        boolean inserto = true;
        Vendedor ven = new Vendedor();
        ven = (Vendedor)obj;
        
        if(arregloVendedor.isEmpty()){
            arregloVendedor.add(ven);
            return inserto = true;
        }
        else{
            for(Vendedor admi1: arregloVendedor){
                if(admi1.equals(ven)){
                    return inserto = true;
                }
            }
        }
        if(inserto){
            arregloVendedor.add(ven);
            return inserto = true;
        }
        
        return inserto;
    }

    //Metodo modificar uno, por objeto
    @Override
    public Object modificar(Object obj) {
        ordenar();
        Vendedor vend = (Vendedor)obj;
        int pos = Collections.binarySearch(arregloVendedor, vend);
        if(pos > -1){
            vend = arregloVendedor.set(pos, vend);
        } else{
            return null;
        }
        return vend; //Devuelve true o false
    }

    //Metodo consultar un objeto unicamente, uno, por objeto
    @Override
    public Object consultarUno(Object obj) {
        Collections.sort(arregloVendedor);
        Vendedor vend = (Vendedor)obj;
        int pos = Collections.binarySearch(arregloVendedor, vend);
        if (pos<0) {
            vend = null;
        }else{
            vend = arregloVendedor.get(pos);
        }
        return vend; //Devuelve true o false
    }

    //Metodo de impresion de todos los objetos existentes
    @Override
    public void consultarGeneral() {
        for (Vendedor vend: arregloVendedor){
            System.out.println(vend.toString());
        }
    }

    //Metodo de eliminacion de objetos, uno por objeto
    @Override
    public boolean borrar(Object obj) {
        boolean borro = false;
        Vendedor vend = (Vendedor)obj;
        ordenar();
        int pos = Collections.binarySearch(arregloVendedor, vend);
        if(pos <= -1)
            return borro;
        else{
            vend = arregloVendedor.get(pos);
            borro = arregloVendedor.remove(vend);
            return borro;
        }
    }

    //Metodo de ordenamiento por sort
    @Override
    public void ordenar() {
        Collections.sort(arregloVendedor);
    }

    @Override
    public void ordenar(int x, int y) {
        //Ordenamiento por quicksort
        Vendedor pivote = arregloVendedor.get(x);
        
        int i = x;
        int j = y;
        Vendedor aux;
        
        while(i < j){
            while(arregloVendedor.get(i).getNombre().compareToIgnoreCase(pivote.getNombre()) < 1 && i < j) i++;
            while(arregloVendedor.get(j).getNombre().compareToIgnoreCase(pivote.getNombre())>= 1) j--;
            
            if (i <= j){
                aux = arregloVendedor.get(i);
                arregloVendedor.set(i, arregloVendedor.get(j));
                arregloVendedor.set(j, aux);
            }
        }
        arregloVendedor.set(x, arregloVendedor.get(j));
        arregloVendedor.set(j, pivote);
        
        if(x <= j-1){
            ordenar(x, j-1);
        }
        if(j+1 <= y){
            ordenar(j+1, y);
        }
    }
    
    public void burbuja(){
        //Ordenamiento por burbuja 
        Vendedor pivote = new Vendedor();
        
        for (int i = 0; i < arregloVendedor.size(); i++) {                  
            for (int j = i; j < arregloVendedor.size(); j++) {             
                if (arregloVendedor.get(i).getApellido().compareToIgnoreCase(arregloVendedor.get(j).getApellido()) >= 0){
                    pivote = arregloVendedor.get(i);
                    arregloVendedor.set(i, arregloVendedor.get(j));
                    arregloVendedor.set(j, pivote);
                }
            }
        }
    }
    
    public static ArrayList<Vendedor> mergeSort(ArrayList<Vendedor> arregloVendedores){
        //Ordenamiento por mergesort
        if(arregloVendedores == null || arregloVendedores.size() <= 1){
            return arregloVendedores;
        }
         int medio = arregloVendedores.size() / 2;
         int x = 0;
         int y = 0;
         ArrayList<Vendedor> resultado = new ArrayList<>();
         ArrayList<Vendedor> mitad1 = new ArrayList<>(arregloVendedores.subList(0, medio));
         ArrayList<Vendedor> mitad2 = new ArrayList<>(arregloVendedores.subList(medio, arregloVendedores.size()));
         
         mitad1 = mergeSort(mitad1);
         mitad2 = mergeSort(mitad2);
         
         while(x < mitad1.size() && y < mitad2.size()){
             Vendedor vendedorE1 = mitad1.get(x);
             Vendedor vendedorE2 = mitad2.get(y);
             
             if(Float.compare(vendedorE1.getTelefono(), vendedorE2.getTelefono()) < 0){
                 resultado.add(vendedorE1);
                 x++;
             } else {
                 resultado.add(vendedorE2);
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
