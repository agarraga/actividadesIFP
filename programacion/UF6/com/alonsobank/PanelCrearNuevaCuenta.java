package com.alonsobank;

public class PanelCrearNuevaCuenta extends javax.swing.JPanel {

    public PanelCrearNuevaCuenta() {
        initComponents();
    }

    // Do not modify
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelIntroduceDNI = new javax.swing.JLabel();
        labelIntroduceNombre = new javax.swing.JLabel();
        txtIntroduceDNI = new javax.swing.JTextField();
        txtIntroduceNombre = new javax.swing.JTextField();
        labelFormatoDNI = new javax.swing.JLabel();

        labelIntroduceDNI.setText("Introduce DNI del cliente");

        labelIntroduceNombre.setText("Introduce Nombre del cliente");

        labelFormatoDNI.setText("ej: 12345678A");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIntroduceNombre)
                    .addComponent(labelIntroduceDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIntroduceDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(labelFormatoDNI)
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addComponent(txtIntroduceNombre))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIntroduceDNI)
                    .addComponent(txtIntroduceDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFormatoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIntroduceNombre)
                    .addComponent(txtIntroduceNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getDNI() {
        return txtIntroduceDNI.getText(); 
    }

    public String getNombreCliente() {
        return txtIntroduceNombre.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelFormatoDNI;
    private javax.swing.JLabel labelIntroduceDNI;
    private javax.swing.JLabel labelIntroduceNombre;
    private javax.swing.JTextField txtIntroduceDNI;
    private javax.swing.JTextField txtIntroduceNombre;
    // End of variables declaration//GEN-END:variables
}