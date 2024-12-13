/**
 *@title: MenuClientes.java
 * @description: Menu clientes para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Vista;

//Importaciones de clases y apis de java
import Controlador.ControladorCliente;
import java.util.Scanner;
import Modelo.Cliente;
import Modelo.Usuario;

//Clase menu
public class MenuCliente 
{
    //Inicializacion de escaner y controlador
    ControladorCliente proCliencont;
    Scanner leerDatos;
    
    //Constructor
    public MenuCliente()
    {
        proCliencont = new ControladorCliente();
        leerDatos = new Scanner(System.in);
        insertarDatosDefault();
    }
    
    //Metodo de datos por defecto 
    private void insertarDatosDefault()
    {
        //Cliente 1
        Usuario cli = new Cliente(60982736, "Juan Carlos", "Vargas", "Calle 12G #21-32", 3098273, "jcvid@hotmail.com", "07/05/1976", "jcvm1976");
        proCliencont.insertar(cli);
        
        //Cliente 2
        cli = new Cliente(42981728, "Laura", "Herrera", "Calle 32j #11-01", 32098839, "laherrera@gmail.com", "20/04/2000", "lkha6534");
        proCliencont.insertar(cli);
    
        //Cliente 3
        cli = new Cliente(21902980, "Ana", "Martinez", "Calle 89U #54-01", 34587901, "anispa@outlook.com", "10/05/1986", "ani9819pao01");
        proCliencont.insertar(cli);
        
    }
    
    //Metodo de recoleccion de nuevos datos
    private void insertarDatos()
    {
        Cliente cli = new Cliente();
        
        System.out.println("\n\n-------- INSERTAR CLIENTE -------\n");
        System.out.println("Inserte su cedula: ");
        cli.setCedula(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Inserte su nombre: ");
        cli.setNombre(leerDatos.nextLine()); 
        
        leerDatos.nextLine();
        System.out.println("Inserte el apellido: ");
        cli.setApellido(leerDatos.nextLine());
        
        System.out.println("Inserte el telefono: ");
        cli.setTelefono(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Inserte la direccion residencial: ");
        cli.setDireccion(leerDatos.nextLine());
        
        System.out.println("Inserte el correo: ");
        cli.setEmail(leerDatos.next());
        
        System.out.println("Inserte la fecha de nacimiento: ");
        cli.setFechanacimiento(leerDatos.next());
        
        if(proCliencont.insertar(cli)){
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
        if(!proCliencont.arregloCliente.isEmpty()){
            System.out.println("\n\n------ CONSULTAR CLIENTES ------\n");
            
            proCliencont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo para cosultar un solo objeto
    private void consultarUno()
    {
        Cliente cli = new Cliente();
        
        if(!ControladorCliente.arregloCliente.isEmpty()){
            System.out.println("\n\n------- CONSULTAR CLIENTE -------\n");
            System.out.println("Digite la cedula del cliente: ");
            cli.setCedula(leerDatos.nextInt());
            
            cli=(Cliente)proCliencont.consultarUno(cli);
            if(cli == null){
                System.out.println("\n  *El cliente que busca, no existe");
            }
            else{
                System.out.println("\n"+cli.toString());
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
        Cliente cli = new Cliente();
        
        if(!proCliencont.arregloCliente.isEmpty()){
            System.out.println("\n\n-------- BORRAR CLIENTE ---------\n");
            proCliencont.consultarGeneral();
            System.out.println("Estos son los clientes actuales, inserte la cedula a borrar del cliente: ");
            cli.setCedula(leerDatos.nextInt());
            
            if(proCliencont.borrar(cli)){
                System.out.println("\n\n    CLIENTE BORRADO!\n    Digite 2 para consultar.");
            }else{
                System.out.println("\n  *No fue posible borrar al cliente");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de actualizacion de datos del objeto
    private void actualizar()
    {
        Cliente cli = new Cliente();
        int opc;
        
        if(!proCliencont.arregloCliente.isEmpty()){
            System.out.println("\n\n------ ACTUALIZAR CLIENTE --------\n");
            proCliencont.consultarGeneral();
            System.out.println("Estos son los clientes actuales, inserte la cedula del cliente a actualizar: ");
            cli.setCedula(leerDatos.nextInt());
            
            cli = (Cliente)proCliencont.consultarUno(cli);
            if(cli != null){
                do{
                    System.out.println("\n\n  Menu de actualizacion del cliente");
                    System.out.println("      Que desea modificar?");
                    System.out.println("      1. Nombre");
                    System.out.println("      2, Apellido");
                    System.out.println("      3. Telefono");
                    System.out.println("      4. Direccion residencial");
                    System.out.println("      5. Correo electronico");
                    System.out.println("      6. Fecha de nacimiento");
                    System.out.println("      7. Volver al MENU CLIENTE");
                    System.out.println("\n  Digite su opcion: ");
                    
                    opc = leerDatos.nextInt();
                    cli = (Cliente)proCliencont.consultarUno(cli);
                    
                    switch(opc){
                        case 1:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo nombre: ");
                            cli.setNombre(leerDatos.nextLine());
                        break;
                        
                        case 2:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo apellido: ");
                            cli.setApellido(leerDatos.nextLine());
                        break;
                        
                        case 3:
                            System.out.println("\nNuevo telefono: ");
                            cli.setTelefono(leerDatos.nextInt());
                        break;
                        
                        case 4:
                            leerDatos.nextLine();
                            System.out.println("\nNueva direccion residencial: ");
                            cli.setDireccion(leerDatos.nextLine());
                        break;
                        
                        case 5:
                            System.out.println("\nNuevo correo electronico: ");
                            cli.setEmail(leerDatos.next());
                        break;
                        
                        case 6:
                            System.out.println("\nNueva fecha de nacimiento: ");
                            cli.setFechanacimiento(leerDatos.next());
                        break;
                        
                        case 7:
                            System.out.println("\n\nCargando.....\n");
                            cli = null;
                        break;
                        
                        default:
                            System.out.println("\n\nInsertó una opcion invalida\n\n");
                        break;
                    }
                    if(cli != null){
                        proCliencont.modificar(cli);
                        System.out.println("\n  Dato actualizado\n    En MENU CLIENTE Digite la opcion 2 para consultar");
                    }
                }while(opc < 7);
            }else{
                System.out.println("\n *El cliente no existe");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }     
    }
    
    private void ordenarSort(){
        if(!proCliencont.arregloCliente.isEmpty()){
            System.out.println("\n\n----- ORDENAR CLIENTES(id) -----\n");
            
            proCliencont.ordenar();
            proCliencont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    private void ordenarQuickSort(){
        if(!proCliencont.arregloCliente.isEmpty()){
            System.out.println("\n\n----- ORDENAR BODEGUEROS(nombre) -----\n");
            
            proCliencont.ordenar(0, proCliencont.arregloCliente.size()-1);
            proCliencont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    private void ordenarBurbuja(){
        if(!proCliencont.arregloCliente.isEmpty()){
            System.out.println("\n\n----- ORDENAR BODEGUEROS(nombre) -----\n");
            
            proCliencont.burbuja();
            proCliencont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia!");
        }
    }
    
    private void ordenarMergeSort(){
        //Cliente clien = new Cliente();
        
        if(!proCliencont.arregloCliente.isEmpty()){
            System.out.println("\n\n----- ORDENAR BODEGUEROS(telefono) -----\n");
            
            proCliencont.arregloCliente = proCliencont.mergeSort(proCliencont.arregloCliente);
            proCliencont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia!");
        }
    }
    
    
    //Menu principal
    public void menu()
    {
        int opc;
        
        do{
            System.out.println("\n\n======= MENU CLIENTES =======");
            
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
                    System.out.println("\n\nDigitó una opcion invalida\n\n");
                break;
            }
        }while(opc < 10);
    }
}
