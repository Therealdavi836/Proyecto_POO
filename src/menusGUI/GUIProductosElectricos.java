/**
 * @title: GUIProductosElectricos.java
 * @description: GUI de productos electricos para el proyecto CadenaSuministros.
 * @date: Domingo 12 de noviembre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

package menusGUI;

//Imports de apis de java y sql
import Controlador.ControladorProductosElectricos;
import Controlador.ConexionBD;
import Excepciones.Excepciones;
import Modelo.ProductosElectricos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

//Clase de la interfaz grafica 
public class GUIProductosElectricos extends javax.swing.JFrame {

    /**
     * Creates new form GUIProductosElectricos
     */
    
    //Inicializacion de variables globales 
    private ControladorProductosElectricos proECont;
    ProductosElectricos ProE;
    ConexionBD conBD;
    Connection con;
    Object[] arregloDatos;
    private DefaultTableModel Modelo;
    
    //Constructor 
    public GUIProductosElectricos() {
        initComponents();
        proECont = new ControladorProductosElectricos();
        ProE = new ProductosElectricos();
        conBD = new ConexionBD();
        con = conBD.mysqlConexion();
        arregloDatos = new Object[12];
        Modelo = (DefaultTableModel)jTMPE.getModel();
        consultarDB();
    }
    
    //Metodo para limpiar las cajas de texto y jcombobox
    private void LimpiarCajasDeTexto(){
        //Atributos de producto
        NS.setText("");
        Nom.setText("");
        Col.setSelectedIndex(0);
        Marc.setText("");
        Materi.setSelectedIndex(0);
        Demand.setText("");
        CP.setText("");
        CV.setText("");
        CA.setText("");
        Idbodega.setSelectedIndex(0);
        //Atributos propios 
        CC.setText("");
        Calibre.setText("");
    }
    
    //Metodo para insertar a la tabla de la interfaz 
    private void insertarTabla(ProductosElectricos ProE){
        //Atributos de productos
        arregloDatos[0] = ProE.getSerial();
        arregloDatos[1] = ProE.getNombre();
        arregloDatos[2] = ProE.getColor();
        arregloDatos[3] = ProE.getMarca();
        arregloDatos[4] = ProE.getMaterial();
        arregloDatos[5] = ProE.getbodegaId();
        arregloDatos[6] = ProE.getdemanda();
        arregloDatos[7] = ProE.getCostoproduccion();
        arregloDatos[8] = ProE.getCostodeventa();
        arregloDatos[9] = ProE.getCostoalmacenamiento();
        //Atributos propios 
        arregloDatos[10] = ProE.getCapacidadCarga();
        arregloDatos[11] = ProE.getCalibre();
        
        Modelo.addRow(arregloDatos);
    }

    private void imagen(){
        try{
            System.out.println("\nimg: " + ProE.getImagen());
            BufferedImage buf = ImageIO.read(new File(ProE.getImagen()));
            ImageIcon icon = new ImageIcon(buf);
            jRuta.setIcon(icon);
        } catch (IOException ex){
            System.out.println("\nLa imagen no se insertó");
        }
    }

    //Trae desde la base de datos los atributos de cada columna y los inserta en la tabla 
    private void consultarDB(){

        try{
            Statement stmt = con.createStatement();
            ResultSet rsProE = stmt.executeQuery("SELECT * FROM ferreteria.productoelectrico");
            
            while(rsProE.next()){
                ProE = new ProductosElectricos();
                
                arregloDatos[0] = rsProE.getInt(1); //Serial
                ProE.setSerial(rsProE.getInt(1));
                
                arregloDatos[1] = rsProE.getString(2);//Nombre
                ProE.setNombre(rsProE.getString(2));
                
                arregloDatos[2] = rsProE.getString(3);//Color
                ProE.setColor(rsProE.getString(3));
                
                arregloDatos[3] = rsProE.getString(4);//Marca
                ProE.setMarca(rsProE.getString(4));
                
                arregloDatos[4] = rsProE.getString(5);//Material
                ProE.setMaterial(rsProE.getString(5));
                
                arregloDatos[5] = rsProE.getInt(6);//bodega id
                ProE.setBodegaId(rsProE.getInt(6));
                
                arregloDatos[6] = rsProE.getInt(7);//Demanda
                ProE.setdemanda(rsProE.getInt(7));
                
                arregloDatos[7] = rsProE.getFloat(8);//Costo de produccion 
                ProE.setCostoproduccion(rsProE.getFloat(8));
                
                arregloDatos[8] = rsProE.getFloat(9);//Costo de venta
                ProE.setCostodeventa(rsProE.getFloat(9));
                
                arregloDatos[9] = rsProE.getFloat(10);//Costo almacenamiento
                ProE.setCostoalmacenamiento(rsProE.getFloat(10));
                
                arregloDatos[10] = rsProE.getFloat(11);//Capacidad de carga
                ProE.setCapacidadCarga(rsProE.getFloat(11));
                
                arregloDatos[11] = rsProE.getFloat(12);//Calibre
                ProE.setCalibre(rsProE.getFloat(12));
               
                ProE.setImagen(ProE.getImagen() + rsProE.getString(13)); //Imagen
                
                if(proECont.insertar(ProE)){
                    Modelo.addRow(arregloDatos);
                    System.out.println("Insertado correctamente");
                }else{
                    insertarTabla(ProE);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NumeroSerial = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Color = new javax.swing.JLabel();
        JLabel7 = new javax.swing.JLabel();
        Marca = new javax.swing.JLabel();
        Material = new javax.swing.JLabel();
        Demanda = new javax.swing.JLabel();
        Cdp = new javax.swing.JLabel();
        Cda = new javax.swing.JLabel();
        Cdv = new javax.swing.JLabel();
        TipoE = new javax.swing.JLabel();
        NS = new javax.swing.JTextField();
        Nom = new javax.swing.JTextField();
        Marc = new javax.swing.JTextField();
        CV = new javax.swing.JTextField();
        CA = new javax.swing.JTextField();
        CP = new javax.swing.JTextField();
        Demand = new javax.swing.JTextField();
        CC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMPE = new javax.swing.JTable();
        IDBodega = new javax.swing.JLabel();
        Borrar = new javax.swing.JButton();
        OrdenarID = new javax.swing.JButton();
        OrdenarMarca = new javax.swing.JButton();
        OrdenarPV = new javax.swing.JButton();
        OrdenarNombre = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Insertar = new javax.swing.JButton();
        Calibre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jRuta = new javax.swing.JLabel();
        Col = new javax.swing.JComboBox<>();
        Materi = new javax.swing.JComboBox<>();
        Idbodega = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setAutoscrolls(true);
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setFocusTraversalPolicyProvider(true);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu de Productos Electricos");

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Complete la informacion solicitada ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        NumeroSerial.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        NumeroSerial.setForeground(new java.awt.Color(255, 255, 255));
        NumeroSerial.setText("Numero Serial");

        Nombre.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Nombre");

        Color.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        Color.setForeground(new java.awt.Color(255, 255, 255));
        Color.setText("Color ");

        JLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        JLabel7.setForeground(new java.awt.Color(255, 255, 255));
        JLabel7.setText("Calibre ");

        Marca.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        Marca.setForeground(new java.awt.Color(255, 255, 255));
        Marca.setText("Marca ");

        Material.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        Material.setForeground(new java.awt.Color(255, 255, 255));
        Material.setText("Material");

        Demanda.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        Demanda.setForeground(new java.awt.Color(255, 255, 255));
        Demanda.setText("Demanda");

        Cdp.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        Cdp.setForeground(new java.awt.Color(255, 255, 255));
        Cdp.setText("Costo de Producción ");

        Cda.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        Cda.setForeground(new java.awt.Color(255, 255, 255));
        Cda.setText("Costo de Almacenamiento ");

        Cdv.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Cdv.setForeground(new java.awt.Color(255, 255, 255));
        Cdv.setText("Costo de Venta ");

        TipoE.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        TipoE.setForeground(new java.awt.Color(255, 255, 255));
        TipoE.setText("Capacidad de carga");

        NS.setBackground(new java.awt.Color(153, 153, 255));
        NS.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        NS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NS.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        NS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NSFocusLost(evt);
            }
        });
        NS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NSActionPerformed(evt);
            }
        });

        Nom.setBackground(new java.awt.Color(153, 153, 255));
        Nom.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Nom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nom.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Nom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NomFocusLost(evt);
            }
        });
        Nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomActionPerformed(evt);
            }
        });

        Marc.setBackground(new java.awt.Color(153, 153, 255));
        Marc.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Marc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Marc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Marc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MarcFocusLost(evt);
            }
        });
        Marc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcActionPerformed(evt);
            }
        });

        CV.setBackground(new java.awt.Color(153, 153, 255));
        CV.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        CV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CVFocusLost(evt);
            }
        });
        CV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVActionPerformed(evt);
            }
        });

        CA.setBackground(new java.awt.Color(153, 153, 255));
        CA.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        CA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CA.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CAFocusLost(evt);
            }
        });
        CA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CAActionPerformed(evt);
            }
        });

        CP.setBackground(new java.awt.Color(153, 153, 255));
        CP.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        CP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CPFocusLost(evt);
            }
        });
        CP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPActionPerformed(evt);
            }
        });

        Demand.setBackground(new java.awt.Color(153, 153, 255));
        Demand.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Demand.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Demand.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Demand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DemandFocusLost(evt);
            }
        });
        Demand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DemandActionPerformed(evt);
            }
        });

        CC.setBackground(new java.awt.Color(153, 153, 255));
        CC.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        CC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CCFocusLost(evt);
            }
        });
        CC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCActionPerformed(evt);
            }
        });

        jTMPE.setBackground(new java.awt.Color(153, 153, 255));
        jTMPE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTMPE.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jTMPE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Serial", "Nombre", "Color ", "Marca ", "Material", "ID Bodega ", "Demanda", "Costo P", "Costo V ", "Costo A", "Capacidad C", "Calibre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMPE.setRowHeight(30);
        jTMPE.setShowHorizontalLines(true);
        jTMPE.setShowVerticalLines(true);
        jTMPE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMPEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTMPE);

        IDBodega.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        IDBodega.setForeground(new java.awt.Color(255, 255, 255));
        IDBodega.setText("ID Bodega");

        Borrar.setBackground(new java.awt.Color(102, 102, 255));
        Borrar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Borrar.setText("Borrar");
        Borrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        OrdenarID.setBackground(new java.awt.Color(102, 102, 255));
        OrdenarID.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarID.setText("Ordenar por ID");
        OrdenarID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarIDActionPerformed(evt);
            }
        });

        OrdenarMarca.setBackground(new java.awt.Color(102, 102, 255));
        OrdenarMarca.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarMarca.setText("Ordenar por Marca ");
        OrdenarMarca.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarMarcaActionPerformed(evt);
            }
        });

        OrdenarPV.setBackground(new java.awt.Color(102, 102, 255));
        OrdenarPV.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarPV.setText("Ordenar por Precio");
        OrdenarPV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarPVActionPerformed(evt);
            }
        });

        OrdenarNombre.setBackground(new java.awt.Color(102, 102, 255));
        OrdenarNombre.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarNombre.setText("Ordenar por Nombre");
        OrdenarNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarNombreActionPerformed(evt);
            }
        });

        Consultar.setBackground(new java.awt.Color(102, 102, 255));
        Consultar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Consultar.setText("Consultar ");
        Consultar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        Actualizar.setBackground(new java.awt.Color(102, 102, 255));
        Actualizar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Actualizar.setText("Actualizar ");
        Actualizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Insertar.setBackground(new java.awt.Color(102, 102, 255));
        Insertar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Insertar.setText("Insertar ");
        Insertar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });

        Calibre.setBackground(new java.awt.Color(153, 153, 255));
        Calibre.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Calibre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Calibre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Calibre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CalibreFocusLost(evt);
            }
        });
        Calibre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalibreActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Imagen ");

        Col.setBackground(new java.awt.Color(153, 153, 255));
        Col.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Col.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Blanco", "Negro", "Plateado", "Azul Oscuro ", "Rojo" }));
        Col.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Col.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColActionPerformed(evt);
            }
        });

        Materi.setBackground(new java.awt.Color(153, 153, 255));
        Materi.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Materi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Porcelana", "Metal", "Vidrio", "Hierro", "Policarbono" }));
        Materi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        Idbodega.setBackground(new java.awt.Color(153, 153, 255));
        Idbodega.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Idbodega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2", "3", "4", "5" }));
        Idbodega.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NumeroSerial)
                            .addComponent(Nombre)
                            .addComponent(Color)
                            .addComponent(Material)
                            .addComponent(IDBodega)
                            .addComponent(Marca)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                                .addComponent(jRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Nom, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NS, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Marc, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Col, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Materi, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Idbodega, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Cdp)
                                                    .addComponent(Demanda)
                                                    .addComponent(Cdv))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Demand, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(CV, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                                        .addComponent(CP))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Cda)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                                .addComponent(CA, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(JLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Calibre, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(TipoE)
                                                .addGap(94, 94, 94)
                                                .addComponent(CC)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(214, 214, 214)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrdenarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenarNombre))
                        .addGap(139, 139, 139)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrdenarPV)
                            .addComponent(OrdenarID, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(238, 238, 238))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NumeroSerial)
                                .addComponent(NS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Demanda)
                                    .addComponent(Demand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cdp)
                                    .addComponent(CP, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Nombre))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cdv)
                                    .addComponent(CV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Color)
                                    .addComponent(Col, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cda)
                                    .addComponent(CA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Marca)
                                    .addComponent(Marc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TipoE)
                                    .addComponent(CC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Material)
                                    .addComponent(Materi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabel7)
                            .addComponent(Calibre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDBodega)
                            .addComponent(Idbodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(120, 120, 120))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(69, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OrdenarID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OrdenarPV, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomActionPerformed

    private void MarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcActionPerformed

    private void CVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CVActionPerformed

    private void CAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CAActionPerformed

    private void CPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPActionPerformed

    private void DemandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DemandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DemandActionPerformed

    private void CCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CCActionPerformed

    //Metodo para borrar un objeto desde la base de datos 
    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        // TODO add your handling code here:
        //Si el campo esta vacio, no lo dejara pasar 
        if(NS.getText().equals("")){
            JOptionPane .showMessageDialog(rootPane, "El campo id esta vacio");
        }else{
            //Se inicializa una variable temporal
            int serial = Integer.parseInt(NS.getText());
            
            //El for recorre fila por fila hasta encontrar el objeto segun el id insertado 
            for(int i = 0 ; i < Modelo.getRowCount(); i++){
                if(serial == (int) Modelo.getValueAt(i, 0)){
                    ProE = new ProductosElectricos();
                    ProE.setSerial(Integer.parseInt(NS.getText()));
                    
                    if(proECont.borrar(ProE)){
                        Modelo.removeRow(i);
                        proECont.borrar(ProE);
                        try{
                            //Se crea una instruccion del sql y se manda a la base de datos 
                            String query = "DELETE FROM productoelectrico WHERE serial = " + serial + ";" ;
                            Statement stm = con.createStatement();
                            stm.executeUpdate(query);
                            
                            JOptionPane.showMessageDialog(rootPane, "Dato borrado");
                        
                        } catch(SQLException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Dato no borrado de la base de datos");
                            ex.printStackTrace();
                        }
                        LimpiarCajasDeTexto();
                        NS.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Dato no borrado");
                    }
                    break;
                }
            }
        } 
    }//GEN-LAST:event_BorrarActionPerformed

    //Metodo para ordenar por id los objetos mediante sort 
    private void OrdenarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarIDActionPerformed
        // TODO add your handling code here:
        proECont.ordenar();
        Modelo.setRowCount(0);
        for(ProductosElectricos ProE1: proECont.arregloProductosElectricos){
            insertarTabla(ProE1);
        }
    }//GEN-LAST:event_OrdenarIDActionPerformed

    //Metodo para consultar un objeto del arreglo 
    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        // TODO add your handling code here:
        try{
            //Si el campo esta vacio , no lo dejara pasar 
            if(NS.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "El campo id está vacio");
            }else{
                //Se inicializa una variable temporal 
                int serial = Integer.parseInt(NS.getText());

                //El for recorre fila por fila hasta encontrar el objeto por id consultado 
                for(int i = 0; i < Modelo.getRowCount(); i++){
                    if(serial == (int) Modelo.getValueAt(i, 0)){
                        ProE = proECont.arregloProductosElectricos.get(i);
                        //Atributos de producto
                        NS.setText("" + ProE.getSerial());
                        Nom.setText(ProE.getNombre());
                        Col.setSelectedItem(ProE.getColor());
                        Marc.setText(ProE.getMarca());
                        Materi.setSelectedItem(ProE.getMaterial());
                        Idbodega.setSelectedItem("" + ProE.getbodegaId());
                        Demand.setText("" + ProE.getdemanda());
                        CP.setText("" + ProE.getCostoproduccion());
                        CV.setText("" + ProE.getCostodeventa());
                        CA.setText("" + ProE.getCostoalmacenamiento());
                        //Atributos propios
                        CC.setText(""+ ProE.getCapacidadCarga());
                        Calibre.setText("" + ProE.getCalibre());
                        imagen();
                        NS.setEnabled(false);
                    }
                }
            }
        } catch(IndexOutOfBoundsException ex){
            System.out.println("\nFormato excedido");
        }

    }//GEN-LAST:event_ConsultarActionPerformed

    //Metodo para actualizar un objeto de la base de datos 
    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
        //Si el campo esta vacio, no lo dejara pasar 
        if(NS.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "El campo id está vacio");
        }else{
            //Variable temporal 
            int serial = Integer.parseInt(NS.getText());
            
            //El for recorre fila por fila hasta encontrar el objeto a actualizar y 
            //convierte los textfields a solo texto 
            for(int i = 0; i < Modelo.getRowCount(); i++){
                if(serial == (int) Modelo.getValueAt(i, 0)){
                    ProE = new ProductosElectricos();
                    ProE.setSerial(Integer.parseInt(NS.getText()));
                    proECont.borrar(ProE);
                    Modelo.removeRow(i);
                    
                    //Atributos de producto
                    ProE.setSerial(Integer.parseInt(NS.getText()));
                    ProE.setNombre(Nom.getText());
                    ProE.setColor((String) Col.getSelectedItem());
                    ProE.setMarca(Marc.getText());
                    ProE.setMaterial((String) Materi.getSelectedItem());
                    ProE.setBodegaId((int) Idbodega.getSelectedIndex());
                    ProE.setdemanda(Integer.parseInt(Demand.getText()));
                    ProE.setCostoproduccion(Float.parseFloat(CP.getText()));
                    ProE.setCostodeventa(Float.parseFloat(CV.getText()));
                    ProE.setCostoalmacenamiento(Float.parseFloat(CA.getText()));
                    ProE.setCapacidadCarga(Float.parseFloat(CC.getText()));
                    ProE.setCalibre(Float.parseFloat(Calibre.getText()));
                    //ProHe.setImagen(" ");
                    
                    if(proECont.insertar(ProE)){
                        insertarTabla(ProE);
                        proECont.insertar(ProE);
                        try{
                            //Se crea una instruccion del sql y se manda hacia la base de datos
                            String query = "UPDATE productoelectrico SET "
                                    //Atributos de producto 
                                    + "`nombre` = '" + ProE.getNombre() + "', "
                                    + "`color` = '" + ProE.getColor() + "', "
                                    + "`marca` = '" + ProE.getMarca() + "', "
                                    + "`material` = '" + ProE.getMaterial() + "', "
                                    + "`bodegaid` = '" + ProE.getbodegaId() + "', "
                                    + "`demanda` = '" + ProE.getdemanda() + "', "
                                    + "`costoproduccion` = '" + ProE.getCostoproduccion() + "', "
                                    + "`costodeventa` = '" + ProE.getCostodeventa() + "', "
                                    + "`costoalmacenamiento` = '" + ProE.getCostoalmacenamiento() + "', "
                                    + "`capacidaddecarga` = '" + ProE.getCapacidadCarga()+ "', "
                                    + "`calibre` = '" + ProE.getCalibre()+ "' "
                                    + "WHERE (`serial` = '" + ProE.getSerial() + "');";
                            //System.out.println("query: " + query);
                            Statement stm = con.createStatement();
                            stm.executeUpdate(query);
                            
                            OrdenarIDActionPerformed(evt);
                            JOptionPane.showMessageDialog(rootPane, "Dato Modificado");
                                    
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Dato NO modificado en la base de datos");
                            ex.printStackTrace();
                        }
                        LimpiarCajasDeTexto();
                        //Se activa el campo de cedula unicamente para la consulta 
                        NS.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Dato NO modificado");
                    }
                    break;
                }
            }
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    //Metodo para insertar un objeto a la base de datos 
    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        // TODO add your handling code here:
        //Se separa memoria con el constructor vacio 
        ProE = new ProductosElectricos();
        
        //Atributos de producto
        //Se hace una conversion de variable de los textfield 
        
        ProE.setSerial(Integer.parseInt(NS.getText()));
        ProE.setNombre(Nom.getText());
        ProE.setColor((String) Col.getSelectedItem());
        ProE.setMarca(Marc.getText());
        ProE.setMaterial((String)Materi.getSelectedItem());
        ProE.setBodegaId((int) Idbodega.getSelectedIndex());
        ProE.setdemanda(Integer.parseInt(Demand.getText()));
        ProE.setCostoproduccion(Float.parseFloat(CP.getText()));
        ProE.setCostodeventa(Float.parseFloat(CV.getText()));
        ProE.setCostoalmacenamiento(Float.parseFloat(CA.getText()));
        ProE.setCapacidadCarga(Float.parseFloat(CC.getText()));
        ProE.setCalibre(Float.parseFloat(Calibre.getText()));
        ProE.setImagen(" ");
        
        if(proECont.insertar(ProE)){
            insertarTabla(ProE);
            proECont.insertar(ProE);
            try {
                //Se hace una instruccion del sql y se manda hacia la base de datos 
                String query = "INSERT INTO productoelectrico VALUES('"
                //Atributos de producto 
                +ProE.getSerial() + "','"
                +ProE.getNombre()+ "','"
                +ProE.getColor()+ "','"
                +ProE.getMarca()+ "','"
                +ProE.getMaterial()+ "','"
                +ProE.getbodegaId()+ "','"
                +ProE.getdemanda()+ "','"
                +ProE.getCostoproduccion()+ "','"
                +ProE.getCostodeventa()+ "','"
                +ProE.getCostoalmacenamiento()+ "','"
         
                //Atributo propio
                +ProE.getCapacidadCarga()+ "','"
                +ProE.getCalibre()+ "','"
                +ProE.getImagen()+ "');";

                Statement stm = con.createStatement();
                stm.executeUpdate(query);

                JOptionPane.showMessageDialog(rootPane, "Dato Insertado");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Dato NO Insertado en la Base de Datos");
                ex.printStackTrace();
            }

            LimpiarCajasDeTexto();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Dato NO insertado");
        }
        
    }//GEN-LAST:event_InsertarActionPerformed

    private void CalibreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalibreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CalibreActionPerformed

    private void NSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NSActionPerformed

    //Metodo para ordenar el costo de venta mediante mergesort
    private void OrdenarPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarPVActionPerformed
        // TODO add your handling code here:
        proECont.arregloProductosElectricos = proECont.mergeSort(proECont.arregloProductosElectricos);
        Modelo.setRowCount(0);
        for(ProductosElectricos ProE1: proECont.arregloProductosElectricos){
            insertarTabla(ProE1);
        }
    }//GEN-LAST:event_OrdenarPVActionPerformed

    //Metodo para ordenar el nombre mediante quicksort 
    private void OrdenarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarNombreActionPerformed
        // TODO add your handling code here:
        proECont.ordenar(0, proECont.arregloProductosElectricos.size() - 1);
        Modelo.setRowCount(0);
        for(ProductosElectricos ProE1: proECont.arregloProductosElectricos){
            insertarTabla(ProE1);
        }
    }//GEN-LAST:event_OrdenarNombreActionPerformed

    //Metodo para ordenar la marca mediante burbuja 
    private void OrdenarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarMarcaActionPerformed
        // TODO add your handling code here:
        proECont.burbuja();
        Modelo.setRowCount(0);
        for(ProductosElectricos ProE1: proECont.arregloProductosElectricos){
            insertarTabla(ProE1);
        }
    }//GEN-LAST:event_OrdenarMarcaActionPerformed

    //Metodo para llenar los textfield desde la taba de la interfaz 
    private void jTMPEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMPEMouseClicked
        // TODO add your handling code here:
        proECont.consultarGeneral();
        int pos = jTMPE.getSelectedRow();
        
        ProE = proECont.arregloProductosElectricos.get(pos);
        try{
            //Atributos de producto
            NS.setText("" + ProE.getSerial());
            Nom.setText(ProE.getNombre());
            Col.setSelectedItem(ProE.getColor());
            Marc.setText(ProE.getMarca());
            Materi.setSelectedItem("" + ProE.getMaterial());
            Idbodega.setSelectedItem("" + ProE.getbodegaId());
            Demand.setText("" + ProE.getdemanda());
            CP.setText("" + ProE.getCostoproduccion());
            CV.setText("" + ProE.getCostodeventa());
            CA.setText("" + ProE.getCostoalmacenamiento());
            CC.setText("" + ProE.getCapacidadCarga());
            Calibre.setText("" + ProE.getCalibre());
            imagen();
            NS.setEnabled(false);
            
        } catch(IndexOutOfBoundsException ex){
            System.out.println("\nFormato excedido");
        }
    }//GEN-LAST:event_jTMPEMouseClicked

    private void ColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColActionPerformed

    private void NSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NSFocusLost
        // TODO add your handling code here:
       try{
            ProE.setSerial(Integer.parseInt(NS.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "El numero serial debe ser numerico");
            NS.setText("");
            NS.requestFocus();
        }
        
    }//GEN-LAST:event_NSFocusLost

    private void NomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NomFocusLost
        // TODO add your handling code here:
        Excepciones excepcion = new Excepciones();
        try{
            excepcion.ValidarNombreProducto(Nom.getText());
        } catch (Excepciones ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Nom.setText("");
            Nom.requestFocus();
        }
    }//GEN-LAST:event_NomFocusLost

    private void MarcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MarcFocusLost
        // TODO add your handling code here:
        Excepciones excepcion = new Excepciones();
        try{
            excepcion.ValidarTexto(Marc.getText());
        } catch(Excepciones ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Marc.setText("");
            Marc.requestFocus();
        }
    }//GEN-LAST:event_MarcFocusLost

    private void DemandFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DemandFocusLost
        // TODO add your handling code here:
        try{
            ProE.setdemanda(Integer.parseInt(Demand.getText()));
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "La demanda debe de ser numerica");
            Demand.setText("");
            Demand.requestFocus();
        }
    }//GEN-LAST:event_DemandFocusLost

    private void CPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CPFocusLost
        // TODO add your handling code here:
        try{
            ProE.setCostoproduccion(Float.parseFloat(CP.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "El costo de produccion debe de ser un numero");
            CP.setText("");
            CP.requestFocus();
        }
    }//GEN-LAST:event_CPFocusLost

    private void CVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CVFocusLost
        // TODO add your handling code here:
        try{
            ProE.setCostodeventa(Float.parseFloat(CV.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "El costo de venta debe de ser un numero");
            CV.setText("");
            CV.requestFocus();
        }
    }//GEN-LAST:event_CVFocusLost

    private void CAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CAFocusLost
        // TODO add your handling code here:
        try{
            ProE.setCostoalmacenamiento(Float.parseFloat(CA.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "El costo de almacenamiento debe de ser un numero");
            CA.setText("");
            CA.requestFocus();
        }

    }//GEN-LAST:event_CAFocusLost

    private void CCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CCFocusLost
        // TODO add your handling code here:
        try{
            ProE.setCapacidadCarga(Float.parseFloat(CC.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "La capacidad de carga debe ser numerica");
            CC.setText("");
            CC.requestFocus();
        }
    }//GEN-LAST:event_CCFocusLost

    private void CalibreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CalibreFocusLost
        // TODO add your handling code here:
        try{
            ProE.setCalibre(Float.parseFloat(Calibre.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "El calibre debe de ser numerico");
            Calibre.setText("");
            Calibre.requestFocus();
        }
    }//GEN-LAST:event_CalibreFocusLost

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
//            java.util.logging.Logger.getLogger(GUIProductosElectricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIProductosElectricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIProductosElectricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIProductosElectricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIProductosElectricos().setVisible(true);
//            }
//        });
//    }

    //Getters y setters 
    
    public ControladorProductosElectricos getProECont() {
        return proECont;
    }

    public void setProECont(ControladorProductosElectricos proECont) {
        this.proECont = proECont;
    }

    public ProductosElectricos getProE() {
        return ProE;
    }

    public void setProE(ProductosElectricos ProE) {
        this.ProE = ProE;
    }

    public ConexionBD getConBD() {
        return conBD;
    }

    public void setConBD(ConexionBD conBD) {
        this.conBD = conBD;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Object[] getArregloDatos() {
        return arregloDatos;
    }

    public void setArregloDatos(Object[] arregloDatos) {
        this.arregloDatos = arregloDatos;
    }

    public DefaultTableModel getModelo() {
        return Modelo;
    }

    public void setModelo(DefaultTableModel Modelo) {
        this.Modelo = Modelo;
    }

    public JButton getActualizar() {
        return Actualizar;
    }

    public void setActualizar(JButton Actualizar) {
        this.Actualizar = Actualizar;
    }

    public JButton getBorrar() {
        return Borrar;
    }

    public void setBorrar(JButton Borrar) {
        this.Borrar = Borrar;
    }

    public JTextField getCA() {
        return CA;
    }

    public void setCA(JTextField CA) {
        this.CA = CA;
    }

    public JTextField getCC() {
        return CC;
    }

    public void setCC(JTextField CC) {
        this.CC = CC;
    }

    public JTextField getCP() {
        return CP;
    }

    public void setCP(JTextField CP) {
        this.CP = CP;
    }

    public JTextField getCV() {
        return CV;
    }

    public void setCV(JTextField CV) {
        this.CV = CV;
    }

    public JTextField getCalibre() {
        return Calibre;
    }

    public void setCalibre(JTextField Calibre) {
        this.Calibre = Calibre;
    }

    public JLabel getCda() {
        return Cda;
    }

    public void setCda(JLabel Cda) {
        this.Cda = Cda;
    }

    public JLabel getCdp() {
        return Cdp;
    }

    public void setCdp(JLabel Cdp) {
        this.Cdp = Cdp;
    }

    public JLabel getCdv() {
        return Cdv;
    }

    public void setCdv(JLabel Cdv) {
        this.Cdv = Cdv;
    }

    public JComboBox<String> getCol() {
        return Col;
    }

    public void setCol(JComboBox<String> Col) {
        this.Col = Col;
    }

    public JLabel getColor() {
        return Color;
    }

    public void setColor(JLabel Color) {
        this.Color = Color;
    }

    public JButton getConsultar() {
        return Consultar;
    }

    public void setConsultar(JButton Consultar) {
        this.Consultar = Consultar;
    }

    public JTextField getDemand() {
        return Demand;
    }

    public void setDemand(JTextField Demand) {
        this.Demand = Demand;
    }

    public JLabel getDemanda() {
        return Demanda;
    }

    public void setDemanda(JLabel Demanda) {
        this.Demanda = Demanda;
    }

    public JLabel getIDBodega() {
        return IDBodega;
    }

    public void setIDBodega(JLabel IDBodega) {
        this.IDBodega = IDBodega;
    }

    public JComboBox<String> getIdbodega() {
        return Idbodega;
    }

    public void setIdbodega(JComboBox<String> Idbodega) {
        this.Idbodega = Idbodega;
    }

    public JButton getInsertar() {
        return Insertar;
    }

    public void setInsertar(JButton Insertar) {
        this.Insertar = Insertar;
    }

    public JLabel getJLabel7() {
        return JLabel7;
    }

    public void setJLabel7(JLabel JLabel7) {
        this.JLabel7 = JLabel7;
    }

    public JTextField getMarc() {
        return Marc;
    }

    public void setMarc(JTextField Marc) {
        this.Marc = Marc;
    }

    public JLabel getMarca() {
        return Marca;
    }

    public void setMarca(JLabel Marca) {
        this.Marca = Marca;
    }

    public JComboBox<String> getMateri() {
        return Materi;
    }

    public void setMateri(JComboBox<String> Materi) {
        this.Materi = Materi;
    }

    public JLabel getMaterial() {
        return Material;
    }

    public void setMaterial(JLabel Material) {
        this.Material = Material;
    }

    public JTextField getNS() {
        return NS;
    }

    public void setNS(JTextField NS) {
        this.NS = NS;
    }

    public JTextField getNom() {
        return Nom;
    }

    public void setNom(JTextField Nom) {
        this.Nom = Nom;
    }

    public JLabel getNombre() {
        return Nombre;
    }

    public void setNombre(JLabel Nombre) {
        this.Nombre = Nombre;
    }

    public JLabel getNumeroSerial() {
        return NumeroSerial;
    }

    public void setNumeroSerial(JLabel NumeroSerial) {
        this.NumeroSerial = NumeroSerial;
    }

    public JButton getOrdenarID() {
        return OrdenarID;
    }

    public void setOrdenarID(JButton OrdenarID) {
        this.OrdenarID = OrdenarID;
    }

    public JButton getOrdenarMarca() {
        return OrdenarMarca;
    }

    public void setOrdenarMarca(JButton OrdenarMarca) {
        this.OrdenarMarca = OrdenarMarca;
    }

    public JButton getOrdenarNombre() {
        return OrdenarNombre;
    }

    public void setOrdenarNombre(JButton OrdenarNombre) {
        this.OrdenarNombre = OrdenarNombre;
    }

    public JButton getOrdenarPV() {
        return OrdenarPV;
    }

    public void setOrdenarPV(JButton OrdenarPV) {
        this.OrdenarPV = OrdenarPV;
    }

    public JLabel getTipoE() {
        return TipoE;
    }

    public void setTipoE(JLabel TipoE) {
        this.TipoE = TipoE;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JLabel getjRuta() {
        return jRuta;
    }

    public void setjRuta(JLabel jRuta) {
        this.jRuta = jRuta;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTMPE() {
        return jTMPE;
    }

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
//            java.util.logging.Logger.getLogger(GUIProductosElectricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIProductosElectricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIProductosElectricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIProductosElectricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIProductosElectricos().setVisible(true);
//            }
//        });
//    }
    public void setjTMPE(JTable jTMPE) {
        this.jTMPE = jTMPE;
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Borrar;
    private javax.swing.JTextField CA;
    private javax.swing.JTextField CC;
    private javax.swing.JTextField CP;
    private javax.swing.JTextField CV;
    private javax.swing.JTextField Calibre;
    private javax.swing.JLabel Cda;
    private javax.swing.JLabel Cdp;
    private javax.swing.JLabel Cdv;
    private javax.swing.JComboBox<String> Col;
    private javax.swing.JLabel Color;
    private javax.swing.JButton Consultar;
    private javax.swing.JTextField Demand;
    private javax.swing.JLabel Demanda;
    private javax.swing.JLabel IDBodega;
    private javax.swing.JComboBox<String> Idbodega;
    private javax.swing.JButton Insertar;
    private javax.swing.JLabel JLabel7;
    private javax.swing.JTextField Marc;
    private javax.swing.JLabel Marca;
    private javax.swing.JComboBox<String> Materi;
    private javax.swing.JLabel Material;
    private javax.swing.JTextField NS;
    private javax.swing.JTextField Nom;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel NumeroSerial;
    private javax.swing.JButton OrdenarID;
    private javax.swing.JButton OrdenarMarca;
    private javax.swing.JButton OrdenarNombre;
    private javax.swing.JButton OrdenarPV;
    private javax.swing.JLabel TipoE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jRuta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMPE;
    // End of variables declaration//GEN-END:variables

}
