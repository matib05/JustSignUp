package com.matib05.android.justsignup.presenter;

import android.util.Log;

import com.google.firebase.database.FirebaseDatabase;
import com.matib05.android.justsignup.R;
import com.matib05.android.justsignup.view.signup.SignUpView;

import java.util.UUID;

/**
 * Created by matib05 on 9/11/2017.
 */

public class SignUpPresenter {
    private SignUpView view;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();

    public SignUpPresenter(SignUpView view) {
        this.view = view;
    }

    public void onSignUpClicked() {
        String name = view.getName();
        if(name.isEmpty()) {
            view.showNameError(R.string.name_error);
            return;
        }
        String email = view.getEmail();
        if (email.isEmpty() || email.length() == 0 || email.equals("") || !email.contains("@") || !email.contains(".")) {
            view.showEmailError(R.string.email_error);
            return;
        }
        String password = view.getPassword();
        if (password.isEmpty() || password.length() == 0 || password.equals("")) {
            view.showPasswordError(R.string.password_error);
            return;
        }
        signUp(name, email, password);
        view.navigateToPickActivity();

    }

    private void signUp(String name, String email, String password) {
        UUID userId = UUID.randomUUID();
        mDatabase.getReference().child(userId.toString()).child("Name").setValue(name);
        mDatabase.getReference().child(userId.toString()).child("Email").setValue(email);
        mDatabase.getReference().child(userId.toString()).child("Password").setValue(password);
    }
}
