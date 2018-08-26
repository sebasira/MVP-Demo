package ar.com.sebasira.mvp_test.presenter;

import ar.com.sebasira.mvp_test.R;
import ar.com.sebasira.mvp_test.contract.LoginContract;
import ar.com.sebasira.mvp_test.network.LoginAPI;

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

