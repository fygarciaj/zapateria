/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.repair;

import datos.Reparacion;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocios.ReparacionesBL;
import ui.JAppmain_ui;

public final class JReparaciones_ui extends javax.swing.JInternalFrame {

    private JAppmain_ui app;
    private int reparacionId = 0;
    private Reparacion reparacion;

    /**
     * Creates new form
     */
    public JReparaciones_ui(JAppmain_ui app) {
        this.app = app;
        initComponents();
        disableButtons();
        fillTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnEdit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnRefresh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Reparaciones por Ervin Arsuza");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons8-martillo-64.png"))); // NOI18N
        setOpaque(true);

        jToolBar1.setRollover(true);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/shoe_add_24.png"))); // NOI18N
        btnNew.setText("Registrar");
        btnNew.setToolTipText("Crea un nuevo cliente");
        btnNew.setFocusable(false);
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setOpaque(false);
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNew);
        jToolBar1.add(jSeparator1);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/shoe_edit_24.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.setToolTipText("Edita una reparacion");
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setOpaque(false);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);
        jToolBar1.add(jSeparator2);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/shoe_del_24.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setToolTipText("Elimina una reparacion");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setOpaque(false);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDelete);
        jToolBar1.add(jSeparator3);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/refresh_24.png"))); // NOI18N
        btnRefresh.setText("Actualizar");
        btnRefresh.setFocusable(false);
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setOpaque(false);
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRefresh);

        tblRegistros.setEditingColumn(0);
        tblRegistros.setEditingRow(0);
        tblRegistros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRegistros.getTableHeader().setReorderingAllowed(false);
        tblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegistros);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            JAddRepar add_repar = new JAddRepar(this);
            // Centrado de formulario
            Dimension desktopSize = this.app.dskMain.getSize();
            Dimension FrameSize = add_repar.getSize();
            add_repar.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            this.app.dskMain.add(add_repar);
            add_repar.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnNewActionPerformed

    private void tblRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegistrosMouseClicked

        int row = this.tblRegistros.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
            disableButtons();
        } else {
            reparacionId = (int) this.tblRegistros.getValueAt(row, 0);
            reparacion = ReparacionesBL.findById(reparacionId);
            // Si la reparacion ya tiene un ticket facturado no se puede ni editar ni borrar por eso se desactivan los botones
            if (!"Facturado".equals(reparacion.getEstado())) {
                enabledButtons();
            } else {
                disableButtons();
            }

        }

    }//GEN-LAST:event_tblRegistrosMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (reparacionId > 0) {
            try {
                reparacion = ReparacionesBL.findById(reparacionId);
                // Si la reparacion ya tiene un ticket facturado no se puede borrar
                if ("Facturado".equals(reparacion.getEstado())) {
                    JOptionPane.showMessageDialog(rootPane, "No es posible borrar esta reparación ya que \n tiene un ticket facturado.");
                } else {
                    int result = JOptionPane.showConfirmDialog(rootPane, "Desea borrar el registro?", "Borrar Registro", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (result == 0) {
                        ReparacionesBL.delete(reparacionId);
                        fillTable();
                        disableButtons();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        if (reparacionId > 0) {
            try {
                reparacion = ReparacionesBL.findById(reparacionId);
                // Si la reparacion ya tiene un ticket facturado no se puede borrar
                if ("Facturado".equals(reparacion.getEstado())) {
                    JOptionPane.showMessageDialog(rootPane, "No es posible editar esta reparación ya que \n tiene un ticket facturado.");
                } else {
                    JEditRepar edit_repar = new JEditRepar(this, reparacion);

                    this.app.dskMain.add(edit_repar);
                    edit_repar.show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        fillTable();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblRegistros;
    // End of variables declaration//GEN-END:variables

    /**
     * Llena la tabla con los valores en la base de datos.
     *
     */
    public void fillTable() {

        try {
            DefaultTableModel modelReparaciones;

            modelReparaciones = ReparacionesBL.listar();
            this.tblRegistros.setModel(modelReparaciones);

            TableColumnModel columnModel = tblRegistros.getColumnModel();
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);

            columnModel.getColumn(0).setPreferredWidth(30);
            columnModel.getColumn(1).setPreferredWidth(150);
            columnModel.getColumn(2).setPreferredWidth(200);
            columnModel.getColumn(3).setPreferredWidth(250);
            columnModel.getColumn(4).setPreferredWidth(250);
            columnModel.getColumn(5).setPreferredWidth(100);
            columnModel.getColumn(5).setCellRenderer(tcr);
            columnModel.getColumn(6).setPreferredWidth(250);

            disableButtons();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al cargar la los registros de la tabla " + e.getMessage());
        }

    }

    private void disableButtons() {
        // Si no esta seleccionado un registro es mejor desactivar los botones. fyg
        this.btnEdit.setEnabled(false);
        this.btnDelete.setEnabled(false);
    }

    private void enabledButtons() {
        this.btnEdit.setEnabled(true);
        this.btnDelete.setEnabled(true);
    }
}
