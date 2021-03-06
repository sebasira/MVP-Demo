package ar.com.sebasira.mvp_test.login;

import android.support.annotation.StringRes;

/**
 * http://www.uwanttolearn.com/android/refactor-current-code-to-mvp-android/#comment-57794
 */
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
