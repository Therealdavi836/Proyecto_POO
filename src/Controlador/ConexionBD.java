/**
 * @title: ConexionBD.java
 * @description: Conexión con la base de datos para el proyecto CadenaSuministros.
 * @date: 29 de octubre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public Connection mysqlConexion(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferreteria","root","admin123"); 
            System.out.println("Conectado a la base de datos\n\n");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encontró el driver\n\n");
        } catch (SQLException ex) {
            System.out.println("Usuario, Contraseña o Nombre de Base de Datos son incorrectos\n\n");
        }
        return con;
    }
}
