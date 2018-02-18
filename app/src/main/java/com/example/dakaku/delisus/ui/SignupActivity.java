package com.example.dakaku.delisus.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dakaku.delisus.AppConstants;
import com.example.dakaku.delisus.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SignupActivity";

    @BindView(R.id.textView_register_signInUser)
    TextView textViewSignInUser;
    @BindView(R.id.textView_registerUser)
    TextView textViewRegisterUser;
    @BindView(R.id.editText_username)
    EditText editTextUsername;
    @BindView(R.id.editText_email)
    EditText editTextEmail;
    @BindView(R.id.editText_password)
    EditText editTextPassword;

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);
        mFirebaseAuth = FirebaseAuth.getInstance();

        textViewSignInUser.setOnClickListener(this);
        textViewRegisterUser.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent signUpIntent;

        switch (view.getId()) {

            case R.id.textView_register_signInUser:
                signUpIntent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(signUpIntent);
                finish();
                break;

            case R.id.textView_registerUser:
                creatingUserAccount();
                if (TextUtils.isEmpty(editTextUsername.getText().toString())){
                    editTextUsername.setError("Please enter a Username");
                }

                if (TextUtils.isEmpty(editTextEmail.getText().toString())) {
                    editTextEmail.setError( "Please enter an email");
                }

                if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
                    editTextPassword.setError("Please enter a Password");
                }

                if(TextUtils.isEmpty(editTextEmail.getText().toString())&& TextUtils.isEmpty(editTextPassword.getText().toString())){
                    editTextEmail.setError( "Please enter an email");
                    editTextPassword.setError("Please enter a Password");
                }

                if (TextUtils.isEmpty(editTextUsername.getText().toString())&& TextUtils.isEmpty(editTextPassword.getText().toString())){
                    editTextUsername.setError("Please enter a Username");
                    editTextPassword.setError("Please enter a Password");
                }

                if (TextUtils.isEmpty(editTextEmail.getText().toString())&& TextUtils.isEmpty(editTextUsername.getText().toString())){
                    editTextEmail.setError( "Please enter an email");
                    editTextUsername.setError("Please enter a Username");
                }

                if (TextUtils.isEmpty(editTextEmail.getText().toString())&& TextUtils.isEmpty(editTextPassword.getText().toString())&& TextUtils.isEmpty(editTextUsername.getText().toString())){
                    editTextEmail.setError( "Please enter an email");
                    editTextUsername.setError("Please enter a Username");
                    editTextPassword.setError("Please enter a Password");
                }

                break;

            default:
                Toast.makeText(SignupActivity.this, "Invalid view", Toast.LENGTH_SHORT).show();

        }
    }

    private void creatingUserAccount() {

        final String signUpUsername=editTextUsername.getText().toString().trim();
        final String signUpEmail = editTextEmail.getText().toString().trim();
        final String signUpPassword = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(signUpUsername)){
            return;
        }

        if (TextUtils.isEmpty(signUpEmail)) {
            return;
        }

        if (TextUtils.isEmpty(signUpPassword)) {
           return;
        }

        if(TextUtils.isEmpty(signUpEmail)&& TextUtils.isEmpty(signUpPassword)){
            return;
        }

        if (TextUtils.isEmpty(signUpUsername)&& TextUtils.isEmpty(signUpPassword)){
            return;
        }

        if (TextUtils.isEmpty(signUpEmail)&& TextUtils.isEmpty(signUpUsername)){
            return;
        }

        if (TextUtils.isEmpty(signUpEmail)&& TextUtils.isEmpty(signUpPassword)&& TextUtils.isEmpty(signUpUsername)){
            return;
        }


        mFirebaseAuth.createUserWithEmailAndPassword(signUpEmail,
                signUpPassword).addOnCompleteListener(SignupActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {

                            if (signUpPassword.length() < 6) {

                                editTextPassword.setError("Password should be of 6 or more Characters length");
                            } else {
                                editTextPassword.setError("Please enter a valid email or password");
                            }
                        } else {
                            // User creation is successful
                            Toast.makeText(SignupActivity.this,
                                    "User successfully registered ",
                                    Toast.LENGTH_SHORT).show();

                            FirebaseUser mCurrentUser=mFirebaseAuth.getCurrentUser();

                            UserProfileChangeRequest userProfileChangeRequest= new UserProfileChangeRequest.Builder()
                                    .setDisplayName(signUpUsername)
                                    .build();

                            if (mCurrentUser != null) {
                                mCurrentUser.updateProfile(userProfileChangeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                    }
                                });
                            }

                            Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                            intent.putExtra(AppConstants.USERNAME_KEY,signUpUsername);
                            startActivity(intent);
                            finish();
                        }
                    }
                });


    }
}
