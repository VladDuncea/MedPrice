package com.fragmentedpixel.medprice;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeScreen extends AppCompatActivity {

    private EditText search_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        link();
        //byte[] byteArray = DBcursor.getBlob(columnIndex);

       // Bitmap bm = BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length);
    }

    private void link()
    {
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