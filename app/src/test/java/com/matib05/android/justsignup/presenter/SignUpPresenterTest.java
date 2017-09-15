package com.matib05.android.justsignup.presenter;


import com.matib05.android.justsignup.R;
import com.matib05.android.justsignup.view.signup.SignUpView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by matib05 on 9/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SignUpPresenterTest {

    @Mock
    SignUpView view;
    SignUpPresenter presenter;

    @Before
    public void setup() throws Exception{
        presenter = new SignUpPresenter(view);
    }

    @Test
    public void shouldReturnErrorIfNameIsInvalid() throws Exception {
        when(view.getName()).thenReturn("");
        presenter.onSignUpClicked();

        verify(view).showNameError(R.string.name_error);

    }

    @Test
    public void shouldReturnErrorIfEmailIsValid() throws Exception{
        when(view.getName()).thenReturn("matib");
        when(view.getEmail()).thenReturn("matib");
        when(view.getEmail()).thenReturn("matib05@");
        when(view.getEmail()).thenReturn("");
        presenter.onSignUpClicked();

        verify(view).showEmailError(R.string.email_error);
    }

    @Test
    public void shouldReturnErrorIfPasswordIsValid() throws Exception {
        when(view.getName()).thenReturn("matib");
        when(view.getEmail()).thenReturn("matib05@gmail.com");
        when(view.getPassword()).thenReturn("");
        presenter.onSignUpClicked();

        verify(view).showPasswordError(R.string.password_error);
    }

    @Test
    public void shouldStartPickActivity() throws Exception {
        when(view.getName()).thenReturn("matib");
        when(view.getEmail()).thenReturn("matib05@gmail.com");
        when(view.getPassword()).thenReturn("pass");
        presenter.onSignUpClicked();

        verify(view).navigateToPickActivity();

    }

}