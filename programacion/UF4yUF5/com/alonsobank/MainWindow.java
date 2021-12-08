package com.alonsobank;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends javax.swing.JFrame {
    private Banco banco;

    public MainWindow() {
        initComponents();
        banco = new Banco("Banco Hola Mundo !");
        labelNombreBanco.setText(banco.getNombreBanco());
    }

    // Do not modify
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentas = new javax.swing.JTable();
        labelCuentas = new javax.swing.JLabel();
        labelNombreBanco = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuBarArchivo = new javax.swing.JMenu();
        menuBarArchivoImportarCSV = new javax.swing.JMenuItem();
        menuBarArchivoExportarCSV = new javax.swing.JMenuItem();
        menuBarArchivoSalir = new javax.swing.JMenuItem();
        menuBarCuentas = new javax.swing.JMenu();
        menuBarCuentasCrearNueva = new javax.swing.JMenuItem();
        menuBarCuentasCambiarNombre = new javax.swing.JMenuItem();
        menuBarCuentasEncontrarCuenta = new javax.swing.JMenuItem();
        menuBarCuentasIngresarRetirar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Saldo", "Fecha Creación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCuentas);

        labelCuentas.setText("CUENTAS");

        labelNombreBanco.setMaximumSize(new java.awt.Dimension(128, 17));

        menuBarArchivo.setMnemonic('a');
        menuBarArchivo.setText("Archivo");

        menuBarArchivoImportarCSV.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBarArchivoImportarCSV.setMnemonic('i');
        menuBarArchivoImportarCSV.setText("Importar CSV");
        menuBarArchivoImportarCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarArchivoImportarCSVActionPerformed(evt);
            }
        });
        menuBarArchivo.add(menuBarArchivoImportarCSV);

        menuBarArchivoExportarCSV.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBarArchivoExportarCSV.setMnemonic('e');
        menuBarArchivoExportarCSV.setText("Exportar CSV");
        menuBarArchivoExportarCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarArchivoExportarCSVActionPerformed(evt);
            }
        });
        menuBarArchivo.add(menuBarArchivoExportarCSV);

        menuBarArchivoSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuBarArchivoSalir.setMnemonic('s');
        menuBarArchivoSalir.setText("Salir");
        menuBarArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarArchivoSalirActionPerformed(evt);
            }
        });
        menuBarArchivo.add(menuBarArchivoSalir);

        menuBar.add(menuBarArchivo);

        menuBarCuentas.setMnemonic('c');
        menuBarCuentas.setText("Cuentas");

        menuBarCuentasCrearNueva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBarCuentasCrearNueva.setMnemonic('n');
        menuBarCuentasCrearNueva.setText("Crear Nueva");
        menuBarCuentasCrearNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarCuentasCrearNuevaActionPerformed(evt);
            }
        });
        menuBarCuentas.add(menuBarCuentasCrearNueva);

        menuBarCuentasCambiarNombre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBarCuentasCambiarNombre.setMnemonic('r');
        menuBarCuentasCambiarNombre.setText("Cambiar Nombre");
        menuBarCuentasCambiarNombre.setToolTipText("");
        menuBarCuentasCambiarNombre.setDisplayedMnemonicIndex(12);
        menuBarCuentasCambiarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarCuentasCambiarNombreActionPerformed(evt);
            }
        });
        menuBarCuentas.add(menuBarCuentasCambiarNombre);

        menuBarCuentasEncontrarCuenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBarCuentasEncontrarCuenta.setMnemonic('e');
        menuBarCuentasEncontrarCuenta.setText("Encontrar Cuenta");
        menuBarCuentasEncontrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarCuentasEncontrarCuentaActionPerformed(evt);
            }
        });
        menuBarCuentas.add(menuBarCuentasEncontrarCuenta);

        menuBarCuentasIngresarRetirar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBarCuentasIngresarRetirar.setMnemonic('o');
        menuBarCuentasIngresarRetirar.setText("Ingresar o retirar ...");
        menuBarCuentasIngresarRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarCuentasIngresarRetirarActionPerformed(evt);
            }
        });
        menuBarCuentas.add(menuBarCuentasIngresarRetirar);

        menuBar.add(menuBarCuentas);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCuentas)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(labelNombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(labelCuentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    private void menuBarArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarArchivoSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuBarArchivoSalirActionPerformed

    private void menuBarCuentasCrearNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarCuentasCrearNuevaActionPerformed
        PanelCrearNuevaCuenta panelCrearNuevaCuenta = new PanelCrearNuevaCuenta(); 
        int result = JOptionPane.showConfirmDialog(null, panelCrearNuevaCuenta, 
                "Crear Nueva Cuenta", JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.PLAIN_MESSAGE);

        try {
            if(result == JOptionPane.OK_OPTION) {
                String dni = panelCrearNuevaCuenta.getDNI();
                String nombreCliente = panelCrearNuevaCuenta.getNombreCliente();

                banco.crearCuenta(dni, nombreCliente);
                refrescarTabla();
            }
        }catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "DNI no válido", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuBarCuentasCrearNuevaActionPerformed

    private void menuBarCuentasCambiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarCuentasCambiarNombreActionPerformed
        PanelCambiarNombreCuenta panelCambiarNombreCuenta = new PanelCambiarNombreCuenta(banco); 
        int result = JOptionPane.showConfirmDialog(null, panelCambiarNombreCuenta, 
                "Cambiar nombre cliente de cuenta existente", JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.PLAIN_MESSAGE);
        try{
            if(result == JOptionPane.OK_OPTION) {
            String dni = panelCambiarNombreCuenta.getDNI();
            String nuevoNombre = panelCambiarNombreCuenta.getNuevoNombre();
            Cuenta cuenta = banco.encontrarCuenta(dni);
            banco.cambiarNombre(dni, nuevoNombre);
            refrescarTabla();
            }  
        } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "DNI no válido", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuBarCuentasCambiarNombreActionPerformed

    private void menuBarCuentasEncontrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarCuentasEncontrarCuentaActionPerformed
        PanelEncontrarCuenta panelEncontrarCuenta = new PanelEncontrarCuenta(banco); 
        int result = JOptionPane.showConfirmDialog(null, panelEncontrarCuenta, 
                "Encontrar Cuenta por DNI", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_menuBarCuentasEncontrarCuentaActionPerformed

    private void menuBarCuentasIngresarRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarCuentasIngresarRetirarActionPerformed
        PanelIngresarRetirar panelIngresarRetirar = new PanelIngresarRetirar(banco);
        int result = JOptionPane.showConfirmDialog(null, panelIngresarRetirar, 
                "Encontrar Cuenta por DNI", JOptionPane.PLAIN_MESSAGE);
        if(result == JOptionPane.OK_OPTION) {
            refrescarTabla();
        }
        
    }//GEN-LAST:event_menuBarCuentasIngresarRetirarActionPerformed

    private void menuBarArchivoImportarCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarArchivoImportarCSVActionPerformed
        PanelImportarCSV panelImportarCSV = new PanelImportarCSV();
        int result = JOptionPane.showConfirmDialog(null, panelImportarCSV, 
                "Importar Cuentas", JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.PLAIN_MESSAGE);

        try {
            if(result == JOptionPane.OK_OPTION) {
                String ruta = panelImportarCSV.getRuta();
                banco.importarCSV(ruta);
                refrescarTabla();
            }
        } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Ruta no válida", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuBarArchivoImportarCSVActionPerformed

    private void menuBarArchivoExportarCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarArchivoExportarCSVActionPerformed
        PanelExportarCSV panelExportarCSV = new PanelExportarCSV(); 
        int result = JOptionPane.showConfirmDialog(null, panelExportarCSV, 
                "Exportar Cuentas", JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.PLAIN_MESSAGE);

        try {
            if(result == JOptionPane.OK_OPTION) {
                String ruta = panelExportarCSV.getRuta();
                banco.exportarCSV(banco.getCuentas(), ruta);
            }
        } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Ruta no válida", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuBarArchivoExportarCSVActionPerformed

    public void refrescarTabla() {
        DefaultTableModel modelo = (DefaultTableModel)tablaCuentas.getModel();
        modelo.setRowCount(0);
        List<Cuenta> cuentas = banco.getCuentas();
        for(Cuenta cuenta : cuentas) {
            modelo.addRow(new Object[]{
                cuenta.getNumeroCuenta(), 
                cuenta.getNombreCliente(), 
                cuenta.getSaldoDosDecimales(), 
                cuenta.getFechaCreacion()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCuentas;
    private javax.swing.JLabel labelNombreBanco;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBarArchivo;
    private javax.swing.JMenuItem menuBarArchivoExportarCSV;
    private javax.swing.JMenuItem menuBarArchivoImportarCSV;
    private javax.swing.JMenuItem menuBarArchivoSalir;
    private javax.swing.JMenu menuBarCuentas;
    private javax.swing.JMenuItem menuBarCuentasCambiarNombre;
    private javax.swing.JMenuItem menuBarCuentasCrearNueva;
    private javax.swing.JMenuItem menuBarCuentasEncontrarCuenta;
    private javax.swing.JMenuItem menuBarCuentasIngresarRetirar;
    private javax.swing.JTable tablaCuentas;
    // End of variables declaration//GEN-END:variables
}