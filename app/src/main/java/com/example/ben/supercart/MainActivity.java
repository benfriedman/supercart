package com.example.ben.supercart;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    static final int SIGN_UP = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);


        setUpButtons();
    }


    protected void setUpButtons(){
        Button loginButton = (Button)findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.login);
                dialog.setTitle("Login");

                // get the references of views
                final EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
                final EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);
                editTextPassword.setTypeface(Typeface.DEFAULT);

                Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

                // Set On ClickListener
                btnSignIn.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        // get The User name and Password
                        String userName=editTextUserName.getText().toString();
                        String password=editTextPassword.getText().toString();

                        // fetch the Password form database for respective user name
                        //String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

                        // check if the Stored password matches with  Password entered by user
                        /*if(password.equals(storedPassword))
                        {
                            Toast.makeText(HomeActivity.this, "Login Successfull", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }
                        else
                        {

                            Toast.makeText(HomeActivity.this, "User Name and Does Not Matches", Toast.LENGTH_LONG).show();
                        }*/

                    }
                });


                dialog.show();
            }
        });

        Button signupButton = (Button)findViewById(R.id.signupButton);

        signupButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent intentSignUp=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivityForResult(intentSignUp, SIGN_UP);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SIGN_UP){
            if (resultCode == RESULT_OK){
                System.out.println("came back from sign up");
                finish();
                /*Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);*/
            }
        }
    }
}
