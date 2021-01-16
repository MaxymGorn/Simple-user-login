package com.example.user.ui.login;

import androidx.annotation.Nullable;

/**
 * Data validation state of the login form.
 */
class LoginFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer secondUsernameError;
    private boolean isDataValid;

    LoginFormState(@Nullable Integer usernameError, @Nullable Integer secondUsernameError) {
        this.usernameError = usernameError;
        this.secondUsernameError = secondUsernameError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid) {
        this.usernameError = null;
        this.secondUsernameError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    @Nullable
    Integer getSecondUsernameError() {
        return secondUsernameError;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}