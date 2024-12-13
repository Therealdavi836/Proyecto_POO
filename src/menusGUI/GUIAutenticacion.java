/**
 * @title: GUIAutenticacion.java
 * @description: GUI para la autenticacion de usuarios para el proyecto CadenaSuministros.
 * @date: Domingo 12 de noviembre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

package menusGUI;

//Se importan todas las clases usuario y su respectiva base de datos 
import Controlador.ConexionBD;
import Controlador.ControladorCliente;
import Controlador.ControladorVendedor;
import Controlador.ControladorBodegueros;
import Controlador.TextPrompt;
import Excepciones.Excepciones;
import Modelo.Usuario;
import Modelo.Administrador;
import Modelo.Bodegueros;
import Modelo.Cliente;
import Modelo.Vendedor;

//Import de apis del SQL
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//Clase de la interfaz grafica 
public class GUIAutenticacion extends javax.swing.JFrame {

    /**
     * Creates new form GUIAutenticacion
     */
    
    //Inicializacion de las variables globales 
    Administrador proAdmicont;
    ControladorCliente proCliencont;
    ControladorBodegueros proBodecont;
    ControladorVendedor proVendcont;
    Usuario usu;
    Administrador usuario1;
    Bodegueros usuario2;
    Cliente usuario3;
    Vendedor usuario4;
    ConexionBD conBD;
    Connection con;
    GUIMenuPrincipal menu;
    
    //Constructor 
    public GUIAutenticacion() {
        initComponents();
        proAdmicont = new Administrador();
        proVendcont = new ControladorVendedor();
        proCliencont = new ControladorCliente();
        proBodecont = new ControladorBodegueros();
        conBD = new ConexionBD();
        con = conBD.mysqlConexion();
        consultarDBAdm();
        consultarDBBode();
        consultarDBCli();
        consultarDBVen();
        TextPrompt placeholder = new TextPrompt("••••", Contrasena);
    }
    
    //Se consulta desde la base de datos el usuario administrador insertado a a autenticar 
    private void consultarDBAdm(){
        try{
            //Se inicializa una instruccion y se ejecuta, enviandola a la base de datos 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM administrador"); //order by id DESC
            
            //El result set selecciona al usuraio y compara lo insertado 
            while(rs.next()){
                //Se separa memoria 
                usuario1 = new Administrador();
                
                //Atributos de usuario administrador 
                usuario1.setCedula(rs.getInt(1)); //cedula
                usuario1.setNombre(rs.getString(2)); //nombre
                usuario1.setApellido(rs.getString(3)); //apellido
                usuario1.setDireccion(rs.getString(4)); //direccion
                usuario1.setTelefono(rs.getInt(5)); //teléfono
                usuario1.setEmail(rs.getString(6)); //correo
                usuario1.setFechanacimiento(rs.getString(7)); //fecha de nacimiento
                usuario1.setFechaIngreso(rs.getString(8)); //fecha de ingreso
                usuario1.setSueldo(rs.getInt(9)); //sueldo
                usuario1.setContrasena(rs.getString(10)); //contraseña
                
                proAdmicont.insertar(usuario1);
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Usuario NO Consultado de la Base de Datos");
            ex.printStackTrace();
        }
    }
    
    //Se consulta desde la base de datos al usuario bodeguero insertado a autenticar 
    private void consultarDBBode(){
        try{
            //Se inicializa una instruccion y se ejecuta hacia la base de datos 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bodegueros"); //order by id DESC
            
            //El result set compara lo insertado 
            while(rs.next()){
                usuario2 = new Bodegueros();
                
                usuario2.setCedula(rs.getInt(1)); //cedula
                usuario2.setNombre(rs.getString(2)); //nombre
                usuario2.setApellido(rs.getString(3)); //apellido
                usuario2.setDireccion(rs.getString(4)); //direccion
                usuario2.setTelefono(rs.getInt(5)); //teléfono
                usuario2.setEmail(rs.getString(6)); //correo
                usuario2.setFechanacimiento(rs.getString(7)); //fecha de nacimiento
                usuario2.setFechaIngreso(rs.getString(8)); //fecha de ingreso
                usuario2.setSueldo(rs.getInt(9)); //sueldo
                usuario2.setContrasena(rs.getString(10)); //contraseña
                
                proBodecont.insertar(usuario2);
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Usuario NO Consultado de la Base de Datos");
            ex.printStackTrace();
        }
    }
    
    //Se consulta desde la base de datos al usuario cliente a autenticar 
    private void consultarDBCli(){
        try{
            //Se inicializa una instruccion y se ejecuta hacia la base de datos 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente"); //order by id DESC
            
            //El result set compara al usuario insertado 
            while(rs.next()){
                usuario3 = new Cliente();
                usuario3.setCedula(rs.getInt(1)); //cedula
                usuario3.setNombre(rs.getString(2)); //nombre
                usuario3.setApellido(rs.getString(3)); //apellido
                usuario3.setDireccion(rs.getString(4)); //direccion
                usuario3.setTelefono(rs.getInt(5)); //teléfono
                usuario3.setEmail(rs.getString(6)); //correo
                usuario3.setFechanacimiento(rs.getString(7)); //fecha de nacimiento
                usuario3.setContrasena(rs.getString(8)); //contraseña
                
                proCliencont.insertar(usuario3);
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Usuario NO Consultado de la Base de Datos");
            ex.printStackTrace();
        }
    }
    
    //Se consulta desde la base de datos al usuario vendedor a autenticar 
    private void consultarDBVen(){
        try{
            //Se inicializa una instruccion y se ejecuta hacia la base de datos 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vendedor"); //order by id DESC
            
            //El result set compara lo insertado 
            while(rs.next()){
                usuario4 = new Vendedor();
                
                usuario4.setCedula(rs.getInt(1)); //cedula
                usuario4.setNombre(rs.getString(2)); //nombre
                usuario4.setApellido(rs.getString(3)); //apellido
                usuario4.setDireccion(rs.getString(4)); //direccion
                usuario4.setTelefono(rs.getInt(5)); //teléfono
                usuario4.setEmail(rs.getString(6)); //correo
                usuario4.setFechanacimiento(rs.getString(7)); //fecha de nacimiento
                usuario4.setFechaIngreso(rs.getString(8)); //fecha de ingreso
                usuario4.setSueldo(rs.getInt(9)); //sueldo
                usuario4.setContrasena(rs.getString(10)); //contraseña
                
                proVendcont.insertar(usuario4);
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Usuario NO Consultado de la Base de Datos");
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Cedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Contrasena = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        Tipo = new javax.swing.JComboBox<>();
        Insertar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 48)); // NOI18N
        jLabel1.setText("Cadena de Suministros");

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel2.setText("Iniciar Sesión ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 217, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cédula");

        Cedula.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cedula.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Cedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CedulaFocusLost(evt);
            }
        });
        Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña");

        Contrasena.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Contrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Contrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Contrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ContrasenaFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de usuario");

        Tipo.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Administrador", "Bodeguero", "Cliente", "Vendedor" }));
        Tipo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoActionPerformed(evt);
            }
        });

        Insertar.setBackground(new java.awt.Color(51, 255, 255));
        Insertar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Insertar.setText("Ingresar\n");
        Insertar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CedulaActionPerformed

    private void TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoActionPerformed

    //Boton esencial para entrar al programa 
    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        // TODO add your handling code here:
        //Se valida que los campos esten llenos 
        if(Cedula.getText().equals("") || Contrasena.getPassword().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Alguno de los campos está vacío");
        }else{
            //Se separa nemoria, se convierte en texto, se valida contraseña
            // y se busca en la base de datos la informacion suministrada concordante 
            //con el jcombobox de los roles de usuario del sistema 
            
            usu = new Usuario();
            usu.setCedula(Integer.parseInt(Cedula.getText()));
            usu.setContrasena(new String(Contrasena.getPassword()));
            int index = Tipo.getSelectedIndex();
            boolean existe = false;
            
            //Si selecciona 1 para administrador y la informacion concuerda mediante validaciones
            //del sql y arreglo, y si sel usuario administrador existe
            //Inmediatamente accede al sistema y lo puede usar de esquina a esquina 
            switch (index) {
                case 1:
                    for (Administrador temp: proAdmicont.arregloAdministrador) {
                        if (usu.getCedula() == temp.getCedula() && usu.getContrasena().compareTo(temp.getContrasena()) == 0) {
                            existe = true;
                            if (existe) {
                                java.awt.EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                        menu = new GUIMenuPrincipal(index);
                                        menu.setVisible(true);
                                    }
                                });
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "El usuario no existe");
                            }
                            break;
                        }
                    }
                break;
                
                //Si se selecciona 2 para bodeguero y se valida desde la base de datos y el arreglo 
                //El bodeguero accede al sistema desde sus roles 
                case 2:
                    for (Bodegueros temp: proBodecont.arregloBodegueros) {
                        if (usu.getCedula() == temp.getCedula() && usu.getContrasena().compareTo(temp.getContrasena()) == 0) {
                            existe = true;
                            if (existe) {
                                java.awt.EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                        menu = new GUIMenuPrincipal(index);
                                        //Se desactiva el menu de usuarios
                                        //solo el administrador puede acceder a los menus de usuarios 
                                        menu.getjMenu1Usuarios().setVisible(false);
                                        menu.setVisible(true);
                                    }
                                });
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "El usuario no existe");
                            }
                        }
                    }
                break;
                
                //Si se selecciona 3 para cliente y se valida la existencia en la base de datos 
                //el cliente accede al sisteama desde sus roles 
                case 3:
                    for (Cliente temp: proCliencont.arregloCliente) {
                        if (usu.getCedula() == temp.getCedula() && usu.getContrasena().compareTo(temp.getContrasena()) == 0) {
                            existe = true;
                            if (existe) {
                                java.awt.EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                        menu = new GUIMenuPrincipal(index);
                                        //se desactiva el menu de usuarios 
                                        //solo el administrador puede acceder a los menus de usuarios 
                                        menu.getjMenu1Usuarios().setVisible(false);
                                        menu.setVisible(true);
                                    }
                                });
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "El usuario no existe");
                            }
                        }
                    }
                break;
                
                //Si selecciona 4 para vendedor y se valida sus existencia en la base de datos 
                //Se accedeal sistema desde sus roles 
                case 4:
                    for (Vendedor temp: proVendcont.arregloVendedor) {
                        if (usu.getCedula() == temp.getCedula() && usu.getContrasena().compareTo(temp.getContrasena()) == 0) {
                            existe = true;
                            if (existe) {
                                java.awt.EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                        menu = new GUIMenuPrincipal(index);
                                        //Se desactiva los menus de usuarios
                                        //solo el administrador puede acceder a los menus de usuarios 
                                        menu.getjMenu1Usuarios().setVisible(false);
                                        menu.setVisible(true);
                                    }
                                });
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "El usuario no existe");
                            }
                        }
                    }
                break;
                default:
                break;
            }
            if (!existe) {
                JOptionPane.showMessageDialog(rootPane, "Datos incorrectos para este usuario " + usu.getCedula());
            }
        }

    }//GEN-LAST:event_InsertarActionPerformed

    private void CedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CedulaFocusLost
        // TODO add your handling code here:
        try{
            usuario1.setCedula(Integer.parseInt(Cedula.getText()));
            //int dato = Integer.parseInt(Cedula.getText());
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "La cédula debe ser un número");
            Cedula.setText("");
            Cedula.requestFocus();
        }
    }//GEN-LAST:event_CedulaFocusLost

    private void ContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContrasenaFocusLost
        // TODO add your handling code here:
//        Excepciones excepcion = new Excepciones();
//        try{
//            excepcion.ValidarContrasena(Contrasena.getText());
//        } catch(Excepciones ex){
//            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
//            Contrasena.setText("");
//            Contrasena.requestFocus();
//        }
    }//GEN-LAST:event_ContrasenaFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIAutenticacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cedula;
    private javax.swing.JPasswordField Contrasena;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton Insertar;
    private javax.swing.JComboBox<String> Tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
