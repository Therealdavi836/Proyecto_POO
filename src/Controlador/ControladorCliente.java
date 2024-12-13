/**
 *@title: ControladorCliente.java
 * @description: Controlador de clientes para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Controlador;

//Importaciones de clases y apis de java
import java.util.ArrayList;
import java.util.Collections;
import Modelo.Cliente;

//Clase controlador
public class ControladorCliente implements ICRUD{
    //Arreglo
    public static ArrayList<Cliente> arregloCliente = new ArrayList<>();
    
    //Metodo insertar objetos
    @Override
    public boolean insertar(Object obj) {
        boolean inserto = true;
        Cliente cli = (Cliente)obj;
        
        if(arregloCliente.isEmpty()){
            inserto = arregloCliente.add(cli);
            return inserto;
        } else{
            for(Cliente cli1: arregloCliente){
                if(cli1.equals(cli)){
                    inserto = true;
                    return inserto;
                }
            }
        }
        if(inserto){
            inserto = arregloCliente.add(cli);
            return inserto;
        }
        
        return inserto;
   }
    
    //Metodo modificar uno, por objeto
    @Override
    public Object modificar(Object obj) {
       ordenar();
       Cliente cli = (Cliente)obj;
       int pos = Collections.binarySearch(arregloCliente, cli);
       if(pos > -1){
           cli = arregloCliente.set(pos, cli);
       }else{
           return null;
       }
       return cli; //Devuelve true o false
    }
    
    //Metodo consultar un objeto unicamento, uno, por objeto
    @Override
    public Object consultarUno(Object obj) {
        Cliente cli = new Cliente();
        cli = (Cliente)obj;
        ordenar();
        int pos = Collections.binarySearch(arregloCliente, cli);
        if(pos <= -1)
            return null;
        else
            cli = arregloCliente.get(pos);
        
        return cli;
    }
    
    //Metodo de impresion de todos los objetos existentes
    @Override
    public void consultarGeneral() {
        for(Cliente clien: arregloCliente)
        {
          System.out.println("\n"+clien.toString());
        }
    }
    
    //Metodo de eliminacion de objetos, uno por objeto
    @Override
    public boolean borrar(Object obj) {
        boolean borro = false;
        Cliente clien = (Cliente)obj;
        ordenar();
        int pos = Collections.binarySearch(arregloCliente, clien);
        if(pos <= -1)
            return borro;
        else{
            clien = arregloCliente.get(pos);
            borro = arregloCliente.remove(clien);
            return borro;
        }
    }

    //Metodo de ordenamiento por sort
    @Override
    public void ordenar() {
        Collections.sort(arregloCliente);
    }
    
    @Override
    public void ordenar(int x, int y) {
        //Ordenamiento por quicksort
        Cliente pivote = arregloCliente.get(x);
        
        int i = x;
        int j = y;
        Cliente aux;
        
        while(i < j){
            while(arregloCliente.get(i).getNombre().compareToIgnoreCase(pivote.getNombre()) < 1 && i < j) i++;
            while(arregloCliente.get(j).getNombre().compareToIgnoreCase(pivote.getNombre())>= 1) j--;
            
            if (i <= j){
                aux = arregloCliente.get(i);
                arregloCliente.set(i, arregloCliente.get(j));
                arregloCliente.set(j, aux);
            }
        }
        arregloCliente.set(x, arregloCliente.get(j));
        arregloCliente.set(j, pivote);
        
        if(x <= j-1){
            ordenar(x, j-1);
        }
        if(j+1 <= y){
            ordenar(j+1, y);
        }
    }

    public void burbuja(){
        //Ordenamiento por burbuja 
        Cliente pivote = new Cliente();
        
        for (int i = 0; i < arregloCliente.size(); i++) {                  
            for (int j = i; j < arregloCliente.size(); j++) {             
                if (arregloCliente.get(i).getApellido().compareToIgnoreCase(arregloCliente.get(j).getApellido()) >= 0){
                    pivote = arregloCliente.get(i);
                    arregloCliente.set(i, arregloCliente.get(j));
                    arregloCliente.set(j, pivote);
                }
            }
        }
    }
    
    public static ArrayList<Cliente> mergeSort(ArrayList<Cliente> arregloClientes){
        //Ordenamiento por mergesort
        if(arregloClientes == null || arregloClientes.size() <= 1){
            return arregloClientes;
        }
         int medio = arregloClientes.size() / 2;
         int x = 0;
         int y = 0;
         ArrayList<Cliente> resultado = new ArrayList<>();
         ArrayList<Cliente> mitad1 = new ArrayList<>(arregloClientes.subList(0, medio));
         ArrayList<Cliente> mitad2 = new ArrayList<>(arregloClientes.subList(medio, arregloClientes.size()));
         
         mitad1 = mergeSort(mitad1);
         mitad2 = mergeSort(mitad2);
         
         while(x < mitad1.size() && y < mitad2.size()){
             Cliente clienteE1 = mitad1.get(x);
             Cliente clienteE2 = mitad2.get(y);
             
             if(Float.compare(clienteE1.getTelefono(), clienteE2.getTelefono()) < 0){
                 resultado.add(clienteE1);
                 x++;
             } else {
                 resultado.add(clienteE2);
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
