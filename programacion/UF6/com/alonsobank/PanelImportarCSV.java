package com.alonsobank;

public class PanelImportarCSV extends javax.swing.JPanel {

    public PanelImportarCSV() {
        initComponents();
    }

    // Do not modify
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelInserteRuta = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(500, 150));

        labelInserteRuta.setText("Inserte ruta del archivo ...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelInserteRuta)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelInserteRuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getRuta(){
        return txtRuta.getText();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelInserteRuta;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
