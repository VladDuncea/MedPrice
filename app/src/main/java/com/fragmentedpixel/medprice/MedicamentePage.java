package com.fragmentedpixel.medprice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MedicamentePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamente_page);

        Link();
    }

    private void Link()
    {
        ImageView imagineMedicament;
        TextView pretMedicament, numeMedicament, descriereMedicament, ingredienteMedicament;
        imagineMedicament = (ImageView) findViewById(R.id.pagina_med_poza);
        numeMedicament = (TextView) findViewById(R.id.pagina_med_nume);
        descriereMedicament = (TextView) findViewById(R.id.pagina_med_descriere);
        pretMedicament = (TextView) findViewById(R.id.pagina_med_pret);
        ingredienteMedicament = (TextView) findViewById(R.id.pagina_med_ingred);

        imagineMedicament.setImageBitmap(Medicamente.medicamentAles.getImagine());
        numeMedicament.setText(Medicamente.medicamentAles.getDenumire());
        descriereMedicament.setText(Medicamente.medicamentAles.getDescriere());
        pretMedicament.setText(Float.toString(Medicamente.medicamentAles.getPret()));
        ingredienteMedicament.setText(Medicamente.medicamentAles.getIngrediente());
    }
}
