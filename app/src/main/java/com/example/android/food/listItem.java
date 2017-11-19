package com.example.android.food;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//import static com.example.android.food.wordAdapter.giveprice;

public class listItem extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        ArrayList<words> numbers=new ArrayList<>();
        numbers.add(new words("CHOLE BHATURE", 80,R.drawable.chole_bhature_pic));
        numbers.add(new words("CHAOLE KULCHE",  70,R.drawable.chole_kulche_pic));
       numbers.add(new words("PAV BHAJI",  70,R.drawable.pav_bhaji));
       numbers.add(new words("SHAHI PANEER",  110,R.drawable.shahi_paneer));
        numbers.add(new words("DAL MAKHANI",  100,R.drawable.dal_makhani_pic));
       numbers.add(new words("ROTI", 10,R.drawable.roti));
       numbers.add(new words("THALI",  250,R.drawable.thali));
        numbers.add(new words("NOODLES",  90,R.drawable.noodles));
       numbers.add(new words("IDLI SAMBAR", 70,R.drawable.idli_sambar));
       numbers.add(new words("DOSA",90,R.drawable.dosa_pic));


        final wordAdapter itemsAdapter = new wordAdapter(this,numbers,R.color.tan_background);

         ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        Button orderbutton=(Button)findViewById(R.id.order);
        orderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int s=itemsAdapter.giveprice();
                String extra_name = getIntent().getStringExtra("EXTRA_NAME");
                AlertDialog.Builder myAlert=new AlertDialog.Builder(listItem.this);
                myAlert.setMessage("Thankyou : "+extra_name+"\n"+"Price: ₹"+s)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(listItem.this,MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setTitle("Your Order Summary")
                        .create();
                myAlert.show();
            }
        });

    }

}
