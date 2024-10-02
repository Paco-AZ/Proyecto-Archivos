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
public class Multilista implements Serializable
{
    
    public static NodoLista inserta(NodoLista r, int nivel, String s[], NodoLista n)
    {
        if (s.length - 1 == nivel)
        {
            ListaDoblementeLigadaCircular ldlc = new ListaDoblementeLigadaCircular(); //técnico
            ldlc.setR(r);
            ldlc.inserta(n);
            return ldlc.getR();
        } else
        {
//            NodoLista aux = busca(r, s[nivel]);
//            if (aux != null)
//            {
//                NodoLista retorno = inserta(aux.getAbajo(), nivel + 1, s, n);
//                aux.setAbajo(retorno);
//                n.setArriba(aux);
//            }
            
            NodoLista aux = busca(r, s[nivel]);
            if (aux != null)
            {
                aux.setAbajo(inserta(aux.getAbajo(), nivel + 1,s,n));
                if (n.getArriba() == null)
                {
                    n.setArriba(aux);
                }
            }
            return r;
        }
    }
    
    public static void elimina(NodoLista r, int nivel, String s[], NodoLista arr[])
    {
        if (nivel == s.length - 1)
        {
            ListaDoblementeLigadaCircular ldlc = new ListaDoblementeLigadaCircular();
            ldlc.setR(r);
            arr[0] = ldlc.elimina(s[nivel]);
            if (arr[0] != null)
            {
                arr[0].setArriba(null);
            }
            
            arr[1] = ldlc.getR();
        } else
        {
            NodoLista aux = busca(r, s[nivel]);
            if (aux != null)
            {
                elimina(aux.getAbajo(), nivel + 1, s, arr);
                aux.setAbajo(arr[1]);
            }
            arr[1] = r;
        }
    }
    public static void eliminaR(NodoLista r, int nivel, String s[], NodoLista arr[], String ruta)
    {
        if (nivel == s.length - 1)
        {
            ListaDoblementeLigadaCircular ldlc = new ListaDoblementeLigadaCircular();
            ldlc.setR(r);
            arr[0] = ldlc.eliminaConRuta(s[nivel],ruta);
            if (arr[0] != null)
            {
                arr[0].setArriba(null);
            }
            
            arr[1] = ldlc.getR();
        } else
        {
            NodoLista aux = busca(r, s[nivel]);
            if (aux != null)
            {
                elimina(aux.getAbajo(), nivel + 1, s, arr);
                aux.setAbajo(arr[1]);
            }
            arr[1] = r;
        }
    }

    // Método auxiliar para eliminar un nodo específico
    public static NodoLista busca(NodoLista r, String s)
    {
        ListaDoblementeLigadaCircular ldlc = new ListaDoblementeLigadaCircular();
        ldlc.setR(r);
        return ldlc.busca(s);
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
}
//    public static NodoLista buscaGeneral(NodoLista r, NodoLista aux, String elemento)
//    {
//        NodoLista encontrado = null;
//        if (r != null)
//        {
//            do
//            {
//                r = r.getSiguiente();
//
//                if (r.getEtiqueta().equals(elemento))
//                {
//                    return r;
//                }
//                if (r.getAbajo() != null)
//                {
//                    encontrado = buscaGeneral(r.getAbajo(), r.getAbajo(), elemento);
//                }
//            } while (r != aux);
//        }
//
//        return encontrado;
//    }
