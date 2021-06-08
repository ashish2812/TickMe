package com.educationhub.tickme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.educationhub.tickme.OnBoardingFragments.OnboardingFragment1;
import com.educationhub.tickme.OnBoardingFragments.OnboardingFragment2;
import com.educationhub.tickme.OnBoardingFragments.OnboardingFragment3;
import com.educationhub.tickme.OnBoardingFragments.OnboardingFragment4;
import com.educationhub.tickme.OnBoardingFragments.OnboardingFragment5;

public class SplashScreen extends AppCompatActivity {
    private static final String TAG = "SplashScreen";
    LottieAnimationView lottieAnimationView;
    ImageView backgroundImage;
    public static final int NUM_PAGES = 5;
    private static final int SPLASH_TIME_OUT = 3000;
    private ViewPager viewPager;
    private ScreenSliderPagerAdapter adapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        lottieAnimationView = findViewById(R.id.lottie_layer_name);
        backgroundImage = findViewById(R.id.backgroundImage);
        viewPager = findViewById(R.id.pager);


        
        backgroundImage.animate().translationY(-16000).setDuration(2000).setStartDelay(2000);
        lottieAnimationView.animate().translationY(14000).setDuration(2000).setStartDelay(2000);

        Log.d(TAG, "Success: FullScreen");

     new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
             sharedPreferences = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
             boolean isFirstTime = sharedPreferences.getBoolean("firstTime", true);
           if (isFirstTime) {
                 SharedPreferences.Editor editor = sharedPreferences.edit();
                 editor.putBoolean("firstTime", false);
                 editor.apply();
                 adapter = new ScreenSliderPagerAdapter(getSupportFragmentManager());
                 viewPager.setAdapter(adapter);
             } else {

               backgroundImage.animate().translationY(-16000).setDuration(2000).setStartDelay(2000);
               lottieAnimationView.animate().translationY(14000).setDuration(2000).setStartDelay(2000);
                 Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                 startActivity(intent);
                 finish();


            }
     }
     },1000);


    }


    private class ScreenSliderPagerAdapter extends FragmentStatePagerAdapter {


        public ScreenSliderPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    OnboardingFragment1 tab1 = new OnboardingFragment1();
                    return tab1;
                case 1:
                    OnboardingFragment2 tab2 = new OnboardingFragment2();
                    return tab2;
                case 2:
                    OnboardingFragment4 tab3 = new OnboardingFragment4();
                    return tab3;
                case 3:
                    OnboardingFragment5 tab4 = new OnboardingFragment5();
                    return tab4;
                case 4:
                    OnboardingFragment3 tab5 = new OnboardingFragment3();
                    return tab5;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}