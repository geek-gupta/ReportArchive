package com.company.reportarchive.reportarchive.fetch_data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by gaurav on 18/3/18.
 */

public class Fetchdata {


    public FirebaseAuth firebaseAuth;
    FirebaseDatabase db;
    DatabaseReference myref;

    void fetchData(){
        db = FirebaseDatabase.getInstance();
        myref = db.getReference();




    }


}
