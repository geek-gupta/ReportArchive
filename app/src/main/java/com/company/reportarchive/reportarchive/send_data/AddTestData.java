package com.company.reportarchive.reportarchive.send_data;

import android.content.Intent;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.company.reportarchive.reportarchive.R;
import com.company.reportarchive.reportarchive.activities.MainActivity;
import com.company.reportarchive.reportarchive.signup.SignupActivity;
import com.company.reportarchive.reportarchive.utils.Utilities;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

import org.w3c.dom.Document;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AddTestData extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference myRef;
    Button submitTest;

    public FirebaseAuth firebaseAuth;
    private EditText mAadharid, mDoctorid, mHospitalId, mDdText, mMmText, mYyyyText, mDiseaseOne, mDiseaseTwo, mDiseaseThree, mDiseaseFour,
    mDiseaseOneDesc, mDiseaseTwoDesc, mDiseaseThreeDesc, mDiseaseFourDesc;

    String aadharid, hospitalId, doctorId, yyyyText, mmText, diseaseTwoDesc, diseasetwo, diseaseThreeDesc, diseaseThree, diseaseOneDesc, diseaseOne, diseaseFourDesc,
            diseasFour, ddText;
    String mainResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test_data);

        db = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();






        mAadharid = (EditText) findViewById(R.id.patient_aadhar_id);
        mDdText = (EditText) findViewById(R.id.dd_text);
        mDiseaseFour = (EditText) findViewById(R.id.disease_four);
        mDiseaseFourDesc = (EditText) findViewById(R.id.disease_four_desc);
        mDiseaseOne = (EditText) findViewById(R.id.disease_one);
        mDiseaseOneDesc = (EditText) findViewById(R.id.disease_one_desc);
        mDiseaseThree = (EditText) findViewById(R.id.disease_three);
        mDiseaseThreeDesc = (EditText) findViewById(R.id.disease_three_desc);
        mDiseaseTwo = (EditText) findViewById(R.id.disease_two);
        mDiseaseTwoDesc = (EditText) findViewById(R.id.disease_two_desc);
        mDoctorid = (EditText) findViewById(R.id.doctor_id);
        mHospitalId = (EditText) findViewById(R.id.hospital_id);
        mMmText = (EditText) findViewById(R.id.mm_text);
        mYyyyText = (EditText) findViewById(R.id.yyyy_text);
        submitTest = (Button) findViewById(R.id.submit_btn);




        submitTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aadharid = mAadharid.getText().toString();
                Log.d("DataSendActivity",aadharid);
                hospitalId = mHospitalId.getText().toString();
                doctorId = mDoctorid.getText().toString();
                yyyyText = mYyyyText.getText().toString();
                mmText = mMmText.getText().toString();
                diseaseTwoDesc = mDiseaseTwoDesc.getText().toString();
                diseasetwo = mDiseaseTwo.getText().toString();
                diseaseThreeDesc = mDiseaseThreeDesc.getText().toString();
                diseaseThree = mDiseaseThree.getText().toString();
                diseaseOneDesc = mDiseaseOneDesc.getText().toString();
                diseaseOne = mDiseaseOne.getText().toString();
                diseaseFourDesc = mDiseaseFourDesc.getText().toString();
                diseasFour = mDiseaseFour.getText().toString();
                ddText = mDdText.getText().toString();

                mainResult = "Aadhar id : " + aadharid +"\n"+
                             "Hospital id : " + hospitalId+"\n"+
                             "Doctor id : " + doctorId + "\n" +
                             "Date : " + ddText+"/"+mmText+"/"+yyyyText+"\n"+
                             diseaseOne + " : " + diseaseOneDesc + "\n"+
                             diseasetwo + " : " + diseaseTwoDesc + "\n"+
                             diseaseThree + " : " + diseaseThreeDesc + "\n" +
                             diseasFour + " : " + diseaseFourDesc + "\n";

                if (validateInput()) {
                    attemptSubmit();
                    Toast.makeText(AddTestData.this, "Data Submitted", Toast.LENGTH_SHORT).show();
                }

//                myRef = db.getReference().child("users").child(SignupActivity.USER_NAME)
//                myRef.

            }
        });



    }

    boolean validateInput() {

        boolean result = true;



        if (aadharid.trim().length() == 0) {
            mAadharid.setError("Please enter userName");
            result = false;
        }
        if (hospitalId.trim().length() == 0) {
            mHospitalId.setError("Please enter userName");
            result = false;
        }
        if (doctorId.trim().length() == 0) {
            mDoctorid.setError("Please enter userName");
            result = false;
        }
        if (yyyyText.trim().length() == 0) {
            mYyyyText.setError("Please enter userName");
            result = false;
        }
        if (mmText.trim().length() == 0) {
            mMmText.setError("Please enter userName");
            result = false;
        }
        if (diseaseTwoDesc.trim().length() == 0) {
            mDiseaseTwoDesc.setError("Please enter userName");
            result = false;
        }

        if (diseasetwo.trim().length() == 0) {
            mDiseaseTwo.setError("Please enter password");
            result = false;
        }
        if (diseaseThreeDesc.trim().length() == 0) {
            mDiseaseThreeDesc.setError("Please enter password");
            result = false;
        }
        if (diseaseThree.trim().length() == 0) {
            mDiseaseThree.setError("Please enter password");
            result = false;
        }
        if (diseaseOneDesc.trim().length() == 0) {
            mDiseaseOneDesc.setError("Please enter password");
            result = false;
        }
        if (diseaseOne.trim().length() == 0) {
            mDiseaseOne.setError("Please enter password");
            result = false;
        }
        if (diseaseFourDesc.trim().length() == 0) {
            mDiseaseFourDesc.setError("Please enter password");
            result = false;
        }
        if (diseasFour.trim().length() == 0) {
            mDiseaseFour.setError("Please enter password");
            result = false;
        }

        if (ddText.trim().length() == 0) {
            mDdText.setError("Please enter password");
            result = false;
        }


        return true;
    }







    void attemptSubmit() {
        String date = ddText + "/" + mmText + "/" + yyyyText;
       Utilities.sendTestData(db,aadharid,hospitalId,doctorId,date,diseaseOne,diseaseOneDesc,diseasetwo,diseaseTwoDesc,diseaseThree,diseaseThreeDesc,diseasFour,diseaseFourDesc);
    }
}
