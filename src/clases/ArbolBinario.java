/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class ArbolBinario
{

    private NodoArbol r;

    /**
     * @return the r
     */
    public NodoArbol getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoArbol r)
    {
        this.r = r;
    }

    public NodoArbol inserta(NodoArbol r, NodoArbol n)
    {
        if (r == null)
        {
            return n;
        } else
        {
            if (r.getEtiqueta().compareTo(n.getEtiqueta()) > 0)
            {
                r.setIzquierda(inserta(r.getIzquierda(), n));
            } else if (r.getEtiqueta().compareTo(n.getEtiqueta()) < 0)
            {
                r.setDerecha(inserta(r.getDerecha(), n));
            } else
            {
                // Nodo duplicado, insertarlo en el subárbol derecho
                r.setDerecha(inserta(r.getDerecha(), n));
            }
            r = balanceaArbol(r);
            return r;
        }
    }

    public NodoArbol balanceaArbol(NodoArbol n)
    {
        if (r != null)
        {
            int fe = factorEquilibrio(n);
            if (fe > 1)
            {
                n = (factorEquilibrio(n.getDerecha()) < 0 ? rotacionDobleDerechaIzquierda(n) : rotacionIzquierda(n));
            } else if (fe < -1)
            {
                n = (factorEquilibrio(n.getIzquierda()) > 0 ? rotacionDobleIzquierdaDerecha(n) : rotacionDerecha(n));
            }
        }
        return n;
    }

    // Método para hacer una rotación simple a la derecha
    public NodoArbol rotacionDerecha(NodoArbol n)
    {
        NodoArbol aux = n.getIzquierda();
        n.setIzquierda(aux.getDerecha());
        aux.setDerecha(n);
        return aux;
    }

    // Método para hacer una rotación simple a la izquierda
    public NodoArbol rotacionIzquierda(NodoArbol n)
    {
        NodoArbol aux = n.getDerecha();
        n.setDerecha(aux.getIzquierda());
        aux.setIzquierda(n);
        return aux;
    }

    // Método para hacer una rotación doble izquierda-derecha
    public NodoArbol rotacionDobleIzquierdaDerecha(NodoArbol n)
    {
        System.out.println(n);
        n.setIzquierda(rotacionIzquierda(n.getIzquierda()));
        return rotacionDerecha(n);
    }

    // Método para hacer una rotación doble derecha-izquierda
    public NodoArbol rotacionDobleDerechaIzquierda(NodoArbol n)
    {
        n.setDerecha(rotacionDerecha(n.getDerecha()));
        return rotacionIzquierda(n);
    }

    public int factorEquilibrio(NodoArbol n)
    {
        return altura(n.getDerecha()) - altura(n.getIzquierda());
    }

    public int altura(NodoArbol r)
    {
        if (r != null)
        {
            int n1 = altura(r.getDerecha());
            int n2 = altura(r.getIzquierda());

            return (n1 > n2 ? n1 : n2) + 1;
        } else
        {
            return 0;
        }
    }

    public void elimina(NodoArbol r, String etiqueta, NodoArbol arr[])
    {
        if (r == null)//cuando no hay nada que eliminar
        {
            arr[0] = null;
            arr[1] = r;
        } else
        {
            if (r.getEtiqueta().equals(etiqueta))//ya encontro el dato y ahora van los tres casos
            {
                arr[0] = r;
                if (r.getDerecha() == null && r.getIzquierda() == null)
                {
                    arr[1] = null;
                } else
                {
                    if (!(r.getDerecha() != null && r.getIzquierda() != null))//cuando tiene un hijo
                    {//tiene un hijo, está prro eh?
                        if (r.getDerecha() != null)//el hijo lo tengo a la derecha y el que va a reconmectar lo tengo a la derecha
                        {
                            arr[1] = r.getDerecha();
                        } else
                        {
                            arr[1] = r.getIzquierda();
                        }
                    } else//tiene dos hijos
                    {
                        if (r.getDerecha().getIzquierda() == null)
                        {
                            NodoArbol se = r.getDerecha();
                            se.setIzquierda(r.getIzquierda());
                            r.setDerecha(null);
                            r.setIzquierda(null);
                            arr[1] = se;
                            //Simplificado
//                            arr[1]=r.getDerecha();
//                            r.getDerecha().setIzquierda(r.getIzquierda());
//                            r.setDerecha(null);
//                            r.setIzquierda(null);
                        } else
                        {
                            NodoArbol aux = sucesorE(r.getDerecha());
                            NodoArbol se = aux.getIzquierda();
                            aux.setIzquierda(se.getDerecha());
                            se.setDerecha(r.getDerecha());
                            se.setIzquierda(r.getIzquierda());
                            arr[1] = se;
                            r.setDerecha(null);
                            r.setIzquierda(null);

                            //simplificado
//                            NodoArbol se = sucesorE(r.getDerecha());
//                            arr[1]=se.getIzquierda();
//                            se.setIzquierda(arr[1].getDerecha());
//                            se.setDerecha(r.getDerecha());
//                            se.setIzquierda(r.getIzquierda());
                        }
                    }
                }
            } else
            {
                if (r.getEtiqueta().compareTo(etiqueta) > 0)
                {
                    elimina(r.getIzquierda(), etiqueta, arr);
                    r.setIzquierda(arr[1]);
                } else
                {
                    elimina(r.getDerecha(), etiqueta, arr);
                    r.setDerecha(arr[1]);
                }
                r = balanceaArbol(r);
                arr[1] = r;
            }
        }
    }
    public void eliminaRepe(NodoArbol r, String etiqueta, String ruta, NodoArbol arr[])
    {
        if (r == null)
        { // cuando no hay nada que eliminar
            arr[0] = null;
            arr[1] = null;
            return;
        }

        // Continuamos buscando en el árbol primero, recorriendo ambas subramas
        NodoArbol[] arrIzquierda = new NodoArbol[2];
        NodoArbol[] arrDerecha = new NodoArbol[2];
        eliminaRepe(r.getIzquierda(), etiqueta, ruta, arrIzquierda);
        eliminaRepe(r.getDerecha(), etiqueta, ruta, arrDerecha);
        r.setIzquierda(arrIzquierda[1]);
        r.setDerecha(arrDerecha[1]);

        // Balanceamos el árbol después de la eliminación
        r = balanceaArbol(r);
        arr[1] = r;

        // Ahora, manejamos el caso en el que encontramos el nodo que queremos eliminar
        if (((Archivo) ((NodoLista) r.getObj()).getObj()).getRuta().equals(ruta)
                && r.getEtiqueta().equals(etiqueta))
        {
            arr[0] = r; // Nodo a eliminar
            // Caso 1: Nodo sin hijos
            if (r.getDerecha() == null && r.getIzquierda() == null)
            {
                arr[1] = null;
            } // Caso 2: Nodo con un hijo
            else if (r.getDerecha() == null)
            {
                arr[1] = r.getIzquierda();
            } else if (r.getIzquierda() == null)
            {
                arr[1] = r.getDerecha();
            } // Caso 3: Nodo con dos hijos
            else
            {
                if (r.getDerecha().getIzquierda() == null)
                {
                    NodoArbol se = r.getDerecha();
                    se.setIzquierda(r.getIzquierda());
                    arr[1] = se;
                } else
                {
                    NodoArbol aux = sucesorE(r.getDerecha());
                    NodoArbol se = aux.getIzquierda();
                    aux.setIzquierda(se.getDerecha());
                    se.setDerecha(r.getDerecha());
                    se.setIzquierda(r.getIzquierda());
                    arr[1] = se;
                }
            }
            // Desconectamos todo
            r.setDerecha(null);
            r.setIzquierda(null);
        }
    }

    public NodoArbol sucesorE(NodoArbol r)
    {
        if (r.getIzquierda().getIzquierda() != null)
        {
            return sucesorE(r.getIzquierda());
        } else
        {
            return r;
        }
    }

    public String enOrden(NodoArbol r)
    {
        String s = "";
        if (r != null)
        {
            s += enOrden(r.getIzquierda());
            s += r.getEtiqueta();
            s += enOrden(r.getDerecha());
        }
        return s;
    }

    public String preOrden(NodoArbol r)
    {
        String s = "";
        if (r != null)
        {
            s += r.getEtiqueta();
            s += preOrden(r.getIzquierda());
            s += preOrden(r.getDerecha());
        }
        return s;
    }

    public String posOrden(NodoArbol r)
    {
        String s = "";
        if (r != null)
        {
            s += posOrden(r.getIzquierda());
            s += posOrden(r.getDerecha());
            s += r.getEtiqueta();
        }
        return s;
    }

    public NodoArbol busca(NodoArbol r, String et)
    {
        if (r != null)
        {
            if (r.getEtiqueta().equals(et))
            {
                return r;
            } else
            {
                if (r.getEtiqueta().compareTo(et) > 0)
                {
                    return busca(r.getIzquierda(), et);
                } else
                {
                    return busca(r.getDerecha(), et);
                }
            }
        } else
        {
            return null;
        }
    }

    public ArrayList<NodoArbol> buscaTodos(NodoArbol r, String et, ArrayList<NodoArbol> arr)
    {
        if (r != null)
        {
            if (r.getEtiqueta().equals(et))
            {
                arr.add(r);
                if (r.getEtiqueta().compareTo(et) > 0)
                {
                    return buscaTodos(r.getIzquierda(), et, arr);
                } else
                {
                    return buscaTodos(r.getDerecha(), et, arr);
                }
            } else
            {
                if (r.getEtiqueta().compareTo(et) > 0)
                {
                    return buscaTodos(r.getIzquierda(), et, arr);
                } else
                {
                    return buscaTodos(r.getDerecha(), et, arr);
                }
            }
        } else
        {
            return null;
        }
    }
}
