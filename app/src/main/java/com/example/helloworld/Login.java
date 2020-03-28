package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText txtEmail ,txtPassword;
    Button Bt_login;
    FirebaseAuth mFirebaseAuth;
    TextView TvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Log_in");
        txtEmail= (EditText)findViewById(R.id.TE);
        txtPassword= (EditText)findViewById(R.id.TP);
        Bt_login=(Button)findViewById(R.id.Log_in);
        TvSignIn= findViewById(R.id.Text_view);
        mFirebaseAuth= FirebaseAuth.getInstance();

        Bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this,"please enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this,"please enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6){
                    Toast.makeText(Login.this,"password is too short",Toast.LENGTH_SHORT).show();
                }

                mFirebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                FirebaseUser Firebaseuser =mFirebaseAuth.getCurrentUser();
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    Toast.makeText(Login.this,"log in  complete",Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Login.this,"Login Failed or User not Available",Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        });


        TvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

    }

}
