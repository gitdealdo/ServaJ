/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.serva.ui;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.upeu.serva.dao.DAO;
import pe.upeu.serva.dao.IngredienteDAO;
import pe.upeu.serva.dao.ProductoDAO;
import pe.upeu.serva.dao.RecetaDAO;
import pe.upeu.serva.entity.Ingrediente;
import pe.upeu.serva.entity.Producto;
import pe.upeu.serva.entity.Receta;
import pe.upeu.serva.entity.Unidad;

/**
 *
 * @author hikaru
 */
public class RecetaForm extends javax.swing.JFrame {

    Receta receta = new Receta();
    DAO dao = new DAO();
    ProductoDAO pdao = new ProductoDAO();
    RecetaDAO rdao = new RecetaDAO();    
    IngredienteDAO idao = new IngredienteDAO();
    Map prodMap = new HashMap();
    Icon iconDelete = new ImageIcon(getClass().getResource("/pe/upeu/serva/resources/Erase.png"));
    Producto p = new Producto();
    List lista = new ArrayList();
    int index;
    double total = 0.00;
    
    public RecetaForm() {
        initComponents();  
        setLocationRelativeTo(null);
    }
      
    public void nuevaReceta(){
        this.setTitle("Nueva receta");
        this.setVisible(true);
    }
    
    public void editarReceta(String id){
        Map m = rdao.editar(Long.parseLong(id));
        this.setTitle("Editar receta");
        this.setVisible(true);
        try {
            lblId.setText(id);
            txtPorcion.setText(m.get("porcion").toString());
            txtNombre.setText(m.get("nombre").toString());
            txtPreparacion.setText(m.get("prep").toString());
            txtDescripcion.setText(m.get("desc").toString());
            lista = (List) m.get("ingredientes");
            displayResult(lista);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPorcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPreparacion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        lblIdIng = new javax.swing.JLabel();
        txtProducto = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblIngrediente = new javax.swing.JTable();
        lblDelete = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Porción:");

        txtPorcion.setText("1");
        txtPorcion.setToolTipText("Para cuantas personas");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Preparación:");

        txtPreparacion.setColumns(20);
        txtPreparacion.setRows(5);
        jScrollPane1.setViewportView(txtPreparacion);

        jLabel4.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingredientes"));

        jLabel5.setText("Buscar producto:");

        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });

        txtProducto.setText("producto");

