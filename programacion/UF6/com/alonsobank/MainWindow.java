package com.alonsobank;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends javax.swing.JFrame {

    private Banco banco;
    private DAO dao;    

    public MainWindow() {
        initComponents();
        dao = new DAO();
        banco = new Banco("Banco Hola Mundo !", dao);
        labelNombreBanco.setText(banco.getNombreBanco());
        refrescarTabla();
    }

    // Do not modify
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentas = new javax.swing.JTable();
        labelCuentas = new javax.swing.JLabel();
        labelNombreBanco = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        buttonBuscar = new javax.swing.JButton();
        labelDNICliente = new javax.swing.JLabel();
        labelNombreCliente = new javax.swing.JLabel();
        buttonRefrescarCuentas = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuBarArchivo = new javax.swing.JMenu();
        menuBarArchivoImportarCSV = new javax.swing.JMenuItem();
        menuBarArchivoExportarCSV = new javax.swing.JMenuItem();
        menuBarArchivoSeleccionarBBDD = new javax.swing.JMenuItem();
        menuBarArchivoSalir = new javax.swing.JMenuItem();
        menuBarCuentas = new javax.swing.JMenu();
        menuBarCuentasCrearNueva = new javax.swing.JMenuItem();
        menuBarCuentasCambiarNombre = new javax.swing.JMenuItem();
        menuBarCuentasIngresarRetirar = new javax.swing.JMenuItem();
        menuBarCuentasEliminarCuenta = new javax.swing.JMenuItem();
        menuBarCuentasRealizarTransferencia = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(664, 548));

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
        labelNombreBanco.setMinimumSize(new java.awt.Dimension(64, 17));
        labelNombreBanco.setPreferredSize(new java.awt.Dimension(128, 17));

        txtNombre.setToolTipText("");

        buttonBuscar.setText("Buscar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        labelDNICliente.setText("DNI Cliente");

        labelNombreCliente.setText("Nombre cliente");

        buttonRefrescarCuentas.setText("Mostrar todas las cuentas");
        buttonRefrescarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefrescarCuentasActionPerformed(evt);
            }
        });

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

        menuBarArchivoSeleccionarBBDD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBarArchivoSeleccionarBBDD.setMnemonic('b');
        menuBarArchivoSeleccionarBBDD.setText("Seleccionar BBDD ...");
        menuBarArchivoSeleccionarBBDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarArchivoSeleccionarBBDDActionPerformed(evt);
            }
        });
        menuBarArchivo.add(menuBarArchivoSeleccionarBBDD);

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

        menuBarCuentasIngresarRetirar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBarCuentasIngresarRetirar.setMnemonic('o');
        menuBarCuentasIngresarRetirar.setText("Ingresar o retirar ...");
        menuBarCuentasIngresarRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarCuentasIngresarRetirarActionPerformed(evt);
            }
        });
        menuBarCuentas.add(menuBarCuentasIngresarRetirar);

        menuBarCuentasEliminarCuenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBarCuentasEliminarCuenta.setMnemonic('e');
        menuBarCuentasEliminarCuenta.setText("Eliminar Cuenta ");
        menuBarCuentasEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarCuentasEliminarCuentaActionPerformed(evt);
            }
        });
        menuBarCuentas.add(menuBarCuentasEliminarCuenta);

        menuBarCuentasRealizarTransferencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBarCuentasRealizarTransferencia.setMnemonic('t');
        menuBarCuentasRealizarTransferencia.setText("Realizar Transferencia");
        menuBarCuentasRealizarTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarCuentasRealizarTransferenciaActionPerformed(evt);
            }
        });
        menuBarCuentas.add(menuBarCuentasRealizarTransferencia);

        menuBar.add(menuBarCuentas);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(labelCuentas)
                                .addGap(509, 509, 509))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(296, 296, 296)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDNICliente)
                                    .addComponent(labelNombreCliente)
                                    .addComponent(labelNombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonRefrescarCuentas))
                                    .addComponent(txtNombre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDNICliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreCliente)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCuentas))
                    .addComponent(buttonRefrescarCuentas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void menuBarCuentasIngresarRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarCuentasIngresarRetirarActionPerformed
        PanelIngresarRetirar panelIngresarRetirar = new PanelIngresarRetirar(banco);
        int result = JOptionPane.showConfirmDialog(null, panelIngresarRetirar,
            "Encontrar Cuenta por DNI", JOptionPane.PLAIN_MESSAGE);
        if(result == JOptionPane.OK_OPTION) {
            refrescarTabla();
        }

    }//GEN-LAST:event_menuBarCuentasIngresarRetirarActionPerformed

    private void menuBarCuentasCambiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarCuentasCambiarNombreActionPerformed
        PanelCambiarNombreCuenta panelCambiarNombreCuenta = new PanelCambiarNombreCuenta(banco);
        int result = JOptionPane.showConfirmDialog(null, panelCambiarNombreCuenta,
            "Cambiar nombre cliente de cuenta existente", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);
        try{
            if(result == JOptionPane.OK_OPTION) {
                String dni = panelCambiarNombreCuenta.getDNI().toUpperCase();
                String nuevoNombre = panelCambiarNombreCuenta.getNuevoNombre();
                banco.cambiarNombre(dni, nuevoNombre);
                refrescarTabla();
            }
        } catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "DNI no válido", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuBarCuentasCambiarNombreActionPerformed

    private void menuBarCuentasCrearNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarCuentasCrearNuevaActionPerformed
        PanelCrearNuevaCuenta panelCrearNuevaCuenta = new PanelCrearNuevaCuenta();
        int result = JOptionPane.showConfirmDialog(null, panelCrearNuevaCuenta,
            "Crear Nueva Cuenta", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);

        try {
            if(result == JOptionPane.OK_OPTION) {
                String dni = panelCrearNuevaCuenta.getDNI().toUpperCase();
                String nombreCliente = panelCrearNuevaCuenta.getNombreCliente();
                banco.crearCuenta(dni, nombreCliente);
                refrescarTabla();
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "DNI no válido", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuBarCuentasCrearNuevaActionPerformed

    private void buttonRefrescarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefrescarCuentasActionPerformed
        refrescarTabla();
    }//GEN-LAST:event_buttonRefrescarCuentasActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        String dni = txtDNI.getText().toUpperCase();
        String nombre = txtNombre.getText();
        refrescarTabla(dni, nombre);
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void menuBarArchivoSeleccionarBBDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarArchivoSeleccionarBBDDActionPerformed
        PanelSeleccionarBBDD panelSeleccionarBBDD = new PanelSeleccionarBBDD();
        int result = JOptionPane.showConfirmDialog(null, panelSeleccionarBBDD,
            "Selecciona Base de Datos", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);
        try{
            if(result == JOptionPane.OK_OPTION) {
                dao.setRutaBBDD(panelSeleccionarBBDD.getRutaBBDD());
                refrescarTabla();
            }
        } catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Ruta no válida", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuBarArchivoSeleccionarBBDDActionPerformed

    private void menuBarCuentasEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarCuentasEliminarCuentaActionPerformed
        PanelEliminarCuenta panelEliminarCuenta = new PanelEliminarCuenta();
        int result = JOptionPane.showConfirmDialog(null, panelEliminarCuenta,
            "Eliminar Cuenta", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);

        try {
            if(result == JOptionPane.OK_OPTION) {
                String dni = panelEliminarCuenta.getDNI().toUpperCase();
                banco.eliminarCuenta(dni);
                refrescarTabla();
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "DNI no válido", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuBarCuentasEliminarCuentaActionPerformed

    private void menuBarCuentasRealizarTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarCuentasRealizarTransferenciaActionPerformed
        PanelRealizarTransferencia panelRealizarTransferencia = new PanelRealizarTransferencia();
        int result = JOptionPane.showConfirmDialog(null, panelRealizarTransferencia,
            "Realiza una Transferencia", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);

        try {
            if(result == JOptionPane.OK_OPTION) {
                String dniRemitente = panelRealizarTransferencia.getDNIRemitente();
                String dniDestinatario = panelRealizarTransferencia.getDNIDestinatario();
                Float cantidad = panelRealizarTransferencia.getCantidad();
                banco.hacerTransferencia(dniRemitente, dniDestinatario, cantidad);
                refrescarTabla();
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Transferencia no válida", "Error.", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_menuBarCuentasRealizarTransferenciaActionPerformed
    public void refrescarTabla(String dni, String nombre) {
        DefaultTableModel modelo = (DefaultTableModel)tablaCuentas.getModel();
        modelo.setRowCount(0);
        List<Cuenta> cuentas = banco.getCuentas(dni, nombre);
        for (Cuenta cuenta : cuentas) {
            modelo.addRow(new Object[]{
                cuenta.getNumeroCuenta(),
                cuenta.getNombreCliente(),
                cuenta.getSaldoDosDecimales(),
                cuenta.getFechaCreacion()
            });
        }
    } 

    public void refrescarTabla() {
        DefaultTableModel modelo = (DefaultTableModel)tablaCuentas.getModel();
        modelo.setRowCount(0);
        List<Cuenta> cuentas = banco.getCuentas();
        for (Cuenta cuenta : cuentas) {
            modelo.addRow(new Object[]{
                cuenta.getNumeroCuenta(),
                cuenta.getNombreCliente(),
                cuenta.getSaldoDosDecimales(),
                cuenta.getFechaCreacion()
            });
        }
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonRefrescarCuentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCuentas;
    private javax.swing.JLabel labelDNICliente;
    private javax.swing.JLabel labelNombreBanco;
    private javax.swing.JLabel labelNombreCliente;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBarArchivo;
    private javax.swing.JMenuItem menuBarArchivoExportarCSV;
    private javax.swing.JMenuItem menuBarArchivoImportarCSV;
    private javax.swing.JMenuItem menuBarArchivoSalir;
    private javax.swing.JMenuItem menuBarArchivoSeleccionarBBDD;
    private javax.swing.JMenu menuBarCuentas;
    private javax.swing.JMenuItem menuBarCuentasCambiarNombre;
    private javax.swing.JMenuItem menuBarCuentasCrearNueva;
    private javax.swing.JMenuItem menuBarCuentasEliminarCuenta;
    private javax.swing.JMenuItem menuBarCuentasIngresarRetirar;
    private javax.swing.JMenuItem menuBarCuentasRealizarTransferencia;
    private javax.swing.JTable tablaCuentas;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}