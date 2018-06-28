/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Client;

import com.mysql.jdbc.StringUtils;
import datos.Cliente;
import java.text.DateFormat;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import negocios.ClientesBL;

/**
 *
 * @author REBOOTSYSTEM
 */
public class JAddClient extends javax.swing.JInternalFrame {

    private JClientes_ui clientes_ui;
    private Cliente cliente = null;
    private ClientesBL clientebl = null;

    DateFormat df = DateFormat.getDateInstance();
    InputVerifier verifierIdentificacion = new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            final JTextComponent source = (JTextComponent) input;
            String text = source.getText();
            // Que tenga datos el campo
            if ((text.length() > 0)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(source, "Ingrese la identificación del cliente", "Error Dialog",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    };

    InputVerifier verifierNombresCompletos = new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            final JTextComponent source = (JTextComponent) input;
            String text = source.getText();
            // Que tenga datos el campo
            if ((text.length() > 0)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(source, "Ingrese el nombre completo del cliente", "Error Dialog",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    };

    InputVerifier verifierFechaNacimiento = new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            final JTextComponent source = (JTextComponent) input;
            String text = source.getText();
            // Que tenga datos el campo
            if ((text.length() > 0)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(source, "Ingrese la fecha de nacimiento del cliente", "Error Dialog",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    };

    /**
     * Creates new form JAddClient
     */
    public JAddClient(JClientes_ui cliente_ui) {
        // referencia al formulario principal de clientes
        this.clientes_ui = cliente_ui;
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        utilDateModel1 = new org.jdatepicker.UtilDateModel();
        sqlDateModel1 = new org.jdatepicker.SqlDateModel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        dtpFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jToolBar1 = new javax.swing.JToolBar();
        btnSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnClose = new javax.swing.JButton();

        utilDateModel1.setSelected(true);

        sqlDateModel1.setSelected(true);

        setTitle("Nuevo Cliente");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/user_add_32.png"))); // NOI18N

        jLabel2.setLabelFor(txtIdentificacion);
        jLabel2.setText("Identificación");

        txtIdentificacion.setInputVerifier(verifierIdentificacion);

        jLabel3.setLabelFor(txtNombreCompleto);
        jLabel3.setText("Nombres y Apellidos");

        jLabel4.setLabelFor(dtpFechaNacimiento);
        jLabel4.setText("Fecha de Nacimiento");

        jLabel5.setLabelFor(txtDireccion);
        jLabel5.setText("Dirección");

        jLabel6.setLabelFor(txtTelefono);
        jLabel6.setText("Teléfono");

        dtpFechaNacimiento.setDateFormatString("yyyy-MM-d");
        dtpFechaNacimiento.setMinSelectableDate(new java.util.Date(-2208967363000L));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtNombreCompleto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion)
                            .addComponent(txtTelefono)
                            .addComponent(dtpFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
                .addGap(307, 307, 307))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dtpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/diskette_24.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setToolTipText("Guarda el registro");
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);
        jToolBar1.add(jSeparator1);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cancel_24.png"))); // NOI18N
        btnClose.setMnemonic('c');
        btnClose.setText("Cerrar");
        btnClose.setToolTipText("Cierra el Formulario");
        btnClose.setFocusable(false);
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnClose);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (this.txtIdentificacion.getText().length() > 0) {
            if (this.txtNombreCompleto.getText().length() > 0) {
                try {
                    cliente = new Cliente();

//                    String fecha = this.dtpFechaNacimiento.getFormattedTextField().getText();
//                    List<String> fecha1 = StringUtils.split(fecha, "/", true);
//                    fecha = fecha1.get(2)+"-"+fecha1.get(1)+"-"+fecha1.get(0);
String fecha = this.dtpFechaNacimiento.
                    cliente.setIdentificacion(this.txtIdentificacion.getText());
                    cliente.setNombreCompleto(this.txtNombreCompleto.getText());
                    cliente.setFechaNacimiento(fecha);
                    cliente.setDireccion(this.txtDireccion.getText());
                    cliente.setTelefono(this.txtTelefono.getText());
                    
                    clientebl.create(cliente);

                    clearFields();
                    this.clientes_ui.fillTable();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e.getLocalizedMessage());
                }

            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private com.toedter.calendar.JDateChooser dtpFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private org.jdatepicker.SqlDateModel sqlDateModel1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombreCompleto;
    private javax.swing.JTextField txtTelefono;
    private org.jdatepicker.UtilDateModel utilDateModel1;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {       
        this.txtIdentificacion.setText("");
        this.txtNombreCompleto.setText("");
        this.txtDireccion.setText("");
        this.txtTelefono.setText("");
    }

}
