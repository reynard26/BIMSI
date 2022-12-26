package projectc1.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import projectc1.com.Information.Informasi;
import projectc1.com.Reservation.Reservation;
import projectc1.com.Main.MainActivity;
import projectc1.com.forum.Forum;
import projectc1.com.viewpager.ViewPagerElearning;
import projectc1.com.viewpager.ViewPagerMyumn;

public class Button extends AppCompatActivity {

    ViewPager mVIewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Home");
        setContentView(R.layout.activity_button);

        mVIewPager = (ViewPager)findViewById(R.id.pager);
        mVIewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.forum:
                        startActivity(new Intent(getApplicationContext(), Forum.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        return true;

                    case R.id.information:
                        startActivity(new Intent(getApplicationContext(), Informasi.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.registrasi:
                        startActivity(new Intent(getApplicationContext(), Reservation.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });

    }
    public class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) { super(fm);}
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new MainActivity();
            } else if (position == 1){
                return new ViewPagerElearning();
            }else
                return new ViewPagerMyumn();

        }
        @Override
        public int getCount() { return 3; }
    }
}