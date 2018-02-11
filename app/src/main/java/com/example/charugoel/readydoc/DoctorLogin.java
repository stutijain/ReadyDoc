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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DoctorLogin extends AppCompatActivity {
    private EditText EmailField;
    private EditText PasswordField;
    public Button but1;
    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    public void init(){
        but1 = findViewById(R.id.button3);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy3 = new Intent(DoctorLogin.this , DocRegistration.class);
                startActivity(toy3);
            }
        });
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(DoctorLogin.this, First.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        mAuth=FirebaseAuth.getInstance();
        EmailField = findViewById(R.id.EmailField);
        PasswordField= findViewById(R.id.PasswordField);
        Button mloginbtn = findViewById(R.id.button4);
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null){                            //==null means user has not logged in,!=null means user has logged in ,so move to next activity
                    Intent toy6 = new Intent(DoctorLogin.this, account.class);
                    startActivity(toy6);
                }

            }
        };

        mloginbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick( View view){
                startlogin();
            }
        });
        init();
    }

    @Override
    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startlogin(){
        String email=EmailField.getText().toString();
        String password=PasswordField.getText().toString();
        if(TextUtils.isEmpty(email)  || TextUtils.isEmpty(password)){
            Toast.makeText(DoctorLogin.this, "Fields are empty", Toast.LENGTH_LONG).show();
        }
        else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(DoctorLogin.this, "Sign in denied", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }}