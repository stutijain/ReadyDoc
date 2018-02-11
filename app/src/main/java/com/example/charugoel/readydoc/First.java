package com.example.charugoel.readydoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First extends AppCompatActivity {
    public Button but1,but2;
    public void init(){
        but1 = (Button)findViewById(R.id.button2);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(First.this , PatientLogin.class);
                startActivity(toy);
            }
        });
        but2 = (Button)findViewById(R.id.button);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy2 = new Intent(First.this , DoctorLogin.class);
                startActivity(toy2);
            }
        });
    }
    @Override
    public void onBackPressed(){
        //System.gc();
        //System.exit(0);
        //super.onBackPressed();
        //finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();

    }
}
