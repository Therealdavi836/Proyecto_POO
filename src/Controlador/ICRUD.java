/**
 *@title: ICRUD.java
 * @description: ICRUD para el proyecto de CadenaSuministros 
 * @date: Domingo 24 de septiembre de 2023 
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas 
 */

package Controlador;

//Interface con metodos abstractos 
public interface ICRUD {
    
    public boolean insertar(Object obj); 
    
    public Object modificar(Object obj);
    
    public Object consultarUno(Object obj);
    
    public void consultarGeneral();
    
    public boolean borrar(Object obj);
    
    public void ordenar();
    
    public void ordenar(int x, int y);
}
