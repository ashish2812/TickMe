package com.educationhub.tickme.OnBoardingFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.educationhub.tickme.SignInActivity;
import com.educationhub.tickme.R;

public class OnboardingFragment3 extends Fragment {
    private ImageView startButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment3_onboarding, container, false);
        startButton = root.findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getContext(), SignInActivity.class));
                getActivity().finish();
            }
        });

        return root;

    }
}
