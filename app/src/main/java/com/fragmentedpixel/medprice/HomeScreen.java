package com.fragmentedpixel.medprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {
    private EditText search_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        link();
    }

    private void link()
    {
        search_bar=(EditText) findViewById(R.id.editText);
        search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }



}