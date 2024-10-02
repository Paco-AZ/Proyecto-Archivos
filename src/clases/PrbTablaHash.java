/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import jframes.VtnPrincipal;

/**
 *
 * @author Usuario
 */
public class PrbTablaHash
{
    public static void main(String[] args)
    {
        NodoArbol a1=new NodoArbol("Narciso", null);
        NodoArbol a2=new NodoArbol("Pancracio", null);
        NodoArbol a3=new NodoArbol("Ambrocio", null);
        NodoArbol a4=new NodoArbol("Panfilo", null);
        NodoArbol a5=new NodoArbol("Petra", null);
        NodoArbol a6=new NodoArbol("Putla", null);
        
        TablaHashArbol tb = new TablaHashArbol();
        tb.inserta(a1);
        tb.inserta(a2);
        tb.inserta(a3);
        tb.inserta(a4);
        tb.inserta(a5);
        tb.inserta(a6);
        
        NodoArbol na = tb.busca("Putla");
        System.out.println(na.getEtiqueta());
        System.out.println("***************");
        System.out.println(tb.elimina("Putla").getEtiqueta());
        
        System.out.println("***************");
        na = tb.busca("Putla");
        System.out.println(na);
        
    }
}
