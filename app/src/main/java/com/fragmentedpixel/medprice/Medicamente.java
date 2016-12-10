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
    private String descriere;
    private String ingrediente;

    private ArrayList<Medicamente> medicamente_similare = new ArrayList<>() ;

    public Medicamente(String denumire, float pret, Bitmap imagine, String descriere, String ingrediente)
    {
        this.denumire = denumire;
        this.pret = pret;
        this.imagine = imagine;
        this.descriere = descriere;
        this.ingrediente = ingrediente;

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

    public String getDescriere()
    {
        return descriere;
    }

    public String getIngrediente()
    {
        return ingrediente;
    }

    public void SetMedicamenteSimilare()
    {
        // TODO: add this
        // implementare Medicamenete Similare
    }
}
