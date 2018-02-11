package com.example.charugoel.readydoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ReadyDoc2 extends AppCompatActivity {

    public LinearLayout l_layout,lay2,lay3,lay4,lay5;

    public void init() {
        l_layout = (LinearLayout) findViewById(R.id.linearLayout);
        l_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy5 = new Intent(ReadyDoc2.this, FAQS.class);
                startActivity(toy5);
            }
        });
        lay2 = (LinearLayout) findViewById(R.id.linearLayout4);
        lay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy6 = new Intent(ReadyDoc2.this, HomeRemedies.class);
                startActivity(toy6);
            }
        });
        lay3 = (LinearLayout) findViewById(R.id.linearLayout19);
        lay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy7 = new Intent(ReadyDoc2.this, Reminder.class);
                startActivity(toy7);
            }
        });
        lay4 = (LinearLayout) findViewById(R.id.linearLayout20);
        lay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy8 = new Intent(ReadyDoc2.this, QA.class);
                startActivity(toy8);
            }
        });
        lay5 = (LinearLayout) findViewById(R.id.linearLayout21);
        lay5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy9 = new Intent(ReadyDoc2.this, Diseases.class);
                startActivity(toy9);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_doc2);
        init();
    }
}
