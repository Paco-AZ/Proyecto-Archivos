/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Lenovo
 */
public class NodoArbol <T>
{
    private String etiqueta;
    private T obj;
    private NodoArbol izquierda;
    private NodoArbol derecha;
    
    public NodoArbol(String etiqueta, T obj)
    {
        this.etiqueta=etiqueta;
        this.obj=obj;
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
     * @return the izquierda
     */
    public NodoArbol getIzquierda()
    {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(NodoArbol izquierda)
    {
        this.izquierda = izquierda;
    }

    /**
     * @return the derecha
     */
    public NodoArbol getDerecha()
    {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(NodoArbol derecha)
    {
        this.derecha = derecha;
    }
}
