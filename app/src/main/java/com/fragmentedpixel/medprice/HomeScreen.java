package com.fragmentedpixel.medprice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.UpdateAppearance;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class HomeScreen extends AppCompatActivity {

    private EditText search_bar;
    private ImageView image_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        link();

    }

    private void link()
    {
        search_bar=(EditText) findViewById(R.id.editText);
        image_test=(ImageView) findViewById(R.id.image_test);
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

    public void search(){
        final EditText etName = (EditText) findViewById(R.id.editText);
        final String Name = etName.getText().toString();
        Response.Listener<String> loginListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean logged = jsonResponse.getBoolean("success");
                    //Toast.makeText(HomeScreen.this, "stai fa", Toast.LENGTH_SHORT).show();

                    if(logged){

                        String Name = jsonResponse.getString("Nume");
                        double Pret = jsonResponse.getDouble("Pret");
                        String Descriere = jsonResponse.getString("Descriere");
                        String Poza = jsonResponse.getString("Poza");

                        byte[] byteArray = Poza.getBytes("UTF-16");  //Transforma poza in binar
                        byte[] data = Base64.decode(byteArray, Base64.DEFAULT); // decodeaza poza cryptata in base 64
                        Bitmap bm = BitmapFactory.decodeByteArray(data, 0 ,data.length); //transforma in bitemap
                        image_test.setImageBitmap(bm);//seteaza imageView
                        //String Username = jsonResponse.getString("Username");

                       /* Intent intent = new Intent(HomeScreen.this,HomeScreen.class);
                        intent.putExtra("FirstName",FirstName);
                        intent.putExtra("LastName",LastName);
                        intent.putExtra("Email",Email);
                        //intent.putExtra("Username",Username);
                        HomeScreen.this.startActivity(intent);*/

                        Toast.makeText(HomeScreen.this,Name+Pret+Descriere,Toast.LENGTH_LONG).show();
                    }
                    else{
                        AlertDialog.Builder alert = new AlertDialog.Builder(HomeScreen.this);
                        alert.setMessage("Login Failed").setNegativeButton("Retry",null).create().show();
                    }
                } catch (JSONException e) {
                    //Toast.makeText(HomeScreen.this, e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        };

        Update_Home loginRequest = new Update_Home(Name,loginListener);
        RequestQueue loginQueue = Volley.newRequestQueue(HomeScreen.this);
        loginQueue.add(loginRequest);

    }

    public void home_refresh(View view)
    {
        search();
    }

}