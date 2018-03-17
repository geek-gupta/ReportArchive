package com.company.reportarchive.reportarchive.utils;

import android.app.Activity;
import android.content.Intent;

import com.company.reportarchive.reportarchive.MainActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by gaurav on 17/3/18.
 */

public class Utilities {

//    static public void startHome(Activity context){
//        Intent intent = new Intent(context, MainActivity.class);
//        context.startActivity(intent);
//        context.finish();
//    }

    public static void sendIdTokenToServer(FirebaseDatabase db,String token,String name,String email,String phone,String groupName){
        DatabaseReference myref= db.getReference().child("users").child(encodeEmail(email.trim().toLowerCase()));
        myref.child("Uname").setValue(name);
        myref.child("UToken").setValue(token);
        myref.child("Uphone").setValue(phone);

        db.getReference("groups").child(groupName).setValue(groupName);


    }

    public static void launchHomeScreen(Activity context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        context.finish();
    }
    public  static  void updateToken(FirebaseDatabase db, String email, String token){

        DatabaseReference myref= db.getReference().child("users").child(encodeEmail(email.trim().toLowerCase()));
        myref.child("UToken").setValue(token);
    }
    public  static String encodeEmail(String email){
        email =  email.replace('.','-');
        email = email.replace('#','=');
        email = email.replace('$','+');
        email = email.replace('[',')');
        email = email.replace(']','(');
        email = email.replace('/','|');
        return  email;
    }
}
