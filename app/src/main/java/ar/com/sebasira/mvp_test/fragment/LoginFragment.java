package ar.com.sebasira.mvp_test.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ar.com.sebasira.mvp_test.R;
import ar.com.sebasira.mvp_test.activity.MainActivity;
import ar.com.sebasira.mvp_test.network.LoginAPI;


public class LoginFragment extends Fragment {

    private Button btnLogin;
    private EditText edtPass;
    private EditText edtUser;

    private LoginAPI mLoginApi;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mLoginApi = new LoginAPI();
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
            String user = edtUser.getText().toString();
            if (user.isEmpty()){
                edtUser.setError("Usuario vacio");
                return;
            }

            String pass = edtPass.getText().toString();
            if (pass.isEmpty()){
                edtPass.setError("Usuario vacio");
                return;
            }


            if (mLoginApi.authenticate(user,pass)){
                Intent intento = new Intent(getActivity(), MainActivity.class);
                startActivity(intento);
                getActivity().finish();
            }else{
                Toast.makeText(getActivity(), "Bad Credentials", Toast.LENGTH_SHORT).show();
            }

        }
    };

}
