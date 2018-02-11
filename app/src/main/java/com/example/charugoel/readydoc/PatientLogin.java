package com.example.charugoel.readydoc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PatientLogin extends AppCompatActivity {
    private EditText Email;
    private EditText Password;
    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    public Button but3, but4;

    public void init() {
        but3 = (Button) findViewById(R.id.button5);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy4 = new Intent(PatientLogin.this, PatRegistration.class);
                startActivity(toy4);

            }
        });
      /*  but4 = (Button) findViewById(R.id.button6);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy5 = new Intent(PatientLogin.this, ReadyDocPage.class);
                startActivity(toy5);
            }
        });*/
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(PatientLogin.this, First.class));
    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_patient_login);

            mAuth=FirebaseAuth.getInstance();
            Email = findViewById(R.id.Email);
            Password = findViewById(R.id.Password);
            Button mLoginBtn = findViewById(R.id.button6);
            mAuthListener=new FirebaseAuth.AuthStateListener(){

                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    if(firebaseAuth.getCurrentUser() != null){
                        Intent toy = new Intent(PatientLogin.this, ReadyDocPage.class);
                        startActivity(toy);
                    }
                }
            } ;
            mLoginBtn.setOnClickListener(new View.OnClickListener(){
               public void onClick(View view){
                   startLogin();
               }
            });
            init();
            }



           @Override
            protected void onStart(){
            super.onStart();
            mAuth.addAuthStateListener(mAuthListener);
        }

        private void startLogin(){
                String email = Email.getText().toString();
                String pass = Password.getText().toString();
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){
                    Toast.makeText(PatientLogin.this, "Fields Are Empty", Toast.LENGTH_LONG).show();
                }
                else{
                    mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(PatientLogin.this, "Sign In Denied", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
        }
    }


