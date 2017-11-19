package com.example.android.food;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private String name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button menu=(Button)findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=(TextView)findViewById(R.id.editText);
                name1=(name.getText().toString());

                Intent intent=new Intent(MainActivity.this,listItem.class);
                intent.putExtra("EXTRA_NAME", name1);
                startActivity(intent);}
        });
    }

}
