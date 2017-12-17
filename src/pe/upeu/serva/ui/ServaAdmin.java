/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.serva.ui;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.upeu.serva.dao.DAO;
import pe.upeu.serva.dao.MenuDAO;
import pe.upeu.serva.dao.RecetaDAO;
import pe.upeu.serva.entity.Menu;
import pe.upeu.serva.entity.Receta;
import pe.upeu.serva.entity.Recetamenu;
import pe.upeu.serva.entity.Tipomenu;
import pe.upeu.serva.report.Reporte;

/**
 *
 * @author hikaru
 */
public class ServaAdmin extends javax.swing.JFrame {
    
    Icon iconClose = new ImageIcon(getClass().getResource("/pe/upeu/serva/resources/Turn_off.png"));
    Icon iconDown = new ImageIcon(getClass().getResource("/pe/upeu/serva/resources/Down.png"));
    Icon iconDel = new ImageIcon(getClass().getResource("/pe/upeu/serva/resources/Erase.png"));
    Icon iconRefresh = new ImageIcon(getClass().getResource("/pe/upeu/serva/resources/Refresh.png"));
    Date date = new Date();
    
    JFrame ujf = new UnidadJF();
    RecetasJF rjf = new RecetasJF();
    CategoriaJF cjf = new CategoriaJF();
    ProductoJF pjf = new ProductoJF();
    TipoMenuJF tmjf = new TipoMenuJF();
    MenuJF menujf = new MenuJF();
    DAO dao = new DAO();
    RecetaDAO rdao = new RecetaDAO();
    MenuDAO mdao = new MenuDAO();
    
    Receta rec = new Receta();
    Menu menu;
    Recetamenu rmenu;
    String MONEDA = "Soles";
    
    List lista = new ArrayList();
    int index;
    double menuCosto = 0;
    
    public ServaAdmin() {
        initComponents();
        initUI();        
        setTitle("ServA Application");
        setLocationRelativeTo(null);
        jmiUnidades.setToolTipText("Configurar unidades");
        labelAgregar.setIcon(iconDown);
        labelRefresh.setIcon(iconRefresh);
    }
    
