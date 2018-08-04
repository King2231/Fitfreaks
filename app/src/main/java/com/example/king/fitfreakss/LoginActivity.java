package com.example.king.fitfreakss;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Email, Password;
    Button signup, login;
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        Email = findViewById(R.id.emailR);
        Password = findViewById(R.id.passwordR);
        signup = findViewById(R.id.btn_signup);
        login = findViewById(R.id.btn_login);

        signup.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    private void signUp(){
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            Email.setError("Email cannot be empty");
            Toast.makeText(getApplicationContext(),"Email cannot be empty",Toast.LENGTH_SHORT);
            return;
        }
        if (TextUtils.isEmpty(password)){
            Password.setError("Password cannot be empty");
            Toast.makeText(getApplicationContext(),"Password cannot be empty",Toast.LENGTH_SHORT);
            return;
        }
        if (password.length()<8){
            Password.setError("Password too short");
            Toast.makeText(getApplicationContext(),"Password too short",Toast.LENGTH_SHORT);
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            String s = "Sign up Failed" + task.getException();
                            Toast.makeText(getApplicationContext(), s,Toast.LENGTH_SHORT).show();
                            Log.e("unsuccessful", s);
                        }

                        // ...
                    }
                });
    }

    private void logIn(){
        //Redirect to login page
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_signup:
                signUp();
                break;
            case R.id.btn_login:
                logIn();
                break;
        }
    }
}
