package com.alonsobank;

public class PanelIngresarRetirar extends javax.swing.JPanel {

    private Banco banco;
    private Cuenta cuenta;
    private String dni;
    private Float cantidad;
    
    public PanelIngresarRetirar(Banco banco) {
        initComponents();
        this.banco = banco;
    }
    // Do not modify
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelIntroduzcaDNI = new javax.swing.JLabel();
        labelNombreCliente = new javax.swing.JLabel();
        labelVerNombreCliente = new javax.swing.JLabel();
        labelSaldo = new javax.swing.JLabel();
        labelVerSaldo = new javax.swing.JLabel();
        buttonIngresar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        buttonRetirar = new javax.swing.JButton();
        txtDNI = new javax.swing.JTextField();
        labelCantidad = new javax.swing.JLabel();
        buttonEncontrarCuenta = new javax.swing.JButton();

        labelIntroduzcaDNI.setText("Introduzca DNI:");

        labelNombreCliente.setText("Nombre Cliente");

        labelVerNombreCliente.setMinimumSize(new java.awt.Dimension(20, 17));

        labelSaldo.setText("Saldo");
        labelSaldo.setMaximumSize(new java.awt.Dimension(88, 17));
        labelSaldo.setMinimumSize(new java.awt.Dimension(88, 17));
        labelSaldo.setPreferredSize(new java.awt.Dimension(88, 17));

        labelVerSaldo.setMinimumSize(new java.awt.Dimension(20, 17));

        buttonIngresar.setText("Hacer Ingreso");
        buttonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngresarActionPerformed(evt);
            }
        });

        txtCantidad.setMaximumSize(new java.awt.Dimension(64, 23));

        buttonRetirar.setText("Hacer Extracción");
        buttonRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRetirarActionPerformed(evt);
            }
        });

        labelCantidad.setText("Cantidad:");

        buttonEncontrarCuenta.setText("Encontrar Cuenta");
        buttonEncontrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEncontrarCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(labelCantidad)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(labelNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(labelSaldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelIntroduzcaDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelVerNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelVerSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEncontrarCuenta))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(buttonIngresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRetirar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIntroduzcaDNI)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEncontrarCuenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreCliente)
                    .addComponent(labelVerNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelVerSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonIngresar)
                    .addComponent(buttonRetirar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEncontrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEncontrarCuentaActionPerformed
        dni = txtDNI.getText().toUpperCase();
        cuenta = banco.getCuenta(dni);
        labelVerNombreCliente.setText(cuenta.getNombreCliente());
        labelVerSaldo.setText(cuenta.getSaldoDosDecimales());
    }//GEN-LAST:event_buttonEncontrarCuentaActionPerformed

    private void buttonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngresarActionPerformed
        cantidad = Float.parseFloat(txtCantidad.getText());
        cuenta.hacerIngreso(cantidad);
        labelVerSaldo.setText(cuenta.getSaldoDosDecimales());
        banco.ingresar(dni, cantidad);
    }//GEN-LAST:event_buttonIngresarActionPerformed

    private void buttonRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetirarActionPerformed
        cantidad = Float.parseFloat(txtCantidad.getText());
        cuenta.hacerExtraccion(cantidad);
        labelVerSaldo.setText(cuenta.getSaldoDosDecimales());
        banco.retirar(dni, cantidad);
    }//GEN-LAST:event_buttonRetirarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEncontrarCuenta;
    private javax.swing.JButton buttonIngresar;
    private javax.swing.JButton buttonRetirar;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelIntroduzcaDNI;
    private javax.swing.JLabel labelNombreCliente;
    private javax.swing.JLabel labelSaldo;
    private javax.swing.JLabel labelVerNombreCliente;
    private javax.swing.JLabel labelVerSaldo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDNI;
    // End of variables declaration//GEN-END:variables
}