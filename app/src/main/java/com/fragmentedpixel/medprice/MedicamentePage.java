package com.fragmentedpixel.medprice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MedicamentePage extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamente_page);

        listView = (ListView) (findViewById(R.id.lista_medicamente_similare));
        Link();
        PopulateList();
    }

    private void Link()
    {
        ImageView imagineMedicament;
        TextView pretMedicament, numeMedicament;

        imagineMedicament = (ImageView) findViewById(R.id.pagina_med_poza);
        numeMedicament = (TextView) findViewById(R.id.pagina_med_nume);
        pretMedicament = (TextView) findViewById(R.id.pagina_med_pret);

        imagineMedicament.setImageBitmap(Medicamente.medicamentAles.getImagine());
        numeMedicament.setText(Medicamente.medicamentAles.getDenumire());
        pretMedicament.setText(String.valueOf(Medicamente.medicamentAles.getPret()));
    }

    private void PopulateList()
    {
        MedicamenteArrayAdapter listAdapter;
        ArrayList<Medicamente> lista = Medicamente.FilterSimilare();

        listAdapter = new MedicamenteArrayAdapter(this, lista);
        listView.setAdapter(listAdapter);
    }
}
