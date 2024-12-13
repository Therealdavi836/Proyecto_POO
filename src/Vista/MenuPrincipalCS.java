/**
 * @title: MenuPrincipalCS
 * @description: Controlador-menu principal para el proyecto CadenaSuministros
 * @date: 
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Vista;

import java.util.Scanner;

public class MenuPrincipalCS {
       private static Scanner leerDatos = new Scanner(System.in);
       
       //Sub-menus
       private static MenuProductosHerrajes menuProductosHerrajes = new MenuProductosHerrajes();
       private static MenuProductosElectricos menuProductosElectricos = new MenuProductosElectricos();
       private static MenuAdministrador menuAdministrador = new MenuAdministrador();
       private static MenuBodegueros menuBodegueros = new MenuBodegueros();
       private static MenuCliente menuCliente = new MenuCliente();
       private static MenuVendedor menuVendedor = new MenuVendedor();
       
       private static void menuCS(){
           int opc;
           
           do{
               System.out.println("========= MENU PRINCIPAL ==========");
               
               System.out.println("\n Para productos:");
               System.out.println("   1. Productos Herrajes");
               System.out.println("   2. Productos Electricos");
               System.out.println("\n Para Usuarios:");
               System.out.println("   3. Administradores");
               System.out.println("   4. Bodegueros");
               System.out.println("   5. Clientes");
               System.out.println("   6. Vendedores");
               System.out.println("\n   7. SALIR\n");
               System.out.println("===================================");
               System.out.println("\nDigite la opcion:  ");
               opc = leerDatos.nextInt();
               
               switch(opc){
                    case 1:
                       menuProductosHerrajes.menu();
                       System.out.println("\n\n");
                    break;
                    
                    case 2:
                        menuProductosElectricos.menu();
                        System.out.println("\n\n");
                    break;
                    
                    case 3:
                        menuAdministrador.menu();
                        System.out.println("\n\n");
                    break;
                    
                    case 4:
                        menuBodegueros.menu();
                        System.out.println("\n\n");
                    break;
                    
                    case 5:
                        menuCliente.menu();
                        System.out.println("\n\n");
                    break;
                    
                    case 6:
                        menuVendedor.menu();
                        System.out.println("\n\n");
                    break;
                    
                    case 7:
                        System.out.println("\n\n\nSaliendo del programa...");
                    break;
                    
                    default:
                        System.out.println("\n\nDigitó una opcion inválida\n\n");
                    break;
               }
           }while(opc < 7);
       }
       
//    public static void main(String[] args) {
//        menuCS();
//    }
}
