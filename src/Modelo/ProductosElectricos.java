/**
 *@title: ProductosElectricos.java
 * @description: Clase productoselectricos para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete 
package Modelo;

//Subclase modelo 
public class ProductosElectricos extends Producto{
    //Atributos
    private float CapacidadCarga;
    private float Calibre;

    //Constructor completo 
    public ProductosElectricos(float CapacidadCarga, float Calibre, int serial, String nombre, String color, String imagen, String marca, String material, int bodegaId, float costoproduccion, float costodeventa, float costoalmacenamiento, int demanda) {
        super(serial, nombre, color, imagen, marca, material, bodegaId, costoproduccion, costodeventa, costoalmacenamiento, demanda);
        this.CapacidadCarga = CapacidadCarga;
        this.Calibre = Calibre;
    }

    //Constructor vacio 
    public ProductosElectricos() {
        
    }

    //Metodos getter 
    public float getCapacidadCarga() {
        return CapacidadCarga;
    }

    public float getCalibre() {
        return Calibre;
    }
    
    //Metodos setter 
    public void setCapacidadCarga(float CapacidadCarga) {
        this.CapacidadCarga = CapacidadCarga;
    }

    public void setCalibre(float Calibre) {
        this.Calibre = Calibre;
    }
    
    //Metodo toString 
     @Override
    public String toString() {
        return "\n"+super.toString() + "  \nProductos Electricos{" + "CapacidadCarga=" + CapacidadCarga + ", Calibre=" + Calibre + '}';
    }

//    @Override    
//    public int compareTo(ProductosElectricos o) {      
//        if(this.serial == o.serial){
//                return 0;
//        } else if(this.serial > o.serial){
//                   return 1; 
//        } else {
//            return -1;
//        }
//    }

}
