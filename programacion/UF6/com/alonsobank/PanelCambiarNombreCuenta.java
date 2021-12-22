package com.alonsobank;

import javax.swing.JOptionPane;

public class PanelCambiarNombreCuenta extends javax.swing.JPanel {
    private Banco banco;

    public PanelCambiarNombreCuenta(Banco banco) {
        initComponents();
        this.banco = banco;
    }

    // Do not modify
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelIntroduceDniCliente = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        buttonVerNombreActual = new javax.swing.JButton();
        labelNombreActual = new javax.swing.JLabel();
        labelNuevoNombre = new javax.swing.JLabel();
        txtNuevoNombre = new javax.swing.JTextField();
        txtNombreActual = new javax.swing.JTextField();

        labelIntroduceDniCliente.setText("Introduze DNI del cliente");

        buttonVerNombreActual.setText("Ver Nombre Actual");
        buttonVerNombreActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVerNombreActualActionPerformed(evt);
            }
        });

        labelNombreActual.setText("Nombre Actual:");

        labelNuevoNombre.setText("Nuevo Nombre");

        txtNombreActual.setEditable(false);
        txtNombreActual.setBackground(new java.awt.Color(120, 120, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNuevoNombre)
                    .addComponent(labelNombreActual)
                    .addComponent(labelIntroduceDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNuevoNombre)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonVerNombreActual))
                    .addComponent(txtNombreActual, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIntroduceDniCliente)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVerNombreActual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreActual)
                    .addComponent(txtNombreActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNuevoNombre)
                    .addComponent(txtNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVerNombreActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVerNombreActualActionPerformed
        try{
            String nombreActual = banco.getCuenta(txtDNI.getText().toUpperCase()).getNombreCliente();
            txtNombreActual.setText(nombreActual);
        } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "DNI no válido", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonVerNombreActualActionPerformed

    public String getDNI() {
        return txtDNI.getText();
    }

    public String getNuevoNombre() {
        return txtNuevoNombre.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonVerNombreActual;
    private javax.swing.JLabel labelIntroduceDniCliente;
    private javax.swing.JLabel labelNombreActual;
    private javax.swing.JLabel labelNuevoNombre;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombreActual;
    private javax.swing.JTextField txtNuevoNombre;
    // End of variables declaration//GEN-END:variables
}