/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.batteryworkshop.view;

import com.batteryworkshop.controller.ClienteController;
import com.batteryworkshop.model.Cliente;
import com.batteryworkshop.properties.RenderTable;
import com.batteryworkshop.view.modal.FrmRegistrarCliente;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JuniorMiguel
 */
public class FrmGestionarCliente extends javax.swing.JInternalFrame {

    public static ClienteController clienteC= new ClienteController();

    /**
     * Creates new form FrmGestionarCliente
     */
    public FrmGestionarCliente() {
        initComponents();
        listar("");
    }

    public static void listar(String texto) {
        //agregar columnas
        String columnas[] = {"#", "Documento", "Nombre", "Email", "Telefono","Estado","","", ""};
        //me va ha permitir crear una tabla sombra  de cualquier clase y traer mis datos 
        DefaultTableModel modelo = new DefaultTableModel();
        for (String columns : columnas) {
            modelo.addColumn(columns);
        }
        //1 creo una lista
//        List lista;
        //2 traigo los datos de mi lista
//        Cliente rol;
        //3 creo un objeto
//        Object []  objeto = new Object[6];
//        //4 agregar las filas
//        for (int i = 0; i <lista.size(); i++) {
//            rol=(Cliente) lista.get(i);
//            objeto[0]=rol.getClienteId();
//            objeto[1]=rol.getDescripcion();
//            modelo.addRow(objeto);
//        }

        List lista;
        Cliente cliente;

        if (txtBuscar.getText().length() == 0) {
            lista = clienteC.listar();

        } else {
            lista = clienteC.listar(texto);
        }
        //lista.forEach((x)->{});funcion lamda
        
        for (Object obj : lista) {
            cliente = (Cliente) obj;

            ImageIcon iconoModi = new ImageIcon("src/main/java/com/batteryworkshop/image/editar.png");
            Icon btnModificar = new ImageIcon(iconoModi.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonModificar = new JButton("", btnModificar);
            botonModificar.setName("btnModificar");
            botonModificar.setToolTipText("modificar");
            botonModificar.setBorder(null);
            botonModificar.setBackground(new Color(255, 198, 26));

            ImageIcon icono = new ImageIcon("src/main/java/com/batteryworkshop/image/eliminar.png");
            Icon btnEliminar = new ImageIcon(icono.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonEliminar = new JButton("", btnEliminar);
            botonEliminar.setName("btnEliminar");
            botonEliminar.setToolTipText("eliminar");
            botonEliminar.setBorder(null);
            botonEliminar.setBackground(new Color(223, 68, 83));

            ImageIcon iconoVer = new ImageIcon("src/main/java/com/batteryworkshop/image/ver.png");
            Icon btnVer = new ImageIcon(iconoVer.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonVer = new JButton("", btnVer);
            botonVer.setName("btnVer");
            botonVer.setToolTipText("vista del registro");
            botonVer.setBorder(null);
            botonVer.setBackground(new Color(41, 143, 96));

            modelo.addRow(new Object[]{
                cliente.getClienteId(),
                cliente.getDocumento(),
                cliente.getNombres()+ " " + cliente.getApellidos(),
                cliente.getCorreo() ,
                cliente.getTelefono(),
                cliente.isEstado(),
                botonModificar,
                botonEliminar,
                botonVer
            });
        }
        tbListado.setRowHeight(30);
        tbListado.setModel(modelo);
        tbListado.setBackground(Color.WHITE);
        tbListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbListado.getColumnModel().getColumn(0).setMaxWidth(0);
        tbListado.getColumnModel().getColumn(0).setMinWidth(0);
        tbListado.getColumnModel().getColumn(0).setPreferredWidth(0);
        tbListado.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbListado.getColumnModel().getColumn(2).setPreferredWidth(220);
        tbListado.getColumnModel().getColumn(3).setPreferredWidth(175);
        tbListado.getColumnModel().getColumn(4).setPreferredWidth(80);
        tbListado.getColumnModel().getColumn(5).setPreferredWidth(50);
        tbListado.getColumnModel().getColumn(6).setPreferredWidth(30);
        tbListado.getColumnModel().getColumn(7).setPreferredWidth(30);
        tbListado.getColumnModel().getColumn(8).setPreferredWidth(30);
        lblTotal.setText("" + tbListado.getRowCount());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListado = new javax.swing.JTable();
        cmdAgregar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestionar Cliente");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscar.setBackground(new java.awt.Color(223, 235, 255));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tbListado = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tbListado.setDefaultRenderer(Object.class, new RenderTable());
        tbListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListado);

        cmdAgregar.setBackground(new java.awt.Color(27, 118, 253));
        cmdAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas20.png"))); // NOI18N
        cmdAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(27, 118, 253));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar20.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
                        .addComponent(cmdAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarActionPerformed
        FrmMenuPrincipal.centrarVentana(new FrmRegistrarCliente());

    }//GEN-LAST:event_cmdAgregarActionPerformed

    private void tbListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListadoMouseClicked

        //capturo seleccion de fila 0
        int fila = tbListado.getSelectedRow();
        //de la tabla traeme el valor de la fila 0 y traeme el 0 trael el id
        int id = Integer.parseInt(tbListado.getValueAt(fila, 0).toString());
        //de la columna que tenga un alto de x y 
        int colum = tbListado.getColumnModel().getColumnIndexAtX(evt.getX());
        //cuando de un click en el boton  
        int row = evt.getY() / tbListado.getRowHeight();

        if (row < tbListado.getRowCount() && row >= 0 && colum < tbListado.getColumnCount() && colum >= 0) {
            Object value = tbListado.getValueAt(row, colum);

            if (value instanceof JButton jButton) {
                jButton.doClick();
                JButton boton = jButton;
                int filas = tbListado.getSelectedRowCount();

                switch (boton.getName()) {
                    case "btnEliminar" -> {
                        if (filas == 0) {//si no elije ninguna fila
                            JOptionPane.showMessageDialog(null, "Datos Inexistente");
//                          
                        } else {
                            String valor = String.valueOf(tbListado.getValueAt(fila, 1));

                            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el Cliente " + valor + "?", "Confirmar", 2);
                            if (opcion == 0) {

                                try {
                                    clienteC.eliminar(id);
                                    JOptionPane.showMessageDialog(null, "Cliente Eliminado Correctamente");
//                                    AlertaBien alertaBien = new AlertaBien("Mensaje", "Cliente eliminado correctamente!");
                                    listar("");
                                } catch (Exception ex) {
//                                    AlertaError err = new AlertaError("ERROR", ex.getMessage());
                                    JOptionPane.showMessageDialog(null, ex.getMessage());
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Operacion Cancelada");
//                                Alerta alerta = new Alerta("Alerta", "Operación cancelada!");
                            }

                        }
                    }
                    case "btnModificar" -> {
                        if (filas == 0) {//si no elije ninguna fila
//                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un Cliente");
                            JOptionPane.showMessageDialog(null, "Debe Seleccionar Un Cliente");
                        } else {
//                            FrmRegistrarCliente.idCliente = id;
                            FrmMenuPrincipal.centrarVentana(new FrmRegistrarCliente());
//                            FrmRegistrarCliente.cmdGrabar.setText("Modificar");

                        }
                    }
                    case "btnPermiso" -> {
//                        FrmGestionarPermiso.idCliente = id;
//                        FrmMenuPrincipal.centrarVentana(new FrmGestionarPermiso());
                    }
                    case "btnVer" -> {
                        if (filas == 0) {
//                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un tipo");
                            JOptionPane.showMessageDialog(null, "Debe Seleccionar Un Cliente");
                        } else {
//                            FrmRegistrarCliente.vista = true;
//                            FrmRegistrarCliente.idCliente = id;
                            FrmMenuPrincipal.centrarVentana(new FrmRegistrarCliente());
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tbListadoMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (txtBuscar.getText().length() % 2 == 0) {
            listar(txtBuscar.getText().toUpperCase());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAgregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JTable tbListado;
    public static javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}