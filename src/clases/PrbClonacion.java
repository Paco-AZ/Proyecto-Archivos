/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class PrbClonacion
{
    public static void main(String[] args)
    {
        NodoLista <Archivo>n = new NodoLista("hola", new Archivo("nombre", "exte", "fe", "au", 'c', 15, "ru"));
        
        try
        {
            NodoLista <Archivo>a=(NodoLista)n.clone();
            
            a.getObj().setNombre("se modifico");
            
            System.out.println("de n: "+n.getObj().getNombre());
            System.out.println("de a: "+a.getObj().getNombre());
        } catch (CloneNotSupportedException ex)
        {
            Logger.getLogger(PrbClonacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
