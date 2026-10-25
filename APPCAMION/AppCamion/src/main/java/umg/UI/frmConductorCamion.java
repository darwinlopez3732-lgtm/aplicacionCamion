
package umg.UI;
import umg.modelo.Camionero;
import umg.modelo.Camion;
import umg.modelo.ConductorCamion;
import umg.DAO.ConductorCamionDAO;
import umg.DAO.CamioneroDAO;
import umg.DAO.CamionDAO;

import java.sql.SQLException;

import java.util.List;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;


public class frmConductorCamion extends javax.swing.JFrame {
    private int idConductorCamion = 0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmConductorCamion.class.getName());

    public frmConductorCamion() {
        initComponents();
        cargarCamioneros();
        cargarCamiones();
        cargarConductorCamionDAO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        cboCamionero = new javax.swing.JComboBox<>();
        cboCamion = new javax.swing.JComboBox<>();
        txtFecha = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        BtnVolver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConductorCamion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Camionero:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Camion:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha :");

        cboCamionero.addActionListener(this::cboCamioneroActionPerformed);

        cboCamion.addActionListener(this::cboCamionActionPerformed);

        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        BtnVolver.setForeground(new java.awt.Color(0, 0, 0));
        BtnVolver.setText("Volver");
        BtnVolver.addActionListener(this::BtnVolverActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboCamionero, 0, 241, Short.MAX_VALUE)
                            .addComponent(cboCamion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(22, 22, 22)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboCamionero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(BtnVolver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblConductorCamion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Camionero", "Camion", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblConductorCamion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConductorCamionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConductorCamion);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
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

    private void cargarCamioneros(){
        CamioneroDAO dao = new CamioneroDAO();
        try{
            List<Camionero> lista = dao.listar();
            DefaultComboBoxModel<Camionero> model = new DefaultComboBoxModel<>();
            for (Camionero c : lista){
                model.addElement(c);
            }
            cboCamionero.setModel(model);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Error al cargar camioneros: " + e.getMessage());
        }
    }

    private void cargarCamiones(){
        CamionDAO dao = new CamionDAO();
        try{
            List<Camion> lista = dao.listar();
            DefaultComboBoxModel<Camion> model = new DefaultComboBoxModel<>();
            for (Camion c : lista){
                model.addElement(c);
            }
            cboCamion.setModel(model);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Error al cargar camiones: " + e.getMessage());
        }
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ConductorCamion cc = new ConductorCamion();
        cc.setConductor((Camionero) cboCamionero.getSelectedItem());
        cc.setCamion((Camion) cboCamion.getSelectedItem());
        cc.setFecha(LocalDate.parse(txtFecha.getText()));

        ConductorCamionDAO dao = new ConductorCamionDAO();
        try {
            dao.insertar(cc);
            JOptionPane.showMessageDialog(this, "Datos almacenados correctamente");
            cargarConductorCamionDAO();
            limpiarCampos();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, "Error: " + error.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        idConductorCamion = Integer.parseInt(txtID.getText());
        if (idConductorCamion == 0){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún registro");
            return;
        }
        try{
            ConductorCamion cc = new ConductorCamion();
            cc.setIdConductorCamion(idConductorCamion);
            cc.setConductor((Camionero) cboCamionero.getSelectedItem());
            cc.setCamion((Camion) cboCamion.getSelectedItem());
            cc.setFecha(LocalDate.parse(txtFecha.getText()));

            ConductorCamionDAO dao = new ConductorCamionDAO();
            dao.actualizar(cc);
            JOptionPane.showMessageDialog(this, "Datos actualizados Correctamente");
            idConductorCamion = 0;
            limpiarCampos();
            cargarConductorCamionDAO();
        } catch (SQLException error){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún registro");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        idConductorCamion = Integer.parseInt(txtID.getText());
        if (idConductorCamion == 0){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún registro");
            return;
        }
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION){
            try{
                ConductorCamionDAO dao = new ConductorCamionDAO();
                dao.eliminar(idConductorCamion);
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
                idConductorCamion = 0;
                limpiarCampos();
                cargarConductorCamionDAO();
            } catch (SQLException error){
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + error.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblConductorCamionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConductorCamionMouseClicked
        int fila = tblConductorCamion.getSelectedRow();
        if (fila >= 0){
            idConductorCamion = Integer.parseInt(tblConductorCamion.getValueAt(fila, 0).toString());
            txtID.setText(tblConductorCamion.getValueAt(fila, 0).toString());
            String camioneroStr = tblConductorCamion.getValueAt(fila, 1).toString();
            String camionStr = tblConductorCamion.getValueAt(fila, 2).toString();
            txtFecha.setText(tblConductorCamion.getValueAt(fila, 3).toString());
            for (int i = 0; i < cboCamionero.getItemCount(); i++){
                Camionero c = (Camionero) cboCamionero.getItemAt(i);
                if (c.getNombre().equals(camioneroStr)){
                    cboCamionero.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < cboCamion.getItemCount(); i++){
                Camion c = (Camion) cboCamion.getItemAt(i);
                if (c.getModelo().equals(camionStr)){
                    cboCamion.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_tblConductorCamionMouseClicked

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
    new frmMenuPPL().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void cboCamioneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCamioneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCamioneroActionPerformed

    private void cboCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCamionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCamionActionPerformed

    private void cargarConductorCamionDAO(){
        ConductorCamionDAO listar = new ConductorCamionDAO();
        try{
            List<ConductorCamion> lista = listar.listar();
            DefaultTableModel modelo = (DefaultTableModel) tblConductorCamion.getModel();
            modelo.setRowCount(0);
            for (ConductorCamion cc : lista){
                modelo.addRow(new Object[]{
                    cc.getIdConductorCamion(),
                    cc.getConductor() != null ? cc.getConductor().getNombre() : "",
                    cc.getCamion() != null ? cc.getCamion().getModelo() : "",
                    cc.getFecha() != null ? cc.getFecha().toString() : ""
                });
            }
        } catch (SQLException errorSQL){
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + errorSQL.getMessage());
        }
    }

    private void limpiarCampos(){
        txtID.setText("");
        txtFecha.setText("");
        idConductorCamion = 0;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new frmConductorCamion().setVisible(true));
    }

    // Variables declaration
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVolver;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Camion> cboCamion;
    private javax.swing.JComboBox<Camionero> cboCamionero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConductorCamion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
