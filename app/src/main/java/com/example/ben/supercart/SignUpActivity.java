package com.example.ben.supercart;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);



        final EditText editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
        final EditText editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        final EditText editTextUserName=(EditText)findViewById(R.id.editTextUserName);
        editTextPassword.setTypeface(Typeface.DEFAULT);
        editTextConfirmPassword.setTypeface(Typeface.DEFAULT);
        Button btnCreateAccount = (Button)findViewById(R.id.buttonCreateAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Firebase myFirebaseRef = new Firebase("https://supercart.firebaseio.com/");

                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                if(userName == "" || password == ""){

                }else{
                    myFirebaseRef.createUser(userName, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
                        @Override
                        public void onSuccess(Map<String, Object> result) {
                            System.out.println("Successfully created user account with uid: " + result.get("uid"));
                        }

                        @Override
                        public void onError(FirebaseError firebaseError) {
                            // there was an error
                        }
                    });
                    setResult(RESULT_OK);
                    finish();
                }

            }
        });


    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }


}
