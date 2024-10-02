/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframes;

import cjb.ci.Mensaje;
import cjb.ci.Validaciones;
import clases.NodoLista;
import clases.Multilista;
import clases.Archivo;
import clases.Metodos;
import clases.NodoArbol;
import clases.TablaHashArbol;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import static jframes.VtnElementosAEliminar.cargaTablaArchivos;
import static jframes.VtnElementosAEliminar.modelo;

/**
 *
 * @author Lenovo
 */
public class VtnPrincipal extends javax.swing.JFrame
{

    int xMouse, yMouse;
    public static TablaHashArbol tbh = new TablaHashArbol();
    public static NodoLista r = null;//r de la multilista, en mi caso r está en la parte de atras, es el mismo caso para la doblemente ligada
    public static DefaultTreeModel modelo;
    public static DefaultMutableTreeNode nodoSeleccionado;
    public static boolean desactivaPopMenuEnBusqueda = true;
    //variables para eliminar
    public String elementoBuscado;
    public String nombreElementoEliminar;
    //variables para el Copiar
    public int copiarPegar = -1;
    public static NodoLista<Archivo> nodoCopiar;
    public ArrayList<JLabel> arregloLablesParaLimpiar = new ArrayList<>();
    public boolean soloUnoSelecciona = true;
    String textoConFormato = "";
    //variables para mover
    TreePath ultimoSeleccion = null;
    NodoLista<Archivo> movido;
    DefaultMutableTreeNode raiz = null;

    /**
     * Creates new form VtnPrincipal
     */
    public VtnPrincipal()
    {
        initComponents();
        Metodos.evitaCopiar(jtextBuscador);
        Metodos.evitaPegar(jtextBuscador);
        jCarpetas.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jCarpetas.setCellRenderer(new DefaultTreeCellRenderer()
        {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel,
                    boolean expanded, boolean leaf, int row,
                    boolean hasFocus)
            {
                JLabel label = (JLabel) super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

                if (sel)
                {
                    label.setOpaque(true);
                    label.setBackground(new Color(252, 252, 252));
                    label.setForeground(Color.BLACK);
                } else
                {
                    label.setBackground(new Color(252, 252, 252)); // Cambia el fondo a blanco
                    label.setOpaque(false); // Establece el componente como no opaco para que no pinte ningún color de fondo
                    label.setForeground(Color.BLACK);
                }
                if (tree.getModel().getRoot().equals(value))
                {
                    label.setIcon(new ImageIcon("src/imagenes/OneDrive.png"));
                } else
                {
                    label.setIcon(new ImageIcon("src/imagenes/folder.png"));
                }

                return label;
            }
        });
        this.setLocationRelativeTo(null);

