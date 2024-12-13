/**
 *@title: ProductosHerrajes.java
 * @description: Clase productosherrajes para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Modelo;

//Subclase modelo 
public class ProductosHerrajes extends Producto{
    //Atributo
    private String TipoElemento;

    //Constructor completo 
    public ProductosHerrajes(String TipoElemento, int serial, String nombre, String color, String imagen, String marca, String material, int bodegaId, float costoproduccion, float costodeventa, float costoalmacenamiento, int demanda) {
        super(serial, nombre, color, imagen, marca, material, bodegaId, costoproduccion, costodeventa, costoalmacenamiento, demanda);
        this.TipoElemento = TipoElemento;
    }

    //Constructor vacio 
    public ProductosHerrajes() {
  
    }

    //Metodo getter
    public String getTipoElemento() {
        return TipoElemento;
    }

    //Metodo setter 
    public void setTipoElemento(String TipoElemento) {
        this.TipoElemento = TipoElemento;
    }

    //Metodo toString 
    @Override
    public String toString() {
        return "\n"+super.toString() + "  \nProductos Herrajes{" + "TipoElemento=" + TipoElemento + '}';
    }
    
//  @Override
//    public int compareTo(ProductosHerrajes o) {      
//        if(this.serial == o.serial){
//                return 0;
//        } else if(this.serial > o.serial){
//                   return 1; 
//        } else {
//            return -1;
//        }
//    }
    
}
