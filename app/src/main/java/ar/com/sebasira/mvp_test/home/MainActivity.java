package ar.com.sebasira.mvp_test.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ar.com.sebasira.mvp_test.R;

/**
 * http://www.uwanttolearn.com/android/refactor-current-code-to-mvp-android/#comment-57794
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
