/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class ListaDoblementeLigadaCircular implements Serializable
{

    private NodoLista r;

    /**
     * @return the r
     */
    public NodoLista getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoLista r)
    {
        this.r = r;
    }

    public boolean inserta(NodoLista n)
    {
        if (n != null)
        {
            if (r == null)
            {
                r = n;
                r.setSiguiente(r);
                r.setAnterior(r);
            } else
            {
                if (n.getEtiqueta().compareTo(r.getSiguiente().getEtiqueta()) <= 0
                        || n.getEtiqueta().compareTo(r.getEtiqueta()) >= 0)
                {
                    n.setSiguiente(r.getSiguiente());
                    r.setSiguiente(n);
                    n.setAnterior(r);
                    n.getSiguiente().setAnterior(n);
                    if (n.getEtiqueta().compareTo(r.getEtiqueta()) >= 0)
                    {
                        r = n;
                    }
                } else
                {
                    NodoLista aux = r.getSiguiente();
                    while (true)
                    {
                        if (aux.getSiguiente().getEtiqueta().compareTo(n.getEtiqueta()) >= 0)
                        {
                            n.setSiguiente(aux.getSiguiente());
                            aux.setSiguiente(n);
                            n.getSiguiente().setAnterior(n);
                            n.setAnterior(aux);
                            break;
                        }
                        aux = aux.getSiguiente();
                    }
                }
            }
            return true;
        }
        return false;
    }

    public NodoLista elimina(String etiqueta)
    {
        NodoLista n = null;
        if (r != null)
        {
            if (etiqueta.compareTo(r.getSiguiente().getEtiqueta()) >= 0
                    && etiqueta.compareTo(r.getEtiqueta()) <= 0)
            {
                if (r.getSiguiente().getEtiqueta().equals(etiqueta))
                {
                    n = r.getSiguiente();
                    r.setSiguiente(n.getSiguiente());
                    n.getSiguiente().setAnterior(r);
                    if (r == n)
                    {
                        r = null;
                    }
                } else
                {
                    NodoLista aux = r.getSiguiente();
                    do
                    {
                        if (aux.getSiguiente().getEtiqueta().equals(etiqueta))
                        {
                            n = aux.getSiguiente();
                            aux.setSiguiente(n.getSiguiente());
                            aux.getSiguiente().setAnterior(aux);
                            if (n == r)
                            {
                                r = aux;
                            }
                            break;
                        } else
                        {
                            if (aux.getSiguiente().getEtiqueta().compareTo(etiqueta) > 0)//Para que antes del salto vea si es mayor al que quiere, si es mayor para que loo busca? si no va a estar
                            {
                                System.out.println("Dato no encontrado");
                                break;
                            } else
                            {
                                aux = aux.getSiguiente();
                            }
                        }
                    } while (aux != r.getSiguiente());
                }
            }

            if (n != null)
            {
                n.setSiguiente(null);
                n.setAnterior(null);
            } else
            {
                System.out.println("No se ha encontrado el dato");
            }

        } else
        {
            System.out.println("La lista simplemente ligada Circular está vacia");
        }

        return n;
    }
    public NodoLista eliminaConRuta(String etiqueta, String ruta)
    {
        NodoLista n = null;
        if (r != null)
        {
            if (etiqueta.compareTo(r.getSiguiente().getEtiqueta()) >= 0
                    && etiqueta.compareTo(r.getEtiqueta()) <= 0)
            {
                if (r.getSiguiente().getEtiqueta().equals(etiqueta)&&((Archivo)r.getObj()).getRuta().equals(ruta))
                {
                    n = r.getSiguiente();
                    r.setSiguiente(n.getSiguiente());
                    n.getSiguiente().setAnterior(r);
                    if (r == n)
                    {
                        r = null;
                    }
                } else
                {
                    NodoLista aux = r.getSiguiente();
                    do
                    {
                        if (aux.getSiguiente().getEtiqueta().equals(etiqueta)&&((Archivo)r.getObj()).getRuta().equals(ruta))
                        {
                            n = aux.getSiguiente();
                            aux.setSiguiente(n.getSiguiente());
                            aux.getSiguiente().setAnterior(aux);
                            if (n == r)
                            {
                                r = aux;
                            }
                            break;
                        } else
                        {
                            if (aux.getSiguiente().getEtiqueta().compareTo(etiqueta) > 0)//Para que antes del salto vea si es mayor al que quiere, si es mayor para que loo busca? si no va a estar
                            {
                                System.out.println("Dato no encontrado");
                                break;
                            } else
                            {
                                aux = aux.getSiguiente();
                            }
                        }
                    } while (aux != r.getSiguiente());
                }
            }

            if (n != null)
            {
                n.setSiguiente(null);
                n.setAnterior(null);
            } else
            {
                System.out.println("No se ha encontrado el dato");
            }
        } else
        {
            System.out.println("La lista simplemente ligada Circular está vacia");
        }

        return n;
    }

    public NodoLista busca(String etiqueta)
    {
        if (r != null)
        {
            NodoLista aux = r;
            do
            {
                if (aux.getEtiqueta().equals(etiqueta))
                {
                    return aux;
                } else
                {
                    aux = aux.getSiguiente();
                }
            }while (aux != r);
        }
        System.out.println("Dato no encontrado");
        return null;
    }

    public String desp(NodoLista aux)
    {
        if (aux != null)
        {
            if (aux != r)
            {
                return aux.getEtiqueta() + "\n" + desp(aux.getSiguiente());
            } else
            {
                return aux.getEtiqueta() + "\n" + despR(aux);
            }
        }
        return "";
    }

    private String despR(NodoLista aux)
    {
        if (aux.getAnterior() != r)
        {
            return aux.getEtiqueta() + "\n" + despR(aux.getAnterior());
        } else
        {
            return aux.getEtiqueta();
        }
    }
}
