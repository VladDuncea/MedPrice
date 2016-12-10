package com.fragmentedpixel.medprice;

import android.widget.ImageView;
import android.widget.TextView;

public class MedicamenteViewHolder {
    private TextView textView;
    private ImageView image;
    private TextView pretView;

    public MedicamenteViewHolder(TextView textView, ImageView image, TextView pretView)
    {
        this.textView = textView;
        this.image = image;
        this.pretView = pretView;
    }

    public TextView getTextView()
    {
        return textView;
    }

    public void setTextView(TextView textView)
    {
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

    public TextView getPretView()
    {
        return pretView;
    }

    public void setPretView(TextView pretView)
    {
        this.pretView = pretView;
    }
}
