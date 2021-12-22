package com.alonsobank;

public class PanelRealizarTransferencia extends javax.swing.JPanel {

    public PanelRealizarTransferencia() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDNIRemitente = new javax.swing.JLabel();
        labelDNIDestinatario = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        txtDNIRemitente = new javax.swing.JTextField();
        txtDNIDestinatario = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));

        labelDNIRemitente.setText("DNI del Remitente");

        labelDNIDestinatario.setText("DNI del Destinatario");

        labelCantidad.setText("Cantidad");

        txtDNIRemitente.setMaximumSize(new java.awt.Dimension(64, 23));

        txtDNIDestinatario.setMaximumSize(new java.awt.Dimension(64, 23));

        txtCantidad.setMaximumSize(new java.awt.Dimension(64, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCantidad)
                    .addComponent(labelDNIDestinatario)
                    .addComponent(labelDNIRemitente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDNIRemitente, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(txtDNIDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDNIRemitente)
                    .addComponent(txtDNIRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDNIDestinatario)
                    .addComponent(txtDNIDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getDNIDestinatario(){
        return txtDNIDestinatario.getText().toUpperCase();
    }

    public String getDNIRemitente(){
        return txtDNIRemitente.getText().toUpperCase();
    }

    public Float getCantidad() {
        return Float.parseFloat(txtCantidad.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelDNIDestinatario;
    private javax.swing.JLabel labelDNIRemitente;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDNIDestinatario;
    private javax.swing.JTextField txtDNIRemitente;
    // End of variables declaration//GEN-END:variables
}
