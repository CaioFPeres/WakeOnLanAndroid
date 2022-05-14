package com.example.ligarpc;

import com.google.firebase.database.*;

public class FirebaseClient {

    MainActivity context;
    FirebaseDatabase database;
    DatabaseReference ref;

    FirebaseClient(MainActivity context){
        this.context = context;
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Ligar");
    }

    public void set(){
        ref.setValue(true);
    }

}
