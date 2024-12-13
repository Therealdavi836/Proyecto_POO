/**
 * @title: PrincipalM2.java
 * @description: Segundo controlador principal para la sustentacion del proyecto CadenaSuministros.
 * @date: Lunes 2 de octubre del 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt 
 */

//Paquete para la sustentacion 
package Sustentacion1;

//Importacion de las clases requeridas y el escaner
import Controlador.ControladorProductosHerrajes;
import java.util.Scanner;
import Modelo.Producto;
import Modelo.ProductosHerrajes;

//Clase para la sustentacion 
public class PrincipalM2 {
    //Inicializacion de menu, controlador y escaner 
    private static PrincipalM2 menuPH = new PrincipalM2();
    ControladorProductosHerrajes proConth;
    Scanner leerDatos;
    
    //Constructor de la clases para la sustentacion 
    public PrincipalM2(){
        proConth = new ControladorProductosHerrajes();
        leerDatos = new Scanner(System.in);
        
        insertarDatosDefault();
    }
    
    //Menu nuevo para la clase de la sustentacion, sin usar el menu principal  
    private void menu(){
        int opc;
        do{
            System.out.println("\n\n======== MENU SUSTENTACION ========");
            System.out.println("  Seleccione las opciones requeridas: ");
            System.out.println("  1. Borrar producto de herraje: ");
            System.out.println("  2. Consultar productos de herraje: ");
            System.out.println("  3. SALIR");
            System.out.println("===================================");
            System.out.println("\nDigite su opcion: ");
            
            opc = leerDatos.nextInt();
            
            switch(opc){
                case 1:
                    menuPH.borrarPPH();
                break;
                
                case 2:
                    menuPH.consultarPPH();
                break;
                
                case 3:
                    System.out.println("\n\n\nSaliendo del programa...");
                break;
                
                default:
                    System.out.println("\n\nDigito una opcion invalida\n\n");
                break;
            }
        }while(opc < 3); 
    }
    
    //Creacion de los productos de herrajes con el constructor completo 
    private void insertarDatosDefault(){
        //Producto 1
        Producto pph = new ProductosHerrajes("Para duchas", 121, "Manivela", "Plateado", "", "Koch", "Hierro", 4, 2000, 7000, 200, 100);
        proConth.insertar(pph);
        
        //Producto 2
        pph = new ProductosHerrajes("Para armarios", 122, "Manija", "Negro", "", "Riduco", "Plastico", 4, 200, 4000, 500, 23);
        proConth.insertar(pph);
        
        //Producto 3
        pph = new ProductosHerrajes("Para gabinetes", 123, "Candado", "Dorado", "", "Induma", "Acero", 4, 5000, 30000, 700, 35);
        proConth.insertar(pph);
        
        //Producto 4
        pph = new ProductosHerrajes("Para manijas", 124, "Palanca", "Rojo", "", "Bellota", "Porcelana", 4, 3000, 12000, 900, 60);
        proConth.insertar(pph);
    }
    
    //Metodo requerido para borrar el producto de herraje a seleccionar 
    private void borrarPPH(){
    
        ProductosHerrajes pph = new ProductosHerrajes();
        
        //Validacion del arreglo dado el caso de que se encuentre vacio 
        if(!proConth.arregloProductosHerrajes.isEmpty()){
            System.out.println("\n\n------------- BORRAR PRODUCTO HERRAJE -------------\n");
            proConth.consultarGeneral();
            System.out.println("Estos son los productos herrajes actuales, inserte el serial del producto a borrar: ");
            pph.setSerial(leerDatos.nextInt());
            
            if(proConth.borrar(pph)){
                System.out.println("\n\n    PRODUCTO HERRAJE BORRADO!\n    Digite 2 para consultar.");
            }else{
                System.out.println("\n  *No fue posible borrar el producto");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo para cosultar todos los productos de herrajes disponibles en el arreglo para la sustentacion 
    private void consultarPPH(){
        //Validacion del arreglo dado el caso de que se encuentre vacio
        if(!proConth.arregloProductosHerrajes.isEmpty()){
            System.out.println("\n\n----------- CONSULTAR PRODUCTOS DE HERRAJES -----------\n");
            
            //Se llama al metodo consultar general desde el controlador importado 
            proConth.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia!");
        }
    }
    
   //Metodo principal de esta clase para no usar el menu principal del proyecto 
//   public static void main(String[] args) {
//        menuPH.menu();
//   }
}
