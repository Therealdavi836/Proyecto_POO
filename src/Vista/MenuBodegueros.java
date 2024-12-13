/**
 *@title: MenuBodegueros.java
 * @description: Menu bodegueros para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Vista;

//Importaciones de clases y apis de java
import Controlador.ControladorBodegueros;
import java.util.Date;
import java.util.Scanner;
import Modelo.Usuario;
import Modelo.Bodegueros;

//Clase menu 
public class MenuBodegueros 
{   
    //Inicializacion de escaner y controlador 
    ControladorBodegueros proBodecont;
    Scanner leerDatos;
    
    //Constructor
    public MenuBodegueros()
    {
        proBodecont = new ControladorBodegueros();
        leerDatos = new Scanner(System.in);
        insertarDatosDefault();
    }
    
    //Metodo de datos por defecto 
    private void insertarDatosDefault()
    {
        Date fecha = new Date();
        
        //Bodeguero 1
        Usuario bode = new Bodegueros(fecha.toString(), 1000000, 20973819, "Andres", "Alonso", "Calle 30O #90-01", 38902937, "Aalonsop@hotmail.com", "12/09/1998", "alon1998opl2"); 
        proBodecont.insertar(bode);
        
        //Bodeguero 2
        bode = new Bodegueros(fecha.toString(), 1000000, 98393129, "Leonardo", "Perez", "Calle 34R #21-98", 30098637, "lmore345@gmail.com", "21/12/1990", "lmju89'1q");
        proBodecont.insertar(bode);
        
        //Bodeguero 3
        bode = new Bodegueros(fecha.toString(), 2000000, 54293808, "Santiago", "Rosero", "Calle 90P #12-62", 311097263, "elopsan@gmail.com", "14/6/1993", "679sant12g");
        proBodecont.insertar(bode);
        
    }
    
    //Metodo de recoleccion de nuevos datos
    private void insertarDatos()
    {
        Bodegueros bode = new Bodegueros();
        
        System.out.println("\n\n-------- INSERTAR BODEGUERO -------\n");
        System.out.println("Inserte su cedula: ");
        bode.setCedula(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Inserte su nombre: ");
        bode.setNombre(leerDatos.nextLine());
        
        leerDatos.nextLine();
        System.out.println("Inserte el apellido: ");
        bode.setApellido(leerDatos.nextLine());
        
        System.out.println("Inserte el telefono: ");
        bode.setTelefono(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Inserte la direccion residencial: ");
        bode.setDireccion(leerDatos.nextLine());
        
        System.out.println("Inserte el correo: ");
        bode.setEmail(leerDatos.next());
        
        System.out.println("Inserte la fecha de nacimiento: ");
        bode.setFechanacimiento(leerDatos.next());
        
        System.out.println("Inserte su sueldo: ");
        bode.setSueldo(leerDatos.nextInt());
        
        Date fecha = new Date();
        bode.setFechaIngreso(fecha.toString());
        
        if(proBodecont.insertar(bode)){
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
        if(!proBodecont.arregloBodegueros.isEmpty()){
            System.out.println("\n\n------ CONSULTAR BODEGUEROS ------\n");
            
            proBodecont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo para consultar un solo objeto
    private void consultarUno()
    {
        Bodegueros bode = new Bodegueros();
        
        if(!ControladorBodegueros.arregloBodegueros.isEmpty()){
            System.out.println("\n\n------- CONSULTAR BODEGUEROS -------\n");
            System.out.println("Digite la cedula del bodeguero: ");
            bode.setCedula(leerDatos.nextInt());
            
            bode=(Bodegueros)proBodecont.consultarUno(bode);
            if(bode == null){
                System.out.println("\n  *El bodeguero que busca, no existe");
            }
            else{
                System.out.println("\n"+bode.toString());
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
        Bodegueros bode = new Bodegueros();
        
        if(!proBodecont.arregloBodegueros.isEmpty()){
            System.out.println("\n\n-------- BORRAR BODEGUERO ---------\n");
            proBodecont.consultarGeneral();
            System.out.println("Estos son los bodegueros actuales, inserte la cedula a borrar del bodeguero: ");
            bode.setCedula(leerDatos.nextInt());
            
            if(proBodecont.borrar(bode)){
                System.out.println("\n\n    BODEGUERO BORRADO!\n    Digite 2 para consultar.");
            }else{
                System.out.println("\n  *No fue posible borrar al bodeguero");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de actualizacion de datos del objeto
    private void actualizar()
    {
        Bodegueros bode = new Bodegueros();
        int opc;
        
        if(!proBodecont.arregloBodegueros.isEmpty()){
            System.out.println("\n\n------ ACTUALIZAR BODEGUERO --------\n");
            proBodecont.consultarGeneral();
            System.out.println("Estos son los bodegueros actuales, inserte la cedula del bodeguero a actualizar: ");
            bode.setCedula(leerDatos.nextInt());
            
            bode = (Bodegueros)proBodecont.consultarUno(bode);
            if(bode != null){
                do{
                    System.out.println("\n\n  Menu de actualizacion del bodeguero");
                    System.out.println("      Que desea modificar?");
                    System.out.println("      1. Nombre");
                    System.out.println("      2, Apellido");
                    System.out.println("      3. Telefono");
                    System.out.println("      4. Direccion residencial");
                    System.out.println("      5. Correo electronico");
                    System.out.println("      6. Fecha de nacimiento");
                    System.out.println("      7. Sueldo");
                    System.out.println("      8. Volver al MENU BODEGUEROS");
                    System.out.println("\n  Digite su opcion: ");
                    
                    opc = leerDatos.nextInt();
                    bode = (Bodegueros)proBodecont.consultarUno(bode);
                    
                    switch(opc){
                        case 1:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo nombre: ");
                            bode.setNombre(leerDatos.nextLine());
                        break;
                        
                        case 2:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo apellido: ");
                            bode.setApellido(leerDatos.nextLine());
                        break;
                        
                        case 3:
                            System.out.println("\nNuevo telefono: ");
                            bode.setTelefono(leerDatos.nextInt());
                        break;
                        
                        case 4:
                            leerDatos.nextLine();
                            System.out.println("\nNueva direccion residencial: ");
                            bode.setDireccion(leerDatos.nextLine());
                        break;
                        
                        case 5:
                            System.out.println("\nNuevo correo electronico: ");
                            bode.setEmail(leerDatos.next());
                        break;
                        
                        case 6:
                            System.out.println("\nNueva fecha de nacimiento: ");
                            bode.setFechanacimiento(leerDatos.next());
                        break;
                        
                        case 7:
                            System.out.println("\nNuevo sueldo: ");
                            bode.setSueldo(leerDatos.nextInt());
                        break;
                        
                        case 8:
                            System.out.println("\n\nCargando.....\n");
                            bode = null;
                        break;
                            
                        default:
                            System.out.println("\n\nDigitó una opcion invalida\n\n");
                        break;
                    }
                    if(bode != null){
                        proBodecont.modificar(bode);
                        System.out.println("\n  Dato actualizado\n    En MENU BODEGUEROS Digite la opcion 2 para consultar.");
                    }
                }while(opc < 8);
            }else{
                System.out.println("\n  *El bodeguero no existe");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }     
    }
    
    //Metodo de ordenamiento con sort
    private void ordenarSort(){
        if(!proBodecont.arregloBodegueros.isEmpty()){
            System.out.println("\n\n----- ORDENAR BODEGUEROS(id) -----\n");
            
            proBodecont.ordenar();
            proBodecont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    private void ordenarQuickSort(){
        if(!proBodecont.arregloBodegueros.isEmpty()){
            System.out.println("\n\n----- ORDENAR BODEGUEROS(nombre) -----\n");
            
            proBodecont.ordenar(0, proBodecont.arregloBodegueros.size()-1);
            proBodecont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    private void ordenarBurbuja(){
        if(!proBodecont.arregloBodegueros.isEmpty()){
            System.out.println("\n\n----- ORDENAR BODEGUEROS(nombre) -----\n");
            
            proBodecont.burbuja();
            proBodecont.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia!");
        }
    }
    
    private void ordenarMergeSort(){
        //Bodegueros bode = new Bodegueros();
        
        if(!proBodecont.arregloBodegueros.isEmpty()){
            System.out.println("\n\n----- ORDENAR BODEGUEROS(telefono) -----\n");
            
            proBodecont.arregloBodegueros = proBodecont.mergeSort(proBodecont.arregloBodegueros);
            proBodecont.consultarGeneral();
            
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
            System.out.println("\n\n======= MENU BODEGUEROS =======");
            
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
