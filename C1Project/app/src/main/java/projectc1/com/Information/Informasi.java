package projectc1.com.Information;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import projectc1.com.Button;
import projectc1.com.Reservation.Reservation;
import projectc1.com.Maps.CustomMaps;
import projectc1.com.R;
import projectc1.com.forum.Forum;

public class Informasi extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);
        setTitle("Information");
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setSelectedItemId(R.id.information);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.forum:
                        startActivity(new Intent(getApplicationContext(), Forum.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Button.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.information:
                        return true;

                    case R.id.registrasi:
                        startActivity(new Intent(getApplicationContext(), Reservation.class));
                        overridePendingTransition(0, 0);
                        return true;


                }
                return false;
            }
        });
        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new Browsers());
        webView.getSettings().setJavaScriptEnabled(true);


    }
    private class Browsers extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading (WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    public void test (View view) {
        switch (view.getId()) {
            case R.id.btnInstagram:
                webView.loadUrl("https://www.instagram.com/umn_si/?hl=en");
                break;

            case R.id.btnYoutube:
                webView.loadUrl("https://www.youtube.com/channel/UCEDU8s0Ezl0F-LsyfSiW-aw");
                break;

            case R.id.btnLine:
                webView.loadUrl("https://page.line.me/?accountId=gyf6027o");
                break;

            case R.id.btnWebsite:
                webView.loadUrl("https://himsi.umn.ac.id/");
                break;

            case R.id.btnMaps:
                startActivity(new Intent(getApplicationContext(), CustomMaps.class));
                break;
        }
    }
}