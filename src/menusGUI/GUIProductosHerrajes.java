/**
 * @title: GUIProductosHerrajes.java
 * @description: GUI de productos herrajes para el proyecto CadenaSuministros.
 * @date: Domingo 12 de noviembre de 2023
 * @version: 0.1
 * @author: Juan David Fajardo Betancourt y Leonardo Moreno Vargas
 */

package menusGUI;

//Imports de apis de java y sql 
import Controlador.ConexionBD;
import Controlador.ControladorProductosHerrajes;
import Modelo.ProductosHerrajes;
import Excepciones.Excepciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

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

//Clase de la interfaz 
public class GUIProductosHerrajes extends javax.swing.JFrame {

    /**
     * Creates new form GUIProductosHerrajes
     */
    
    //Inicializacion de las variables globales 
    private ControladorProductosHerrajes proHCont;
    ProductosHerrajes ProHe;
    ConexionBD conBD;
    Connection con;
    Object[] arregloDatos;
    private DefaultTableModel Modelo;
    
    //Constructor 
    public GUIProductosHerrajes(){
        initComponents();
        proHCont = new ControladorProductosHerrajes();
        ProHe = new ProductosHerrajes();
        conBD = new ConexionBD();
        con = conBD.mysqlConexion();
        arregloDatos = new Object[11];
        Modelo = (DefaultTableModel)jTMPH.getModel();
        consultarDB();
        
    }
    
    //Metodo para limpiar los textfields 
    private void LimpiarCajasDeTexto(){
        //Atributos de Producto 
        NS.setText("");
        Nom.setText("");
        Col.setSelectedIndex(0);
        Marc.setText("");
        Materi.setSelectedIndex(0);
        Demand.setText("");
        CP.setText("");
        CA.setText("");
        CV.setText("");
        Idbodega.setSelectedIndex(0);
        //Atributo propio
        TE.setText("");
    }
    
    //Metodo para insertar los datos ala tabla de la interfaz 
    private void insertarTabla(ProductosHerrajes ProHe){
        //Atributos de producto
        arregloDatos[0] = ProHe.getSerial();
        arregloDatos[1] = ProHe.getNombre();
        arregloDatos[2] = ProHe.getColor();
        arregloDatos[3] = ProHe.getMarca();
        arregloDatos[4] = ProHe.getMaterial();
        arregloDatos[5] = ProHe.getdemanda();
        arregloDatos[6] = ProHe.getCostoproduccion();
        arregloDatos[7] = ProHe.getCostoalmacenamiento();
        arregloDatos[8] = ProHe.getCostodeventa();
        arregloDatos[9] = ProHe.getbodegaId();
        //Atributo propio 
        arregloDatos[10] = ProHe.getTipoElemento();
        
        Modelo.addRow(arregloDatos);
    }
    
    public void imagen(){
        try{
            System.out.println("\nimg: " + ProHe.getImagen());
            BufferedImage buf = ImageIO.read(new File(ProHe.getImagen()));
            ImageIcon icon = new ImageIcon(buf);
            jRuta.setIcon(icon);
        } catch (IOException ex){
            System.out.println("\nLa imagen no se insertó");
        }
    }
    
