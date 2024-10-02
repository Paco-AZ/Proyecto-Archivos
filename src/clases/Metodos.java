/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import jframes.VtnPrincipal;
import static jframes.VtnPrincipal.jCarpetas;
import static jframes.VtnPrincipal.jPanelFondo;

/**
 *
 * @author Lenovo
 */
public class Metodos
{

    public static void insertaCarpetasArchivos(NodoLista<Archivo> archi)
    {
        if (VtnPrincipal.nodoSeleccionado != null)
        {
            DefaultMutableTreeNode carpeta = null;

            if (archi.getObj().getTipo() == 'C')
            {
                carpeta = new DefaultMutableTreeNode(archi);
                VtnPrincipal.modelo.insertNodeInto(carpeta, VtnPrincipal.nodoSeleccionado, VtnPrincipal.nodoSeleccionado.getChildCount());
            }

            VtnPrincipal.tbh.inserta(new NodoArbol(archi.getEtiqueta(), archi));
            VtnPrincipal.r = Multilista.inserta(VtnPrincipal.r, 0, concatenarStrings().split(","), archi);
            NodoLista<Archivo> nodo = (NodoLista) VtnPrincipal.nodoSeleccionado.getUserObject();
            if (nodo.getObj() != null)//para cambiar el peso de la carpeta principal o padre que se está seleccionando
            {
                int total = Metodos.calculoPeso(nodo.getAbajo(), nodo.getAbajo(), 0);
                nodo.getObj().setTamanio(total);
            }

            //solo es para ver de manera interna los cambios que se están haciendo el la multilista
            System.out.println("*************Multilista");
            Multilista.desp(VtnPrincipal.r, VtnPrincipal.r, "");
            System.out.println("****************");
        }
    }

    public static void limpiarFondo()
    {
        jPanelFondo.removeAll();//Borra todo lo que hay en el panel
        jPanelFondo.revalidate();
        jPanelFondo.repaint();
    }

    public static String concatenarStrings()
    {
        String cadena = " ";
        NodoLista<Archivo> nodoClic = ((NodoLista) VtnPrincipal.nodoSeleccionado.getUserObject());

        do
        {
            cadena = nodoClic.getEtiqueta() + "," + cadena;
            nodoClic = nodoClic.getArriba();
        } while (nodoClic != null);
        return cadena;
    }

    public static String concatenarStrings2(NodoLista buscado)
    {
        String cadena = "";
        do
        {
            cadena = buscado.getEtiqueta() + "," + cadena;
            buscado = buscado.getArriba();
        } while (buscado != null);
        return cadena;
    }

    public static String concatenarStringsRutas(NodoLista<Archivo> nodoClic, String primero)
    {
        String cadena = " ";
        do
        {
            if (!nodoClic.getEtiqueta().equals(primero))
            {
                cadena = nodoClic.getEtiqueta() + "," + cadena;
            }
            nodoClic = nodoClic.getArriba();

        } while (nodoClic != null);
        return cadena;
    }
    
    public static void cambiaRutasAbajo(NodoLista padre, NodoLista aux)
    {
        if (padre != null)
        {
            do
            {
                padre = padre.getSiguiente();
                if (padre.getAbajo() != null)
                {
                    cambiaRutasAbajo(padre.getAbajo(), padre.getAbajo());
                }
                String rut = Metodos.despliegaRuta("C:\\" + Metodos.concatenarStringsRutas(padre, padre.getEtiqueta()));
                ((Archivo) padre.getObj()).setRuta(rut);
                
            } while (padre != aux);
            
        }
    }

    public static NodoLista buscaArchivo(NodoLista<Archivo> ar, String nombreArchivo)
    {
        if (ar != null)
        {
            NodoLista<Archivo> aux = ar;
            do
            {
                if (aux.getEtiqueta().equals(nombreArchivo))
                {
                    return aux;
                }
                aux = aux.getSiguiente();
            } while (aux != ar);
        }
        return null;
    }

