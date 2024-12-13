/**
 *@title: MenuVendedor.java
 * @description: Menu vendedor para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Vista;

//Importaciones de clases y apis de java
import Controlador.ControladorVendedor;
import java.util.Date;
import java.util.Scanner;
import Modelo.Usuario;
import Modelo.Vendedor;

//Clase menu
public class MenuVendedor 
{
    //Inicializacion de escaner y controlador
    ControladorVendedor  proVendcont;
    Scanner leerDatos;
    
    //Constructor
    public MenuVendedor()
    {
        proVendcont = new ControladorVendedor();
        leerDatos = new Scanner(System.in);
        insertarDatosDefault();
    }
    
    //Metodo de datos por defecto
    private void insertarDatosDefault()
    {   
        Date fecha = new Date();
        
        //Vendedor 1
        Usuario ven = new Vendedor(fecha.toString(), 200000, 98736452, "Elizabeth", "Solorzano", "Calle 76U #32-56", 32060654, "esolorzanot@gmail.com", "07/01/1975", "solorzael98012");
        proVendcont.insertar(ven);
        
        //Vendedor 2
        ven = new Vendedor(fecha.toString(), 600000, 23982299, "Humberto", "Salas", "Calle 76S #89-67", 310909763, "ahsalass@hotmail.com", "09/11/1966", "kjahdik901");
        proVendcont.insertar(ven);
        
        //Vendedor 3
        ven = new Vendedor(fecha.toString(), 500000, 49086790, "Felipe", "Cardenas", "Calle 19D #45-01", 321973636, "fecarden@colombo.edu.co", "11/02/1999", "fel90182car");
        proVendcont.insertar(ven);
    
    }  
    
    //Menu de recoleccion de nuevos datos
    private void insertarDatos()
    {
        Vendedor ven = new Vendedor();
        
        System.out.println("\n\n-------- INSERTAR VENDEDOR -------\n");
        System.out.println("Inserte su cedula: ");
        ven.setCedula(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Inserte su nombre: ");
        ven.setNombre(leerDatos.nextLine());
        
        leerDatos.nextLine();
        System.out.println("Inserte su apellido: ");
        ven.setApellido(leerDatos.nextLine());
        
        System.out.println("Inserte su numero telefonico: ");
        ven.setTelefono(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Inserte su direccion residencial: ");
        ven.setDireccion(leerDatos.nextLine());
        
        System.out.println("Inserte su correo electronico: ");
        ven.setEmail(leerDatos.next());
        
        System.out.println("Inserte su fecha de nacimiento: ");
        ven.setFechanacimiento(leerDatos.next());
        
        System.out.println("Inserte su sueldo: ");
        ven.setSueldo(leerDatos.nextInt());
        
        Date fecha = new Date();
        ven.setFechaIngreso(fecha.toString());
        
        if(proVendcont.insertar(ven)){
            System.out.println("\n  DATOS INSERTADOS CON ÉXITO!");
        }
        else{
            System.out.println("\n<== ERROR AL INSERTAR LOS DATOS ==>");
        }
         System.out.println("\n---------------------------------------");
    }
    
    //Metodo de impresion de todos los objetos existentes
    private void consultarTodos()
    {
        if(!proVendcont.arregloVendedor.isEmpty()){
            System.out.println("\n\n------ CONSULTAR VENDEDORES ------\n");
            
            proVendcont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo para consultar un solo objeto
    private void consultarUno()
    {
        Vendedor ven = new Vendedor();
        
        if(!proVendcont.arregloVendedor.isEmpty()){
            System.out.println("\n\n------- CONSULTAR VENDEDOR -------\n");
            System.out.println("Digite la cedula del vendedor: ");
            ven.setCedula(leerDatos.nextInt());
            
            ven = (Vendedor)proVendcont.consultarUno(ven);
            if(ven == null){
                System.out.println("\n  *El vendedor que busca, no existe");
            }
            else{
                System.out.println("\n"+ven.toString());
                System.out.println("\n---------------------------------------");
            }
        }
        else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de borrado de objetos
    private void borrar()
    {
        Vendedor ven = new Vendedor();
        
        if(!proVendcont.arregloVendedor.isEmpty()){
            System.out.println("\n\n-------- BORRAR VENDEDOR ---------\n");
            proVendcont.consultarGeneral();
            System.out.println("Estos son los vendedores actuales, inserte la cedula a borrar del vendedor: ");
            ven.setCedula(leerDatos.nextInt());
            
            if(proVendcont.borrar(ven)){
                System.out.println("\n\n    VENDEDOR BORRADO!\n    Digite 2 para consultar.");
            }else{
                System.out.println("\n  *No fue posible borrar al vendedor");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de ordenamiento con sort
    private void ordenarSort(){
        if(!proVendcont.arregloVendedor.isEmpty()){
            System.out.println("\n\n----- ORDENAR VENDEDORES(id) -----\n");
            
            proVendcont.ordenar();
            proVendcont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    private void ordenarQuickSort(){
        if(!proVendcont.arregloVendedor.isEmpty()){
            System.out.println("\n\n----- ORDENAR BODEGUEROS(nombre) -----\n");
            
            proVendcont.ordenar(0, proVendcont.arregloVendedor.size()-1);
            proVendcont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    private void ordenarBurbuja(){
        if(!proVendcont.arregloVendedor.isEmpty()){
            System.out.println("\n\n----- ORDENAR BODEGUEROS(nombre) -----\n");
            
            proVendcont.burbuja();
            proVendcont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia!");
        }
    }
    
    private void ordenarMergeSort(){
        //Vendedor vend = new Vendedor();
        
        if(!proVendcont.arregloVendedor.isEmpty()){
            System.out.println("\n\n----- ORDENAR BODEGUEROS(telefono) -----\n");
            
            proVendcont.arregloVendedor = proVendcont.mergeSort(proVendcont.arregloVendedor);
            proVendcont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia!");
        }
    }
    
    //Metodo de actualizacion de datos del objeto
    private void actualizar()
    {
        Vendedor ven = new Vendedor();
        int opc;
        
        if(!proVendcont.arregloVendedor.isEmpty()){
            System.out.println("\n\n------ ACTUALIZAR VENDEDOR --------\n");
            proVendcont.consultarGeneral();
            System.out.println("Estos son los vendedores actuales, inserte la cedula del vendedor a actualizar: ");
            ven.setCedula(leerDatos.nextInt());
            
            ven = (Vendedor)proVendcont.consultarUno(ven);
            if(ven != null){
                do{
                    System.out.println("\n\n  Menu de actualizacion del vendedor:");
                    System.out.println("      Que desea modificar?");
                    System.out.println("      1. Nombre");
                    System.out.println("      2. Apellido");
                    System.out.println("      3. Telefono");
                    System.out.println("      4. Direccion residencial");
                    System.out.println("      5. Correo electronico");
                    System.out.println("      6. Fecha de nacimiento");
                    System.out.println("      7. Sueldo");
                    System.out.println("      8. volver al MENU VENDEDOR");
                    System.out.println("\n  Digite su opcion: ");
                    
                    opc = leerDatos.nextInt();
                    ven = (Vendedor)proVendcont.consultarUno(ven);
                    
                    switch(opc){
                        case 1:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo nombre: ");
                            ven.setNombre(leerDatos.nextLine());
                        break;
                        
                        case 2:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo apellido: ");
                            ven.setApellido(leerDatos.nextLine());
                        break;
                        
                        case 3:
                            System.out.println("\nNuevo telefono: ");
                            ven.setTelefono(leerDatos.nextInt());
                        break;
                        
                        case 4:
                            leerDatos.nextLine();
                            System.out.println("\nNueva direccion residencial: ");
                            ven.setDireccion(leerDatos.nextLine());
                        break;
                        
                        case 5:
                            System.out.println("\nNuevo correo electronico: ");
                            ven.setEmail(leerDatos.next());
                        break;
                        
                        case 6:
                            System.out.println("\nNueva fecha de nacimiento: ");
                            ven.setFechanacimiento(leerDatos.next());
                        break;
                        
                        case 7:
                            System.out.println("\nNuevo sueldo: ");
                            ven.setSueldo(leerDatos.nextInt());
                        break;
                        
                        case 8:
                            System.out.println("\nCargando.....\n");
                            ven = null;
                        break;
                        
                        default:
                            System.out.println("\n\nInserto una opcion invalida\n\n");
                        break;
                    }
                    if(ven != null){
                        proVendcont.modificar(ven);
                        System.out.println("\n  Dato actualizado\n    En MENU VENDEDOR Digite la opcion 2 para consultar.");
                    }
                }while(opc <8);
            }else{
                System.out.println("\n  *El vendedor no existe");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    public void menu()
    {
        int opc;
        
        do{
            System.out.println("\n\n======= MENU VENDEDOR =======");
            
            System.out.println("1. Insertar datos");
            System.out.println("2. Consultar datos");
            System.out.println("3. Consultar un dato");
            System.out.println("4. Modificar datos");
            System.out.println("5. Borrar datos");
            System.out.println("6. Ordenar datos por Sort --------> por Id");
            System.out.println("7. Ordenar datos por QuickSort----> por Nombre");
            System.out.println("8. Ordenar datos por Burbuja------> por Apellido");
            System.out.println("9. Ordenar datos por MergeSort----> por Telefono");
            System.out.println("10. Volver a MENU PRINCIPAL");
            System.out.println("====================================");
            System.out.println("\nDigite su opcion: ");
            
            opc = leerDatos.nextInt();
            
            switch(opc){
                case 1:
                    insertarDatos();
                break;
                
                case 2:
                    consultarTodos();
                break;
                
                case 3:
                    consultarUno();
                break;
                
                case 4:
                    actualizar();
                break;
                
                case 5:
                    borrar();
                break;
                
                case 6:
                    ordenarSort();
                break;
                
                case 7:
                    ordenarQuickSort();
                break;
                
                case 8:
                    ordenarBurbuja();
                break;
                
                case 9:
                    ordenarMergeSort();
                break;
               
                case 10:
                    System.out.println("\n\nCargando.....");
                break;
                
                default:
                    System.out.println("\n\nDigitó una opcion inválida\n\n");
                break;
            }
        }while(opc < 10);
    }
}
