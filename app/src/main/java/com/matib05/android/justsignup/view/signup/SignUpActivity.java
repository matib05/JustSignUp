package com.matib05.android.justsignup.view.signup;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.matib05.android.justsignup.view.list.GitActivity;
import com.matib05.android.justsignup.R;
import com.matib05.android.justsignup.presenter.SignUpPresenter;



public class SignUpActivity extends AppCompatActivity implements SignUpView{

    SignUpPresenter presenter;
    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private Button mSignUp;
    private static final String TAG = "SignUpActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        presenter = new SignUpPresenter(this);

        mName = (EditText) findViewById(R.id.editText_name);
        mEmail = (EditText) findViewById(R.id.editText_email);
        mPassword = (EditText) findViewById(R.id.editText_password);

        mSignUp = (Button) findViewById(R.id.sign_up_button);
        mSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                presenter.onSignUpClicked();
            }
        });
    }

    @Override
    public void showNameError(int resId) {
        mName.setError(getString(resId));
    }

    @Override
    public String getName() {
        return mName.getText().toString().trim();
    }


    @Override
    public void navigateToPickActivity() {
        Intent intent = new Intent(getApplicationContext(), GitActivity.class);
        intent.putExtra("username", getName());
        startActivity(intent);
        finish();
    }

    @Override
    public String getEmail() {
        return mEmail.getText().toString().trim();
    }

    @Override
    public void showEmailError(int resId) {
        mEmail.setError(getString(resId));
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString().trim();
    }

    @Override
    public void showPasswordError(int resId) {
        mPassword.setError(getText(resId));
    }


    protected void sendEmail() {

        String[] TO = {"matib05@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "TEST");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "TESTING");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SignUpActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
