package ar.com.sebasira.mvp_test.network;

public class LoginAPI {

    private String USERNAME = "sebasira";
    private String PASSWORD = "12345";



    public boolean authenticate(String user, String pass){
        if (user.equals(USERNAME) && pass.equals(PASSWORD)){
            return true;
        }else{
            return false;
        }
    }
}
