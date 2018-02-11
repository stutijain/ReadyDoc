package com.example.charugoel.readydoc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class account extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

       firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,DoctorLogin.class));
        }

        FirebaseUser user= firebaseAuth.getCurrentUser();

        buttonLogout = (Button) findViewById(R.id.button15);

        buttonLogout.setOnClickListener(this);}

    public void onClick(View view){
        if(view==buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,DoctorLogin.class));
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}




