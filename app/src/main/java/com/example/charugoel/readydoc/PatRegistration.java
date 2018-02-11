package com.example.charugoel.readydoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

public class PatRegistration extends AppCompatActivity {
    private Button but3;

    private void init() {
        but3 = (Button) findViewById(R.id.button8);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy6 = new Intent(PatRegistration.this, ReadyDocPage.class);
                startActivity(toy6);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_registration);
        init();
    }
}
