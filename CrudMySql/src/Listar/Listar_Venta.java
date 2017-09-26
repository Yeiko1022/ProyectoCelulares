package Listar;
import ConexionBD.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Principal.*;
import Insertar.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Listar_Venta extends javax.swing.JFrame {
    JTable tabla;
    ResultSet resultadoTabla;
    
    public Listar_Venta() throws SQLException {
        initComponents();
        id_update.setVisible(false);
        disableInputsUpdate();
        TablaMostrarUsers.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (TablaMostrarUsers.getSelectedRow() != -1){
                    enableInputsUpdate();
                    int fila = TablaMostrarUsers.getSelectedRow();
                    id_update.setText(TablaMostrarUsers.getValueAt(fila, 0).toString());
                    id_user_update.setText(TablaMostrarUsers.getValueAt(fila, 1).toString());
                    tamaño_pantalla_update.setText(TablaMostrarUsers.getValueAt(fila, 2).toString());
                    marca_update.setText(TablaMostrarUsers.getValueAt(fila, 3).toString());
                }
            }
            
        });
        
        this.setLocationRelativeTo(null);
        
        DefaultTableModel dfm = new DefaultTableModel();
        tabla = this.TablaMostrarUsers;
        tabla.setModel(dfm);
        
        dfm.setColumnIdentifiers(new Object[]{ //Con esto se cambia el titulo de la tabla
            "Id de la Venta",
            "N° Identificación Comprador", 
            "Imei",
            "Fecha de Venta",
        });
        
        Conexion connect = new Conexion();
        resultadoTabla = this.SelectAllVenta("salida_celular");
        
        try{
            while(resultadoTabla.next()){
                dfm.addRow(new Object[]{
                    resultadoTabla.getString("id_venta"),
                    resultadoTabla.getString("id_usuario"), 
                    resultadoTabla.getString("Imei"), 
                    resultadoTabla.getString("fecha_venta")             
                });
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);        
        }
             
        
    }
    
    void disableInputsUpdate(){
        id_user_update.setEnabled(false);
        tamaño_pantalla_update.setEnabled(false);
        marca_update.setEnabled(false);
        btn_update.setVisible(false);
        eliminar_dato.setVisible(false);
        id_user_update.setText("");
        tamaño_pantalla_update.setText("");
        marca_update.setText("");
        btn_update.setVisible(false);
        eliminar_dato.setVisible(false);
    }
    
    void enableInputsUpdate(){
        id_user_update.setEnabled(true);
        tamaño_pantalla_update.setEnabled(true);
        marca_update.setEnabled(true);
        btn_update.setVisible(true);
        eliminar_dato.setVisible(true);
    }

    public ResultSet SelectAllVenta(String table){
        Conexion mysql = new Conexion();
        Connection connect = mysql.Conectar();
        Statement st;
        ResultSet rs = null;
        
        try{
           st =  connect.createStatement();
           rs = st.executeQuery("SELECT * FROM " + table);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return rs;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMostrarUsers = new javax.swing.JTable();
        btn_volver_listar = new javax.swing.JButton();
        btn_salir_listar = new javax.swing.JButton();
        btn_insertar_listar = new javax.swing.JButton();
        id_user_update = new javax.swing.JTextField();
        tamaño_pantalla_update = new javax.swing.JTextField();
        marca_update = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Tamaño_Pantalla = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        eliminar_dato = new javax.swing.JButton();
        id_update = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado"));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ventas");

        TablaMostrarUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaMostrarUsers);

        btn_volver_listar.setBackground(new java.awt.Color(255, 0, 51));
        btn_volver_listar.setForeground(new java.awt.Color(255, 255, 255));
        btn_volver_listar.setText("Volver");
        btn_volver_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volver_listarActionPerformed(evt);
            }
        });

        btn_salir_listar.setBackground(new java.awt.Color(255, 0, 51));
        btn_salir_listar.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir_listar.setText("SALIR");
        btn_salir_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_listarActionPerformed(evt);
            }
        });

        btn_insertar_listar.setBackground(new java.awt.Color(255, 0, 51));
        btn_insertar_listar.setForeground(new java.awt.Color(255, 255, 255));
        btn_insertar_listar.setText("Nueva Venta");
        btn_insertar_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertar_listarActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(255, 0, 51));
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Actualizar Datos");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jLabel2.setText("Id Comprador: ");

        Tamaño_Pantalla.setText("Imei: ");

        jLabel4.setText("Fecha de Venta:");

        eliminar_dato.setBackground(new java.awt.Color(255, 0, 51));
        eliminar_dato.setForeground(new java.awt.Color(255, 255, 255));
        eliminar_dato.setText("Eliminar Celular");
        eliminar_dato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_datoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_insertar_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_volver_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_salir_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_user_update)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tamaño_pantalla_update, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tamaño_Pantalla))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(marca_update, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(eliminar_dato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(id_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(Tamaño_Pantalla)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_user_update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tamaño_pantalla_update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marca_update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar_dato, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(id_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_insertar_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_volver_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salir_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_listarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salir_listarActionPerformed

    private void btn_volver_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volver_listarActionPerformed
        Principal vistaPrincipal = new Principal();
        vistaPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_volver_listarActionPerformed

    private void btn_insertar_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertar_listarActionPerformed
        Insertar_celular vistaInsertar_celular = new Insertar_celular();
        vistaInsertar_celular.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_insertar_listarActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        Conexion mysql = new Conexion();
        Connection connect = mysql.Conectar();
        String id_venta, id_usuario, Imei, fecha_venta;
        String SQL="", messageSuccess="";
        
        id_venta = id_update.getText();
        id_usuario = id_user_update.getText();
        Imei = tamaño_pantalla_update.getText();
        fecha_venta = marca_update.getText();
        
        SQL = "UPDATE salida_celular SET id_usuario = ?, Imei = ?, fecha_venta = ? WHERE id_venta = ?";
        messageSuccess = "Se han actualizado los datos correctamente";
        
        try{
            PreparedStatement bindParams = connect.prepareStatement(SQL);
            bindParams.setString(1, id_usuario);
            bindParams.setString(2, Imei);
            bindParams.setString(3, fecha_venta);
            bindParams.setString(4, id_venta);
            
            int affectedRows = bindParams.executeUpdate();
            
            if (affectedRows > 0){
                JOptionPane.showMessageDialog(null, messageSuccess);
                disableInputsUpdate();
                Listar_Venta viewListar = new Listar_Venta();
                viewListar.setVisible(true);
                this.setVisible(false);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void eliminar_datoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_datoActionPerformed
        Conexion mysql = new Conexion();
        Connection connect = mysql.Conectar();
        String id_delete = id_update.getText();        
        String SQL = "", messageSuccess = "";
        
        SQL = "DELETE FROM salida_celular WHERE id_venta = ?";
        messageSuccess = "Se ha eliminado el celular correctamente";
        
        try{
            PreparedStatement bindParams = connect.prepareStatement(SQL);
            bindParams.setString(1, id_delete);
            
            int affectedRows = bindParams.executeUpdate();
            
            if (affectedRows > 0){
                JOptionPane.showMessageDialog(null, messageSuccess);
                disableInputsUpdate();
                Listar_Venta viewListar = new Listar_Venta();
                viewListar.setVisible(true);
                this.setVisible(false);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_eliminar_datoActionPerformed

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
            java.util.logging.Logger.getLogger(Listar_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Listar_Venta().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Listar_Venta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaMostrarUsers;
    private javax.swing.JLabel Tamaño_Pantalla;
    private javax.swing.JButton btn_insertar_listar;
    private javax.swing.JButton btn_salir_listar;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_volver_listar;
    private javax.swing.JButton eliminar_dato;
    private javax.swing.JTextField id_update;
    private javax.swing.JTextField id_user_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField marca_update;
    private javax.swing.JTextField tamaño_pantalla_update;
    // End of variables declaration//GEN-END:variables
}
