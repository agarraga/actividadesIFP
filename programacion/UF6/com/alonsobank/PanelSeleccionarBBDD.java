package com.alonsobank;

public class PanelSeleccionarBBDD extends javax.swing.JPanel {

    public PanelSeleccionarBBDD() {
        initComponents();
    }

    // Do not modify
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRutaBBDD = new javax.swing.JTextField();
        labelIntroduzcaRuta = new javax.swing.JLabel();

        labelIntroduzcaRuta.setText("Introduzca la ruta a la BBDD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(labelIntroduzcaRuta)
                .addGap(18, 18, 18)
                .addComponent(txtRutaBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRutaBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIntroduzcaRuta))
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getRutaBBDD() {
        return txtRutaBBDD.getText();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelIntroduzcaRuta;
    private javax.swing.JTextField txtRutaBBDD;
    // End of variables declaration//GEN-END:variables
}
