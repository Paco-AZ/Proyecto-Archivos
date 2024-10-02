/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Lenovo
 */
public class PrbMultilista
{

    public static void main(String[] args)
    {
        NodoLista r = null;
        /*
        r = Multilista.inserta(r, 0, new String[]{""}, new NodoLista("A", null));
        r = Multilista.inserta(r, 0, new String[]{""}, new NodoLista("B", null));
        r = Multilista.inserta(r, 0, new String[]{""}, new NodoLista("C", null));

        r = Multilista.inserta(r, 0, new String[]{"A", ""}, new NodoLista("A1", null));
        NodoLista a = new NodoLista("AA1", null);
        r = Multilista.inserta(r, 0, new String[]{"A", "A1", ""}, a);
        a.setAbajo(Multilista.inserta(a.getAbajo(), 0, new String[]{""}, new NodoLista("hermano", null)));

        System.out.println("Estructura inicial:");
        Multilista.desp(r, r, "");

        r = Multilista.Edesp(r, r, "A1");

        System.out.println("Estructura después de eliminar 'A1':");
        Multilista.desp(r, r, "");
        
         */

        r = Multilista.inserta(r, 0, new String[]
        {
            ""
        }, new NodoLista("A", new Archivo("nom", "ext", "fec", "aut", 'c', 12, "ru")));
        r = Multilista.inserta(r, 0, new String[]
        {
            ""
        }, new NodoLista("B", new Archivo("nom", "ext", "fec", "aut", 'c', 12, "ru")));
        r = Multilista.inserta(r, 0, new String[]
        {
            "A", ""
        }, new NodoLista("A1", new Archivo("nom", "ext", "fec", "aut", 'c', 12, "ru")));
        r = Multilista.inserta(r, 0, new String[]
        {
            "A", ""
        }, new NodoLista("A2", new Archivo("nom", "ext", "fec", "aut", 'c', 12, "ru")));
        r = Multilista.inserta(r, 0, new String[]
        {
            "A", "A2",""
        }, new NodoLista("AA21", new Archivo("nom", "ext", "fec", "aut", 'c', 12, "ru")));

        r = Multilista.inserta(r, 0, new String[]
        {
            "A", "A1",""
        }, new NodoLista("AA1", new Archivo("nom", "ext", "fec", "aut", 'c', 12, "ru")));

        r = Multilista.inserta(r, 0, new String[]
        {
            "A", "A1",""
        }, new NodoLista("AAA2", new Archivo("nom", "ext", "fec", "aut", 'c', 12, "ru")));

        
        r = Multilista.inserta(r, 0, new String[]
        {
            "A", "A1","AA1",""
        }, new NodoLista("AAA2", new Archivo("nom", "ext", "fec", "aut", 'c', 12, "ru")));

        r = Multilista.inserta(r, 0, new String[]
        {
            "A", "A1","AAA2",""
        }, new NodoLista("AA1", new Archivo("nom", "ext", "fec", "aut", 'c', 12, "ru")));


        NodoLista<Archivo> n=Metodos.buscaArchivo(r, "A1");
        System.out.println(n.getEtiqueta());
        System.out.println("Res: "+ calculoPeso(n.getAbajo(), n.getAbajo(), 0));
        System.out.println("***********");
        Multilista.desp(r, r, "");
    }
 
    public static int calculoPeso(NodoLista<Archivo> r, NodoLista<Archivo> aux, int pesoTotal)
    {
        if (r != null)
        {
            do
            {
                r = r.getSiguiente();
                if (r.getAbajo() != null)
                {
                    pesoTotal += r.getObj().getTamanio();
                    calculoPeso(r.getAbajo(), r.getAbajo(), pesoTotal);
                }
                pesoTotal += r.getObj().getTamanio();
            } while (r != aux);
            System.out.println("Pes: " + pesoTotal);
            return pesoTotal;
        } else
        {
            return 0;
        }
    }

}

//        NodoLista n1= new NodoLista("Mexico", null);
//        NodoLista n2= new NodoLista("Alemania", null);
//        NodoLista n3= new NodoLista("Grecia", null);
//        NodoLista n4= new NodoLista("Colombia", null);
//        
//        NodoLista e1=new NodoLista("CDMX", null);
//        NodoLista e2=new NodoLista("berlin", null);
//        NodoLista e3=new NodoLista("atenas", null);
//        NodoLista e4=new NodoLista("medellin", null);
//        NodoLista e5=new NodoLista("rusia", null);
//        
//        NodoLista es1= new NodoLista("Argos", null);
//        NodoLista es2= new NodoLista("niños heroes", null);
//        NodoLista es3= new NodoLista("justo sierra", null);
//        NodoLista es4= new NodoLista("abc", null);
//        
//        NodoLista r=null;
//        r=Multilista.inserta(r, 0, new String[]{""}, n1);
//        r=Multilista.inserta(r, 0, new String[]{""}, n2);
//        r=Multilista.inserta(r, 0, new String[]{""}, n3);
//        r=Multilista.inserta(r, 0, new String[]{""}, n4);
//        
//        r=Multilista.inserta(r, 0, new String[]{"Mexico",""}, e1);
//        r=Multilista.inserta(r, 0, new String[]{"Alemania",""}, e2);
//        r=Multilista.inserta(r, 0, new String[]{"Grecia",""}, e3);
//        r=Multilista.inserta(r, 0, new String[]{"Colombia",""}, e4);
//        r=Multilista.inserta(r, 0, new String[]{"p","e","es"}, es1);
//        r=Multilista.inserta(r, 0, new String[]{"p","e","es"}, es2);
//        r=Multilista.inserta(r, 0, new String[]{"p","e","es"}, es3);
//        r=Multilista.inserta(r, 0, new String[]{"p","e","es"}, es4);
//        System.out.println(Multilista.buscaGeneral(r, r, "B1").getEtiqueta());
//        NodoLista l =Multilista.busca(r, "B");
//        NodoLista l2 =Multilista.busca(l.getAbajo(), "BB1");
//        NodoLista l3 =Multilista.busca(l2.getAbajo(), "nivel3");
//        
//        
//        if (l3!=null)
//        {
//            System.out.println(l3.getArriba().getArriba().getEtiqueta());
//        } else
//        {
//            System.out.println("s");
//        }
//        
//        System.out.println(l2.getArriba().getEtiqueta());
//        Multilista.desp2(l2, l2,"");
//        Multilista.desp(r, r,"");
//        System.out.println("*****************************");
//        NodoLista arr[]=new NodoLista[2];
//        Multilista.elimina(r, 0, new String[]{"C"}, arr);
//        r=arr[1];
//        System.out.println(arr[0].getEtiqueta());
//        System.out.println("*******************");
