package ar.com.sebasira.mvp_test.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ar.com.sebasira.mvp_test.R;

import static org.junit.Assert.*;

public class LoginPresenterTest{
    private LoginPresenter mLoginPresenter;
    private LoginContract.View mockedView;
    private LoginAPI mockedLoginApi;

    @Before
    public void setUp() throws Exception {

        mockedView = Mockito.mock(LoginContract.View.class);
        mockedLoginApi = Mockito.mock(LoginAPI.class);

        mLoginPresenter = new LoginPresenter(mockedView, mockedLoginApi);
    }


    @Test
    public void whenUsernameEmptyShowError() {
        Mockito.when(mockedView.getUsername()).thenReturn("");

        mLoginPresenter.onLoginButtonClicked();

        Mockito.verify(mockedView).setUsernameError(R.string.errror_empty_user);
    }


    @Test
    public void whenPasswordEmptyShowError() {
        // I need to set the Username otherwise when invoking the 'onLoginButtonClicked' method
        // and calling the mView.getusername() the return would be null and we don't whant that
        Mockito.when(mockedView.getUsername()).thenReturn("sebasira");
        Mockito.when(mockedView.getPassword()).thenReturn("");

        mLoginPresenter.onLoginButtonClicked();

        Mockito.verify(mockedView).setPasswordError(R.string.errror_empty_pass);
    }


    @Test
    public void whenUsernameAndPasswordNotEmptyTestOnServerWithBadCredentials() {
        String username = "sebasira";
        String pass = "111";
        Mockito.when(mockedView.getUsername()).thenReturn(username);
        Mockito.when(mockedView.getPassword()).thenReturn(pass);

        Mockito.when(mockedLoginApi.authenticate(username, pass)).thenReturn(false);

        mLoginPresenter.onLoginButtonClicked();

        Mockito.verify(mockedView).showBadCredentials( );
    }


    @Test
    public void whenUsernameAndPasswordNotEmptyTestOnServerWithGoodCredentials() {
        String username = "sebasira";
        String pass = "123454";
        Mockito.when(mockedView.getUsername()).thenReturn(username);
        Mockito.when(mockedView.getPassword()).thenReturn(pass);

        Mockito.when(mockedLoginApi.authenticate(username, pass)).thenReturn(true);

        mLoginPresenter.onLoginButtonClicked();

        Mockito.verify(mockedView).startMainActivity( );
    }
}