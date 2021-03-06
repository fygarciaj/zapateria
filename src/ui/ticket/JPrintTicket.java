/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.ticket;

import datos.Cliente;
import datos.Reparacion;
import datos.Ticket;
import negocios.ClientesBL;
import negocios.ReparacionesBL;
import negocios.TicketsBL;

/**
 *
 * @author REBOOTSYSTEM
 */
public class JPrintTicket extends javax.swing.JInternalFrame {

    private Cliente cliente;
    private Reparacion reparacion;
    private Ticket ticket;
    private String contentTicket = "\n"
            + "\n"
            + "ZAPATERIA Calzaditos\n"
            + "VALLEDUPAR, CALLE 28 #5C 63\n"
            + "NIT: 771717435-3\n"
            + "======================================\n"
            + "Caja # {{box}} - Ticket # {{ticket}}\n"
            + "Fecha: {{dateTime}}\n"
            + "Cliente: {{nombre_cliente}}\n"
            + "Teléfono: {{telefono_cliente}}\n"
            + "======================================\n"
            + "{{reparacion}}\n"
            + "======================================\n"
            + "SUBTOTAL: {{subTotal}}\n"
            + "IVA: {{iva}}\n"
            + "TOTAL: {{total}}\n\n"
            + "======================================\n"
            + "LE ATENDIO: {{usuario}}\n"
            + "GRACIAS POR SU PREFERENCIA...\n"
            + "ESPERAMOS SU VISITA NUEVAMENTE\n"
            + "\n"
            + "\n";

    /**
     * Creates new form JPrintTicket
     */
    public JPrintTicket() {
        this.ticket = null;
        this.reparacion = null;
        this.cliente = null;
        initComponents();
    }

    public JPrintTicket(Reparacion reparacion) {

        this.reparacion = reparacion;

        ReparacionesBL.findById(reparacion.getId());

        this.ticket = TicketsBL.findByRepairId(reparacion.getId());
        this.cliente = ClientesBL.findById(reparacion.getClienteID());
        initComponents();
        fillPrintTicket();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtPaneTicket = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        jScrollPane1.setViewportView(txtPaneTicket);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/printer_24.png"))); // NOI18N
        jButton1.setText("Imprimir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 311, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtPaneTicket;
    // End of variables declaration//GEN-END:variables

    // Genera el texto del ticket
    private void fillPrintTicket() {

        this.contentTicket = this.contentTicket.replace("{{box}}", "1");
        this.contentTicket = this.contentTicket.replace("{{ticket}}", ticket.getId().toString());
        this.contentTicket = this.contentTicket.replace("{{dateTime}}", ticket.getFecha());
        this.contentTicket = this.contentTicket.replace("{{nombre_cliente}}", cliente.getNombreCompleto());
        this.contentTicket = this.contentTicket.replace("{{telefono_cliente}}", cliente.getTelefono());
        this.contentTicket = this.contentTicket.replace("{{reparacion}}", reparacion.getDescripcionReparacion()+" "+reparacion.getValor());
        this.contentTicket = this.contentTicket.replace("{{subTotal}}", ticket.getValorTotal().toString());
        Double iva = ((ticket.getValorTotal() * 16) /100);
        Double total =  ticket.getValorTotal() + iva;
        this.contentTicket = this.contentTicket.replace("{{iva}}", iva.toString());
        this.contentTicket = this.contentTicket.replace("{{total}}", total.toString());
        this.contentTicket = this.contentTicket.replace("{{usuario}}", "Fabian");


        txtPaneTicket.setText(contentTicket);

    }
}
