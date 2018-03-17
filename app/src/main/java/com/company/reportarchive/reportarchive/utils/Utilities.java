package com.company.reportarchive.reportarchive.utils;

import android.app.Activity;
import android.content.Intent;

import com.company.reportarchive.reportarchive.activities.MainActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gaurav on 17/3/18.
 */

public class Utilities {

    private Calendar calendar;
    static Date currentTime = Calendar.getInstance().getTime();


//    static public void startHome(Activity context){
//        Intent intent = new Intent(context, MainActivity.class);
//        context.startActivity(intent);
//        context.finish();
//    }

    public static void sendIdTokenToServer(FirebaseDatabase db,String token,String name,String email,String phone){
        DatabaseReference myref= db.getReference().child("users").child(encodeEmail(email.trim().toLowerCase()));
        myref.child("Uname").setValue(name);
        myref.child("UToken").setValue(token);
        myref.child("Uphone").setValue(phone);

    }


    public static void sendTestData(FirebaseDatabase db, String aadharId, String hospitalId, String doctorId, String date, String diseaseOne, String diseaseOneDesc
            , String diseaseTwo, String diseaseTwoDesc
            , String diseaseThree, String diseaseThreeDesc
            , String diseaseFour, String diseaseFourDesc) {



        DatabaseReference myRef = db.getReference().child(aadharId).child(Calendar.getInstance().getTime().toString());
        myRef.child("Hospital Id").setValue(hospitalId);
        myRef.child("Doctor Id").setValue(doctorId);
        myRef.child("Date").setValue(date);
        myRef.child(diseaseOne).setValue(diseaseOneDesc);
        myRef.child(diseaseTwo).setValue(diseaseTwoDesc);
        myRef.child(diseaseThree).setValue(diseaseThree);
        myRef.child(diseaseFour).setValue(diseaseFourDesc);
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
