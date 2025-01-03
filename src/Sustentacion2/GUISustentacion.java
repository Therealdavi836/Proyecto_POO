/**
 *@title: GUISustentacion.java
 *@description: GUI de productos electricos para la sustentacion del proyecto CadenaSuministros
 *@date: Miercoles 15 de noviembre del 2023
 *@version: 0.1
 *@author: Juan David Fajardo Betancourt 
 */

//Paquete
package Sustentacion2;

//Imports de apis de java y sql(el sql aca solo es decoracion y no hace nada ) 
import menusGUI.*;
import Controlador.ConexionBD;
import Controlador.ControladorProductosElectricos;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import Modelo.ProductosElectricos;

//Clase de la interfaz grafica 
public class GUISustentacion extends javax.swing.JFrame {

    /**
     * Creates new form GUISustentacion
     */
    
    //Variables globales por defecto 
    private ControladorProductosElectricos proECont;
    ProductosElectricos producto;
    ConexionBD conBD;
    Connection con;
    Object[] arregloDatos;
    private DefaultTableModel modelo;
    
    //Constructor de la clase 
    public GUISustentacion() {
        initComponents();
        proECont = new ControladorProductosElectricos();
        producto = new ProductosElectricos();
        conBD = new ConexionBD();
        con = conBD.mysqlConexion();
        arregloDatos = new Object[12];
        modelo = (DefaultTableModel)jTMPE.getModel();
        //Insertar datos por defecto almacena los datos en el arreglo y el constructor 
        insertarDatosDefault();
    }

    //Metodo para insertar los datos por defecto sin crear repertidos en el arreglo y no usa la base de datos 
    private void insertarDatosDefault(){
        
        //Producto electrico 1
        producto = new ProductosElectricos(11, 9, 361, "Control", "Verde", "", "Miniso", "Polisilicona", 3, 8000, 40000, 12000, 30);
        proECont.insertar(producto);
        
        //Producto electrico 2
        producto = new ProductosElectricos(17, 25, 321, "Transistor", "Azul", "", "Kingston", "Silicio dopado", 2, 2000, 80000, 300, 780);
        proECont.insertar(producto);
        
        //Producto electrico 3
        producto = new ProductosElectricos(8, 12, 332, "Linterna", "Blanco", "", "Paqlin", " Ceramica", 4, 5000, 5000, 800, 120);
        proECont.insertar(producto);
        
        //Producto electrico 4
        producto = new ProductosElectricos(29, 18, 390, "Procesador", "Negro", "", "AMD", "Fibra de Carbono", 1, 9000, 12000, 2000, 55);
        proECont.insertar(producto);
        
        //Este ciclo inserta en la tabla los datos usados del constructor 
        for(ProductosElectricos objpro : proECont.arregloProductosElectricos){
            //Se invoca al metodo para quelos inserte en la tabla de la interfaz grafica 
            insertarTabla(objpro);
        }
    }
    
    //Metodo para insertar los datos por defecto en la tabla de la interfaz grafica 
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
        
        modelo.addRow(arregloDatos);
    }
        
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OrdenarPV = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMPE = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OrdenarPV.setBackground(new java.awt.Color(102, 102, 255));
        OrdenarPV.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        OrdenarPV.setText("Ordenar por Costo V");
        OrdenarPV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrdenarPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarPVActionPerformed(evt);
            }
        });

        jTMPE.setBackground(new java.awt.Color(153, 153, 255));
        jTMPE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTMPE.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        jTMPE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Serial", "Nombre", "Color ", "Marca ", "Material", "ID Bodega ", "Demanda", "Costo P", "Costo V ", "Costo A", "Capacidad Carga", "Calibre"
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
        if (jTMPE.getColumnModel().getColumnCount() > 0) {
            jTMPE.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 48)); // NOI18N
        jLabel1.setText("Menú de Sustentación");

        jLabel2.setText("El ordenamiento MergeSort se hace con el costo de venta ----------------------------->");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(341, 341, 341))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(OrdenarPV, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(521, 521, 521))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrdenarPV, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Este metodo/boton ordena por precios de venta a los productos de la tabla 
    private void OrdenarPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarPVActionPerformed
        // TODO add your handling code here:
        
        //Se invoca al metodo MergeSort llamado desde el controlador de productos electricos 
        proECont.arregloProductosElectricos = proECont.mergeSort(proECont.arregloProductosElectricos);
        //Se hace el conteo de las filas en 0 para que los datos se ordenen sin imprimir dobles o dejar estaticos
        //en la fila 
        modelo.setRowCount(0);
        //El ciclo inserta en la tabla los datos ordenados del arreglo 
        for(ProductosElectricos ProE1: proECont.arregloProductosElectricos){
            //Se insertan en la tabla 
            insertarTabla(ProE1);
        }
    }//GEN-LAST:event_OrdenarPVActionPerformed

    private void jTMPEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMPEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTMPEMouseClicked

    /**
     * @param args the command line arguments
     */ //Metodo principal que ejecuta la interfaz 
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
//            java.util.logging.Logger.getLogger(GUISustentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUISustentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUISustentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUISustentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUISustentacion().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OrdenarPV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMPE;
    // End of variables declaration//GEN-END:variables
}
