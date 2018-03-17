package com.company.reportarchive.reportarchive.signup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.company.reportarchive.reportarchive.activities.MainActivity;
import com.company.reportarchive.reportarchive.R;
import com.company.reportarchive.reportarchive.utils.Utilities;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    FirebaseDatabase db;

    public static String USER_NAME;

    EditText userNameText, phoneNumberText, emailText, passwordText;
    Button register;
    public FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        getSupportActionBar().hide();

        userNameText = (EditText) findViewById(R.id.userNameText);
        phoneNumberText =(EditText)findViewById(R.id.phoneText);
        emailText = (EditText)findViewById(R.id.emailText);
        passwordText =(EditText) findViewById(R.id.passwordText);
        register = (Button) findViewById(R.id.registerButton);
        register.setOnClickListener(this);
    }
    boolean validateInput() {

        boolean result = true;
        String username = userNameText.getText().toString();

        String password = passwordText.getText().toString();
        String phone = phoneNumberText.getText().toString();
        String email = emailText.getText().toString();
        if (username.trim().length() == 0) {
            userNameText.setError("Please enter userName");
            result = false;
        }
        if (password.trim().length() == 0) {
            passwordText.setError("Please enter password");
            result = false;
        }
        if (phone.trim().length() == 0) {
            phoneNumberText.setError("Please enter phone");
            result = false;
        }else if(phone.trim().length() != 10){
            phoneNumberText.setError("Enter valid Phone number");
            result = false;
        }else if(phone.trim().contains("+91")){
            if(phone.trim().length() != 12){
                phoneNumberText.setError("Enter valid phone number");
                result = false;
            }
        }
        if (email.trim().length() == 0) {
            emailText.setError("Please enter email");
            result = false;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerButton:
                if (validateInput())
                    attemptRegister();
                break;
        }
    }

    void registerUser(final String email, final String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String token = FirebaseInstanceId.getInstance().getToken();
                        if (task.isSuccessful() && token!=null) {
                            //showProgress(false);
                            Utilities.sendIdTokenToServer(FirebaseDatabase.getInstance(),token
                                    , userNameText.getText().toString()
                                    , emailText.getText().toString(),
                                    phoneNumberText.getText().toString());
                            USER_NAME = userNameText.getText().toString();
                            Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                            startActivity(intent);
                            //Utilites.startHome(SignUpActivity.this);
                            Toast.makeText(SignupActivity.this, "user Regsitered", Toast.LENGTH_SHORT).show();
                            //loginSuccessful();
                        } else {
                            //showProgress(false);
                            Toast.makeText(SignupActivity.this, "Unable to Register ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }


    private void attemptRegister() {

        // Reset errors.
        emailText.setError(null);
        passwordText.setError(null);
        phoneNumberText.setError(null);
        userNameText.setError(null);

        // Store values at the time of the login attempt.
        String username = userNameText.getText().toString();
        String password = passwordText.getText().toString();
        String phone = phoneNumberText.getText().toString();
        String email = emailText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordText.setError("Enter Password");
            focusView = passwordText;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            emailText.setError("Enter Email");
            focusView = emailText;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailText.setError("Enter Valid Email");
            focusView = emailText;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //showProgress(true);
//            mAuthTask = new UserLoginTask(email, password);
//            mAuthTask.execute((Void) null);

            registerUser(email, password);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
}