        jCarpetas.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (SwingUtilities.isRightMouseButton(e) && nodoSeleccionado != null)
                {
                    if (((NodoLista) nodoSeleccionado.getUserObject()).getEtiqueta().equals("Archivos"))
                    {
                        menuItemMostrar.setVisible(false);
                        menuItemEliminar.setVisible(false);
                    } else
                    {
                        menuItemMostrar.setVisible(true);
                        menuItemEliminar.setVisible(true);
                    }
                    popMenuCarpetas.show(jCarpetas, e.getX(), e.getY());
                }
            }
        });
        menuPegar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        popMenuCarpetas = new javax.swing.JPopupMenu();
        menuItemCarpeta = new javax.swing.JMenuItem();
        menuPegar = new javax.swing.JMenuItem();
        menuItemMostrar = new javax.swing.JMenuItem();
        menuItemEliminar = new javax.swing.JMenuItem();
        popMenuCentro = new javax.swing.JPopupMenu();
        menuItemCopiar = new javax.swing.JMenuItem();
        menuItemMover = new javax.swing.JMenuItem();
        menuItemEliminarCentro = new javax.swing.JMenuItem();
        menuItemVerCentro = new javax.swing.JMenuItem();
        cabecera = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        ultimoPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jCarpetas = new javax.swing.JTree();
        jScrolPanelFondo = new javax.swing.JScrollPane();
        jPanelFondo = new javax.swing.JPanel();
        jPanelArribaCentro = new javax.swing.JPanel();
        jtextBuscador = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        jLabelRuta = new javax.swing.JLabel();

        menuItemCarpeta.setText("Alta");
        menuItemCarpeta.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuItemCarpetaActionPerformed(evt);
            }
        });
        popMenuCarpetas.add(menuItemCarpeta);

        menuPegar.setText("Pegar");
        menuPegar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuPegarActionPerformed(evt);
            }
        });
        popMenuCarpetas.add(menuPegar);

        menuItemMostrar.setText("Ver");
        menuItemMostrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuItemMostrarActionPerformed(evt);
            }
        });
        popMenuCarpetas.add(menuItemMostrar);

        menuItemEliminar.setText("Eliminar");
        menuItemEliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuItemEliminarActionPerformed(evt);
            }
        });
        popMenuCarpetas.add(menuItemEliminar);

        menuItemCopiar.setText("Copiar");
        menuItemCopiar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuItemCopiarActionPerformed(evt);
            }
        });
        popMenuCentro.add(menuItemCopiar);

        menuItemMover.setText("Mover");
        menuItemMover.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuItemMoverActionPerformed(evt);
            }
        });
        popMenuCentro.add(menuItemMover);

        menuItemEliminarCentro.setText("Eliminar");
        menuItemEliminarCentro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuItemEliminarCentroActionPerformed(evt);
            }
        });
        popMenuCentro.add(menuItemEliminarCentro);

        menuItemVerCentro.setText("Ver");
        menuItemVerCentro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuItemVerCentroActionPerformed(evt);
            }
        });
        popMenuCentro.add(menuItemVerCentro);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 509));
        setMinimumSize(new java.awt.Dimension(960, 509));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(960, 509));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        cabecera.setBackground(new java.awt.Color(132, 165, 214));
        cabecera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                cabeceraMouseDragged(evt);
            }
        });
        cabecera.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                cabeceraMousePressed(evt);
            }
        });

        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cerrar.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btnCerrarMouseClicked(evt);
            }
        });

        btnMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimizar.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btnMinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout cabeceraLayout = new javax.swing.GroupLayout(cabecera);
        cabecera.setLayout(cabeceraLayout);
        cabeceraLayout.setHorizontalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cabeceraLayout.createSequentialGroup()
                .addContainerGap(845, Short.MAX_VALUE)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cabeceraLayout.setVerticalGroup(
            cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cabeceraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        getContentPane().add(cabecera);
        cabecera.setBounds(0, 0, 960, 50);

        ultimoPanel.setBackground(new java.awt.Color(252, 252, 252));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jCarpetas.setBackground(new java.awt.Color(252, 252, 252));
        jCarpetas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jCarpetas.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jCarpetas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCarpetas.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener()
        {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt)
            {
                jCarpetasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jCarpetas);

        jScrolPanelFondo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanelFondo.setBackground(new java.awt.Color(220, 230, 244));
        jPanelFondo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanelFondo.setToolTipText("");
        jPanelFondo.setLayout(new java.awt.GridLayout(0, 1));
        jScrolPanelFondo.setViewportView(jPanelFondo);

        jPanelArribaCentro.setBackground(new java.awt.Color(252, 252, 252));
        jPanelArribaCentro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtextBuscador.setBackground(new java.awt.Color(252, 252, 252));
        jtextBuscador.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jtextBuscador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtextBuscador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jtextBuscador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtextBuscador.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jtextBuscadorKeyTyped(evt);
            }
        });
        jPanelArribaCentro.add(jtextBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 240, 30));

        btnBusca.setBackground(new java.awt.Color(252, 252, 252));
        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        btnBusca.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBusca.setBorderPainted(false);
        btnBusca.setContentAreaFilled(false);
        btnBusca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBusca.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBuscaActionPerformed(evt);
            }
        });
        jPanelArribaCentro.add(btnBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 80, 50));

        jLabelRuta.setBackground(new java.awt.Color(252, 252, 252));
        jLabelRuta.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabelRuta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabelRuta.setOpaque(true);
        jPanelArribaCentro.add(jLabelRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 480, 30));

        javax.swing.GroupLayout ultimoPanelLayout = new javax.swing.GroupLayout(ultimoPanel);
        ultimoPanel.setLayout(ultimoPanelLayout);
        ultimoPanelLayout.setHorizontalGroup(
            ultimoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
            .addGroup(ultimoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ultimoPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(ultimoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ultimoPanelLayout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addComponent(jPanelArribaCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ultimoPanelLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jScrolPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ultimoPanelLayout.setVerticalGroup(
            ultimoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
            .addGroup(ultimoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ultimoPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelArribaCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jScrolPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(ultimoPanelLayout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(ultimoPanel);
        ultimoPanel.setBounds(0, 50, 960, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCarpetaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuItemCarpetaActionPerformed
    {//GEN-HEADEREND:event_menuItemCarpetaActionPerformed
        if (nodoSeleccionado != null)
        {
            new VtnFormularioArchivo(this, true).setVisible(true);
//            recorreNodosApartirDelSeleccionado();
            Metodos.limpiarFondo();
            jCarpetas.clearSelection();
        }
    }//GEN-LAST:event_menuItemCarpetaActionPerformed

    private void jCarpetasValueChanged(javax.swing.event.TreeSelectionEvent evt)//GEN-FIRST:event_jCarpetasValueChanged
    {//GEN-HEADEREND:event_jCarpetasValueChanged

        /*
            La variable nodoSeleccionado
            obtiene la carpeta del seleccionado, al darle clic a la izquierda se obtiene el nodo que contiene todo el objeto
         */
        nodoSeleccionado = (DefaultMutableTreeNode) jCarpetas.getLastSelectedPathComponent();

        /*
            Este método lo que hace es que no importe la carpeta que seleccione de lado izquierdo va a mostrar todas las carpetas
            y archivos que contiene, es decir a sus hijos.
         */
        if (nodoSeleccionado != null)
        {
            jLabelRuta.setText("C:\\" + Metodos.despliegaRuta(Metodos.concatenarStrings()));
            recorreNodosApartirDelSeleccionado();
            NodoLista<Archivo> nodo = (NodoLista) VtnPrincipal.nodoSeleccionado.getUserObject();

            if (nodo.getObj() != null)
            {
                int total = Metodos.calculoPeso(nodo.getAbajo(), nodo.getAbajo(), 0);
                nodo.getObj().setTamanio(total);
            }
            desactivaPopMenuEnBusqueda = true;
        }
        soloUnoSelecciona = true;

    }//GEN-LAST:event_jCarpetasValueChanged

    private void menuItemCopiarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuItemCopiarActionPerformed
    {//GEN-HEADEREND:event_menuItemCopiarActionPerformed

        if (nodoSeleccionado != null)
        {
            NodoLista n = ((NodoLista) nodoSeleccionado.getUserObject());

            try
            {
                if (!n.getEtiqueta().equals("Archivos"))
                {
                    boolean mensaje = false;
                    NodoLista buscado = Metodos.buscaArchivo(n.getAbajo(), nombreElementoEliminar);
                    if (buscado != null)
                    {
                        if (((Archivo) buscado.getObj()).getTipo() != 'C')
                        {
                            nodoCopiar = (NodoLista) buscado.clone();
                            copiarPegar = 0;
                            menuPegar.setVisible(true);
                        } else
                        {
                            mensaje = true;
                        }
                    } else
                    {
                        mensaje = true;
                    }
                    if (mensaje)
                    {
                        Metodos.limpiaCampos(arregloLablesParaLimpiar);
                        JOptionPane.showMessageDialog(null, "No puedes copiar una carpeta", "Aviso", JOptionPane.WARNING_MESSAGE);
                        soloUnoSelecciona = true;
                    }
                } else
                {
                    JOptionPane.showMessageDialog(null, "No puedes copiar la carpeta Archivos", "Aviso", JOptionPane.WARNING_MESSAGE);
                }

            } catch (CloneNotSupportedException ex)
            {
                Logger.getLogger(VtnPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Selecciona una carpeta de lado izquierdo", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_menuItemCopiarActionPerformed

    private void menuPegarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuPegarActionPerformed
    {//GEN-HEADEREND:event_menuPegarActionPerformed
        if (nodoSeleccionado != null)
        {
            NodoLista<Archivo> nodo = (NodoLista) VtnPrincipal.nodoSeleccionado.getUserObject();;
            switch (copiarPegar)//Este es el caso en el que se quiera copiar
            {
                case 0:
                    NodoLista<Archivo> nodoCopy = Metodos.verificaSiHayDosArchivosIguales(nodo, nodoCopiar.getEtiqueta(), nodoCopiar);
                    nodoCopy.getObj().setRuta("C:\\" + Metodos.despliegaRuta(Metodos.concatenarStrings()));
                    nodoCopy.setArriba(null);
                    VtnPrincipal.r = Multilista.inserta(VtnPrincipal.r, 0, Metodos.concatenarStrings().split(","), nodoCopy);
                    tbh.inserta(new NodoArbol(nodoCopy.getEtiqueta(), nodoCopy));
                    nodoCopiar = null;
                    copiarPegar = -1;

                    //calcular el peso
                    Metodos.calculaDeNuevoPeso(nodo);
                    jCarpetas.clearSelection();
                    Metodos.limpiarFondo();
                    break;
                case 1:
                    if (movido != null)//caso en caso de que se quiera mover
                    {
                        if (!Metodos.verificaArchivosRegistrados(movido.getEtiqueta(), movido.getObj().getTipo(), nodo))
                        {
                            if (Metodos.verificaSiEsPadre(movido, (NodoLista<Archivo>) nodoSeleccionado.getUserObject()))
                            {
                                NodoLista arr[] = new NodoLista[2];
                                Multilista.elimina(VtnPrincipal.r, 0, Metodos.concatenarStrings2(movido).split(","), arr);
                                VtnPrincipal.r = arr[1];
                                VtnPrincipal.r = Multilista.inserta(VtnPrincipal.r, 0, Metodos.concatenarStrings().split(","), arr[0]);
                                movido.getObj().setRuta("C:\\" + Metodos.despliegaRuta(Metodos.concatenarStrings()));
                                Metodos.cambiaRutasAbajo(arr[0].getAbajo(), arr[0].getAbajo());

                                if (movido.getObj().getTipo() == 'C')
                                {
                                    Metodos.eliminaNodoJTree(nombreElementoEliminar, ultimoSeleccion);
                                }

                                //calcular el peso
                                Metodos.calculaDeNuevoPeso(nodo);
                                Metodos.limpiarFondo();
                                DefaultMutableTreeNode sele = nodoSeleccionado;

                                nodoSeleccionado.removeAllChildren();
                                modelo.reload();
                                ArrayList<NodoLista> a = new ArrayList();
                                Metodos.recorreAprofundidad(movido, movido, sele, a);
                                if (a != null)
                                {
                                    metodoQueCreaLabels(a);
                                }
                                movido = null;
                                copiarPegar = -1;
                            } else
                            {
                                JOptionPane.showMessageDialog(null, "No puedes mover la carpeta padre dentro de una subcarpeta", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else
                        {
                            JOptionPane.showMessageDialog(null, "Ya se encuentra un archivo con el mismo nombre", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
            }
            System.out.println("*************Multilista");
            Multilista.desp(VtnPrincipal.r, VtnPrincipal.r, "");
            System.out.println("************************");
        }
    }//GEN-LAST:event_menuPegarActionPerformed

    private void menuItemMostrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuItemMostrarActionPerformed
    {//GEN-HEADEREND:event_menuItemMostrarActionPerformed
        if (nodoSeleccionado != null)
        {
            NodoLista<Archivo> nodo = ((NodoLista) nodoSeleccionado.getUserObject());
            new VtnMostrarInfo(this, true, nodo.getObj().getNombre(), nodo.getObj().getExtension(),
                    nodo.getObj().getFecha(), nodo.getObj().getAutor(), String.valueOf(nodo.getObj().getTipo()),
                    nodo.getObj().getTamanio(), nodo.getObj().getRuta()).setVisible(true);
        }
    }//GEN-LAST:event_menuItemMostrarActionPerformed

    private void menuItemMoverActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuItemMoverActionPerformed
    {//GEN-HEADEREND:event_menuItemMoverActionPerformed
        if (nodoSeleccionado != null)
        {
            NodoLista n = ((NodoLista) nodoSeleccionado.getUserObject());
            NodoLista buscado = Metodos.buscaArchivo(n.getAbajo(), nombreElementoEliminar);
            if (buscado != null)
            {
                movido = (NodoLista) buscado;
                ultimoSeleccion = jCarpetas.getSelectionPath();
                copiarPegar = 1;
                menuPegar.setVisible(true);
            } else
            {
                System.out.println("No se encontro el buscado");
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Selecciona una carpeta de lado izquierdo", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_menuItemMoverActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened

        try
        {
            FileInputStream fos = new FileInputStream("datos.dat");
            try (ObjectInputStream arch = new ObjectInputStream(fos))
            {
                try
                {
                    NodoLista<Archivo> archi = (NodoLista<Archivo>) arch.readObject();
                    r = archi;

                    raiz = new DefaultMutableTreeNode(r);
                    modelo = new DefaultTreeModel(raiz);
                    jCarpetas.setModel(modelo);

                    if (r.getAbajo() != null)
                    {
                        Metodos.guarda(r.getAbajo().getSiguiente(), tbh, raiz, r.getAbajo().getSiguiente());
                        modelo.reload();
                    }

                    System.out.println("*************Multilista");
                    Multilista.desp(VtnPrincipal.r, VtnPrincipal.r, "");
                    System.out.println("************************");
                } catch (IOException ex)
                {
                    Logger.getLogger(VtnPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(VtnPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex)
            {
                Logger.getLogger(VtnPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex)
        {
            NodoLista<Archivo> a = new NodoLista("Archivos", null);
            r = Multilista.inserta(r, 0, new String[]
            {
                ""
            }, a);
            raiz = new DefaultMutableTreeNode(r);
            modelo = new DefaultTreeModel(raiz);
            jCarpetas.setModel(modelo);
        }

    }//GEN-LAST:event_formWindowOpened

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btnMinimizarMouseClicked
    {//GEN-HEADEREND:event_btnMinimizarMouseClicked
        this.setState(VtnPrincipal.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btnCerrarMouseClicked
    {//GEN-HEADEREND:event_btnCerrarMouseClicked
        if (Mensaje.pregunta(this, "¿Está seguro que quieres salir?") == 0)
        {
            try
            {
                FileOutputStream fos = new FileOutputStream("datos.dat");
                try
                {
                    ObjectOutputStream arch = new ObjectOutputStream(fos);
                    arch.writeObject(r);
                    arch.close();
                    System.out.println("Se ha guardado");
                } catch (IOException ex)
                {
                    Logger.getLogger(VtnPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(VtnPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void menuItemEliminarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuItemEliminarActionPerformed
    {//GEN-HEADEREND:event_menuItemEliminarActionPerformed
        if (nodoSeleccionado != null)
        {
            NodoLista<Archivo> carp = (NodoLista) nodoSeleccionado.getUserObject();
            VtnElementosAEliminar dialog = new VtnElementosAEliminar(this, true, carp);
            dialog.setVisible(true);
            if (dialog.getReturnStatus() == JOptionPane.YES_NO_OPTION)
            {
                // Obtener el nodo seleccionado de la tabla hash
                ArrayList<NodoLista> ar = new ArrayList();
                Metodos.recolectaLosNodosDelArbol(carp, carp, ar);
                //comienza a recorrer todos los archivos y carpetas con esa ruta para eliminarlos
                for (int i = 0; i < ar.size(); i++)
                {
                    VtnPrincipal.tbh.eliminaRuta(ar.get(i).getEtiqueta(), ((Archivo) ar.get(i).getObj()).getRuta());
                }

                //Eliminarlo de la multilista
                NodoLista arr[] = new NodoLista[2];
                Multilista.elimina(VtnPrincipal.r, 0, Metodos.concatenarStrings2(carp).split(","), arr);
                VtnPrincipal.r = arr[1];

                // Eliminar del JTree
                DefaultTreeModel model = (DefaultTreeModel) jCarpetas.getModel();
                model.removeNodeFromParent(nodoSeleccionado);
                modelo.reload();  // Recargar el modelo para actualizar el JTree

                //se vuelve a calcular el peso
                Metodos.calculaDeNuevoPeso(carp);
                // Actualizar el panel central
                Metodos.limpiarFondo();
                System.out.println("*************MultilistaEliminado");
                Multilista.desp(VtnPrincipal.r, VtnPrincipal.r, "");
                System.out.println("****************");
            }

        }
    }//GEN-LAST:event_menuItemEliminarActionPerformed

    private void menuItemEliminarCentroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuItemEliminarCentroActionPerformed
    {//GEN-HEADEREND:event_menuItemEliminarCentroActionPerformed
        if (nodoSeleccionado != null)
        {
            if (elementoBuscado != null)
            {
                NodoLista<Archivo> n = ((NodoLista) nodoSeleccionado.getUserObject());
                NodoLista<Archivo> buscado = Metodos.buscaArchivo(n.getAbajo(), nombreElementoEliminar);
                if (buscado != null)
                {
                    int confirm = 0;
                    if (((Archivo) buscado.getObj()).getTipo() == 'C')
                    {
                        VtnElementosAEliminar dialog = new VtnElementosAEliminar(this, true, buscado);
                        dialog.setVisible(true);
                        confirm = dialog.getReturnStatus();
                    } else
                    {
                        confirm = JOptionPane.showConfirmDialog(this, "¿Quieres eliminar el archivo " + "\" " + buscado.getEtiqueta() + " \" ?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    }
                    // Confirmar la eliminación
                    if (confirm == JOptionPane.YES_OPTION)
                    {

                        //Elimina de la tabla hash
                        ArrayList<NodoLista> ar = new ArrayList();
                        Metodos.recolectaLosNodosDelArbol(buscado, buscado, ar);
                        for (int i = 0; i < ar.size(); i++)
                        {
                            VtnPrincipal.tbh.eliminaRuta(ar.get(i).getEtiqueta(), ((Archivo) ar.get(i).getObj()).getRuta());
                        }
                        //Se elimina de la multilista
                        NodoLista arr[] = new NodoLista[2];
                        Multilista.eliminaR(VtnPrincipal.r, 0, Metodos.concatenarStrings2(buscado).split(","), arr, buscado.getObj().getRuta());
                        VtnPrincipal.r = arr[1];
                        ultimoSeleccion = jCarpetas.getSelectionPath();
                        // Eliminar del JTree
                        if (((Archivo) arr[0].getObj()).getTipo() == 'C')
                        {
                            Metodos.eliminaNodoJTree(nombreElementoEliminar, ultimoSeleccion);
                        }
                        modelo.reload();

                        Metodos.calculaDeNuevoPeso(n);
                        Metodos.limpiarFondo();
                        recorreNodosApartirDelSeleccionado();
                        System.out.println("*************MultilistaEliminado");
                        Multilista.desp(VtnPrincipal.r, VtnPrincipal.r, "");
                        System.out.println("****************");
                    }
                }
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Selecciona una carpeta de lado izquierdo", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_menuItemEliminarCentroActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBuscaActionPerformed
    {//GEN-HEADEREND:event_btnBuscaActionPerformed
        NodoArbol ar = VtnPrincipal.tbh.busca(jtextBuscador.getText());
        desactivaPopMenuEnBusqueda = false;
        if (ar != null)
        {
            ArrayList<NodoArbol> arreglo = new ArrayList();
            Metodos.buscaTodos(ar, jtextBuscador.getText(), arreglo);

            metodoQueCreaLabelsParaArbol(arreglo);
        } else
        {
            Metodos.limpiarFondo();
            mandaMensajeSinCoincidencias(jPanelFondo);
            insertaLabels(11);
        }
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void jtextBuscadorKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jtextBuscadorKeyTyped
    {//GEN-HEADEREND:event_jtextBuscadorKeyTyped
        Metodos.validaNombreCarpeta(evt, 15, jtextBuscador.getText());
        desactivaPopMenuEnBusqueda = false;
        if ((jtextBuscador.getText() + (evt.getKeyChar() == 8 ? "" : evt.getKeyChar())).matches("[a-zA-Z](\\w?\\.?)*"))
        {
            if ((evt.getKeyChar() >= 65 && evt.getKeyChar() <= 122) || evt.getKeyChar() == 8)
            {
                if (evt.getKeyChar() == 8 && jtextBuscador.getText().equals(""))
                {
                    Metodos.limpiarFondo();
                } else
                {
                    NodoArbol ar = VtnPrincipal.tbh.busca(jtextBuscador.getText() + (evt.getKeyChar() == 8 ? "" : evt.getKeyChar()));

                    if (ar != null)
                    {
                        ArrayList<NodoArbol> arreglo = new ArrayList();
                        Metodos.buscaTodos(ar, jtextBuscador.getText() + (evt.getKeyChar() == 8 ? "" : evt.getKeyChar()), arreglo);
                        metodoQueCreaLabelsParaArbol(arreglo);
                    } else
                    {
                        Metodos.limpiarFondo();
                        mandaMensajeSinCoincidencias(jPanelFondo);
                        insertaLabels(11);
                    }
                }
            }
        } else
        {
            Metodos.limpiarFondo();
            mandaMensajeSinCoincidencias(jPanelFondo);
            insertaLabels(11);
        }
    }//GEN-LAST:event_jtextBuscadorKeyTyped

    private void cabeceraMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_cabeceraMousePressed
    {//GEN-HEADEREND:event_cabeceraMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_cabeceraMousePressed

    private void cabeceraMouseDragged(java.awt.event.MouseEvent evt)//GEN-FIRST:event_cabeceraMouseDragged
    {//GEN-HEADEREND:event_cabeceraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_cabeceraMouseDragged

    private void menuItemVerCentroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuItemVerCentroActionPerformed
    {//GEN-HEADEREND:event_menuItemVerCentroActionPerformed
        if (nodoSeleccionado != null)
        {
            NodoLista<Archivo> n = ((NodoLista) nodoSeleccionado.getUserObject());
            NodoLista<Archivo> nodo = Metodos.buscaArchivo(n.getAbajo(), nombreElementoEliminar);
            if (nodo != null)
            {
                new VtnMostrarInfo(this, true, nodo.getObj().getNombre(), nodo.getObj().getExtension(),
                        nodo.getObj().getFecha(), nodo.getObj().getAutor(), String.valueOf(nodo.getObj().getTipo()),
                        nodo.getObj().getTamanio(), nodo.getObj().getRuta()).setVisible(true);
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Selecciona una carpeta de lado izquierdo", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_menuItemVerCentroActionPerformed

    //MÉTODOS PARA MOSTRAR GRAFICAMENTE------------------------------------
    /*
        Como ya lo mencione, si se le da clic a la carpeta padre que se llama archivos va a mostrar todas las carpetas que contiene la carpeta "Archivos"
        esto porque es el primer nivel de la multilista, entonces cuando se inserta una carpeta por primera ves, lo inserta a lado del nodo archivos (En el mismo nivel).
        Nivel que en la parte de arriba, en el constructor lo he insertado previamente.
     */
    public void recorreNodosApartirDelSeleccionado()
    {
        if (nodoSeleccionado != null)
        {
            NodoLista nodo = ((NodoLista) nodoSeleccionado.getUserObject());
            Metodos.limpiarFondo();
            if (nodo != null)
            {
                ArrayList<NodoLista> arr = new ArrayList();
                NodoLista<Archivo> aux = nodo.getAbajo();//se coloca abajo, ya que se le esta dando clic al padre
                if (aux != null)
                {
                    do
                    {
                        arr.add(aux.getSiguiente());//Va agregando los hijos, es decir sus siguientes hasta que se vuelvan a topar con la raiz
                        aux = aux.getSiguiente();
                    } while (aux != nodo.getAbajo());
                    metodoQueCreaLabels(arr);//En el arreglo se guardan todos archivos y carpetas que tiene del lado izquierdo
                }
            }
        }
    }

    /*
        Este metodo va llamando a el metodo "mostrarArchivos" que crea el label que se van a ir colocando de manera dinamica en el panel central
        No hay que preocuparse de eso, ya que va sacando posición por posición y obtiene el nombre de la carpeta que se va a mostrar
        y el tipo para que dependiendo de esto se le coloque un icono diferente
     */
    private void metodoQueCreaLabels(ArrayList<NodoLista> arr)
    {
        char tipo = ' ';
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i).getObj() != null)
            {
                tipo = ((Archivo) arr.get(i).getObj()).getTipo();
                mostrarArchivos(arr.get(i).getEtiqueta(), ((Archivo) arr.get(i).getObj()).getRuta(), jPanelFondo, tipo);
            }
        }
        insertaLabels(10 - arr.size());
    }

    private String llenaEspacios(int cal, String s)
    {
        if (cal > 0)
        {
            return s + llenaEspacios(cal - 1, " ");
        }
        return s;
    }

    /*
        Método que menos hay que hacerle caso xd
        esto es para que al insertar una carpeta se vaya en la parte de arriba y no este mal acomodado, no le hagan caso
     */
    private void insertaLabels(int i)
    {
        if (i > 0)
        {
            JLabel label = new JLabel();
            jPanelFondo.add(label);
            insertaLabels(i - 1);
        }
    }

    /*
        Método que cre los Labels y coloca el icono dependiendo si el objeto es de tipo Carpeta o Archivo
        Este método tampoco hay que hacerle mucho caso
     */
    private void mostrarArchivos(String nombre, String ruta, JPanel panelLabel, char tipo)
    {
        ImageIcon im = null;
        if (tipo == 'C')
        {
            im = new ImageIcon("src\\imagenes\\folder.png");
        } else
        {
            im = new ImageIcon("src\\imagenes\\iconArchivo.png");
        }
        String espacios = llenaEspacios(41 - nombre.length(), "");
        JLabel label = new JLabel("<html><pre>" + nombre + espacios + ruta + " </pre></html>", im, JLabel.LEFT);
        label.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (desactivaPopMenuEnBusqueda)
                {
                    if (SwingUtilities.isLeftMouseButton(e))
                    {
                        if (soloUnoSelecciona)
                        {
                            label.setBackground(new Color(132, 165, 214));
                            textoConFormato = label.getText();
                            elementoBuscado = textoConFormato.replaceAll("\\<.*?\\>", "");//lo que hace es quitar las etiquetas de html y darnos ahora si el texto puro, sin esto nos da el nombre de la carpeta pero rara 
                            //Para obtener el puro nombre
                            int finN = elementoBuscado.indexOf(" ");
                            nombreElementoEliminar = elementoBuscado.substring(0, finN);
//                        System.out.println("nombreEle: " +  nombreElementoEliminar);
                            //Para obtener la ruta del label
                            int inicio = elementoBuscado.indexOf("C");
                            int fin = elementoBuscado.lastIndexOf(" ");
                            elementoBuscado = elementoBuscado.substring(inicio, fin);
//                        System.out.println("Ele: " +  elementoBuscado);
                            soloUnoSelecciona = false;
                        } else
                        {
                            // Buscar el JLabel usando una expresión lambda
                            Optional<JLabel> result = arregloLablesParaLimpiar.stream()
                                    .filter(label -> label.getText().equals(textoConFormato))
                                    .findFirst();
                            if (result.isPresent())
                            {
                                Metodos.limpiaCampos(arregloLablesParaLimpiar);
                                soloUnoSelecciona = true;
                            }
                        }
                    } else if (SwingUtilities.isRightMouseButton(e))
                    {
                        if (label.getBackground().equals(new Color(132, 165, 214)))
                        {
                            popMenuCentro.show(label, e.getX(), e.getY());
                        }
                    }
                }

            }
        });

        label.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18));
        label.setBackground(new Color(220, 230, 244));
        label.setOpaque(true);
        label.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        label.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panelLabel.add(label);
        arregloLablesParaLimpiar.add(label);
        panelLabel.revalidate();
        panelLabel.repaint();
    }

    public void metodoQueCreaLabelsParaArbol(ArrayList<NodoArbol> arreglo)
    {
        char tipo = ' ';

        Metodos.limpiarFondo();
        for (int i = 0; i < arreglo.size(); i++)
        {
            if (arreglo.get(i).getObj() != null)
            {
                tipo = ((Archivo) ((NodoLista) arreglo.get(i).getObj()).getObj()).getTipo();
                mostrarArchivos(arreglo.get(i).getEtiqueta(), ((Archivo) ((NodoLista) arreglo.get(i).getObj()).getObj()).getRuta(), jPanelFondo, tipo);
            }
        }
        insertaLabels(10);
    }

    public void mandaMensajeSinCoincidencias(JPanel panelLabel)
    {
        ImageIcon im = new ImageIcon("src\\imagenes\\NoEncontro.png");
        JLabel label = new JLabel("<html><p>No se econtraron coincidencias<p></html>", im, JLabel.CENTER);
        label.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18));
        label.setBackground(new Color(132, 165, 214));
        label.setOpaque(true);
        label.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        label.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panelLabel.add(label);
        arregloLablesParaLimpiar.add(label);
        panelLabel.revalidate();
        panelLabel.repaint();
    }

//-------------------------------------------------------------------------------  
//        public void buscaTodos(NodoArbol r, String et, ArrayList<NodoArbol> arr)
//    {
//        if (r != null)
//        {
//            if (r.getEtiqueta().length()>=et.length())
//            {
//                String s=r.getEtiqueta().substring(0, et.length());
//                
//                if (r.getEtiqueta().equals(et))
//                {
//                    arr.add(r);
//                    buscaTodos(r.getIzquierda(), et, arr);
//                    buscaTodos(r.getDerecha(), et, arr);
//                } else
//                {
//                    if (r.getEtiqueta().compareTo(et) > 0)
//                    {
//                        buscaTodos(r.getIzquierda(), et, arr);
//                    } else
//                    {
//                        buscaTodos(r.getDerecha(), et, arr);
//                    }
//                }
//            }else
//            {
//                buscaTodos(r.getDerecha(), et, arr);
//            }
//        }
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VtnPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JPanel cabecera;
    public static javax.swing.JTree jCarpetas;
    private javax.swing.JLabel jLabelRuta;
    private javax.swing.JPanel jPanelArribaCentro;
    public static javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrolPanelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtextBuscador;
    private javax.swing.JMenuItem menuItemCarpeta;
    private javax.swing.JMenuItem menuItemCopiar;
    private javax.swing.JMenuItem menuItemEliminar;
    private javax.swing.JMenuItem menuItemEliminarCentro;
    private javax.swing.JMenuItem menuItemMostrar;
    private javax.swing.JMenuItem menuItemMover;
    private javax.swing.JMenuItem menuItemVerCentro;
    private javax.swing.JMenuItem menuPegar;
    private javax.swing.JPopupMenu popMenuCarpetas;
    private javax.swing.JPopupMenu popMenuCentro;
    private javax.swing.JPanel ultimoPanel;
    // End of variables declaration//GEN-END:variables
}
