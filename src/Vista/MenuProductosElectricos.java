/**
 *@title: MenuProductosElectricos.java
 * @description: Menu productoselectricos para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Vista;

//Importaciones de clase y apis de java 
import Modelo.ProductosElectricos;
import Controlador.ControladorProductosElectricos;
import java.util.Scanner;

//Clase menu 
public class MenuProductosElectricos 
{
    //Inicializacion de escaner y controlador
    Scanner leerDatos;
    ControladorProductosElectricos proEControlador;
    
    //Constructor
    public MenuProductosElectricos(){
        leerDatos = new Scanner(System.in);
        proEControlador = new ControladorProductosElectricos();
        insertarDatosDefault();
    }
    
    //Metodo de datos por defecto 
    private void insertarDatosDefault()
    {
        //Producto 1
        ProductosElectricos ppe = new ProductosElectricos(12, 6, 120, "Lampara", "Negro", "", "Victus", "Plastico reforzado", 3, 20000, 30000, 2000, 21);
        proEControlador.insertar(ppe);
        
        //Producto 2
        ppe = new ProductosElectricos(30, 8, 911, "Audifonos inalambricos", "Blanco", "", "Apple", "Titanio", 3, 40000, 90000, 20000, 120);
        proEControlador.insertar(ppe);
        
        //Producto 3
        ppe = new ProductosElectricos(18, 3, 721, "Pantalla inalambrica", "Blanco", "", "Sony", "Plastico reforzado", 3, 30000, 120000, 35000, 43);
        
        //Producto 4
        ppe = new ProductosElectricos(12, 7, 62, "Ventilador", "Amarillo", "", "Miniso", "Polisilicona", 3, 8000, 20000, 12000, 32);
        proEControlador.insertar(ppe);
        
        //Producto 5
        ppe = new ProductosElectricos(4, 3, 42, "Memoria USB", "Azul", "", "Kingston", "Plastico zinc", 3, 2000, 6000, 300, 781);
        proEControlador.insertar(ppe);
        
        //Producto 6
        ppe = new ProductosElectricos(6, 5, 10, "Swiche", "Blanco", "", "Paqlin", " Ceramica", 3, 5000, 9000, 800, 120);
        proEControlador.insertar(ppe);
        
        //Producto 7
        ppe = new ProductosElectricos(14, 8, 20, "Bombillo", "Amarillo", "", "Nova", "Porcelanato", 3, 8000, 22000, 2000, 56);
        proEControlador.insertar(ppe);
        
        //Producto 8
        ppe = new ProductosElectricos(9, 6, 31, "Transistor", "Negro", "", "Amd", "Silicio", 3, 3000, 8300, 1000, 900);
        proEControlador.insertar(ppe);
        
        //Producto 9
        ppe = new ProductosElectricos(15, 16, 509, "Linterna", "Gris", "", "prevent", "Plastico", 3, 6000, 27000, 1300, 200);
        proEControlador.insertar(ppe);
        
        //Producto 10
        ppe = new ProductosElectricos(12, 10, 81, "Procesador", "Azul", "", "Intel", "Silico", 3, 200000, 1200000, 50000, 60);
        proEControlador.insertar(ppe);
        
    }
    
    //Metodo de recoleccion de nuevos datos
    private void insertarDatos()
    {
        ProductosElectricos objppe = new ProductosElectricos();
        
        System.out.println("\n\n-------- INSERTAR PRODUCTOS ELECTRICOS -------\n");
        
        leerDatos.nextLine();
        System.out.println("Nombre del producto electrico: ");
        objppe.setNombre(leerDatos.nextLine());
        
        System.out.println("Serial del producto electrico: ");
        objppe.setSerial(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Color del producto electrico: ");
        objppe.setColor(leerDatos.nextLine());
        
        System.out.println("Marca del producto electrico: ");
        objppe.setMarca(leerDatos.next());
        
        leerDatos.nextLine();
        System.out.println("Material del producto electrico: ");
        objppe.setMaterial(leerDatos.nextLine());
        
        System.out.println("Costo de produccion: ");
        objppe.setCostoproduccion(leerDatos.nextFloat());
        
        System.out.println("Costo de almacenamiento: ");
        objppe.setCostoalmacenamiento(leerDatos.nextFloat());
        
        System.out.println("Costo de venta: ");
        objppe.setCostodeventa(leerDatos.nextFloat());
        
        System.out.println("Bodega a asignar: ");
        objppe.setBodegaId(leerDatos.nextInt());
        
        System.out.println("Demanda del producto: ");
        objppe.setdemanda(leerDatos.nextInt());
        
        System.out.println("Capacidad de carga del producto: ");
        objppe.setCapacidadCarga(leerDatos.nextFloat());
        
        System.out.println("Calibre del producto: ");
        objppe.setCalibre(leerDatos.nextFloat());
        
        if(proEControlador.insertar(objppe))
        {
            System.out.println("\n  PRODUCTO ELECTRICO INSERTADO CON ÉXITO!");
        }
        else{
            System.out.println("\n<== ERROR AL INSERTAR EL PRODUCTO ==>");
        }
        System.out.println("\n---------------------------------------");
    }
    
    //Metodo de impresion de todos los objetos existentes
    private void consultarTodos(){
        if(!proEControlador.arregloProductosElectricos.isEmpty()){
            System.out.println("\n\n----------- CONSULTAR PRODUCTOS ELECTRICOS -----------\n");
            
            proEControlador.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo para consultar un solo objeto
    private void consultarUno(){
         ProductosElectricos ppe = new ProductosElectricos();
        
        if(!proEControlador.arregloProductosElectricos.isEmpty()){
            System.out.println("\n\n----------- CONSULTAR PRODUCTO ELECTRICO ------------\n");
            
            System.out.println("Digite el numero serial del producto electrico: ");
            ppe.setSerial(leerDatos.nextInt());
            
            ppe = (ProductosElectricos)proEControlador.consultarUno(ppe);
            if(ppe == null){
                System.out.println("\n  *El producto electrico que busca, no existe.");
            }
            else{
                System.out.println("\n"+ppe.toString());
                System.out.println("\n---------------------------------------");
            }
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de borrado del objeto
    private void borrar()
    {
        ProductosElectricos ppe = new ProductosElectricos();
        
        if(!proEControlador.arregloProductosElectricos.isEmpty()){
            System.out.println("\n\n------------- BORRAR PRODUCTO ELECTRICO -------------\n");
            proEControlador.consultarGeneral();
            System.out.println("Estos son los productos electricos actuales, inserte el serial del producto a borrar: ");
            ppe.setSerial(leerDatos.nextInt());
            
            if(proEControlador.borrar(ppe)){
                System.out.println("\n\n    PRODUCTO ELECTRICO BORRADO!\n    Digite 2 para consultar.");
            }else{
                System.out.println("\n  *No fue posible borrar el producto");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo para actualizar datos de un objeto 
    private void actualizar()
    {
        ProductosElectricos ppe = new ProductosElectricos();
        int opc;
        
        if(!proEControlador.arregloProductosElectricos.isEmpty()){
            System.out.println("\n\n----------- ACTUALIZAR PRODUCTO ELECTRICO -----------\n");
            proEControlador.consultarGeneral();
            System.out.println("Estos son los productos electricos disponibles, inserte el serial del producto a actualizar: ");
            ppe.setSerial(leerDatos.nextInt());
            
            ppe = (ProductosElectricos)proEControlador.consultarUno(ppe);
            if(ppe != null){
                do{
                    System.out.println("\n\n  Menu de actualizacion de producto");
                    System.out.println("      Que desea modificar?");
                    System.out.println("      1.  Nombre");
                    System.out.println("      2.  Color");
                    System.out.println("      3.  Marca");
                    System.out.println("      4.  Material");
                    System.out.println("      5.  Costo de produccion");
                    System.out.println("      6.  Costo de venta");
                    System.out.println("      7.  Costo de almacenamiento");
                    System.out.println("      8.  Identificacion de la bodega");
                    System.out.println("      9.  Demanda del producto");
                    System.out.println("      10. Capacidad de carga del producto");
                    System.out.println("      11. Calibre del producto");
                    System.out.println("      12. Actualizar datos y volver al MENU PRODUCTOS ELECTRICOS.");
                    System.out.println("\n  Digite su opcion: ");
                    
                    opc = leerDatos.nextInt();
                    ppe = (ProductosElectricos)proEControlador.consultarUno(ppe);
                    
                    switch(opc){
                        case 1:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo nombre: ");
                            ppe.setNombre(leerDatos.nextLine());
                        break;
                        
                        case 2:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo color: ");
                            ppe.setColor(leerDatos.nextLine());
                        break;
                        
                        case 3:
                            System.out.println("\nNueva marca: ");
                            ppe.setMarca(leerDatos.next());
                        break;
                        
                        case 4:
                            leerDatos.nextLine();
                            System.out.println("\nNueva material: ");
                            ppe.setMarca(leerDatos.nextLine());
                        break;
                        
                        case 5:
                            System.out.println("\nNuevo costo de produccion: ");
                            ppe.setCostoproduccion(leerDatos.nextFloat());
                        break;
                        
                        case 6:
                            System.out.println("\nNuevo costo de venta: ");
                            ppe.setCostodeventa(leerDatos.nextFloat());
                        break;
                        
                        case 7:
                            System.out.println("\nNuevo costo de almacenamiento: ");
                            ppe.setCostoalmacenamiento(leerDatos.nextFloat());
                        break;
                        
                        case 8:
                            System.out.println("\nNueva identificacion de la bodega: ");
                            ppe.setBodegaId(leerDatos.nextInt());
                        break;
                        
                        case 9:
                            System.out.println("\nNueva demanda del producto: ");
                            ppe.setdemanda(leerDatos.nextInt());
                        break;
                        
                        case 10:
                            System.out.println("\nNueva capacidad de carga del producto: ");
                            ppe.setCapacidadCarga(leerDatos.nextFloat());
                        break;
                        
                        case 11:
                            System.out.println("\nNuevo calibre del producto: ");
                            ppe.setCalibre(leerDatos.nextFloat());
                        break;
                        
                        case 12:
                            System.out.println("\n\nCargando.....\n");
                            ppe = null;
                        break;
                        
                        default:
                            System.out.println("\n\nDigitó una opción inválida.\n\n");
                        break;
                        
                        }
                        if(ppe != null){
                            proEControlador.modificar(ppe);
                            System.out.println("\n  Dato Actualizado\n    En MENU PRODUCTOS ELECTRICOS Digite la opcion 2 para consultar.");
                        }
                }while(opc < 12);
            }else{
                System.out.println("\n  *El producto electrico no existe");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de ordenamiento con sort
    private void ordenarSort(){
        if(!proEControlador.arregloProductosElectricos.isEmpty()){
            System.out.println("\n\n----- ORDENAR PRODUCTOS ELECTRICOS (id/serial) -----\n");
            
            proEControlador.ordenar();
            proEControlador.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    
    //Metodo de ordenamiento con quicksort
    private void ordenarQuickSort(){
        if(!proEControlador.arregloProductosElectricos.isEmpty()){
            System.out.println("\n\n----- ORDENAR PRODUCTOS ELECTRICOS (Nombre del producto) -----\n");
            
            proEControlador.ordenar(0,proEControlador.arregloProductosElectricos.size()-1);
            proEControlador.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de ordneamiento con burbuja
    private void ordenarBurbuja(){
        if(!proEControlador.arregloProductosElectricos.isEmpty()){
            System.out.println("\n\n----- ORDENAR PRODUCTOS ELECTRICOS (Marca del producto) -----\n");
            
            proEControlador.burbuja();
            proEControlador.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de ordenamiento con MergeSort
    private void ordenarMergeSort(){
        if(!proEControlador.arregloProductosElectricos.isEmpty()){
            System.out.println("\n\n----- ORDENAR PRODUCTOS HERRAJES (Precio de venta) -----\n");
            
            proEControlador.arregloProductosElectricos = proEControlador.mergeSort(proEControlador.arregloProductosElectricos);
            proEControlador.consultarGeneral();
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Menu principal
    public void menu()
    {
        int opc;
        
        do{
            System.out.println("\n\n======= MENU PRODUCTOS ELECTRICOS =======");
            
            System.out.println("1. Insertar datos");
            System.out.println("2. Consultar datos");
            System.out.println("3. Consultar un dato");
            System.out.println("4. Modificar datos");
            System.out.println("5. Borrar datos");
            System.out.println("6. Ordenar datos por sort --------> por Id/serial");
            System.out.println("7. Ordenar Datos por QuickSort ---> por Nombre");
            System.out.println("8. Ordenar Datos por Burbuja -----> por Marca");
            System.out.println("9. Ordenar Datos por MergeSort ---> por Precio de venta");
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
