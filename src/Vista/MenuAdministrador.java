/**
 *@title: MenuAdministrador.java
 * @description: Menu de administrador para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete 
package Vista;

//Importaciones de clases y apis de java 
import Modelo.Administrador;
import Modelo.Usuario;
import java.util.Scanner;
import java.util.Date;

//Clase menu 
public class MenuAdministrador 
{
    //Inicializacion de escaner y controlador 
    Scanner leerDatos;
    Administrador proAdmicont;
    
    //Constructor 
    public MenuAdministrador()
    {
        proAdmicont = new Administrador();
        leerDatos = new Scanner(System.in);
        insertarDatosDefault();
    }
    
    //Metodo de datos por defecto 
    private void insertarDatosDefault()
    {   
        Date fecha = new Date();
        
        //Administrador 1
        Usuario admi = new Administrador(fecha.toString(), 500000, 156120853, "Juan David", "Fajardo", "Calle 104c #27-47", 30466739, "fajardodavid567@gmai.com", "02/07/2004", "jski912");
        proAdmicont.insertar(admi);
        
        //Administrador 2
        admi = new Administrador(fecha.toString(), 400000, 302937483, "Jose javier", "Gonzales", "Calle 104c", 30987748, "jjgonza2736@gmail.com", "12/11/1999", "jahsla9801");
        proAdmicont.insertar(admi);
    
        //Administrador 3
        admi = new Administrador(fecha.toString(), 800000, 209376891, "William", "Lopez", "Calle 39Q #67-22", 30067087,"wiloper@hotmail.com", "01/07/1995", "9862wil112");
        proAdmicont.insertar(admi);
    }
    
    //Metodo de recoleccion de nuevos datos 
    private void insertarDatos()
    {
        Administrador admi = new Administrador();
        
        System.out.println("\n\n-------- INSERTAR ADMINISTRADOR -------\n");
        System.out.println("Inserte su cedula: ");
        admi.setCedula(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Inserte su nombre: ");
        admi.setNombre(leerDatos.nextLine());
        
        leerDatos.nextLine();
        System.out.println("Inserte su apellido: ");
        admi.setApellido(leerDatos.nextLine());
        
        System.out.println("Inserte su numero telefonico: ");
        admi.setTelefono(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Inserte su direccion residencial: ");
        admi.setDireccion(leerDatos.nextLine());
        
        System.out.println("Inserte su correo electronico: ");
        admi.setEmail(leerDatos.next());
        
        System.out.println("Inserte su fecha de nacimiento: ");
        admi.setFechanacimiento(leerDatos.next());
        
        System.out.println("Inserte su sueldo: ");
        admi.setSueldo(leerDatos.nextInt());
        
        Date fecha = new Date();
        admi.setFechaIngreso(fecha.toString());
        
        if(proAdmicont.insertar(admi)){
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
        if(!proAdmicont.arregloAdministrador.isEmpty()){
            System.out.println("\n\n------ CONSULTAR ADMINISTRADORES ------\n");
            
            proAdmicont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo para consultar un solo objeto
    private void consultarUno()
    {
        Administrador admi = new Administrador();
        
        if(!proAdmicont.arregloAdministrador.isEmpty()){
            System.out.println("\n\n------- CONSULTAR ADMINISTRADOR -------\n");
            System.out.println("Digite la cedula del administrador: ");
            admi.setCedula(leerDatos.nextInt());
            
            admi = (Administrador)proAdmicont.consultarUno(admi);
            if(admi == null){
                System.out.println("\n  *El administrador que busca, no existe.");
            }
            else{
                System.out.println("\n"+admi.toString());
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
        Administrador admi = new Administrador();
        
        if(!proAdmicont.arregloAdministrador.isEmpty()){
            System.out.println("\n\n-------- BORRAR ADMINISTRADOR ---------\n");
            proAdmicont.consultarGeneral();
            System.out.println("Estos son los administradores actuales, inserte la cedula a borrar del administrador: ");
            admi.setCedula(leerDatos.nextInt());
            
            if(proAdmicont.borrar(admi)){
                System.out.println("\n\n    ADMINISTRADOR BORRADO!\n    Digite la opcion 2 para consultar.");
            }else{
                System.out.println("\n  *No fue posible borrar al administrador");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de actualizacion de datos del objeto 
    private void actualizar()
    {
        Administrador admi = new Administrador();
        int opc;
        
        if(!proAdmicont.arregloAdministrador.isEmpty()){
            System.out.println("\n\n------ ACTUALIZAR ADMINISTRADOR --------\n");
            proAdmicont.consultarGeneral();
            System.out.println("Estos son los administradores actuales, inserte la cedula del administrador a actualizar: ");
            admi.setCedula(leerDatos.nextInt());
            
            admi = (Administrador)proAdmicont.consultarUno(admi);
            if(admi != null){
                do{
                    System.out.println("\n\n  Menu de actualizacion del administrador:");
                    System.out.println("      Que desea modificar?");
                    System.out.println("      1. Nombre");
                    System.out.println("      2. Apellido");
                    System.out.println("      3. Telefono");
                    System.out.println("      4. Direccion residencial");
                    System.out.println("      5. Correo electronico");
                    System.out.println("      6. Fecha de nacimiento");
                    System.out.println("      7. Sueldo");
                    System.out.println("      8. volver al MENU ADMINISTRADOR");
                    System.out.println("\n  Digite su opcion: ");
                    
                    opc = leerDatos.nextInt();
                    admi = (Administrador)proAdmicont.consultarUno(admi);
                    
                    switch(opc){
                        case 1:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo nombre: ");
                            admi.setNombre(leerDatos.nextLine());
                        break;
                        
                        case 2:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo apellido: ");
                            admi.setApellido(leerDatos.nextLine());
                        break;
                        
                        case 3:
                            System.out.println("\nNuevo telefono: ");
                            admi.setTelefono(leerDatos.nextInt());
                        break;
                        
                        case 4:
                            leerDatos.nextLine();
                            System.out.println("\nNueva direccion residencial: ");
                            admi.setDireccion(leerDatos.nextLine());
                        break;
                        
                        case 5:
                            System.out.println("\nNuevo correo electronico: ");
                            admi.setEmail(leerDatos.next());
                        break;
                        
                        case 6:
                            System.out.println("\nNueva fecha de nacimiento: ");
                            admi.setFechanacimiento(leerDatos.next());
                        break;
                        
                        case 7:
                            System.out.println("\nNuevo sueldo: ");
                            admi.setSueldo(leerDatos.nextInt());
                        break;
                        
                        case 8:
                            System.out.println("\n\nCargando.....\n");
                            admi = null;
                        break;
                        
                        default:
                            System.out.println("\n\nInsertó una opcion invalida\n\n");
                        break;
                    }
                    if(admi != null){
                        proAdmicont.modificar(admi);
                        System.out.println("\n  Dato actualizado\n    En MENU ADMINISTRADOR Digite la opcion 2 para consultar.");
                    }
                }while(opc < 8);
            }else{
                System.out.println("\n  *El administrador no existe");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de ordenamiento con sort 
    private void ordenarSort(){
        if(!proAdmicont.arregloAdministrador.isEmpty()){
            System.out.println("\n\n----- ORDENAR ADMINISTRADORES(id) -----\n");
            
            proAdmicont.ordenar();
            proAdmicont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    private void ordenarQuickSort(){
        if(!proAdmicont.arregloAdministrador.isEmpty()){
            System.out.println("\n\n----- ORDENAR ADMINISTRADORES(nombre) -----\n");
            
            proAdmicont.ordenar(0, proAdmicont.arregloAdministrador.size()-1);
            proAdmicont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    private void ordenarBurbuja(){
        if(!proAdmicont.arregloAdministrador.isEmpty()){
            System.out.println("\n\n----- ORDENAR ADMINISTRADORES(nombre) -----\n");
            
            proAdmicont.burbuja();
            proAdmicont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia!");
        }
    }
    
    private void ordenarMergeSort(){
        //Administrador admi = new Administrador();
        
        if(!proAdmicont.arregloAdministrador.isEmpty()){
            System.out.println("\n\n----- ORDENAR ADMINISTRADORES(telefono) -----\n");
            
            proAdmicont.arregloAdministrador = proAdmicont.mergeSort(proAdmicont.arregloAdministrador);
            proAdmicont.consultarGeneral();
            
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
            System.out.println("\n\n======= MENU ADMINISTRADORES =======");
            
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
