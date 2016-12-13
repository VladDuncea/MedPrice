package com.fragmentedpixel.medprice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //dUNCEA
        link();
        UpdateDB();
    }

    private void link()
    {
        EditText search_bar;
        search_bar=(EditText) findViewById(R.id.editText);
        search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //refresh();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void home_refresh(View view)
    {
        PopulateList();
    }

    private void PopulateList()
    {
        ListView listView = (ListView) findViewById(R.id.lista_medicamente);
        MedicamenteArrayAdapter listAdapter;
        EditText searchedText = (EditText) findViewById(R.id.editText);
        ArrayList<Medicamente> lista = Medicamente.Filter(searchedText.getText().toString());
        listAdapter = new MedicamenteArrayAdapter(this, lista);
        listView.setAdapter(listAdapter);
    }

    public void UpdateDB(){
        final EditText etName = (EditText) findViewById(R.id.editText);
        final String Name = etName.getText().toString();
        Response.Listener<String> loginListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    int c = jsonResponse.getInt("contor");
                    for(int i = 1; i <= c; i++)
                    {
                        String Name = jsonResponse.getString("Nume"+i);
                        float Pret = (float) jsonResponse.getDouble("Pret"+i);
                        String Descriere = jsonResponse.getString("Descriere"+i);
                        String Ingrediente = jsonResponse.getString("Ingrediente"+i);

                        String Poza = jsonResponse.getString("Poza"+i);
                        byte[] byteArray = Poza.getBytes("UTF-16");  //Transforma poza in binar
                        byte[] data = Base64.decode(byteArray, Base64.DEFAULT); // decodeaza poza cryptata in base 64
                        Bitmap bm = BitmapFactory.decodeByteArray(data, 0 ,data.length); //transforma in bitemap

                        Medicamente medicament = new Medicamente(Name, Pret, bm, Descriere, Ingrediente);
                    }

                } catch (JSONException | UnsupportedEncodingException e) {
                    Toast.makeText(HomeScreen.this, e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        };

        Update_Home loginRequest = new Update_Home(Name,loginListener);
        RequestQueue loginQueue = Volley.newRequestQueue(HomeScreen.this);
        loginQueue.add(loginRequest);
    }
}