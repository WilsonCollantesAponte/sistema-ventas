/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.batteryworkshop.view.modal;

import com.batteryworkshop.model.Categoria;
import com.batteryworkshop.model.dao.CategoriaDao;
import com.batteryworkshop.model.dao.ProductoDao;
import com.batteryworkshop.model.Producto;
import com.batteryworkshop.view.FrmGestionarProducto;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JuniorMiguel
 */
public class FrmRegistrarProducto extends javax.swing.JInternalFrame {

    ProductoDao productoC = new ProductoDao();
    CategoriaDao categoriaC = new CategoriaDao();
    public static int idProducto = 0;
    public static boolean vista = false;

    /**
     * Creates new form FrmRegistroProducto
     */
    public FrmRegistrarProducto() {
        initComponents();
        cargarRoles();
        acciones();
    }

    private void cargarRoles() {

        cmbCategoria.removeAllItems();
        List lista = categoriaC.listar();
        Categoria categoria;

        for (int i = 0; i < lista.size(); i++) {
            categoria = (Categoria) lista.get(i);
            cmbCategoria.addItem(categoria.getDescripcion());
        }
    }

    void acciones() {

        if (vista) {

            txtCodigo.setEnabled(false);
            txtNombre.setEnabled(false);
            txtDescripcion.setEnabled(false);
            txtStock.setEnabled(false);
            txtPrecioCompra.setEnabled(false);
            cmbCategoria.setEnabled(false);
            txtPrecioVenta.setEnabled(false);
            cmdGrabar.setEnabled(false);

        }
        if (idProducto > 0) {

            Producto productoV = (Producto) productoC.obtenerObjecto(idProducto);
            txtCodigo.setText(productoV.getCodigo());
            txtNombre.setText(productoV.getNombre());
            txtDescripcion.setText(productoV.getDescripcion());
            cmbCategoria.setSelectedItem(productoV.getCategoria().getDescripcion());
//            txtStock.setText(Integer.parseInt(productoV.getStock()));
//            txtPrecioVenta.setText(Float.parseFloat(productoV.getPrecioCompra()));
//            txtDescripcion.setText(productoV.getApellidos());
//            txtFecha.setDate(productoV.getFechaNacimiento());       
        }

    }

    void grabar() {

        Producto producto = new Producto();
        producto.setCodigo(txtCodigo.getText());
        producto.setNombre(txtNombre.getText().toUpperCase());
        producto.setDescripcion(txtDescripcion.getText().toUpperCase());
        producto.setCategoria((Categoria) categoriaC.obtenerObjecto(cmbCategoria.getSelectedItem().toString()));
        producto.setStock(Integer.parseInt(txtPrecioVenta.getText()));
        producto.setPrecioCompra(Float.parseFloat(txtPrecioCompra.getText()));
        producto.setPrecioVenta(Float.parseFloat(txtPrecioVenta.getText()));
        
        

        if (cmdGrabar.getText().equalsIgnoreCase("Grabar")) {
            try {
                productoC.registrar(producto);
                JOptionPane.showMessageDialog(null, "Producto Se Registro Correctamente");
//                AlertaBien alerta = new AlertaBien("MENSAJE", "El producto se registro correctamente");
                this.dispose();
                FrmGestionarProducto.listar("");

            } catch (Exception e) {
//                AlertaError error = new AlertaError("ERROR", e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            try {
                producto.setProductoId(idProducto);
                productoC.editar(producto);
//                AlertaBien alerta = new AlertaBien("MENSAJE", "El producto se actulizó correctamente");
                JOptionPane.showMessageDialog(null, "Los Datos Se Actualizarón Correctamente");
                this.dispose();
                FrmGestionarProducto.listar("");

            } catch (Exception e) {
//                AlertaError error = new AlertaError("ERROR", e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        cmdGrabar = new javax.swing.JButton();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Producto");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Codigo");

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Nombres*");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Descripcion*");

        txtNombre.setMinimumSize(new java.awt.Dimension(64, 17));
        txtNombre.setPreferredSize(new java.awt.Dimension(69, 20));

        txtCodigo.setMinimumSize(new java.awt.Dimension(64, 17));
        txtCodigo.setPreferredSize(new java.awt.Dimension(69, 20));

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Categoria");

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Stock");

        txtStock.setMinimumSize(new java.awt.Dimension(64, 17));
        txtStock.setPreferredSize(new java.awt.Dimension(69, 20));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Precio Venta");

        txtPrecioVenta.setMinimumSize(new java.awt.Dimension(64, 17));
        txtPrecioVenta.setPreferredSize(new java.awt.Dimension(69, 20));

        txtDescripcion.setMinimumSize(new java.awt.Dimension(64, 17));
        txtDescripcion.setPreferredSize(new java.awt.Dimension(69, 20));

        cmdGrabar.setBackground(new java.awt.Color(27, 118, 253));
        cmdGrabar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cmdGrabar.setForeground(new java.awt.Color(255, 255, 255));
        cmdGrabar.setMnemonic('N');
        cmdGrabar.setText("Grabar");
        cmdGrabar.setToolTipText("Realizar Nuevo Registro");
        cmdGrabar.setBorder(null);
        cmdGrabar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGrabarActionPerformed(evt);
            }
        });

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Precio Compra");

        txtPrecioCompra.setMinimumSize(new java.awt.Dimension(64, 17));
        txtPrecioCompra.setPreferredSize(new java.awt.Dimension(69, 20));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Activo", "Inactivo" }));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdGrabar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCategoria)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(35, 35, 35)))
                .addGap(18, 18, 18)
                .addComponent(cmdGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGrabarActionPerformed
        grabar();

    }//GEN-LAST:event_cmdGrabarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        idProducto = 0;
        vista = false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        idProducto = 0;
        vista = false;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEstado;
    public static javax.swing.JButton cmdGrabar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
