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

public class Listar_Usuarios extends javax.swing.JFrame {
    JTable tabla;
    ResultSet resultadoTabla;
    
    public Listar_Usuarios() throws SQLException {
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
                    nombres_update.setText(TablaMostrarUsers.getValueAt(fila, 1).toString());
                    apellidos_update.setText(TablaMostrarUsers.getValueAt(fila, 2).toString());
                    correo_update.setText(TablaMostrarUsers.getValueAt(fila, 3).toString());
                    telefono_update.setText(TablaMostrarUsers.getValueAt(fila, 4).toString());
                }
            }
            
        });
        
        this.setLocationRelativeTo(null);
        
        DefaultTableModel dfm = new DefaultTableModel();
        tabla = this.TablaMostrarUsers;
        tabla.setModel(dfm);
        
        dfm.setColumnIdentifiers(new Object[]{
            "id",
            "Nombre(s)", 
            "Apellidos",
            "Correo",
            "Telefono"
        });
        
        Conexion connect = new Conexion();
        resultadoTabla = this.SelectAllUsers("users");
        
        try{
            while(resultadoTabla.next()){
                dfm.addRow(new Object[]{
                    resultadoTabla.getString("id"),
                    resultadoTabla.getString("nombre"), 
                    resultadoTabla.getString("apellido"), 
                    resultadoTabla.getString("correo"), 
                    resultadoTabla.getString("telefono")                  
                });
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);        
        }
             
        
    }
    
    void disableInputsUpdate(){
        nombres_update.setEnabled(false);
        apellidos_update.setEnabled(false);
        correo_update.setEnabled(false);
        telefono_update.setEnabled(false);
        btn_update.setVisible(false);
        eliminar_dato.setVisible(false);
        nombres_update.setText("");
        apellidos_update.setText("");
        correo_update.setText("");
        telefono_update.setText("");
        btn_update.setVisible(false);
        eliminar_dato.setVisible(false);
    }
    
    void enableInputsUpdate(){
        nombres_update.setEnabled(true);
        apellidos_update.setEnabled(true);
        correo_update.setEnabled(true);
        telefono_update.setEnabled(true);
        btn_update.setVisible(true);
        eliminar_dato.setVisible(true);
    }

    public ResultSet SelectAllUsers(String table){
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
        nombres_update = new javax.swing.JTextField();
        apellidos_update = new javax.swing.JTextField();
        correo_update = new javax.swing.JTextField();
        telefono_update = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        eliminar_dato = new javax.swing.JButton();
        id_update = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado"));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Personas");

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

        btn_volver_listar.setBackground(new java.awt.Color(255, 102, 0));
        btn_volver_listar.setForeground(new java.awt.Color(255, 255, 255));
        btn_volver_listar.setText("Volver");
        btn_volver_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volver_listarActionPerformed(evt);
            }
        });

        btn_salir_listar.setBackground(new java.awt.Color(255, 0, 0));
        btn_salir_listar.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir_listar.setText("Salir! :(");
        btn_salir_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_listarActionPerformed(evt);
            }
        });

        btn_insertar_listar.setBackground(new java.awt.Color(0, 153, 0));
        btn_insertar_listar.setForeground(new java.awt.Color(255, 255, 255));
        btn_insertar_listar.setText("Insertar!");
        btn_insertar_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertar_listarActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(51, 153, 255));
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Actualizar Datos");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre(s):");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Correo:");

        jLabel5.setText("Telefono:");

        eliminar_dato.setBackground(new java.awt.Color(51, 51, 51));
        eliminar_dato.setForeground(new java.awt.Color(255, 255, 255));
        eliminar_dato.setText("Eliminar Dato");
        eliminar_dato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_datoActionPerformed(evt);
            }
        });

        id_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btn_insertar_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(btn_volver_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(btn_salir_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombres_update)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(id_update, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(telefono_update, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apellidos_update, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(correo_update, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btn_update)
                        .addGap(152, 152, 152)
                        .addComponent(eliminar_dato)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombres_update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidos_update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo_update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(telefono_update, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eliminar_dato, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_volver_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_insertar_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_salir_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(id_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, Short.MAX_VALUE)
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
        Insertar vistaInsertar = new Insertar();
        vistaInsertar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_insertar_listarActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        Conexion mysql = new Conexion();
        Connection connect = mysql.Conectar();
        String id_persona, nombre_nuevo, apellido_nuevo, correo_nuevo, telefono_nuevo;
        String SQL="", messageSuccess="";
        
        id_persona = id_update.getText();
        nombre_nuevo = nombres_update.getText();
        apellido_nuevo = apellidos_update.getText();
        correo_nuevo = correo_update.getText();
        telefono_nuevo = telefono_update.getText();
        
        SQL = "UPDATE users SET nombre = ?, apellido = ?, correo = ?, telefono = ? WHERE id = ?";
        messageSuccess = "Se han actualizado los datos correctamente";
        
        try{
            PreparedStatement bindParams = connect.prepareStatement(SQL);
            bindParams.setString(1, nombre_nuevo);
            bindParams.setString(2, apellido_nuevo);
            bindParams.setString(3, correo_nuevo);
            bindParams.setString(4, telefono_nuevo);
            bindParams.setString(5, id_persona);
            
            int affectedRows = bindParams.executeUpdate();
            
            if (affectedRows > 0){
                JOptionPane.showMessageDialog(null, messageSuccess);
                disableInputsUpdate();
                Listar_Usuarios viewListar = new Listar_Usuarios();
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
        
        SQL = "DELETE FROM users WHERE id = ?";
        messageSuccess = "Se ha eliminado el usuario correctamente";
        
        try{
            PreparedStatement bindParams = connect.prepareStatement(SQL);
            bindParams.setString(1, id_delete);
            
            int affectedRows = bindParams.executeUpdate();
            
            if (affectedRows > 0){
                JOptionPane.showMessageDialog(null, messageSuccess);
                disableInputsUpdate();
                Listar_Usuarios viewListar = new Listar_Usuarios();
                viewListar.setVisible(true);
                this.setVisible(false);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_eliminar_datoActionPerformed

    private void id_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_updateActionPerformed

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
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Listar_Usuarios().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Listar_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaMostrarUsers;
    private javax.swing.JTextField apellidos_update;
    private javax.swing.JButton btn_insertar_listar;
    private javax.swing.JButton btn_salir_listar;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_volver_listar;
    private javax.swing.JTextField correo_update;
    private javax.swing.JButton eliminar_dato;
    private javax.swing.JTextField id_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombres_update;
    private javax.swing.JTextField telefono_update;
    // End of variables declaration//GEN-END:variables
}
