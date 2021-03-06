package ar.com.sebasira.mvp_test.login;

import ar.com.sebasira.mvp_test.R;

/**
 * http://www.uwanttolearn.com/android/refactor-current-code-to-mvp-android/#comment-57794
 */
public class LoginPresenter {
    private final LoginContract.View view;
    private final LoginAPI loginAPI;

    public LoginPresenter(LoginContract.View view, LoginAPI loginAPI) {
        this.view = view;
        this.loginAPI = loginAPI;
    }

    public void onLoginButtonClicked() {
        String user = view.getUsername();
        String pass = view.getPassword();

        if (user.isEmpty()){
            view.setUsernameError(R.string.errror_empty_user);
            return;
        }

        if (pass.isEmpty()){
            view.setPasswordError(R.string.errror_empty_pass);
            return;
        }

        if (loginAPI .authenticate(user,pass)){
            view.startMainActivity();
        }else{
            view.showBadCredentials();
        }

    }
}

