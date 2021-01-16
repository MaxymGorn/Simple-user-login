package com.example.user.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.content.Intent;
import android.util.Patterns;

import com.example.user.data.LoginRepository;
import com.example.user.data.Result;
import com.example.user.data.model.LoggedInUser;
import com.example.user.R;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String secondUsername) {
        // can be launched in a separate asynchronous job
        Result<LoggedInUser> result = loginRepository.login(username, secondUsername);

        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new UserModel(username, secondUsername)));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isSecondUserNameValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_second_username));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    private boolean isUserNameValid(String username) {
        try {
        return username != null && username.trim().length() > 0;
        }
        catch (Exception e) {

        }
        return false;
    }

    private boolean isSecondUserNameValid(String secondUsername) {
        try{
        return secondUsername != null && secondUsername.trim().length() > 0;
        }
        catch (Exception e) {

        }
        return false;
    }
}