package com.matib05.android.justsignup.presenter;

import com.matib05.android.justsignup.R;
import com.matib05.android.justsignup.view.signup.SignUpView;

/**
 * Created by matib05 on 9/11/2017.
 */

public class SignUpPresenter {
    private SignUpView view;

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
        view.navigateToPickActivity();
    }
}
