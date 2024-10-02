/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class Archivo implements Cloneable, Serializable
{

    private String nombre;
    private String extension;
    private String fecha;
    private String autor;
    private char tipo;
    private int tamanio;
    private String ruta;

    public Archivo(String nombre, String extension, String fecha, String autor, char tipo, int tamanio, String ruta)
    {
        this.nombre = nombre;
        this.extension = extension;
        this.fecha = fecha;
        this.autor = autor;
        this.tipo = tipo;
        this.tamanio = tamanio;
        this.ruta = ruta;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the extension
     */
    public String getExtension()
    {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    /**
     * @return the fecha
     */
    public String getFecha()
    {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    /**
     * @return the autor
     */
    public String getAutor()
    {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    /**
     * @return the tipo
     */
    public char getTipo()
    {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo)
    {
        this.tipo = tipo;
    }

    /**
     * @return the tamanio
     */
    public int getTamanio()
    {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio)
    {
        this.tamanio = tamanio;
    }

    /**
     * @return the ruta
     */
    public String getRuta()
    {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta)
    {
        this.ruta = ruta;
    }

    @Override
    public String toString()
    {
        return "Archivo{" + "nombre=" + nombre + ", extension=" + extension + ", fecha=" + fecha + ", autor=" + autor + ", tipo=" + tipo + ", tamanio=" + tamanio + ", ruta=" + ruta + '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