        txtCantidad.setText("1");
        txtCantidad.setToolTipText("Cantidad del ingrediente");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblIngrediente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblIngrediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIngredienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblIngrediente);

        lblDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProducto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIdIng)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDelete)
                        .addGap(4, 4, 4)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(lblIdIng)
                    .addComponent(lblDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPorcion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNombre)))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelTotal)
                        .addGap(119, 119, 119)
                        .addComponent(btnGuardar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(jLabel1)
                    .addComponent(txtPorcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(labelTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        try {
            prodMap = pdao.buscarProducto(txtBuscarProducto.getText());
            txtProducto.setText(prodMap.get("prodNombre")+" "+prodMap.get("unidad"));
            txtProducto.setForeground(Color.blue);
            lblDelete.setIcon(null);
            lblIdIng.setText("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            txtProducto.setText("No existe el producto");
            txtProducto.setForeground(Color.red);
//            JOptionPane.showMessageDialog(null, "No existe el producto");
        }
    }//GEN-LAST:event_txtBuscarProductoKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {      
            System.out.println(prodMap);
            Map m = new HashMap();
            m.put("producto", prodMap.get("producto"));
            m.put("prodNombre", prodMap.get("prodNombre"));
            m.put("cantidad", txtCantidad.getText());
            m.put("unidad", prodMap.get("unidad"));
            m.put("costo", Double.parseDouble(prodMap.get("costo").toString()) * Double.parseDouble(txtCantidad.getText()));
            m.put("idIng", "0");
            lista.add(m);
            System.out.println(lista);
//            lista.add(new Producto(p.getId(), p.getNombre(), Long.parseLong(txtCantidad.getText())));
            displayResult(lista);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (txtPorcion.getText().isEmpty() || txtNombre.getText().isEmpty()) {                
                JOptionPane.showMessageDialog(null, "Los campos porción y nombre no pueden ir vacios");
            }else{
                receta.setNombre(txtNombre.getText());
                receta.setPorcion(Integer.parseInt(txtPorcion.getText()));
                receta.setPreparacion(txtPreparacion.getText());
                receta.setDescripcion(txtDescripcion.getText());
                receta.setCosto(total);
                /*HashSet set1 = new HashSet();
                for (Object o : listab) {
                    Map m = (Map) o;
                    Producto producto = (Producto) m.get("producto");
                    Long cantidad = Long.parseLong(m.get("cantidad").toString());
                    String unidad = m.get("unidad").toString();
                    set1.add(new Ingrediente(cantidad, unidad));
                }
                receta.setIngredientes(set1);*/
                if (lblId.getText().isEmpty()) {
                    System.out.println("Registrando");
                    Object obj = dao.registrar(receta);
                    guardarIngredientes(obj.toString());
                }else{
                    System.out.println("Actualizando");
                    receta.setId(Long.parseLong(lblId.getText()));
                    dao.actualizar(receta);
                    guardarIngredientes(lblId.getText());
                }                
                this.setVisible(false);
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void lblDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMouseClicked
        try {
            Ingrediente ing = new Ingrediente();
            int confir = JOptionPane.showConfirmDialog(null,"¿Está seguro?");
            if (confir==0) {
                ing.setId(Long.parseLong(lblIdIng.getText()));
                if (lblIdIng.getText()!="0") {
                    System.out.println(lblIdIng.getText());
                    dao.eliminar(ing);
                }
                lista.remove(index);
                displayResult(lista);
                lblIdIng.setText("");
                txtProducto.setText("");
                lblDelete.setIcon(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_lblDeleteMouseClicked

    private void tblIngredienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIngredienteMouseClicked
        try {
            index = this.tblIngrediente.getSelectedRow();
            lblIdIng.setText(this.tblIngrediente.getValueAt(index,4).toString());
            txtProducto.setText((String) this.tblIngrediente.getValueAt(index,1));
            lblDelete.setIcon(iconDelete);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblIngredienteMouseClicked

    private void displayResult(List resultList) {
        System.out.println(resultList);
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("#");        
        tableHeaders.add("Producto");
        tableHeaders.add("Cantidad");
        tableHeaders.add("Unidad");        
        tableHeaders.add("id");
        int num = 1;
        total = 0;
        for (Object o : resultList) {
            Map m = (Map) o;
            total = total + (Double) m.get("costo");
//            System.out.println(new BigDecimal(m.get("costo").toString()));
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(num++);
            oneRow.add(m.get("prodNombre"));
            oneRow.add(m.get("cantidad"));
            oneRow.add(m.get("unidad"));
            oneRow.add(m.get("idIng"));
            tableData.add(oneRow);
        }
        labelTotal.setText("Total: "+total);
        tblIngrediente.setModel(new DefaultTableModel(tableData, tableHeaders));
    }
    
    private void guardarIngredientes(String receta_id) {        
        try {
            receta = rdao.buscarReceta(Long.parseLong(receta_id));
            for (Object o : lista) {
                Map m = (Map) o;
                if (m.get("idIng")=="0") {
                    Producto prod = (Producto) m.get("producto");                    
                    Double cantidad = Double.parseDouble(m.get("cantidad").toString()) ;
                    Double costo = (Double) m.get("costo");
                    dao.registrar(new Ingrediente(prod, receta, cantidad, costo));
                }                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdIng;
    private javax.swing.JTable tblIngrediente;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPorcion;
    private javax.swing.JTextArea txtPreparacion;
    private javax.swing.JLabel txtProducto;
    // End of variables declaration//GEN-END:variables
  
}
