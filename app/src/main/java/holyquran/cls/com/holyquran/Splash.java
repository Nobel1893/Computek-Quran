package holyquran.cls.com.holyquran;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import holyquran.cls.com.holyquran.Base.MyBaseActivity;

public class Splash extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(activity,QuranActivity.class));
            }
        },2500);
    }
}
