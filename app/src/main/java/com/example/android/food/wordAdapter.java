package com.example.android.food;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;



public class wordAdapter extends ArrayAdapter<words> {
    private int colorid;
    public wordAdapter(Context context, ArrayList<words> numbers,int color) {
        super(context,0,numbers);
        colorid=color;
    }
    private  int quantity;
    private   int priceTotal;
    private  TextView  price;
    private  TextView quantityText;
    @NonNull
    @Override
    public  View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_items, parent, false);
        }
         words currentword = getItem(position);

        TextView name = (TextView) convertView.findViewById(R.id.item_name);
        name.setText(currentword.getNameOfItem());

         price = (TextView) convertView.findViewById(R.id.item_price);
        price.setText("" + currentword.getPriceOfItem());

        quantityText = (TextView) convertView.findViewById(R.id.quantity_text_view);
        quantityText.setText("" + currentword.getQuantityOfItem());

        ImageView itemview = (ImageView) convertView.findViewById(R.id.imageView);
        itemview.setImageResource(currentword.getresource());

        Button inc = (Button) convertView.findViewById(R.id.inc);
        final View finalConvertView = convertView;
        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityText = (TextView) finalConvertView.findViewById(R.id.quantity_text_view);
                String s= quantityText.getText().toString();
                int q=Integer.parseInt(s);
                q++;
                quantityText.setText("" + q);
               price = (TextView) finalConvertView.findViewById(R.id.item_price);
                 String st=  price.getText().toString();
                int p=Integer.parseInt(st);
                returnPrice(p,1);

            }
        });

        Button dec = (Button) convertView.findViewById(R.id.dec);
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityText = (TextView) finalConvertView.findViewById(R.id.quantity_text_view);
                String s= quantityText.getText().toString();
               int  q=Integer.parseInt(s);
                q--;
                quantityText.setText("" + q);
                price = (TextView) finalConvertView.findViewById(R.id.item_price);
                String st=  price.getText().toString();
                int p=Integer.parseInt(st);
                returnPrice(p,0);
            }
        });
        View textcolor=convertView.findViewById(R.id.linearlayout);
        int color= ContextCompat.getColor(getContext(),colorid);
        textcolor.setBackgroundColor(color);
        return convertView;
     }
     public void returnPrice(int pr,int qu){
         if(qu==1) {
             priceTotal = priceTotal + (pr);
         }else if(qu==0){
             priceTotal = priceTotal - (pr);
         }
     }
    public  int giveprice(){
       return priceTotal;
    }
}
