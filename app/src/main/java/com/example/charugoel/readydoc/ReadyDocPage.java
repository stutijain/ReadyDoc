package com.example.charugoel.readydoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ReadyDocPage extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    //private TextView textViewUserEmail;
    private Button buttonLogout;

    public LinearLayout l_layout,lay2,lay3,lay4,lay5;

    public void init() {
        l_layout = (LinearLayout) findViewById(R.id.linearLayout);
        l_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy5 = new Intent(ReadyDocPage.this, FAQS.class);
                startActivity(toy5);
            }
        });
        lay2 = (LinearLayout) findViewById(R.id.linearLayout4);
        lay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy6 = new Intent(ReadyDocPage.this, HomeRemedies.class);
                startActivity(toy6);
            }
        });
        lay3 = (LinearLayout) findViewById(R.id.linearLayout21);
        lay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy7 = new Intent(ReadyDocPage.this, Reminder.class);
                startActivity(toy7);
            }
        });
        lay4 = (LinearLayout) findViewById(R.id.linearLayout20);
        lay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy8 = new Intent(ReadyDocPage.this, Diseases.class);
                startActivity(toy8);
            }
        });
        lay5 = (LinearLayout) findViewById(R.id.linearLayout19);
        lay5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy9 = new Intent(ReadyDocPage.this, QA.class);
                startActivity(toy9);
            }
        });
   /* public ImageButton but3;

    public void init() {
        but3 = (ImageButton) findViewById(R.id.imageButton2);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy5 = new Intent(ReadyDocPage.this, FAQS.class);
                startActivity(toy5);
            }
        });*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_doc_page);
        init();
       firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(ReadyDocPage.this,PatientLogin.class));
        }

        FirebaseUser user= firebaseAuth.getCurrentUser();
        buttonLogout = (Button) findViewById(R.id.logout);

        buttonLogout.setOnClickListener(this);}

    public void onClick(View view){
        if(view==buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(ReadyDocPage.this,PatientLogin.class));
        }

    }
}