    public static void desp(NodoLista r, NodoLista aux, String s)
    {
        do
        {
            r = r.getSiguiente();
            System.out.println(s + r.getEtiqueta());
            if (r.getAbajo() != null)
            {
                desp(r.getAbajo(), r.getAbajo(), s + "\t");
            }
        } while (r != aux);
    }

    public static void guarda(NodoLista r, TablaHashArbol tbh, DefaultMutableTreeNode nodoSeleccionado, NodoLista n) throws IOException
    {
        if (r != null)
        {
//            NodoLista tmp = new NodoLista(null, "");
//            tmp.setAbajo(r.getAbajo());
            DefaultMutableTreeNode df = null;
            if (((Archivo) r.getObj()).getTipo() == 'C')
            {
                df = new DefaultMutableTreeNode(r);
                VtnPrincipal.modelo.insertNodeInto(df, nodoSeleccionado, nodoSeleccionado.getChildCount());
            }
            tbh.inserta(new NodoArbol(r.getEtiqueta(), r));
            if (r.getAbajo() != null)
            {
                guarda(r.getAbajo().getSiguiente(), tbh, df, r.getAbajo().getSiguiente());
            }
            if (r.getSiguiente() != n)
            {
                guarda(r.getSiguiente(), tbh, nodoSeleccionado, n);
            }
        }
    }

