/**
 *@title: Producto.java
 * @description: Clase producto para el proyecto CadenaSuministros
 * @date: Domingo 24 de septiembre de 2023
 * @version: 0.1
 * @author Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

//Paquete
package Modelo;

//Clase padre que implementa interface con comparador
public class Producto implements Comparable<Producto> {
    //Atributos
    private int serial;
    private String nombre;
    private String color;
    private String imagen = "C:\\Users\\fajar\\OneDrive\\Documentos\\NetBeansProjects\\CadenaSuministros\\Imagenes\\";
    private String marca;
    private String material;
    private int demanda;
    private float costoproduccion;
    private float costodeventa;
    private float costoalmacenamiento;
    private int bodegaId;
    
    //CONSTRUCTORES
    
    //Constructor completo

    /**
     *
     * @param serial
     * @param nombre
     * @param color
     * @param imagen
     * @param marca
     * @param material
     * @param bodegaId
     * @param costoproduccion
     * @param costodeventa
     * @param costoalmacenamiento
     * @param demanda
     */
    
    public Producto(int serial, String nombre, String color, String imagen, String marca, String material, int bodegaId, float costoproduccion, float costodeventa, float costoalmacenamiento, int demanda) {
        this.serial = serial;
        this.nombre = nombre;
        this.color = color;
        this.imagen = imagen;
        this.marca = marca;
        this.material = material;
        this.costoproduccion = costoproduccion;
        this.costodeventa = costodeventa;
        this.costoalmacenamiento = costoalmacenamiento;
        this.bodegaId = bodegaId;
        this.demanda = demanda;
    }
    
    //Constructor vacío
    public Producto() {   
    }
    
    //MÉTODOS
    
    //Metodo getter, muestra
    public int getSerial() {
        return serial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public String getImagen() {
        return imagen;
    }

    public String getMarca() {
        return marca;
    }

    public String getMaterial() {
        return material;
    }

    public float getCostoproduccion() {
        return costoproduccion;
    }

    public float getCostodeventa() {
        return costodeventa;
    }

    public float getCostoalmacenamiento() {
        return costoalmacenamiento;
    }
    
    public int getbodegaId(){
        return bodegaId;
    }
    
    public int getdemanda(){
        return demanda;
    }
    
    //Metodo setter cambia
    public void setSerial(int serial) {
        this.serial = serial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setCostoproduccion(float costoproduccion) {
        this.costoproduccion = costoproduccion;
    }

    public void setCostodeventa(float costodeventa) {
        this.costodeventa = costodeventa;
    }

    public void setCostoalmacenamiento(float costoalmacenamiento) {
        this.costoalmacenamiento = costoalmacenamiento;
    }

    public void setBodegaId(int bodegaId) {
        this.bodegaId = bodegaId;
    }
    
    public void setdemanda(int demanda){
        this.demanda= demanda;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        return "\nProducto{" + "serial=" + serial + ", nombre=" + nombre + ", color=" + color + ", imagen=" + imagen + ", marca=" + marca + ", material=" + material + ", costoproduccion=" + costoproduccion + ", costodeventa=" + costodeventa + ", costoalmacenamiento=" + costoalmacenamiento + ", bodegaId=" + bodegaId + ", demanda=" + demanda +'}';
    }

    //Metodo hashCode 
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    //Metodo equals (recibe el objeto)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.serial == other.serial;
    }

    //Metodo compareTo
    @Override
    public int compareTo(Producto o) {      
        if(this.serial == o.serial){
                return 0;
        } else if(this.serial > o.serial){
                   return 1; 
        } else {
            return -1;
        }
    }
}