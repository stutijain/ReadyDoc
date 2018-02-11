package com.example.charugoel.readydoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FAQS extends AppCompatActivity {
    public LinearLayout l_layout,lay2;

    public void init() {
        l_layout = (LinearLayout) findViewById(R.id.linearLayout2);
        l_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy5 = new Intent(FAQS.this, FAQ1.class);
                startActivity(toy5);
            }
        });
        lay2 = (LinearLayout) findViewById(R.id.linearLayout7);
        lay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy6 = new Intent(FAQS.this, FAQ2.class);
                startActivity(toy6);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        init();
    }
}
