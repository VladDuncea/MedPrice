package com.fragmentedpixel.medprice;

import android.widget.ImageView;
import android.widget.TextView;

public class MedicamenteViewHolder {
    private TextView textView;
    private ImageView image;

    public MedicamenteViewHolder(TextView textView, ImageView image)
    {
        this.textView = textView;
        this.image = image;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public ImageView getImage()
    {
        return image;
    }

    public void setImage(ImageView image)
    {
        this.image = image;
    }
}