    public static boolean validaCamposVacios(String... arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].equals(""))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean validaNombreExtencion(String nombre)
    {
        return nombre.matches("^[\\w,\\s-]+\\.[A-Za-z]{2,6}$");
    }

    public static void limpiaCampos(ArrayList<JLabel> labels)
    {
        for (JLabel label : labels)
        {
            label.setBackground(new Color(220, 230, 244));
        }
    }

    public static int calculoPeso(NodoLista<Archivo> r, NodoLista<Archivo> aux, int pesoTotal)
    {
        if (r != null)
        {
            do
            {
                r = r.getSiguiente();
                if (r.getAbajo() != null)
                {
                    calculoPeso(r.getAbajo(), r.getAbajo(), pesoTotal);
                }
                pesoTotal += r.getObj().getTamanio();
            } while (r != aux);
            return pesoTotal;
        } else
        {
            return 0;
        }
    }

    public static void calculaDeNuevoPeso(NodoLista<Archivo> nodo)
    {
        if (!nodo.getEtiqueta().equals("Archivos"))
        {
            int total = Metodos.calculoPeso(nodo.getAbajo(), nodo.getAbajo(), 0);
            nodo.getObj().setTamanio(total);
        }
    }

    public static NodoLista<Archivo> verificaSiHayDosArchivosIguales(NodoLista r, String nombre, NodoLista<Archivo> ar)
    {
        NodoLista nodo = Multilista.busca(r.getAbajo(), nombre);
        String s = "";
        if (nodo != null)
        {
            s = nombre + "-copia";
            nodo = Multilista.busca(r.getAbajo(), s);
            if (nodo != null)
            {
                int i = 1;
                do
                {
                    String s2 = s + "(" + i + ")";
                    nodo = Multilista.busca(r.getAbajo(), s2);
                    if (nodo != null)
                    {
                        i++;
                        continue;
                    }
                    s = s2;
                    break;
                } while (true);
            }
            ar.getObj().setNombre(s);
            ar.setEtiqueta(s);
        }

        return ar;
    }

    public static boolean verificaArchivosRegistrados(String nombreCarpeta, char tipo, NodoLista seleccion)
    {
        NodoLista<Archivo> nodo = seleccion;

        if (nodo.getAbajo() != null)
        {
            NodoLista<Archivo> aux = nodo.getAbajo();
            do
            {
                if (aux.getEtiqueta().equals(nombreCarpeta) && aux.getObj().getTipo() == tipo)
                {
                    return true;
                }
                aux = aux.getSiguiente();
            } while (aux != nodo.getAbajo());
        }
        return false;
    }

    public static void recolectaLosNodosDelArbol(NodoLista r, NodoLista aux, ArrayList<NodoLista> a)
    {
        if (r != null)
        {
            do
            {
                r = r.getSiguiente();
                if (r.getAbajo() != null)
                {
                    recolectaLosNodosDelArbol(r.getAbajo(), r.getAbajo(), a);
                }
                a.add(r);
            } while (r != aux);
        }
    }

    public static void eliminaNodoJTree(String buscado, TreePath ultimoSeleccion)
    {
        if (ultimoSeleccion != null)
        {
            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) ultimoSeleccion.getLastPathComponent();

            // Itera sobre los hijos del nodo padre
            for (int i = 0; i < parentNode.getChildCount(); i++)
            {
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) parentNode.getChildAt(i);
                if (childNode.toString().equals(buscado))
                {
//                    // Encontraste la subcarpeta específica
//                    TreePath pathToSubfolder = selectedPath.pathByAddingChild(childNode);
//                    jCarpetas.setSelectionPath(pathToSubfolder);
//                    jCarpetas.scrollPathToVisible(pathToSubfolder);
//                    // Aquí puedes realizar cualquier operación adicional en la subcarpeta

                    NodoLista<Archivo> n = (NodoLista) childNode.getUserObject();
                    if (n.getObj().getTipo() == 'C')
                    {
                        DefaultTreeModel model = (DefaultTreeModel) jCarpetas.getModel();
                        model.removeNodeFromParent(childNode);
                    }
                    break;
                }
            }
        }
    }

    public static String despliegaRuta(String ruta)
    {
        return ruta.replace(",", "\\");
    }

    public static void buscaTodos(NodoArbol r, String et, ArrayList<NodoArbol> arr)
    {
        if (r != null)
        {
            if (r.getEtiqueta().length() >= et.length())
            {
                String s = r.getEtiqueta().substring(0, et.length());

                if (s.equals(et))
                {
                    arr.add(r);
                    buscaTodos(r.getIzquierda(), et, arr);
                    buscaTodos(r.getDerecha(), et, arr);
                } else
                {
                    if (s.compareTo(et) > 0)
                    {
                        buscaTodos(r.getIzquierda(), et, arr);
                    } else
                    {
                        buscaTodos(r.getDerecha(), et, arr);
                    }
                }
            } else
            {
                buscaTodos(r.getDerecha(), et, arr);
            }
        }
    }

    public static void buscaParaEliminar(NodoArbol r, String etiqueta, String ruta)
    {
        if (r != null)
        {
            if (((Archivo) ((NodoLista) r.getObj()).getObj()).getRuta().equals(ruta))
            {

            } else
            {
                if (r.getEtiqueta().compareTo(etiqueta) > 0)
                {
                    buscaParaEliminar(r.getIzquierda(), etiqueta, ruta);
                } else
                {
                    buscaParaEliminar(r.getDerecha(), etiqueta, ruta);
                }
            }

        }
    }

    public static boolean verificaSiEsPadre(NodoLista<Archivo> moverR, NodoLista<Archivo> lugarAMover)
    {
        if (lugarAMover != null)
        {
            do
            {
                if (lugarAMover.getEtiqueta().equals(moverR.getEtiqueta()))
                {
                    return false;
                }
                lugarAMover = lugarAMover.getArriba();
            } while (lugarAMover != null);
        }
        return true;
    }

    public static void recorreAprofundidad(NodoLista<Archivo> r, NodoLista<Archivo> aux, DefaultMutableTreeNode nodoSeleccionado, ArrayList<NodoLista> a)
    {
        if (r != null)
        {
//            NodoLista tmp = new NodoLista(null, "");
//            tmp.setAbajo(r.getAbajo());
            DefaultMutableTreeNode df = null;
            if (((Archivo) r.getObj()).getTipo() == 'C')
            {
                df = new DefaultMutableTreeNode(r);
                System.out.println("r: " + r.getEtiqueta());
                VtnPrincipal.modelo.insertNodeInto(df, nodoSeleccionado, nodoSeleccionado.getChildCount());
            }
            if (r.getAbajo() != null)
            {
                recorreAprofundidad(r.getAbajo().getSiguiente(), r.getAbajo().getSiguiente(), df, a);
            }
            if (r.getSiguiente() != aux)
            {
                recorreAprofundidad(r.getSiguiente(), aux, nodoSeleccionado, a);
            }
        }
    }

    public static void validaNombreCarpeta(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if (ke.getKeyChar() != 'ñ')
            {
                va(ke, s);
            } else
            {
                ke.consume();
            }
        }
    }

    private static void va(KeyEvent ke, String cad)
    {
        char keyChar = ke.getKeyChar();
        if (!Character.isLetterOrDigit(keyChar)
                && keyChar != 'ñ'
                && keyChar != 'Ñ'
                && keyChar != 'á'
                && keyChar != 'Á'
                && keyChar != 'é'
                && keyChar != 'É'
                && keyChar != 'í'
                && keyChar != 'Í'
                && keyChar != 'ó'
                && keyChar != 'Ó'
                && keyChar != 'ú'
                && keyChar != 'Ú'
                && keyChar != '.'
                && keyChar != '_'
                && keyChar != '-'
                && keyChar != '('
                && keyChar != ')'
                && ke.getKeyCode() != KeyEvent.VK_BACK_SPACE)
        {
            ke.setKeyChar((char) 8);
        } else
        {
            String newCad = cad + keyChar;
            if (!newCad.matches("^(?!.*[._\\-]{3})(?![ñÑ])[a-zA-ZñÑ][a-zA-ZñÑ0-9]*([._\\-][a-zA-ZñÑ0-9]+)*[._\\-()]*$"))
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    /**
     * Método que no permite copiar el contenido de un componente
     *
     * @param component Componente o la caja donde se quiere evitar que copien
     * el contenido
     */
    public static void evitaPegar(JComponent component)
    {
        component.getInputMap().put(KeyStroke.getKeyStroke("control V"), "none");
    }

    /**
     * Método que no permite pegar dentro de un componente
     *
     * @param component Componente o la caja donde se quiere evitar que pegen
     * contenido
     */
    public static void evitaCopiar(JComponent component)
    {
        component.getInputMap().put(KeyStroke.getKeyStroke("control C"), "none");
    }
}

// Este no lo borren por fa jaja
//    //la agrego a la multilista
//            arr = ObtenLasRutas(carpetaClic);
//            VtnPrincipal.r = Multilista.inserta(VtnPrincipal.r, 0, arr, archi);
//            System.out.println("*************Multilista");
//            Multilista.desp(VtnPrincipal.r, VtnPrincipal.r, "");
//            System.out.println("****************");
//            //******************************************

/*
        El método comienza a buscar las rutas a partir de donde se le dio clic. Es decir del clic hacia arriba.
        Cuando llega hasta arriba obtiene su padre y es entonces como sabemos donde se va a colocar el nodo.
 */
//    public static String[] ObtenLasRutas(NodoLista nodo)
//    {
//        PilaDinamica pila = new PilaDinamica();//utilizo una pila para más facilidad, ya que cuadno la vacie, va a quedar ordenado el arreglo que le mando a la multilista
//        String arr[] = null;
//        if (nodo != null)
//        {
//            pila.inserta(new Nodo("", null));//Es el vacio que se pone al final del arreglo para indicar donde se va a insertar en la multilista
//            while (nodo != null)
//            {
//                pila.inserta(new Nodo(nodo.getEtiqueta(), null));
//                nodo = nodo.getArriba();
//            }
//            arr = metodoVaciaPila(pila).toArray(new String[0]);
//            return arr;
//        } else
//        {
//            return new String[]
//            {
//                ""
//            };
//        }
//    }
//
//    public static ArrayList<String> metodoVaciaPila(PilaDinamica p)
//    {
//        ArrayList<String> arr = new ArrayList<>();
//
//        while (p.getTope() != null)
//        {
//            arr.add(p.elimina().getEtiqueta());
//        }
//        return arr;
//    }
