package holyquran.cls.com.holyquran.View;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import holyquran.cls.com.holyquran.Base.MyBaseActivity;
import holyquran.cls.com.holyquran.R;

public class Splash extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(activity,HomeActivity.class));
            }
        },2500);
    }
}
