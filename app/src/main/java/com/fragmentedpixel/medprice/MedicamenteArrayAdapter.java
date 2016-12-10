package com.fragmentedpixel.medprice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MedicamenteArrayAdapter extends ArrayAdapter<Medicamente>
{
    private LayoutInflater inflater;

    public MedicamenteArrayAdapter(Context context, List<Medicamente> listaMedicamente)
    {
        super(context, R.layout.linie_lista, R.id.txt_item, listaMedicamente);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final Medicamente medicament = (Medicamente) this.getItem(position);
        final TextView textView;
        final ImageView imagine;

        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.linie_lista, null);

            textView = (TextView) convertView.findViewById(R.id.txt_item);
            imagine = (ImageView) convertView.findViewById(R.id.img_item);

            convertView.setTag(new MedicamenteViewHolder(textView, imagine));
            //TODO: add on click listener
        }
        else
        {
            MedicamenteViewHolder viewHolder = (MedicamenteViewHolder) convertView.getTag();
            textView = viewHolder.getTextView();
            imagine = viewHolder.getImage();
        }

        textView.setTag(medicament);

        assert medicament != null;
        textView.setText(medicament.getDenumire());
        imagine.setImageBitmap(medicament.getImagine());

        return  convertView;
    }
}
