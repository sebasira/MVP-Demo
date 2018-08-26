package ar.com.sebasira.mvp_test.contract;

import android.support.annotation.StringRes;

public class  LoginContract {

    /**
     * Interface fot the VIEW.
     *
     * Defines all the methods that the VIEW needs to implement in order to communicate with the PRESENTER
     */
    public interface View{

        String getUsername();

        String getPassword();

        void setUsernameError(@StringRes int resId);

        void setPasswordError(@StringRes int resId);

        void startMainActivity();

        void showBadCredentials();
    }
}
