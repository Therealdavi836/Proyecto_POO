/**
 *@title: MenuProductosHerrajes.java
 * @description: Menu productosherrajes para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Vista;

//Importaciones de clase y apis de java
import Modelo.ProductosHerrajes;
import Controlador.ControladorProductosHerrajes;
import java.util.Scanner;

//Clase menu 
public class MenuProductosHerrajes 
{
    //Inicializacion de escaner y controlador
    Scanner leerDatos;
    ControladorProductosHerrajes proHControlador;
    
    //Constructor
    public MenuProductosHerrajes(){
        leerDatos = new Scanner (System.in);
        proHControlador = new ControladorProductosHerrajes();
        insertarDatosDefault();
    }
    
    //Metodo de datos por defecto
    private void insertarDatosDefault()
    {
        //Producto 1
        ProductosHerrajes objpph = new ProductosHerrajes("Para duchas", 23, "Bisagra", "peltre", "","Husqvarna", "Acero", 2, 5000, 12000, 500, 16);
        proHControlador.insertar(objpph);
        
        //Producto 2
        objpph = new ProductosHerrajes("Para gabinetes", 14, "Cerradura", "Latón", "", "Delawere", "Zamak", 2, 7000, 15000, 800, 13);
        proHControlador.insertar(objpph);
        
        //Producto 3
        objpph = new ProductosHerrajes("Para cajones", 25, "Manijas", "Cobre", "", "Dutch", "Aleacion", 2, 4000, 9000, 400, 10);
        proHControlador.insertar(objpph);
        
        //Producto 4
        objpph = new ProductosHerrajes("Para armario", 128, "Pasador", "Oro", "", "Induma", "Zinc", 2, 6000, 12000, 700, 15);
        proHControlador.insertar(objpph);
        
        //Producto 5
        objpph = new ProductosHerrajes("Para escritorios", 49, "Pomos", "Niquel", "", "Nova", "Aluminio", 2, 3000, 7000, 600, 9);
        proHControlador.insertar(objpph);
    
        //Producto 6
        objpph = new ProductosHerrajes("Para organizadores", 45, "Candado", "Plateado", "", "Riduco", "Acero", 2, 9000, 40000, 2000, 120);
        proHControlador.insertar(objpph);
        
        //Producto 7
        objpph = new ProductosHerrajes("Para inodoros", 298, "Boton", "Gris", "", "Mabe", "Plastico", 2, 5000, 20000, 1000, 100);
        proHControlador.insertar(objpph);
        
        //Producto 8
        objpph = new ProductosHerrajes("Para rejas", 90, "Palanca", "Cobrizo", "", "ACesoluciones", "Hierro", 2, 8000, 28000, 3000, 72);
        proHControlador.insertar(objpph);
        
        //Producto 9
        objpph = new ProductosHerrajes("Para bodegas", 37, "Llave", "Platino", "", "Husqvarna", "Plomo", 2, 10000, 30000, 6000, 20);
        proHControlador.insertar(objpph);
        
        //Producto 10
        objpph = new ProductosHerrajes("Para cajas fuertes", 600, "Caja reforzada", "Negro", "", "Casper", "Acero reforzado", 2, 100000, 600000, 20000, 5);
        proHControlador.insertar(objpph);
    
    }
    
    //Metodo de recoleccion de nuevos datos
    private void insertarDatos()
    {
        
        ProductosHerrajes objpph = new ProductosHerrajes();
        System.out.println("\n\n-------- INSERTAR PRODUCTOS HERRAJES -------\n");
        
        leerDatos.nextLine();
        System.out.println("Nombre del producto de herraje: ");
        objpph.setNombre(leerDatos.nextLine());
        
        System.out.println("Serial del producto de herraje: ");
        objpph.setSerial(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Color del producto de herraje: ");
        objpph.setColor(leerDatos.nextLine());
        
        System.out.println("Marca del producto de herraje: ");
        objpph.setMarca(leerDatos.next());
        
        leerDatos.nextLine();
        System.out.println("Material del producto de herraje: ");
        objpph.setMaterial(leerDatos.nextLine());
        
        System.out.println("Costo de produccion: ");
        objpph.setCostoproduccion(leerDatos.nextFloat());
        
        System.out.println("Costo de almacenamiento: ");
        objpph.setCostoalmacenamiento(leerDatos.nextFloat());
        
        System.out.println("Costo de venta: ");
        objpph.setCostodeventa(leerDatos.nextFloat());
        
        System.out.println("Bodega a asignar: ");
        objpph.setBodegaId(leerDatos.nextInt());
        
        System.out.println("Demanda del producto: ");
        objpph.setdemanda(leerDatos.nextInt());
        
        leerDatos.nextLine();
        System.out.println("Tipo de elemento designado del producto: ");
        objpph.setTipoElemento(leerDatos.nextLine());
        
        
        if(proHControlador.insertar(objpph))
        {
            System.out.println("\n  PRODUCTO HERRAJE INSERTADO CON ÉXITO!");
        }
        else
        {
            System.out.println("\n<== ERROR AL INSERTAR EL PRODUCTO ==>");
        }
        System.out.println("\n---------------------------------------");
    }
    
    //Metodo de impresion de todos los objetos existentes 
    private void consultarTodos(){
        if(!proHControlador.arregloProductosHerrajes.isEmpty()){
            System.out.println("\n\n----------- CONSULTAR PRODUCTOS HERRAJES -----------\n");
            
            proHControlador.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo para consultar un solo objeto
    private void consultarUno()
    {
        ProductosHerrajes pph = new ProductosHerrajes();
        
        if(!proHControlador.arregloProductosHerrajes.isEmpty()){
            System.out.println("\n\n----------- CONSULTAR PRODUCTO HERRAJE ------------\n");
            
            System.out.println("Digite el numero serial del producto herraje: ");
            pph.setSerial(leerDatos.nextInt());
            
            pph = (ProductosHerrajes)proHControlador.consultarUno(pph);
            if(pph == null){
                System.out.println("\n  *El producto de herraje que busca, no existe.");
            }
            else{
                System.out.println("\n"+pph.toString());
                System.out.println("\n---------------------------------------");
            }
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de borrado del objeto
    private void borrar()
    {
        ProductosHerrajes pph = new ProductosHerrajes();
        
        if(!proHControlador.arregloProductosHerrajes.isEmpty()){
            System.out.println("\n\n------------- BORRAR PRODUCTO HERRAJE -------------\n");
            proHControlador.consultarGeneral();
            System.out.println("Estos son los productos herrajes actuales, inserte el serial del producto a borrar: ");
            pph.setSerial(leerDatos.nextInt());
            
            if(proHControlador.borrar(pph)){
                System.out.println("\n\n    PRODUCTO HERRAJE BORRADO!\n    Digite 2 para consultar.");
            }else{
                System.out.println("\n  *No fue posible borrar el producto");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo para actualizar los datos de un objeto
    private void actualizar()
    {
        ProductosHerrajes pph = new ProductosHerrajes();
        int opc;
        
        if(!proHControlador.arregloProductosHerrajes.isEmpty()){
            System.out.println("\n\n----------- ACTUALIZAR PRODUCTO HERRAJE -----------\n");
            proHControlador.consultarGeneral();
            System.out.println("Estos son los productos de herrajes disponibles, inserte el serial del producto a modificar: ");
            pph.setSerial(leerDatos.nextInt());
            
            pph = (ProductosHerrajes)proHControlador.consultarUno(pph);
            if(pph != null){
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
                    System.out.println("      10. Tipo de elemento correspondiente");
                    System.out.println("      11.Actualizar datos y volver al MENU PRODUCTOS HERRAJE");
                    System.out.println("\n  Digite su opcion: ");
                    
                    opc = leerDatos.nextInt();
                    pph = (ProductosHerrajes)proHControlador.consultarUno(pph);
                    
                    switch(opc){
                        case 1:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo nombre: ");
                            pph.setNombre(leerDatos.nextLine());
                        break;
                        
                        case 2:
                            leerDatos.nextLine();
                            System.out.println("\nNuevo color: ");
                            pph.setColor(leerDatos.nextLine());
                        break;
                        
                        case 3:
                            System.out.println("\nNueva marca: ");
                            pph.setMarca(leerDatos.next());
                        break;
                        
                        case 4:
                            leerDatos.nextLine();
                            System.out.println("\nNueva material: ");
                            pph.setMarca(leerDatos.nextLine());
                        break;
                        
                        case 5:
                            System.out.println("\nNuevo costo de produccion: ");
                            pph.setCostoproduccion(leerDatos.nextFloat());
                        break;
                        
                        case 6:
                            System.out.println("\nNuevo costo de venta: ");
                            pph.setCostodeventa(leerDatos.nextFloat());
                        break;
                        
                        case 7:
                            System.out.println("\nNuevo costo de almacenamiento: ");
                            pph.setCostoalmacenamiento(leerDatos.nextFloat());
                        break;
                        
                        case 8:
                            System.out.println("\nNueva identificacion de la bodega: ");
                            pph.setBodegaId(leerDatos.nextInt());
                        break;
                        
                        case 9:
                            System.out.println("\nNueva demanda del producto: ");
                            pph.setdemanda(leerDatos.nextInt());
                        break;
                        
                        case 10:
                            System.out.println("\nNueva asignacion del tipo de elemento: ");
                            do{
                                System.out.println("1. Para duchas");
                                System.out.println("2. Para gabinetes");
                                System.out.println("3. Para armarios");
                                System.out.println("4. Para cajones");
                                System.out.println("5. Para escritorios");
                                System.out.println("6. Otra opcion, digitela: ");
                                System.out.println("\nDigite la opción: ");
                                opc = leerDatos.nextInt();

                            }while(opc<1 || opc>6);

                            switch (opc){
                                case 1:
                                    pph.setTipoElemento("Para duchas");
                                break;

                                case 2:
                                    pph.setTipoElemento("Para gabinetes");
                                break;

                                case 3:
                                    pph.setTipoElemento("Para armarios");
                                break;
                                
                                case 4:
                                    pph.setTipoElemento("Para cajones");
                                break;
                                
                                case 5:
                                    pph.setTipoElemento("Para escritorios");
                                break;
                                
                                case 6:
                                    leerDatos.nextLine();
                                    System.out.println("Inserte su otra opcion: ");
                                    pph.setTipoElemento(leerDatos.nextLine());
                                break;
                                    
                                default:
                                    System.out.println("Opción no válida.");
                                break;
                            }
                        break;
                        
                        case 11:
                            System.out.println("\n\nCargando.....\n");
                            pph = null;
                        break;    
                            
                        default:
                            System.out.println("\n\nDigitó una opción inválida.\n\n");
                        break;
                        
                        }
                        if(pph != null){
                            proHControlador.modificar(pph);
                            System.out.println("\n  Dato Actualizado\n    En MENU PRODUCTOS HERRAJES, Digite la opcion 2 para consultar.");
                        }
                }while(opc < 11);
            }else{
                System.out.println("\n  *El producto herraje no existe");
            }
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de ordenamiento con sort
    private void ordenarSort(){
        if(!proHControlador.arregloProductosHerrajes.isEmpty()){
            System.out.println("\n\n----- ORDENAR PRODUCTOS HERRAJES (id/serial) -----\n");
            
            proHControlador.ordenar();
            proHControlador.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de ordenamiento con quicksort
    private void ordenarQuickSort(){
        if(!proHControlador.arregloProductosHerrajes.isEmpty()){
            System.out.println("\n\n----- ORDENAR PRODUCTOS HERRAJES (Nombre del producto) -----\n");
            
            proHControlador.ordenar(0,proHControlador.arregloProductosHerrajes.size()-1);
            proHControlador.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de ordneamiento con burbuja
    private void ordenarBurbuja(){
        if(!proHControlador.arregloProductosHerrajes.isEmpty()){
            System.out.println("\n\n----- ORDENAR PRODUCTOS HERRAJES (Marca del producto) -----\n");
            
            proHControlador.burbuja();
            proHControlador.consultarGeneral();
            
            System.out.println("\n---------------------------------------");
        }else{
            System.out.println("\n  *La lista se encuentra vacia");
        }
    }
    
    //Metodo de ordenamiento con MergeSort
    private void ordenarMergeSort(){
        if(!proHControlador.arregloProductosHerrajes.isEmpty()){
            System.out.println("\n\n----- ORDENAR PRODUCTOS HERRAJES (Precio de venta) -----\n");
            
            proHControlador.arregloProductosHerrajes = proHControlador.mergeSort(proHControlador.arregloProductosHerrajes);
            proHControlador.consultarGeneral();
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
            System.out.println("\n\n======= MENU PRODUCTOS HERRAJES =======");
            
            System.out.println("1. Insertar Datos");
            System.out.println("2. Consultar Datos");
            System.out.println("3. Consultar un Dato");
            System.out.println("4. Modificar Datos");
            System.out.println("5. Borrar Datos");
            System.out.println("6. Ordenar Datos por Sort --------> por Id/serial");
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
