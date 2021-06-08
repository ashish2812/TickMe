package com.educationhub.tickme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.educationhub.tickme.Fragments.CalenderFragment;
import com.educationhub.tickme.Fragments.HabitFragment;
import com.educationhub.tickme.Fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        hooks();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new HomeFragment())
                .commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment =null;

                switch (item.getItemId()){
                    case R.id.homePageNB:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.calenderPageNB:
                        selectedFragment = new CalenderFragment();
                        break;
                    case R.id.profilePageNB:
                        selectedFragment = new HabitFragment() ;
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,selectedFragment)
                        .commit();

                return true;
            }
        });

    }

    private void hooks(){
        frameLayout = findViewById(R.id.frameContainer);
        bottomNavigationView = findViewById(R.id.bottomNavigationBar);
    }
}