package projectc1.com.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import projectc1.com.Button;
import projectc1.com.Maps.CustomMaps;
import projectc1.com.R;
import projectc1.com.forum.Forum;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                }catch (InterruptedException e ) {
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(Splash.this, LogIn.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}