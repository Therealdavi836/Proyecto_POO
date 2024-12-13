/**
 * @title: GUIBodegueros.java
 * @description: GUI de bodegueros para el proyecto CadenaSuministros.
 * @date: Domingo 12 de noviembre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

package menusGUI;

//Imports de apis y sql 
import Controlador.ConexionBD;
import Controlador.TextPrompt;
import Controlador.ControladorBodegueros;
import Excepciones.Excepciones;
import Modelo.Bodegueros;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;

//Clase de la interfaz grafica 
public class GUIBodegueros extends javax.swing.JFrame {

    /**
     * Creates new form GUIBodegueros
     */
    
    //Inicializacion de variables globales 
    private ControladorBodegueros proBodecont;
    Bodegueros usuario;
    ConexionBD conBD;
    Connection con;
    Object[] arregloDatos;
    private DefaultTableModel Modelo;
    
    
    //Constructor 
    public GUIBodegueros() {
        initComponents();
        usuario = new Bodegueros();
        proBodecont = new ControladorBodegueros();
        conBD = new ConexionBD();
        con = conBD.mysqlConexion();
        arregloDatos = new Object[9];
        Modelo = (DefaultTableModel)jTMB.getModel();
        consultarDB();
        
        TextPrompt placeholder = new TextPrompt("dd/mm/aaaa", FechaNacimiento);
        placeholder = new TextPrompt("dd/mm/aaaa", FechaIngreso);
    }
    
    //Metodo para limpiar los textfields 
    private void LimpiarCajasDeTexto(){
        //Atributos de usuario 
        cedula.setText("");
        Nombre.setText("");
        Apellido.setText("");
        Direccion.setText("");
        Telefono.setText("");
        Correo.setText("");
        FechaNacimiento.setText("");
        Contraseña.setText("");
        //Atributos propios
        FechaIngreso.setText("");
        Sueldo.setText("");
    }
    
    //Metodo para insertar en la tabla los atributos 
    private void insertarTabla(Bodegueros usuario){
        //Atributos de usuario
        arregloDatos[0] = usuario.getCedula(); //Cedula
        arregloDatos[1] = usuario.getNombre(); //Nombre
        arregloDatos[2] = usuario.getApellido(); //Apellido
        arregloDatos[3] = usuario.getDireccion(); //Direccion
        arregloDatos[4] = usuario.getTelefono(); //Telefono
        arregloDatos[5] = usuario.getEmail(); //Correo/Email
        arregloDatos[6] = usuario.getFechanacimiento();
        //Atributos propios
        arregloDatos[7] = usuario.getFechaIngreso(); //Fecha de ingreso
        arregloDatos[8] = usuario.getSueldo();
        
        Modelo.addRow(arregloDatos);
    }
    
    //Este metodo trae desde la base de datos las columnas de cada atributo 
    private void consultarDB(){
        
        try{
            Statement stmt = con.createStatement();
            ResultSet rsBode = stmt.executeQuery("SELECT * FROM ferreteria.bodegueros");
            
            while(rsBode.next()){
                usuario = new Bodegueros();
                
                arregloDatos[0] = rsBode.getInt(1); //Cedula
                usuario.setCedula(rsBode.getInt(1));
                
                arregloDatos[1] = rsBode.getString(2); //Nombre
                usuario.setNombre(rsBode.getString(2));
                
                arregloDatos[2] = rsBode.getString(3); //Apellido
                usuario.setApellido(rsBode.getString(3));
                
                arregloDatos[3] = rsBode.getString(4); //Direccion
                usuario.setDireccion(rsBode.getString(4));
                
                arregloDatos[4] = rsBode.getInt(5); //Telefono
                usuario.setTelefono(rsBode.getInt(5));
                
                arregloDatos[5] = rsBode.getString(6); //Correo
                usuario.setEmail(rsBode.getString(6));
                
                arregloDatos[6] = rsBode.getString(7); //Fecha de nacimiento
                usuario.setFechanacimiento(rsBode.getString(7));
                
                arregloDatos[7] = rsBode.getString(8); //Fecha de ingreso
                usuario.setFechaIngreso(rsBode.getString(8));
                
                arregloDatos[8] = rsBode.getInt(9); //Sueldo
                usuario.setSueldo(rsBode.getInt(9));
                
                usuario.setContrasena(rsBode.getString(10));
                
                if(proBodecont.insertar(usuario)){
                    Modelo.addRow(arregloDatos);
                    System.out.println("Insertado correctamente");
                }else{
                    insertarTabla(usuario);
                }
            }
        
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Dato NO Consultado de la base de datos");
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
        FranjaD = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        Borrar = new javax.swing.JButton();
        OrdenarID = new javax.swing.JButton();
        OrdenarTelefono = new javax.swing.JButton();
        OrdenarApellido = new javax.swing.JButton();
        OrdenarNombre = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Insertar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Telefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Direccion = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        FechaNacimiento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Sueldo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        FechaIngreso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMB = new javax.swing.JTable();

        Fondo.setBackground(new java.awt.Color(102, 102, 102));
        Fondo.setAutoscrolls(true);
        Fondo.setFocusCycleRoot(true);
        Fondo.setFocusTraversalPolicyProvider(true);

        FranjaD.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu de Bodeguero");

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Complete la informacion solicitada ");

        javax.swing.GroupLayout FranjaDLayout = new javax.swing.GroupLayout(FranjaD);
        FranjaD.setLayout(FranjaDLayout);
        FranjaDLayout.setHorizontalGroup(
            FranjaDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FranjaDLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(FranjaDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FranjaDLayout.setVerticalGroup(
            FranjaDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FranjaDLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña");

        cedula.setBackground(new java.awt.Color(204, 255, 204));
        cedula.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cedulaFocusLost(evt);
            }
        });
        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });

        Borrar.setBackground(new java.awt.Color(102, 255, 102));
        Borrar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Borrar.setText("Borrar");
        Borrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        OrdenarID.setBackground(new java.awt.Color(102, 255, 102));
        OrdenarID.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarID.setText("Ordenar por ID");
        OrdenarID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarIDActionPerformed(evt);
            }
        });

        OrdenarTelefono.setBackground(new java.awt.Color(102, 255, 102));
        OrdenarTelefono.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarTelefono.setText("Ordenar por Telefono ");
        OrdenarTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarTelefonoActionPerformed(evt);
            }
        });

        OrdenarApellido.setBackground(new java.awt.Color(102, 255, 102));
        OrdenarApellido.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarApellido.setText("Ordenar por Apellido");
        OrdenarApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarApellidoActionPerformed(evt);
            }
        });

        OrdenarNombre.setBackground(new java.awt.Color(102, 255, 102));
        OrdenarNombre.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarNombre.setText("Ordenar por Nombre");
        OrdenarNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarNombreActionPerformed(evt);
            }
        });

        Consultar.setBackground(new java.awt.Color(102, 255, 102));
        Consultar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Consultar.setText("Consultar ");
        Consultar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        Actualizar.setBackground(new java.awt.Color(102, 255, 102));
        Actualizar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Actualizar.setText("Actualizar ");
        Actualizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Insertar.setBackground(new java.awt.Color(102, 255, 102));
        Insertar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Insertar.setText("Insertar ");
        Insertar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cédula");

        Apellido.setBackground(new java.awt.Color(204, 255, 204));
        Apellido.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Apellido.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Apellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ApellidoFocusLost(evt);
            }
        });
        Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido");

        Contraseña.setBackground(new java.awt.Color(204, 255, 204));
        Contraseña.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Contraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Contraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Contraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ContraseñaFocusLost(evt);
            }
        });
        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre");

        Nombre.setBackground(new java.awt.Color(204, 255, 204));
        Nombre.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NombreFocusLost(evt);
            }
        });
        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Teléfono");

        Telefono.setBackground(new java.awt.Color(204, 255, 204));
        Telefono.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Telefono.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Telefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TelefonoFocusLost(evt);
            }
        });
        Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dirección");

        Direccion.setBackground(new java.awt.Color(204, 255, 204));
        Direccion.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Direccion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Direccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DireccionFocusLost(evt);
            }
        });
        Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionActionPerformed(evt);
            }
        });

        Correo.setBackground(new java.awt.Color(204, 255, 204));
        Correo.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Correo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CorreoFocusLost(evt);
            }
        });
        Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sueldo");

        jLabel10.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Correo");

        FechaNacimiento.setBackground(new java.awt.Color(204, 255, 204));
        FechaNacimiento.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        FechaNacimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaNacimiento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        FechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FechaNacimientoFocusLost(evt);
            }
        });
        FechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaNacimientoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha de Ingreso");

        Sueldo.setBackground(new java.awt.Color(204, 255, 204));
        Sueldo.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Sueldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Sueldo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Sueldo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SueldoFocusLost(evt);
            }
        });
        Sueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueldoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha de Nacimiento");

        FechaIngreso.setBackground(new java.awt.Color(204, 255, 204));
        FechaIngreso.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        FechaIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaIngreso.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        FechaIngreso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FechaIngresoFocusLost(evt);
            }
        });
        FechaIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaIngresoActionPerformed(evt);
            }
        });

        jTMB.setBackground(new java.awt.Color(204, 255, 204));
        jTMB.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTMB.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jTMB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Direccion", "Teléfono", "Correo", "Fecha de Nacimiento ", "Fecha de Ingreso ", "Sueldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMB.setGridColor(new java.awt.Color(0, 0, 0));
        jTMB.setShowHorizontalLines(true);
        jTMB.setShowVerticalLines(true);
        jTMB.setSurrendersFocusOnKeystroke(true);
        jTMB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTMB);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FranjaD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Borrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Insertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(Sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(FechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addComponent(Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235)))
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrdenarID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenarApellido))
                        .addGap(121, 121, 121)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrdenarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenarTelefono))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(FranjaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel12))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(FechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OrdenarID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrdenarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrdenarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
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

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    //Metodo para borrar un objeto desde la base de datos 
    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        // TODO add your handling code here:
        //Si el campo esta vavio, no lo dejara pasar 
        if(cedula.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "El campo cédula está vacío!");
        }else{
            //Variable temporal 
            int Cedula = Integer.parseInt(cedula.getText());
            
            //El ciclo recorre fila por fila hasta encontrar el valor insertado 
            for(int i = 0; i < Modelo.getRowCount(); i++){
                if(Cedula == (int) Modelo.getValueAt(i, 0)){
                    usuario = new Bodegueros();
                    usuario.setCedula(Integer.parseInt(cedula.getText()));
                    usuario.setCedula(Cedula);
                    
                    //Se invoca al metodo borrar 
                    if(proBodecont.borrar(usuario)) {
                        Modelo.removeRow(i);
                        proBodecont.borrar(usuario);
                        try {
                            //Se inicializa una instruccion del sql y se envia a la base de datos 
                            String query = "DELETE FROM bodegueros WHERE cedula = " + Cedula + ";";
                            Statement stm = con.createStatement();
                            stm.executeUpdate(query);
                            
                            JOptionPane.showMessageDialog(rootPane, "Dato Borrado");
                            Modelo.removeRow(i);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Dato NO Borrado de la Base de Datos");
                            ex.printStackTrace();
                        }
                        LimpiarCajasDeTexto();
                        cedula.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Dato NO Borrado");
                    }
                    break;
                }
            }
        }
    }//GEN-LAST:event_BorrarActionPerformed

    
    //Metodo para ordenar por cedula los objetos 
    private void OrdenarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarIDActionPerformed
        // TODO add your handling code here:
        proBodecont.ordenar();
        Modelo.setRowCount(0);
        for(Bodegueros usuario1: proBodecont.arregloBodegueros){
            insertarTabla(usuario1);
        }
    }//GEN-LAST:event_OrdenarIDActionPerformed

    //Metodo para ordenar por telefono mediante mergesort 
    private void OrdenarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarTelefonoActionPerformed
        // TODO add your handling code here:
        proBodecont.arregloBodegueros = proBodecont.mergeSort(proBodecont.arregloBodegueros);
        Modelo.setRowCount(0);
        for(Bodegueros usuario1: proBodecont.arregloBodegueros){
            insertarTabla(usuario1);
        }

    }//GEN-LAST:event_OrdenarTelefonoActionPerformed

    //Metodo para ordenar por apellido mediante ordenamiento por burbuja 
    private void OrdenarApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarApellidoActionPerformed
        // TODO add your handling code here:
        proBodecont.burbuja();
        Modelo.setRowCount(0);
        for(Bodegueros usuario1: proBodecont.arregloBodegueros){
            insertarTabla(usuario1);
        }
    }//GEN-LAST:event_OrdenarApellidoActionPerformed

    //Metodo para ordenar por nombre mediante quickSort 
    private void OrdenarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarNombreActionPerformed
        // TODO add your handling code here:
        proBodecont.ordenar(0, proBodecont.arregloBodegueros.size() - 1);
        Modelo.setRowCount(0);
        for(Bodegueros usuario1: proBodecont.arregloBodegueros){
            insertarTabla(usuario1);
        }

    }//GEN-LAST:event_OrdenarNombreActionPerformed

    //Metodo para consultar desde la tabla de datos 
    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        // TODO add your handling code here:
        //Si el campo esta vacio, no lo dejara pasar 
        if(cedula.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "El campo cédula está vacío!");
        }else{
            //Se hace una variable temporal 
            int Cedula = Integer.parseInt(cedula.getText()); 
            
            //El for recorre la tabla por filas hasta encontrar el dato consultado
            for (int i = 0; i < Modelo.getRowCount(); i++) { 
                if (Cedula == (int) Modelo.getValueAt(i, 0)) { 
                    usuario = proBodecont.arregloBodegueros.get(i);
                    //Atributos de Usuario
                    cedula.setText("" + usuario.getCedula());
                    Nombre.setText(usuario.getNombre());
                    Apellido.setText(usuario.getApellido());
                    Direccion.setText(usuario.getDireccion());
                    Telefono.setText("" + usuario.getTelefono());
                    Correo.setText(usuario.getEmail());
                    FechaNacimiento.setText(usuario.getFechanacimiento());
                    Contraseña.setText(usuario.getContrasena());
                    //Atributos Propios
                    FechaIngreso.setText(usuario.getFechaIngreso());
                    Sueldo.setText("" + usuario.getSueldo());
                    //Se desactiva el campo cedula para que este no pueda ser modificado 
                    cedula.setEnabled(false);
                }
            } 
        }
    }//GEN-LAST:event_ConsultarActionPerformed

    //Metodo para actualizar un objeto desde la base de datos 
    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
        //Si la cedula esta vacia, no lo dejara pasar 
        if(cedula.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "El campo cédula está vacío");
        }else{
            //Se hace una variable temporal 
            int Cedula = Integer.parseInt(cedula.getText());

            //El for recorre fila por fila hasta encontrar el objeto modificado 
            for(int i = 0; i < Modelo.getRowCount(); i++){
                if(Cedula == (int)  Modelo.getValueAt(i, 0)){
                    //Se separa memoria 
                    usuario = new Bodegueros();
                    usuario.setCedula(Integer.parseInt(cedula.getText()));
                    proBodecont.borrar(usuario);
                    Modelo.removeRow(i);

                    //Atributos de Usuario
                    usuario.setCedula(Integer.parseInt(cedula.getText()));
                    usuario.setNombre(Nombre.getText());
                    usuario.setApellido(Apellido.getText());
                    usuario.setDireccion(Direccion.getText());
                    usuario.setTelefono(Integer.parseInt(Telefono.getText()));
                    usuario.setEmail(Correo.getText());
                    usuario.setFechanacimiento(FechaNacimiento.getText());
                    usuario.setContrasena(Contraseña.getText());
                    //Atributos Propios
                    usuario.setFechaIngreso(FechaIngreso.getText());
                    usuario.setSueldo(Integer.parseInt(Sueldo.getText()));
                    
                    //Invoca al metodo insertar del controlador 
                    if(proBodecont.insertar(usuario)) {
                        insertarTabla(usuario);
                        proBodecont.insertar(usuario);
                        try {
                            //Se hace una instruccion del sql y se ejecuta hacia la base de datos 
                            String query = "UPDATE bodegueros SET "
                                //Atributos de Usuario
                                + "`nombre` = '" + usuario.getNombre() + "', "
                                + "`apellido` = '" + usuario.getApellido() + "', "
                                + "`direccion` = '" + usuario.getDireccion() + "', "
                                + "`telefono` = '" + usuario.getTelefono() + "', "
                                + "`correo` = '" + usuario.getEmail() + "', "
                                + "`fechaNacimiento` = '" + usuario.getFechanacimiento() + "', "
                                //Atributos Propios
                                + "`fechaIngreso` = '" + usuario.getFechaIngreso() + "', "
                                + "`sueldo` = '" + usuario.getSueldo() + "', "
                                + "`contraseña` = '" + usuario.getContrasena() + "' "
                                + "WHERE (`cedula` = '" + usuario.getCedula() + "');";

                            //Se ejecuta la instruccion inicializada 
                            Statement stm = con.createStatement();
                            stm.executeUpdate(query);
                            
                            //Se invoca al metodo ordenar 
                            OrdenarIDActionPerformed(evt);
                            
                            //Modelo.addRow(arregloDatos);
                            JOptionPane.showMessageDialog(rootPane, "Dato Modificado");
                        } catch (SQLException SQLIntegrityConstraintViolationException) {
                            JOptionPane.showMessageDialog(rootPane, "Dato NO Modificado en la Base de Datos");
                            //ex.printStackTrace();
                        }
                        LimpiarCajasDeTexto();
                        //Se desactiva el campo de id para que el usuario no lo pueda modificar 
                        cedula.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Dato NO Modificado");
                    }
                    break;
                }
            }
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    //Metodo para insertar un objeto a la base de datos 
    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        // TODO add your handling code here:
        //S separa memoria
        usuario = new Bodegueros();
        
        //Conversion de variables a texto
        //Atributos de Usuario
        usuario.setCedula(Integer.parseInt(cedula.getText()));
        usuario.setNombre(Nombre.getText());
        usuario.setApellido(Apellido.getText());
        usuario.setDireccion(Direccion.getText());
        usuario.setTelefono(Integer.parseInt(Telefono.getText()));
        usuario.setEmail(Correo.getText());
        usuario.setFechanacimiento(FechaNacimiento.getText());
        usuario.setContrasena(Contraseña.getText());
        //Atributos Propios
        usuario.setFechaIngreso(FechaIngreso.getText());
        usuario.setSueldo(Integer.parseInt(Sueldo.getText()));
        
        //Invoca al metodo insertar de la base de datos 
        if(proBodecont.insertar(usuario)){
            insertarTabla(usuario);
            proBodecont.insertar(usuario);
            try {
                //Se hace una instruccion del sql 
                String query = "INSERT INTO bodegueros VALUES('"
                    //Atributos de Usuario
                    + usuario.getCedula() + "', '"
                    + usuario.getNombre() + "', '"
                    + usuario.getApellido() + "', '"
                    + usuario.getDireccion() + "', '"
                    + usuario.getTelefono() + "', '"
                    + usuario.getEmail() + "', '"
                    + usuario.getFechanacimiento() + "', '"
                    //Atributos Propios
                    + usuario.getFechaIngreso() + "', '"
                    + usuario.getSueldo() + "', '"
                    + usuario.getContrasena() + "');";
                    
                //Se ejecuta la instruccion del sql 
                Statement stm = con.createStatement();
                stm.executeUpdate(query);

                JOptionPane.showMessageDialog(rootPane, "Dato Insertado");
            } catch (SQLException SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(rootPane, "Dato NO Insertado en la Base de Datos");
                //ex.printStackTrace();
            }
            LimpiarCajasDeTexto();
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Dato NO Insertado");
    }//GEN-LAST:event_InsertarActionPerformed

    private void ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidoActionPerformed

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActionPerformed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonoActionPerformed

    private void DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionActionPerformed

    private void CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreoActionPerformed

    private void FechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaNacimientoActionPerformed

    private void SueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueldoActionPerformed

    private void FechaIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaIngresoActionPerformed

    //El evento trae desde el click de tabla a los textfields de la interfaz 
    private void jTMBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMBMouseClicked
        // TODO add your handling code here:
        for(int i = 0; i < Modelo.getRowCount(); i++){
            if(proBodecont.borrar(usuario)) {
                Modelo.removeTableModelListener(jTMB);
            }
        }    
        consultarDB();
        proBodecont.consultarGeneral();
        int pos = jTMB.getSelectedRow();
        System.out.println("pos: " + pos);

        try {
            if (pos >= 0 && pos < proBodecont.arregloBodegueros.size()) {
                usuario = proBodecont.arregloBodegueros.get(pos);

                // Resto del código para mostrar los atributos del usuario en la interfaz gráfica
                cedula.setText("" + usuario.getCedula());
                Nombre.setText(usuario.getNombre());
                Apellido.setText(usuario.getApellido());
                Direccion.setText(usuario.getDireccion());
                Telefono.setText("" + usuario.getTelefono());
                Correo.setText(usuario.getEmail());
                Sueldo.setText("" + usuario.getSueldo());
                FechaNacimiento.setText(usuario.getFechanacimiento());
                FechaIngreso.setText(usuario.getFechaIngreso());
                Contraseña.setText(usuario.getContrasena());

                // El campo cedula no se puede modificar
                cedula.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Indice fuera del rango");
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("\nFormato excedido");
        }
    }//GEN-LAST:event_jTMBMouseClicked

    private void cedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cedulaFocusLost
        // TODO add your handling code here:
        try{
            usuario.setCedula(Integer.parseInt(cedula.getText()));
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "La cedula debe de ser un numero");
            cedula.setText("");
            cedula.requestFocus();
        }
    }//GEN-LAST:event_cedulaFocusLost

    private void ContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContraseñaFocusLost
        // TODO add your handling code here:
        Excepciones excepcion = new Excepciones();
        try{
            excepcion.ValidarContrasena(Contraseña.getText());
        } catch(Excepciones ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Contraseña.setText("");
            Contraseña.requestFocus();
        }
    }//GEN-LAST:event_ContraseñaFocusLost

    private void NombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreFocusLost
        // TODO add your handling code here:
        Excepciones excepcion = new Excepciones();
        try {
            excepcion.ValidarNombreUsuario(Nombre.getText());
        } catch (Excepciones ex) {
            JOptionPane.showMessageDialog(rootPane , ex.getMessage());
            Nombre.setText("");
            Nombre.requestFocus();
        }
    }//GEN-LAST:event_NombreFocusLost

    private void ApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ApellidoFocusLost
        // TODO add your handling code here:
        Excepciones excepcion = new Excepciones();
        try{
            excepcion.ValidarTexto(Apellido.getText());
        } catch (Excepciones ex) {
            JOptionPane.showMessageDialog(rootPane , ex.getMessage());
            Apellido.setText("");
            Apellido.requestFocus();
        }

    }//GEN-LAST:event_ApellidoFocusLost

    private void DireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DireccionFocusLost
        // TODO add your handling code here:
        Excepciones excepcion = new Excepciones();
        try {
            excepcion.ValidarDireccion(Direccion.getText());
        } catch (Excepciones ex) {
            JOptionPane.showMessageDialog(rootPane , ex.getMessage());
            Direccion.setText("");
            Direccion.requestFocus();
        }

    }//GEN-LAST:event_DireccionFocusLost

    private void TelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TelefonoFocusLost
        // TODO add your handling code here:
        try{
            usuario.setTelefono(Integer.parseInt(Telefono.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "El teléfono debe ser un número");
            Telefono.setText("");
            Telefono.requestFocus();
        }
    }//GEN-LAST:event_TelefonoFocusLost

    private void CorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CorreoFocusLost
        // TODO add your handling code here:
        Excepciones excepcion = new Excepciones();
        try {
            excepcion.ValidarCorreo(Correo.getText());
        } catch (Excepciones ex) {
            JOptionPane.showMessageDialog(rootPane , ex.getMessage());
            Correo.setText("");
            Correo.requestFocus();
        }
    }//GEN-LAST:event_CorreoFocusLost

    private void SueldoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SueldoFocusLost
        // TODO add your handling code here:
        try{
            usuario.setSueldo(Integer.parseInt(Sueldo.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "El sueldo debe ser un número!");
            Sueldo.setText("");
            Sueldo.requestFocus();
        }
    }//GEN-LAST:event_SueldoFocusLost

    private void FechaNacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FechaNacimientoFocusLost
        // TODO add your handling code here:
        Excepciones excepcion = new Excepciones();
        try {
            excepcion.ValidarFecha(FechaNacimiento.getText());
        } catch (Excepciones ex) {
            JOptionPane.showMessageDialog(rootPane , ex.getMessage());
            FechaNacimiento.setText("");
            FechaNacimiento.requestFocus();
        }
    }//GEN-LAST:event_FechaNacimientoFocusLost

    private void FechaIngresoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FechaIngresoFocusLost
        // TODO add your handling code here:
        Excepciones excepcion = new Excepciones();
        try {
            excepcion.ValidarFecha(FechaIngreso.getText());
        } catch (Excepciones ex) {
            JOptionPane.showMessageDialog(rootPane , ex.getMessage());
            FechaIngreso.setText("");
            FechaIngreso.requestFocus();
        }
    }//GEN-LAST:event_FechaIngresoFocusLost

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUIBodegueros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIBodegueros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIBodegueros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIBodegueros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIBodegueros().setVisible(true);
//            }
//        });
//    }

    //Metodos getter y setter 
    
    public JButton getActualizar() {
        return Actualizar;
    }

    public void setActualizar(JButton Actualizar) {
        this.Actualizar = Actualizar;
    }

    public JTextField getApellido() {
        return Apellido;
    }

    public void setApellido(JTextField Apellido) {
        this.Apellido = Apellido;
    }

    public JButton getBorrar() {
        return Borrar;
    }

    public void setBorrar(JButton Borrar) {
        this.Borrar = Borrar;
    }

    public JButton getConsultar() {
        return Consultar;
    }

    public void setConsultar(JButton Consultar) {
        this.Consultar = Consultar;
    }

    public JTextField getContraseña() {
        return Contraseña;
    }

    public void setContraseña(JTextField Contraseña) {
        this.Contraseña = Contraseña;
    }

    public JTextField getCorreo() {
        return Correo;
    }

    public void setCorreo(JTextField Correo) {
        this.Correo = Correo;
    }

    public JTextField getDireccion() {
        return Direccion;
    }

    public void setDireccion(JTextField Direccion) {
        this.Direccion = Direccion;
    }

    public JTextField getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(JTextField FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public JTextField getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(JTextField FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public JTextField getNombre() {
        return Nombre;
    }

    public void setNombre(JTextField Nombre) {
        this.Nombre = Nombre;
    }

    public JButton getOrdenarApellido() {
        return OrdenarApellido;
    }

    public void setOrdenarApellido(JButton OrdenarApellido) {
        this.OrdenarApellido = OrdenarApellido;
    }

    public JTextField getSueldo() {
        return Sueldo;
    }

    public void setSueldo(JTextField Sueldo) {
        this.Sueldo = Sueldo;
    }

    public JTextField getTelefono() {
        return Telefono;
    }

    public void setTelefono(JTextField Telefono) {
        this.Telefono = Telefono;
    }

    public JTextField getCedula() {
        return cedula;
    }

    public void setCedula(JTextField cedula) {
        this.cedula = cedula;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JTextField Apellido;
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Consultar;
    private javax.swing.JTextField Contraseña;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextField Direccion;
    private javax.swing.JTextField FechaIngreso;
    private javax.swing.JTextField FechaNacimiento;
    private javax.swing.JPanel Fondo;
    private javax.swing.JPanel FranjaD;
    private javax.swing.JButton Insertar;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton OrdenarApellido;
    private javax.swing.JButton OrdenarID;
    private javax.swing.JButton OrdenarNombre;
    private javax.swing.JButton OrdenarTelefono;
    private javax.swing.JTextField Sueldo;
    private javax.swing.JTextField Telefono;
    private javax.swing.JTextField cedula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMB;
    // End of variables declaration//GEN-END:variables
}
