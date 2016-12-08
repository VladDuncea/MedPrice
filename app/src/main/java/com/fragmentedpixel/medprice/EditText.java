package com.fragmentedpixel.medprice;

import android.text.TextWatcher;
import android.widget.TextView;

/**
 * Created by vlad_ on 08.12.2016.
 */

public class EditText extends TextView {

    public EditText() {
        EditText searchTo = (EditText) findViewById(R.id.editText);
        searchTo.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                doSomething();
            }
        });
    }

}
