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
public class PrbArbolBinario
{

    public static void main(String[] args)
    {
        ArbolBinario ab = new ArbolBinario();

//        NodoArbol n1 = new NodoArbol("E", null);
//        NodoArbol n2 = new NodoArbol("C", null);
//        NodoArbol n3 = new NodoArbol("H", null);
//        NodoArbol n4 = new NodoArbol("B", null);
//        NodoArbol n5 = new NodoArbol("D", null);
//        NodoArbol n6 = new NodoArbol("G", null);
//        NodoArbol n7 = new NodoArbol("I", null);
//        NodoArbol n8 = new NodoArbol("A", null);
//        NodoArbol n9 = new NodoArbol("C", null);
//        NodoArbol n10 = new NodoArbol("X", null);
//
//        ab.setR(ab.inserta(ab.getR(), n1));
//        ab.setR(ab.inserta(ab.getR(), n2));
//        ab.setR(ab.inserta(ab.getR(), n3));
//        ab.setR(ab.inserta(ab.getR(), n4));
//        ab.setR(ab.inserta(ab.getR(), n5));
//        ab.setR(ab.inserta(ab.getR(), n6));
//        ab.setR(ab.inserta(ab.getR(), n7));
//        ab.setR(ab.inserta(ab.getR(), n8));
//        ab.setR(ab.inserta(ab.getR(), n9));
//        ab.setR(ab.inserta(ab.getR(), n10));
//**************************************************Ver si se balancea
//        NodoArbol n1 = new NodoArbol("B", null);
//        NodoArbol n2 = new NodoArbol("A", null);
//        NodoArbol n3 = new NodoArbol("D", null);
//        NodoArbol n4 = new NodoArbol("C", null);
//        NodoArbol n5 = new NodoArbol("E", null);
        NodoArbol n1 = new NodoArbol("A", null);
        NodoArbol n2 = new NodoArbol("A", null);
        NodoArbol n3 = new NodoArbol("A", null);
        NodoArbol n4 = new NodoArbol("A", null);
        NodoArbol n5 = new NodoArbol("A", null);
        ab.setR(ab.inserta(ab.getR(), n1));
        ab.setR(ab.inserta(ab.getR(), n2));
        ab.setR(ab.inserta(ab.getR(), n3));
        ab.setR(ab.inserta(ab.getR(), n4));
        ab.setR(ab.inserta(ab.getR(), n5));

//        System.out.println(ab.preOrden(ab.getR()));
//        System.out.println(ab.posOrden(ab.getR()));
        ArrayList<NodoArbol> arr = new ArrayList();
        ab.buscaTodos(ab.getR().getDerecha(), "A", arr);
        System.out.println("**********");
        for (NodoArbol<NodoArbol> a:arr)
        {
            System.out.println(a.getEtiqueta());
        }
        System.out.println("---------");
        System.out.println(ab.enOrden(ab.getR()));
//        NodoArbol arr[] = new NodoArbol[2];
//        ab.elimina(ab.getR(), "A", arr);
//        ab.setR(arr[1]);
//        System.out.println("Dato eliminado: "+arr[0].getEtiqueta()); 
    }
}
