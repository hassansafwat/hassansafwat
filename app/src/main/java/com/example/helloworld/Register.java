package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText txtEmail ,txtPassword ,txtConfirmPassword;
    Button Bt_register;
    ProgressBar ProgressBar;
    private FirebaseAuth mfirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Sign_up");
        txtEmail= (EditText)findViewById(R.id.text_Email);
        txtPassword= (EditText)findViewById(R.id.text_password);
        txtConfirmPassword= (EditText)findViewById(R.id.text_Confirm_password);
        Bt_register=(Button)findViewById(R.id.button_register);
        ProgressBar=(ProgressBar)findViewById(R.id.ProgressBar);
        mfirebaseAuth=FirebaseAuth.getInstance();

        Bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String Confirm_password = txtConfirmPassword.getText().toString().trim();


                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this,"please enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this,"please enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Confirm_password)){
                    Toast.makeText(Register.this,"please enter ConfirmPassword",Toast.LENGTH_SHORT).show();
                    return;
                }
               /* if (Confirm_password!=password){
                    Toast.makeText(Register.this,"confirm not equal password",Toast.LENGTH_SHORT).show();

                }*/
                if (password.length()<6){
                    Toast.makeText(Register.this,"password is too short",Toast.LENGTH_SHORT).show();

                }
                ProgressBar.setVisibility(View.VISIBLE);
                if (password.equals(Confirm_password)){
                    mfirebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    ProgressBar.setVisibility(View.GONE);

                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        Toast.makeText(Register.this,"Registration complete",Toast.LENGTH_SHORT).show();

                                    } else {

                                        Toast.makeText(Register.this,"Authentication failed",Toast.LENGTH_SHORT).show();


                                    }

                                }
                            });


                }




            }
        });
    }
}
