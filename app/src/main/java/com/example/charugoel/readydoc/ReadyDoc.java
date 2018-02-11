package com.example.charugoel.readydoc;
import android.app.Application;
import com.firebase.client.Firebase;


public class ReadyDoc extends Application {
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