    private void initUI() {
        comboTipo.removeAllItems();
        List tipos = dao.listar(new Tipomenu());
        for (Object tipo : tipos) {
            Tipomenu tm = (Tipomenu) tipo;
            comboTipo.addItem(tm.getNombre());
        }
        labelFecha.setText(getDate());
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private String getDate(){        
        SimpleDateFormat sdf = new SimpleDateFormat("E dd.MM.yyyy a");
//        SimpleDateFormat sdf = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");       
        return sdf.format(date);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        labelReceta = new javax.swing.JLabel();
        txtPorcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        labelAgregar = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        labelQuitar = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMenu = new javax.swing.JTable();
        buttonGuardarImprimir = new javax.swing.JButton();
        labelFecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelRefresh = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();
        jMConfigurar = new javax.swing.JMenu();
        jmiUnidades = new javax.swing.JMenuItem();
        jmiCategorias = new javax.swing.JMenuItem();
        jmiRecetas = new javax.swing.JMenuItem();
        jmiProductos = new javax.swing.JMenuItem();
        jmiTipo = new javax.swing.JMenuItem();
        jmMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Buscar receta:");

        txtBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        labelReceta.setText("Receta");

        jLabel3.setText("Porción");

        labelAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAgregarMouseClicked(evt);
            }
        });

        labelQuitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelQuitarMouseClicked(evt);
            }
        });

        labelDescripcion.setText("Descripción");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 197, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelReceta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPorcion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(labelAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelReceta)
                        .addComponent(txtPorcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        tableMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        tableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMenu);

        buttonGuardarImprimir.setText("Guardar");
        buttonGuardarImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarImprimirActionPerformed(evt);
            }
        });

        labelFecha.setText("Fecha");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("TOTAL:");

        labelTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(0, 102, 102));
        labelTotal.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTotal)
                .addGap(180, 180, 180))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Menu hoy");

        labelRefresh.setToolTipText("Refrescar");
        labelRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRefreshMouseClicked(evt);
            }
        });

        jMenu2.setText("File");

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/upeu/serva/resources/delete.png"))); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jMenu2.add(salir);

        jMenuBar2.add(jMenu2);

        jMConfigurar.setText("Configurar");

        jmiUnidades.setText("Unidades");
        jmiUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnidadesActionPerformed(evt);
            }
        });
        jMConfigurar.add(jmiUnidades);

        jmiCategorias.setText("Categorias");
        jmiCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCategoriasActionPerformed(evt);
            }
        });
        jMConfigurar.add(jmiCategorias);

        jmiRecetas.setText("Recetas");
        jmiRecetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRecetasActionPerformed(evt);
            }
        });
        jMConfigurar.add(jmiRecetas);

        jmiProductos.setText("Productos");
        jmiProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductosActionPerformed(evt);
            }
        });
        jMConfigurar.add(jmiProductos);

        jmiTipo.setText("Tipo Menu");
        jmiTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipoActionPerformed(evt);
            }
        });
        jMConfigurar.add(jmiTipo);

        jMenuBar2.add(jMConfigurar);

        jmMenu.setText("Menus");
        jmMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmMenuMouseClicked(evt);
            }
        });
        jMenuBar2.add(jmMenu);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(labelRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonGuardarImprimir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFecha)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonGuardarImprimir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnidadesActionPerformed
        ujf.setVisible(true);
    }//GEN-LAST:event_jmiUnidadesActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void jmiRecetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRecetasActionPerformed
        rjf.setVisible(true);
    }//GEN-LAST:event_jmiRecetasActionPerformed

    private void jmiCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCategoriasActionPerformed
        cjf.setVisible(true);
    }//GEN-LAST:event_jmiCategoriasActionPerformed

    private void jmiProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductosActionPerformed
        pjf.setVisible(true);
    }//GEN-LAST:event_jmiProductosActionPerformed
 
    private void jmiTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipoActionPerformed
        tmjf.setVisible(true);
    }//GEN-LAST:event_jmiTipoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        try {
            rec = rdao.buscarRecetaPorNombre(txtBuscar.getText());
            labelReceta.setText(rec.getNombre());
            labelDescripcion.setText(rec.getDescripcion());
            labelReceta.setForeground(Color.blue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            labelReceta.setText("La receta no existe!");
            labelReceta.setForeground(Color.red);
            labelDescripcion.setText("");
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void labelQuitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelQuitarMouseClicked
        try {
            int confir = JOptionPane.showConfirmDialog(null,"¿Está seguro?");
            if (confir==0) {
//                rec.setId(Long.parseLong(lblId.getText()));
//                dao.eliminar(tipo);
//                displayResult(dao.listar(tipo));
                lista.remove(index);
                displayResult(lista);
                limpiarFormulario();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_labelQuitarMouseClicked

    private void labelAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAgregarMouseClicked
        double costo = 0;
        try {
            Map ma = new HashMap();
            ma.put("receta", rec);
            ma.put("recetaNombre", rec.getNombre());
            ma.put("porcion", this.txtPorcion.getText());
            costo = (Double.parseDouble(rec.getCosto().toString())/rec.getPorcion()
                    ) * Double.parseDouble(this.txtPorcion.getText());
            ma.put("costo", costo);
            lista.add(ma);
            System.out.println(lista);
            displayResult(lista);
            limpiarFormulario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_labelAgregarMouseClicked

    private void tableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuMouseClicked
        try {
            index = this.tableMenu.getSelectedRow();
            this.labelReceta.setText((String) this.tableMenu.getValueAt(index,1));
            this.txtPorcion.setText(this.tableMenu.getValueAt(index,2).toString());
            labelQuitar.setIcon(iconDel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tableMenuMouseClicked

    private void buttonGuardarImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarImprimirActionPerformed
        try {
            menu = new Menu();
            menu.setTipoMenu(comboTipo.getSelectedItem().toString());
            menu.setFecha(new Date());
            menu.setCosto(menuCosto);
            String menu_id = dao.registrar(menu).toString();
            Menu me = mdao.getById(Long.parseLong(menu_id));
            System.out.println(me);
//            agregar lista
            rmenu = new Recetamenu();
            for (Object o : lista) {
                Map m = (Map)o;
                rmenu.setMenu(me);
                rmenu.setReceta((Receta) m.get("receta"));
                rmenu.setPorcion(Integer.parseInt(m.get("porcion").toString()));
                rmenu.setCosto(Double.parseDouble(m.get("costo").toString()));
                dao.registrar(rmenu);
            }
            lista = new ArrayList();
            displayResult(lista);
            int confir = JOptionPane.showConfirmDialog(null,"El menu fue guardado con exito!\n ¿Desea imprimir ahora?");
            if (confir==0) {
                Reporte reporte = new Reporte();
                reporte.generarReporte(Integer.parseInt(menu_id));
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_buttonGuardarImprimirActionPerformed

    private void labelRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMouseClicked
        initUI();
        limpiarFormulario();
        lista = new ArrayList();
        displayResult(lista);
        JOptionPane.showMessageDialog(null, "Refrescado");
    }//GEN-LAST:event_labelRefreshMouseClicked

    private void jmMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmMenuMouseClicked
        menujf.setVisible(true);
    }//GEN-LAST:event_jmMenuMouseClicked

    private void limpiarFormulario() {
        this.labelReceta.setText("");
        this.txtPorcion.setText("");
        this.txtBuscar.setText("");
        this.labelDescripcion.setText("");
        this.labelQuitar.setIcon(null);
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGuardarImprimir;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMConfigurar;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmMenu;
    private javax.swing.JMenuItem jmiCategorias;
    private javax.swing.JMenuItem jmiProductos;
    private javax.swing.JMenuItem jmiRecetas;
    private javax.swing.JMenuItem jmiTipo;
    private javax.swing.JMenuItem jmiUnidades;
    private javax.swing.JLabel labelAgregar;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelQuitar;
    private javax.swing.JLabel labelReceta;
    private javax.swing.JLabel labelRefresh;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JMenuItem salir;
    private javax.swing.JTable tableMenu;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtPorcion;
    // End of variables declaration//GEN-END:variables
   
    private void displayResult(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("#"); 
        tableHeaders.add("Nombre");
        tableHeaders.add("Porción");
        tableHeaders.add("Costo");
        int num = 0;
        menuCosto = 0;
        for(Object o : resultList) {
            num += 1;
            Map m = (Map)o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(num);
            oneRow.add(m.get("recetaNombre"));
            oneRow.add(m.get("porcion"));
//            oneRow.add(m.get("costo"));
            oneRow.add(String.format("%.2f", m.get("costo")));
            tableData.add(oneRow);
            menuCosto += Double.parseDouble(m.get("costo").toString());
        }
        labelTotal.setText(String.format("%.2f", menuCosto)+" "+MONEDA);
        tableMenu.setModel(new DefaultTableModel(tableData, tableHeaders));
        /**Redondeos a 2
        double roundOff = (double) Math.round(a * 100) / 100; 
        * ========
        double d = 2.34568;
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println(f.format(d));
        */
    }

}
