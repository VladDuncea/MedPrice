package com.fragmentedpixel.medprice;

import android.graphics.Bitmap;

import java.util.ArrayList;


public class Medicamente
{
    public static ArrayList<Medicamente> toateMedicamentele = new ArrayList<>();
    public static Medicamente medicamentAles;

    private String denumire;
    private float pret;
    private Bitmap imagine;
    private String substanta_activa;


    public Medicamente(String denumire, float pret, Bitmap imagine, String ingrediente)
    {
        this.denumire = denumire;
        this.pret = pret;
        this.imagine = imagine;
        this.substanta_activa = ingrediente;

        Medicamente.toateMedicamentele.add(this);
    }

    public String getDenumire()
    {
        return denumire;
    }

    public float getPret()
    {
        return pret;
    }

    public Bitmap getImagine()
    {
        return imagine;
    }

    public String getSubstanta_activa()
    {
        return substanta_activa;
    }

    public static ArrayList<Medicamente> FilterSimilare ()
    {
        String cautat = medicamentAles.getSubstanta_activa();

        ArrayList<Medicamente> lista_filtrata = new ArrayList<>();
        for (Medicamente medicament : Medicamente.toateMedicamentele)
        {
            if(medicament.getSubstanta_activa().toUpperCase().contains(cautat.toUpperCase()))
                lista_filtrata.add(medicament);
        }
        lista_filtrata.remove(medicamentAles);

        return lista_filtrata;
    }

    public static ArrayList<Medicamente> Filter (String cautat)
    {
        ArrayList<Medicamente> lista_filtrata = new ArrayList<>();
        for (Medicamente medicament : Medicamente.toateMedicamentele)
        {
            if(medicament.getDenumire().toUpperCase().contains(cautat.toUpperCase()))
                lista_filtrata.add(medicament);
        }
        return lista_filtrata;
    }
}