    //Trae los datos de la base de datos y los inserta en la tabla 
    private void consultarDB(){
    
        try{
            Statement stmt = con.createStatement();
            ResultSet rsProHe = stmt.executeQuery("SELECT * FROM ferreteria.productoherraje");
            
            while(rsProHe.next()){
                ProHe = new ProductosHerrajes();
                
                arregloDatos[0] = rsProHe.getInt(1); //Serial
                ProHe.setSerial(rsProHe.getInt(1));
                
                arregloDatos[1] = rsProHe.getString(2); //Nombre
                ProHe.setNombre(rsProHe.getString(2));
                
                arregloDatos[2] = rsProHe.getString(3); //Color
                ProHe.setColor(rsProHe.getString(3));
                
                arregloDatos[3] = rsProHe.getString(4); //Marca
                ProHe.setMarca(rsProHe.getString(4));
                
                arregloDatos[4] = rsProHe.getString(5); //Material
                ProHe.setMaterial(rsProHe.getString(5));
                
                arregloDatos[5] = rsProHe.getInt(6); //Demanda
                ProHe.setdemanda(rsProHe.getInt(6));
                
                arregloDatos[6] = rsProHe.getFloat(7); //Costo produccion
                ProHe.setCostoproduccion(rsProHe.getFloat(7));
                
                arregloDatos[7] = rsProHe.getFloat(8); //Costo almacenamiento
                ProHe.setCostoalmacenamiento(rsProHe.getFloat(8));
                
                arregloDatos[8] = rsProHe.getFloat(9); //Costo venta
                ProHe.setCostodeventa(rsProHe.getFloat(9));
                
                arregloDatos[9] = rsProHe.getInt(10); //ID bodega
                ProHe.setBodegaId(rsProHe.getInt(10));
                
                arregloDatos[10] = rsProHe.getString(11); //Tipo elemento 
                ProHe.setTipoElemento(rsProHe.getString(11));
                
                ProHe.setImagen(ProHe.getImagen() + rsProHe.getString(12)); //Imagen
                
                if(proHCont.insertar(ProHe)){
                    Modelo.addRow(arregloDatos);
                    System.out.println("Insertado correctamente");
                }else{
                    insertarTabla(ProHe);
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
        NumeroSerial = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Color = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
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
        TE = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMPH = new javax.swing.JTable();
        IDBodega = new javax.swing.JLabel();
        Borrar = new javax.swing.JButton();
        OrdenarID = new javax.swing.JButton();
        OrdenarMarca = new javax.swing.JButton();
        OrdenarPV = new javax.swing.JButton();
        OrdenarNombre = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Insertar = new javax.swing.JButton();
        jRuta = new javax.swing.JLabel();
        Col = new javax.swing.JComboBox<>();
        Idbodega = new javax.swing.JComboBox<>();
        Materi = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(102, 102, 102));

        Fondo.setBackground(new java.awt.Color(102, 102, 102));
        Fondo.setAutoscrolls(true);
        Fondo.setFocusCycleRoot(true);
        Fondo.setFocusTraversalPolicyProvider(true);

        FranjaD.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu de Productos de Herraje");

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

        NumeroSerial.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        NumeroSerial.setForeground(new java.awt.Color(255, 255, 255));
        NumeroSerial.setText("Numero Serial");

        Nombre.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Nombre");

        Color.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        Color.setForeground(new java.awt.Color(255, 255, 255));
        Color.setText("Color ");

        Imagen.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        Imagen.setForeground(new java.awt.Color(255, 255, 255));
        Imagen.setText("Imagen ");

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
        TipoE.setText("Tipo de elemento ");

        NS.setBackground(new java.awt.Color(255, 153, 153));
        NS.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        NS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NS.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        NS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NSFocusLost(evt);
            }
        });

        Nom.setBackground(new java.awt.Color(255, 153, 153));
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

        Marc.setBackground(new java.awt.Color(255, 153, 153));
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

        CV.setBackground(new java.awt.Color(255, 153, 153));
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

        CA.setBackground(new java.awt.Color(255, 153, 153));
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

        CP.setBackground(new java.awt.Color(255, 153, 153));
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

        Demand.setBackground(new java.awt.Color(255, 153, 153));
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

