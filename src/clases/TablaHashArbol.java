/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class TablaHashArbol
{

    private ArbolBinario arr[] = new ArbolBinario[26];

    public TablaHashArbol()
    {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]=new ArbolBinario();
        }
    }
    
    public void inserta(NodoArbol n)
    {
        if (n != null)
        {
            int pos = n.getEtiqueta().trim().toUpperCase().charAt(0) - 65;
            arr[pos].setR(arr[pos].inserta(arr[pos].getR(), n));
        } else
        {
            System.out.println("No se puede insertar");
        }
    }

    public NodoArbol busca(String etiqueta)
    {
        if (etiqueta.isEmpty())
        {
            System.out.println("Error... La cadena está vacia");
            return null;
        } else
        {
            int pos = etiqueta.trim().toUpperCase().charAt(0) - 65;
            return arr[pos].busca(arr[pos].getR(), etiqueta);
        }
    }
    
    public NodoArbol elimina(String etiqueta)
    {
        if (etiqueta.isEmpty())
        {
            System.out.println("Error... La cadena está vacia");
            return null;
        } else
        {
            int pos = etiqueta.trim().toUpperCase().charAt(0) - 65;
            NodoArbol elimi[] =new NodoArbol[2];
            arr[pos].elimina(arr[pos].getR(), etiqueta, elimi);
            arr[pos].setR(elimi[1]);
            return elimi[0];
        }
    }
    public NodoArbol eliminaRuta(String etiqueta,String ruta)
    {
        if (etiqueta.isEmpty())
        {
            System.out.println("Error... La cadena está vacia");
            return null;
        } else
        {
            int pos = etiqueta.trim().toUpperCase().charAt(0) - 65;
            NodoArbol elimi[] =new NodoArbol[2];
            arr[pos].eliminaRepe(arr[pos].getR(), etiqueta, ruta, elimi);
            arr[pos].setR(elimi[1]);
            return elimi[0];
        }
    }
}
