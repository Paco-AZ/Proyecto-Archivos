/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class NodoLista<T> implements Cloneable, Serializable//está apuntando a una estructura igualita a él
{

    private String etiqueta;
    private T obj;
    private NodoLista siguiente;
    private NodoLista anterior;
    private NodoLista abajo; //Va a ser la r de la multilista
    private NodoLista arriba; //Va a ser la r de la multilista

    public NodoLista(String etiqueta, T obj)
    {
        this.etiqueta = etiqueta;
        this.obj = obj;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta()
    {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    /**
     * @return the obj
     */
    public T getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj)
    {
        this.obj = obj;
    }

    /**
     * @return the siguiente
     */
    public NodoLista getSiguiente()
    {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoLista siguiente)
    {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoLista getAnterior()
    {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoLista anterior)
    {
        this.anterior = anterior;
    }

    /**
     * @return the abajo
     */
    public NodoLista getAbajo()
    {
        return abajo;
    }

    /**
     * @param abajo the abajo to set
     */
    public void setAbajo(NodoLista abajo)
    {
        this.abajo = abajo;
    }

    /**
     * @return the arriba
     */
    public NodoLista getArriba()
    {
        return arriba;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(NodoLista arriba)
    {
        this.arriba = arriba;
    }

    @Override
    public String toString()
    {
        return etiqueta;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        NodoLista n = (NodoLista) super.clone();
        if (this.obj instanceof Cloneable)
        {
            n.setObj(cloneInnerObject(this.obj));
        }
        return n;
    }

    private Object cloneInnerObject(Object obj) throws CloneNotSupportedException
    {
        if (obj instanceof Cloneable)
        {
            try
            {
                return obj.getClass().getMethod("clone").invoke(obj);
            } catch (Exception e)
            {
                throw new CloneNotSupportedException("Failed to clone inner object");
            }
        } else
        {
            throw new CloneNotSupportedException("Inner object is not cloneable");
        }
    }

}