
package umg.UI;
import umg.modelo.Paquete;
import umg.modelo.Camionero;
import umg.modelo.Ciudad;
import umg.DAO.CamioneroDAO;
import umg.DAO.PaqueteDAO;
import umg.DAO.CiudadDAO;
import java.sql.SQLException;
import java.util.List;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;


public class frmPaquete extends javax.swing.JFrame {
    private int idPaquete = 0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmPaquete.class.getName());

    public frmPaquete() {
        initComponents();
        cargarCamioneros();
        cargarCiudades();
        cargarPaqueteDAO();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtDestinatario = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        cboCamionero = new javax.swing.JComboBox<>();
        cboCiudad = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        BtnVolver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaquete = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripcion:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Destinatario:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Peso:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Camionero:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ciudad:");

        txtDireccion.addActionListener(this::txtDireccionActionPerformed);

        cboCamionero.addActionListener(this::cboCamioneroActionPerformed);

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
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboCamionero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboCiudad, 0, 241, Short.MAX_VALUE)
                            .addComponent(txtDescripcion)
                            .addComponent(txtDireccion)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboCamionero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(BtnVolver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblPaquete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "Destinatario", "Peso", "Camionero", "Ciudad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.math.BigDecimal.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPaquete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaqueteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPaquete);

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
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void cargarCiudades(){
        CiudadDAO dao = new CiudadDAO();
        try{
            List<Ciudad> lista = dao.listar();
            DefaultComboBoxModel<Ciudad> model = new DefaultComboBoxModel<>();
            for (Ciudad c : lista){
                model.addElement(c);
            }
            cboCiudad.setModel(model);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Error al cargar ciudades: " + e.getMessage());
        }
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Paquete paquete = new Paquete();
        paquete.setDescripcion(txtDescripcion.getText());
        paquete.setDestinatario(txtDestinatario.getText());
        paquete.setPeso(new BigDecimal(txtPeso.getText()));
        paquete.setDireccion(txtDireccion.getText());
        paquete.setCamionero((Camionero) cboCamionero.getSelectedItem());
        paquete.setCiudad((Ciudad) cboCiudad.getSelectedItem());

        PaqueteDAO dao = new PaqueteDAO();
        try {
            dao.insertar(paquete);
            JOptionPane.showMessageDialog(this, "Datos almacenados correctamente");
            cargarPaqueteDAO();
            limpiarCampos();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, "Error: " + error.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        idPaquete = Integer.parseInt(txtID.getText());
        if (idPaquete == 0){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún registro");
            return;
        }
        try{
            Paquete paquete = new Paquete();
            paquete.setIdPaquete(idPaquete);
            paquete.setDescripcion(txtDescripcion.getText());
            paquete.setDestinatario(txtDestinatario.getText());
            paquete.setPeso(new BigDecimal(txtPeso.getText()));
            paquete.setDireccion(txtDireccion.getText());
            paquete.setCamionero((Camionero) cboCamionero.getSelectedItem());
            paquete.setCiudad((Ciudad) cboCiudad.getSelectedItem());

            PaqueteDAO dao = new PaqueteDAO();
            dao.actualizar(paquete);
            JOptionPane.showMessageDialog(this, "Datos actualizados Correctamente");
            idPaquete = 0;
            limpiarCampos();
            cargarPaqueteDAO();
        } catch (SQLException error){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún registro");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        idPaquete = Integer.parseInt(txtID.getText());
        if (idPaquete == 0){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún registro");
            return;
        }
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION){
            try{
                PaqueteDAO dao = new PaqueteDAO();
                dao.eliminar(idPaquete);
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
                idPaquete = 0;
                limpiarCampos();
                cargarPaqueteDAO();
            } catch (SQLException error){
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + error.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblPaqueteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaqueteMouseClicked
        int fila = tblPaquete.getSelectedRow();
        if (fila >= 0){
            idPaquete = Integer.parseInt(tblPaquete.getValueAt(fila, 0).toString());
            txtID.setText(tblPaquete.getValueAt(fila, 0).toString());
            txtDescripcion.setText(tblPaquete.getValueAt(fila, 1).toString());
            txtDestinatario.setText(tblPaquete.getValueAt(fila, 2).toString());
            txtPeso.setText(tblPaquete.getValueAt(fila, 3).toString());
            txtDireccion.setText(tblPaquete.getValueAt(fila, 4).toString());
            String camioneroStr = tblPaquete.getValueAt(fila, 5).toString();
            String ciudadStr = tblPaquete.getValueAt(fila, 6).toString();
            for (int i = 0; i < cboCamionero.getItemCount(); i++){
                Camionero c = (Camionero) cboCamionero.getItemAt(i);
                if (c.getNombre().equals(camioneroStr)){
                    cboCamionero.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < cboCiudad.getItemCount(); i++){
                Ciudad c = (Ciudad) cboCiudad.getItemAt(i);
                if (c.getNombre().equals(ciudadStr)){
                    cboCiudad.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_tblPaqueteMouseClicked

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
     new frmMenuPPL().setVisible(true);
     this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void cboCamioneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCamioneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCamioneroActionPerformed

    private void cargarPaqueteDAO(){
        PaqueteDAO listar = new PaqueteDAO();
        try{
            List<Paquete> lista = listar.listar();
            DefaultTableModel modelo = (DefaultTableModel) tblPaquete.getModel();
            modelo.setRowCount(0);
            for (Paquete p : lista){
                modelo.addRow(new Object[]{
                    p.getIdPaquete(),
                    p.getDescripcion(),
                    p.getDestinatario(),
                    p.getPeso(),
                    p.getDireccion(),
                    p.getCamionero() != null ? p.getCamionero().getNombre() : "",
                    p.getCiudad() != null ? p.getCiudad().getNombre() : ""
                });
            }
        } catch (SQLException errorSQL){
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + errorSQL.getMessage());
        }
    }

    private void limpiarCampos(){
        txtID.setText("");
        txtDescripcion.setText("");
        txtDestinatario.setText("");
        txtPeso.setText("");
        txtDireccion.setText("");
        idPaquete = 0;
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
        java.awt.EventQueue.invokeLater(() -> new frmPaquete().setVisible(true));
    }

    // Variables declaration
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVolver;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Camionero> cboCamionero;
    private javax.swing.JComboBox<Ciudad> cboCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPaquete;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDestinatario;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
