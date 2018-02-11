package com.example.charugoel.readydoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DocRegistration extends AppCompatActivity {
    private Button register;
    private DatabaseReference mdatabase;
    private EditText e1, e2, e3, e4, e5, e6,e7;
    private FirebaseAuth firebaseAuth;
    private Firebase mRef;
    FirebaseAuth.AuthStateListener fauto;
    private Button but;

    public void init(){
        but = findViewById(R.id.sendData);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy3 = new Intent(DocRegistration.this , account.class);
                startActivity(toy3);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_registration);
        init();
        Firebase.setAndroidContext(this);
        register=(Button)findViewById(R.id.sendData);
        e1=(EditText)findViewById(R.id.edn);
        e2=(EditText)findViewById(R.id.edq);
        e3=(EditText)findViewById(R.id.eds);
        e4=(EditText)findViewById(R.id.edp);
        e5=(EditText)findViewById(R.id.ede);
        e6=(EditText)findViewById(R.id.edc);
        e7=(EditText)findViewById(R.id.edpass);
       // mRef=new Firebase("https://readydoc-5f9eb.firebaseio.com/");

        mdatabase= FirebaseDatabase.getInstance().getReference();
        firebaseAuth=FirebaseAuth.getInstance();
        fauto=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null)
                {
                }
            }
        };
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=e1.getText().toString().trim();
                String qual=e2.getText().toString().trim();
                String spe=e3.getText().toString().trim();
                String phone=e4.getText().toString().trim();
                String email=e5.getText().toString().trim();
                String city=e6.getText().toString().trim();
                String passw= e7.getText().toString().trim();
                if(name.equals("")){
                    e1.setError("can't be blank");
                    Toast.makeText(DocRegistration.this,"Fields incomplete...",Toast.LENGTH_SHORT).show();
                }
                else if(qual.equals("")){
                    e2.setError("can't be blank");
                    Toast.makeText(DocRegistration.this,"Fields incomplete...",Toast.LENGTH_SHORT).show();
                }
                else if(spe.equals("")){
                    e3.setError("can't be blank");
                    Toast.makeText(DocRegistration.this,"Fields incomplete...",Toast.LENGTH_SHORT).show();
                }
                else if(phone.equals("")){
                    e4.setError("can't be blank");
                    Toast.makeText(DocRegistration.this,"Fields incomplete...",Toast.LENGTH_SHORT).show();
                }
                else if(email.equals("")){
                    e5.setError("can't be blank");
                    Toast.makeText(DocRegistration.this,"Fields incomplete...",Toast.LENGTH_SHORT).show();
                }
                else if(city.equals("")){
                    e6.setError("can't be blank");
                    Toast.makeText(DocRegistration.this,"Fields incomplete...",Toast.LENGTH_SHORT).show();
                }
                else if(passw.equals("")){
                    e6.setError("can't be blank");
                    Toast.makeText(DocRegistration.this,"Fields incomplete...",Toast.LENGTH_SHORT).show();
                }

                else {
                    if(spe=="Phy") {
                        mRef = new Firebase("https://readydoc-5f9eb.firebaseio.com/Phy");
                    }
                    else
                    {
                        mRef=new Firebase("https://readydoc-5f9eb.firebaseio.com/");
                    }
                    HashMap<String,String> data=new HashMap<String, String>();
                    data.put("Name",name);
                    data.put("Qualification",qual);
                    data.put("Specialisation",spe);
                    data.put("Phone",phone);
                    data.put("Email",email);
                    data.put("City",city);
                    data.put("Password", passw);
                    //Firebase mRefChild = mRef.child("Name");
                    // mRefChild.setValue("Aksha");
                    mRef.push().setValue(data);
                firebaseAuth.createUserWithEmailAndPassword(email,passw);

                }
            }
        });
    }

    protected void onStart()
    {
        super.onStart();
        firebaseAuth.addAuthStateListener(fauto);
    }
}

