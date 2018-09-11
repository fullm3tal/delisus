package com.example.dakaku.delisus.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dakaku.delisus.utils.AppConstants;
import com.example.dakaku.delisus.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";

    @BindView(R.id.textView_login_signUp)
    TextView textViewSignUp;
    @BindView(R.id.textView_login_signIn)
    TextView textViewSignIn;

    @BindView(R.id.editText_email)
    EditText editTextEmail;
    @BindView(R.id.editText_password)
    EditText editTextPassword;

    @BindView(R.id.bt_guestLogin)
    Button buttonGuestLogin;

    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mFirebaseAuth = FirebaseAuth.getInstance();
        textViewSignUp.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);
        buttonGuestLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent signInIntent;

        switch (view.getId()) {

            case R.id.textView_login_signUp:

                signInIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signInIntent);
                finish();

                break;

            case R.id.textView_login_signIn:

                signInUser();
                 
               if(TextUtils.isEmpty(editTextEmail.getText().toString()) && TextUtils.isEmpty(editTextPassword.getText().toString())) {
                   editTextEmail.setError("Please enter an email");
                   editTextPassword.setError("Please enter a password");
               }

               if(TextUtils.isEmpty(editTextEmail.getText().toString())){
                   editTextEmail.setError("Please enter an email");
               }

               if(TextUtils.isEmpty(editTextPassword.getText().toString())){
                   editTextPassword.setError("Please enter a password");
               }
                break;

            case R.id.bt_guestLogin:
                signInIntent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(signInIntent);
                finish();
                break;

            default:
                Toast.makeText(LoginActivity.this, "Invalid view", Toast.LENGTH_SHORT).show();

        }
    }

    private void signInUser() {

        String loginEmail= editTextEmail.getText().toString();
        final String loginPassword= editTextPassword.getText().toString();

           if ( TextUtils.isEmpty(loginEmail)) {
               return;
           }

           if ( TextUtils.isEmpty(loginPassword)) {
               return;
           }

          if( TextUtils.isEmpty(loginEmail) &&  TextUtils.isEmpty(loginPassword)){
               return;
           }


        mFirebaseAuth.signInWithEmailAndPassword(loginEmail, loginPassword)
                .addOnCompleteListener(LoginActivity.this,
                new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()) {

                    if (loginPassword.length() < 6) {

                        editTextPassword.setError("Password should be of 6 or more Characters length");
                    } else {
                        editTextPassword.setError("Please enter a valid e-mail or password");
                    }

                } else {

                    FirebaseUser firebaseUser=mFirebaseAuth.getCurrentUser();
                    String username=firebaseUser.getDisplayName();
                    Toast.makeText(LoginActivity.this, "Login successful",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra(AppConstants.USERNAME_KEY,username);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}
