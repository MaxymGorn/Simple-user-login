package com.example.user.ui.login;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private UserModel success;
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    LoginResult(@Nullable UserModel success) {
        this.success = success;
    }

    @Nullable
    UserModel getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}