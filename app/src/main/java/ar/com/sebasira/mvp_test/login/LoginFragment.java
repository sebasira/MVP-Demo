package ar.com.sebasira.mvp_test.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ar.com.sebasira.mvp_test.R;
import ar.com.sebasira.mvp_test.home.MainActivity;


/**
 * http://www.uwanttolearn.com/android/refactor-current-code-to-mvp-android/#comment-57794
 */
public class LoginFragment extends Fragment implements LoginContract.View{

    private Button btnLogin;
    private EditText edtPass;
    private EditText edtUser;

    private LoginPresenter mLoginPresenter;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mLoginPresenter = new LoginPresenter(this, new LoginAPI());
    }

    /* ON CREATE VIEW */
    /* ************** */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);


        edtUser = rootView.findViewById(R.id.edtUser);
        edtPass = rootView.findViewById(R.id.edtPass);
        btnLogin = rootView.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(loginClicked);


        return rootView;
    }


    private View.OnClickListener loginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mLoginPresenter.onLoginButtonClicked();
        }
    };

    @Override
    public String getUsername() {
        return edtUser.getText().toString();
    }

    @Override
    public String getPassword() {
        return edtPass.getText().toString();
    }

    @Override
    public void setUsernameError(@StringRes int resId) {
        edtUser .setError(getString(resId));
    }

    @Override
    public void setPasswordError(@StringRes int resId) {
        edtPass.setError(getString(resId));
    }

    @Override
    public void startMainActivity() {
        Intent intento = new Intent(getActivity(), MainActivity.class);
        startActivity(intento);
        getActivity().finish();
    }

    @Override
    public void showBadCredentials() {
        Toast.makeText(getActivity(), "Bad Credentials", Toast.LENGTH_SHORT).show();
    }
}