        TE.setBackground(new java.awt.Color(255, 153, 153));
        TE.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        TE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TEFocusLost(evt);
            }
        });
        TE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEActionPerformed(evt);
            }
        });

        jTMPH.setBackground(new java.awt.Color(255, 153, 153));
        jTMPH.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTMPH.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jTMPH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Serial", "Nombre", "Color ", "Marca ", "Material", "Demanda", "Costo P", "Costo A", "Costo V ", "ID Bodega ", "Tipo E "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMPH.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTMPH.setDoubleBuffered(true);
        jTMPH.setDragEnabled(true);
        jTMPH.setFillsViewportHeight(true);
        jTMPH.setFocusCycleRoot(true);
        jTMPH.setFocusTraversalPolicyProvider(true);
        jTMPH.setGridColor(new java.awt.Color(0, 0, 0));
        jTMPH.setInheritsPopupMenu(true);
        jTMPH.setRowHeight(30);
        jTMPH.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTMPH.setShowHorizontalLines(true);
        jTMPH.setShowVerticalLines(true);
        jTMPH.setSurrendersFocusOnKeystroke(true);
        jTMPH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMPHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTMPH);

        IDBodega.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        IDBodega.setForeground(new java.awt.Color(255, 255, 255));
        IDBodega.setText("ID Bodega");

        Borrar.setBackground(new java.awt.Color(255, 102, 102));
        Borrar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Borrar.setText("Borrar");
        Borrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        OrdenarID.setBackground(new java.awt.Color(255, 102, 102));
        OrdenarID.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarID.setText("Ordenar por ID");
        OrdenarID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarIDActionPerformed(evt);
            }
        });

        OrdenarMarca.setBackground(new java.awt.Color(255, 102, 102));
        OrdenarMarca.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarMarca.setText("Ordenar por Marca ");
        OrdenarMarca.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarMarcaActionPerformed(evt);
            }
        });

        OrdenarPV.setBackground(new java.awt.Color(255, 102, 102));
        OrdenarPV.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarPV.setText("Ordenar por Precio");
        OrdenarPV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarPVActionPerformed(evt);
            }
        });

        OrdenarNombre.setBackground(new java.awt.Color(255, 102, 102));
        OrdenarNombre.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarNombre.setText("Ordenar por Nombre");
        OrdenarNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarNombreActionPerformed(evt);
            }
        });

        Consultar.setBackground(new java.awt.Color(255, 102, 102));
        Consultar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Consultar.setText("Consultar ");
        Consultar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        Actualizar.setBackground(new java.awt.Color(255, 102, 102));
        Actualizar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Actualizar.setText("Actualizar ");
        Actualizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Insertar.setBackground(new java.awt.Color(255, 102, 102));
        Insertar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        Insertar.setText("Insertar ");
        Insertar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });

        Col.setBackground(new java.awt.Color(255, 153, 153));
        Col.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Col.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Plateado", "Negro", "Dorado", "Latón", "Cobrizo" }));
        Col.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Col.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColActionPerformed(evt);
            }
        });

        Idbodega.setBackground(new java.awt.Color(255, 153, 153));
        Idbodega.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Idbodega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2", "3", "4", "5" }));
        Idbodega.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Idbodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdbodegaActionPerformed(evt);
            }
        });

        Materi.setBackground(new java.awt.Color(255, 153, 153));
        Materi.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        Materi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Hierro", "Metal", "Acero ", "Cobre", "Titanio " }));
        Materi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Materi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MateriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FranjaD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NumeroSerial)
                                    .addComponent(Nombre)
                                    .addComponent(Color)
                                    .addComponent(Material)
                                    .addComponent(IDBodega)
                                    .addComponent(Insertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Borrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FondoLayout.createSequentialGroup()
                                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Cdp)
                                            .addComponent(Demanda))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Demand, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                            .addComponent(CP)))
                                    .addGroup(FondoLayout.createSequentialGroup()
                                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Col, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Consultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Marc, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                            .addComponent(Actualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Idbodega, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Materi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(FondoLayout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Cdv)
                                                    .addComponent(Cda)
                                                    .addComponent(TipoE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(CA, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                                    .addComponent(CV)
                                                    .addComponent(TE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(123, 123, 123))))))
                            .addComponent(Marca)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Imagen)
                        .addGap(192, 192, 192)))
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(0, 222, Short.MAX_VALUE)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(OrdenarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(OrdenarMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrdenarID, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenarPV))
                        .addGap(186, 186, 186))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(FranjaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OrdenarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenarID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OrdenarPV, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrdenarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumeroSerial)
                            .addComponent(Demanda)
                            .addComponent(NS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Demand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nombre)
                            .addComponent(Cdp)
                            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CP, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Color)
                            .addComponent(Cdv)
                            .addComponent(CV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Col, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Marca)
                            .addComponent(Cda)
                            .addComponent(Marc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Material)
                            .addComponent(TipoE)
                            .addComponent(TE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Materi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Imagen)
                        .addGap(12, 12, 12)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IDBodega)
                                    .addComponent(Idbodega, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Insertar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void TEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEActionPerformed

    private void NomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomActionPerformed

    private void MarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcActionPerformed

    //Metodo para borrar un objeto de la base de datos 
    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        // TODO add your handling code here:
        //Si el campo esta vacio, no lo dejara pasar 
        if(NS.getText().equals("")){
            JOptionPane .showMessageDialog(rootPane, "El campo id esta vacio");
        }else{
            //Variable temporal  
            int serial = Integer.parseInt(NS.getText());
            
            //El for recorre fila por fila hasta encontrar el objeto mediante el id
            for(int i = 0 ; i < Modelo.getRowCount(); i++){
                if(serial == (int) Modelo.getValueAt(i, 0)){
                    ProHe = new ProductosHerrajes();
                    ProHe.setSerial(Integer.parseInt(NS.getText()));
                    
                    if(proHCont.borrar(ProHe)){
                        Modelo.removeRow(i);
                        proHCont.borrar(ProHe);
                        try{
                            //Se hace una instruccion del sql y se envia a la base de datos 
                            String query = "DELETE FROM productoherraje WHERE serial = " + serial + ";" ;
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

    //Metodo para insertar un objeto a la base de datos 
    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        // TODO add your handling code here:
        //Se separa memoria 
        ProHe = new ProductosHerrajes();
        
        //Atributos de producto
        //Se convierte los textfield a solo texto 
        ProHe.setSerial(Integer.parseInt(NS.getText()));
        ProHe.setNombre(Nom.getText());
        ProHe.setColor((String) Col.getSelectedItem());
        ProHe.setMarca(Marc.getText());
        ProHe.setMaterial((String) Materi.getSelectedItem());
        ProHe.setBodegaId((int) Idbodega.getSelectedIndex());
        ProHe.setdemanda(Integer.parseInt(Demand.getText()));
        ProHe.setCostoproduccion(Float.parseFloat(CP.getText()));
        ProHe.setCostodeventa(Float.parseFloat(CV.getText()));
        ProHe.setCostoalmacenamiento(Float.parseFloat(CA.getText()));
        ProHe.setTipoElemento(TE.getText());
        ProHe.setImagen(" ");
        
        if(proHCont.insertar(ProHe)){
            insertarTabla(ProHe);
            proHCont.insertar(ProHe);
            try {
                //Se hace una instruccion del sql y se envia a la base de datos 
                String query = "INSERT INTO productoherraje VALUES('"
                //Atributos de producto 
                +ProHe.getSerial() + "','"
                +ProHe.getNombre()+ "','"
                +ProHe.getColor()+ "','"
                +ProHe.getMarca()+ "','"
                +ProHe.getMaterial()+ "','"
                +ProHe.getdemanda()+ "','"
                +ProHe.getCostoproduccion()+ "','"
                +ProHe.getCostoalmacenamiento()+ "','"
                +ProHe.getCostodeventa()+ "','"
                +ProHe.getbodegaId()+ "','"
                //Atributo propio 
                +ProHe.getTipoElemento()+ "','"
                +ProHe.getImagen()+ "');";

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

    //Metodo para consultar un objeto desde el arreglo 
    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        // TODO add your handling code here:
        try{
            //Si el campo esta vacio, no lo dejara pasar
            if(NS.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "El campo id está vacio");
            }else{
                //Se hace una variable temporal 
                int serial = Integer.parseInt(NS.getText());
                
                //El for recorre fila por fila hasta encontrar el objeto consultado 
                for(int i = 0; i < Modelo.getRowCount(); i++){
                    if(serial == (int) Modelo.getValueAt(i, 0)){
                        ProHe = proHCont.arregloProductosHerrajes.get(i);
                        //Atributos de producto
                        NS.setText("" + ProHe.getSerial());
                        Nom.setText(ProHe.getNombre());
                        Col.setSelectedItem(ProHe.getColor());
                        Marc.setText(ProHe.getMarca());
                        Materi.setSelectedItem(ProHe.getMaterial());
                        Demand.setText("" + ProHe.getdemanda());
                        CP.setText("" + ProHe.getCostoproduccion());
                        CA.setText("" + ProHe.getCostoalmacenamiento());
                        CV.setText("" + ProHe.getCostodeventa());
                        Idbodega.setSelectedItem("" + ProHe.getbodegaId());
                        TE.setText(ProHe.getTipoElemento());
                        imagen();
                        //Se desactiva el campo serial para que no pued ser modificado 
                        NS.setEnabled(false);
                    }
                }
            }
        } catch(IndexOutOfBoundsException ex){
            System.out.println("\nFormato excedido");
        }
    }//GEN-LAST:event_ConsultarActionPerformed

    //Metodo para ordenar por numero serial mediante sort 
    private void OrdenarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarIDActionPerformed
        // TODO add your handling code here:
        proHCont.ordenar();
        Modelo.setRowCount(0);
        for(ProductosHerrajes ProHe1: proHCont.arregloProductosHerrajes){
            insertarTabla(ProHe1);
        }
    }//GEN-LAST:event_OrdenarIDActionPerformed

    //Metodo para actualizar un objeto de la base de datos 
    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
        //Si el campo esta vacio, no lo dejara pasar 
        if(NS.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "El campo id está vacio");
        }else{
            //Se hace una variable temporal 
            int serial = Integer.parseInt(NS.getText());
            
            //El for recorre fila por fila hasta encontrar el objeto a actualizar      
            for(int i = 0; i < Modelo.getRowCount(); i++){
                if(serial == (int) Modelo.getValueAt(i, 0)){
                    ProHe = new ProductosHerrajes();
                    ProHe.setSerial(Integer.parseInt(NS.getText()));
                    proHCont.borrar(ProHe);
                    Modelo.removeRow(i);
                    
                    //Atributos de producto
                    ProHe.setSerial(Integer.parseInt(NS.getText()));
                    ProHe.setNombre(Nom.getText());
                    ProHe.setColor((String )Col.getSelectedItem());
                    ProHe.setMarca(Marc.getText());
                    ProHe.setMaterial((String) Materi.getSelectedItem());
                    ProHe.setBodegaId((int) Idbodega.getSelectedIndex());
                    ProHe.setdemanda(Integer.parseInt(Demand.getText()));
                    ProHe.setCostoproduccion(Float.parseFloat(CP.getText()));
                    ProHe.setCostodeventa(Float.parseFloat(CV.getText()));
                    ProHe.setCostoalmacenamiento(Float.parseFloat(CA.getText()));
                    ProHe.setTipoElemento(TE.getText());
                    //ProHe.setImagen(" ");
                    
                    if(proHCont.insertar(ProHe)){
                        insertarTabla(ProHe);
                        proHCont.insertar(ProHe);
                        try{
                            //Se hace una instruccion del sql y se envia hacia la base de datos 
                            String query = "UPDATE productoherraje SET "
                                    //Atributos de producto 
                                    + "`nombre` = '" + ProHe.getNombre() + "', "
                                    + "`color` = '" + ProHe.getColor() + "', "
                                    + "`marca` = '" + ProHe.getMarca() + "', "
                                    + "`material` = '" + ProHe.getMaterial() + "', "
                                    + "`bodegaid` = '" + ProHe.getbodegaId() + "', "
                                    + "`demanda` = '" + ProHe.getdemanda() + "', "
                                    + "`costoproduccion` = '" + ProHe.getCostoproduccion() + "', "
                                    + "`costodeventa` = '" + ProHe.getCostodeventa() + "', "
                                    + "`costoalmacenamiento` = '" + ProHe.getCostoalmacenamiento() + "', "
                                    + "`tipoelemento` = '" + ProHe.getTipoElemento() + "' "
                                    + "WHERE (`serial` = '" + ProHe.getSerial() + "');";
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
                        //Se activa nuevamente el campo serial en caso de que se desee consultar otro producto 
                        NS.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Dato NO modificado");
                    }
                    break;
                }
            }
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    //Metodo para ordenar por nombre mediante quicksort 
    private void OrdenarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarNombreActionPerformed
        // TODO add your handling code here:
        proHCont.ordenar(0, proHCont.arregloProductosHerrajes.size() - 1);
        Modelo.setRowCount(0);
        for(ProductosHerrajes ProHe1: proHCont.arregloProductosHerrajes){
            insertarTabla(ProHe1);
        }
    }//GEN-LAST:event_OrdenarNombreActionPerformed

    //Metodo para ordenar por marca mediante burbuja 
    private void OrdenarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarMarcaActionPerformed
        // TODO add your handling code here:
        proHCont.burbuja();
        Modelo.setRowCount(0);
        for(ProductosHerrajes ProHe1: proHCont.arregloProductosHerrajes){
            insertarTabla(ProHe1);
        }
    }//GEN-LAST:event_OrdenarMarcaActionPerformed

    //Metodo para ordenar por costo de venta mediante mergesort 
    private void OrdenarPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarPVActionPerformed
        // TODO add your handling code here:
        proHCont.arregloProductosHerrajes = proHCont.mergeSort(proHCont.arregloProductosHerrajes);
        Modelo.setRowCount(0);
        for(ProductosHerrajes ProHe1: proHCont.arregloProductosHerrajes){
            insertarTabla(ProHe1);
        }
    }//GEN-LAST:event_OrdenarPVActionPerformed

    //Metodo para llenar los textfields de la tabla
    private void jTMPHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMPHMouseClicked
        // TODO add your handling code here:
        proHCont.consultarGeneral();
        int pos = jTMPH.getSelectedRow();
        //System.out.println("pos: " + pos);
        ProHe = proHCont.arregloProductosHerrajes.get(pos);
        try{
            //Atributos de producto
            NS.setText("" + ProHe.getSerial());
            Nom.setText(ProHe.getNombre());
            Col.setSelectedItem(ProHe.getColor());
            Marc.setText(ProHe.getMarca());
            Materi.setSelectedItem(ProHe.getMaterial());
            Demand.setText("" + ProHe.getdemanda());
            CP.setText("" + ProHe.getCostoproduccion());
            CA.setText("" + ProHe.getCostoalmacenamiento());
            CV.setText("" + ProHe.getCostodeventa());
            Idbodega.setSelectedItem("" + ProHe.getbodegaId());
            TE.setText(ProHe.getTipoElemento());
            imagen();
            NS.setEnabled(false);
        } catch (IndexOutOfBoundsException ex){
            System.out.println("\nFormato excedido");
        }
    }//GEN-LAST:event_jTMPHMouseClicked

    private void ColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColActionPerformed

    private void IdbodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdbodegaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdbodegaActionPerformed

    private void MateriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MateriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MateriActionPerformed

    private void NSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NSFocusLost
        // TODO add your handling code here:
        try{
            ProHe.setSerial(Integer.parseInt(NS.getText()));
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
            ProHe.setdemanda(Integer.parseInt(Demand.getText()));
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "La demanda debe de ser numerica");
            Demand.setText("");
            Demand.requestFocus();
        }
    }//GEN-LAST:event_DemandFocusLost

    private void CPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CPFocusLost
        // TODO add your handling code here:
        try{
            ProHe.setCostoproduccion(Float.parseFloat(CP.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "El costo de produccion debe de ser un numero");
            CP.setText("");
            CP.requestFocus();
        }
    }//GEN-LAST:event_CPFocusLost

    private void CVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CVFocusLost
        // TODO add your handling code here:
        try{
            ProHe.setCostodeventa(Float.parseFloat(CV.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "El costo de venta debe de ser un numero");
            CV.setText("");
            CV.requestFocus();
        }
    }//GEN-LAST:event_CVFocusLost

    private void CAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CAFocusLost
        // TODO add your handling code here:
        try{
            ProHe.setCostoalmacenamiento(Float.parseFloat(CA.getText()));
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "El costo de almacenamiento debe de ser un numero");
            CA.setText("");
            CA.requestFocus();
        }
    }//GEN-LAST:event_CAFocusLost

    private void TEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TEFocusLost
        // TODO add your handling code here:
        Excepciones excepcion = new Excepciones();
        try{
            excepcion.ValidarTexto(TE.getText());
        } catch(Excepciones ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            TE.setText("");
            TE.requestFocus();
        }
    }//GEN-LAST:event_TEFocusLost

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
//            java.util.logging.Logger.getLogger(GUIProductosHerrajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIProductosHerrajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIProductosHerrajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIProductosHerrajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run(){
//                    new GUIProductosHerrajes().setVisible(true);
//            }
//        });
//    }

    //Getter y setter 
    
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

    public JComboBox<String> getCol() {
        return Col;
    }

    public void setCol(JComboBox<String> Col) {
        this.Col = Col;
    }

    public JTextField getDemand() {
        return Demand;
    }

    public void setDemand(JTextField Demand) {
        this.Demand = Demand;
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

    public JTextField getMarc() {
        return Marc;
    }

    public void setMarc(JTextField Marc) {
        this.Marc = Marc;
    }

    public JComboBox<String> getMateri() {
        return Materi;
    }

    public void setMateri(JComboBox<String> Materi) {
        this.Materi = Materi;
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

    public JTextField getTE() {
        return TE;
    }

    public void setTE(JTextField TE) {
        this.TE = TE;
    }

    public JPanel getFondo() {
        return Fondo;
    }

    public void setFondo(JPanel Fondo) {
        this.Fondo = Fondo;
    }

    public JPanel getFranjaD() {
        return FranjaD;
    }

    public void setFranjaD(JPanel FranjaD) {
        this.FranjaD = FranjaD;
    }

    public JLabel getjRuta() {
        return jRuta;
    }

    public void setjRuta(JLabel jRuta) {
        this.jRuta = jRuta;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Borrar;
    private javax.swing.JTextField CA;
    private javax.swing.JTextField CP;
    private javax.swing.JTextField CV;
    private javax.swing.JLabel Cda;
    private javax.swing.JLabel Cdp;
    private javax.swing.JLabel Cdv;
    private javax.swing.JComboBox<String> Col;
    private javax.swing.JLabel Color;
    private javax.swing.JButton Consultar;
    private javax.swing.JTextField Demand;
    private javax.swing.JLabel Demanda;
    private javax.swing.JPanel Fondo;
    private javax.swing.JPanel FranjaD;
    private javax.swing.JLabel IDBodega;
    private javax.swing.JComboBox<String> Idbodega;
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton Insertar;
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
    private javax.swing.JTextField TE;
    private javax.swing.JLabel TipoE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jRuta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMPH;
    // End of variables declaration//GEN-END:variables
}
