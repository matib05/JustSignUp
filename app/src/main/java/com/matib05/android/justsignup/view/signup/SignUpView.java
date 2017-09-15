package com.matib05.android.justsignup.view.signup;

import com.matib05.android.justsignup.view.list.PickActivity;

/**
 * Created by matib05 on 9/11/2017.
 */

public interface SignUpView {
    String getEmail();

    void showEmailError(int resId);

    String getPassword();

    void showPasswordError(int resId);

    void showNameError(int resId);

    String getName();

    void navigateToPickActivity();
}
