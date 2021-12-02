package com.example.tabs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class MainPageFragment extends Fragment {
    EditText urlET1;
    EditText urlET2;
    Button urlButton1;
    Button urlButton2;

    String text1;
    String text2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainpage_fragment, container, false);
        urlButton1 = view.findViewById(R.id.urlButton1);
        urlButton2 = view.findViewById(R.id.urlButton2);
        urlET1 = view.findViewById(R.id.urlET1);
        urlET2 = view.findViewById(R.id.urlET2);
        View viewSB = view.findViewById(R.id.mainpage_layout);
        //Here I added an animation to an image as one of the advanced interface elements
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.animation);
        View view1 = view.findViewById(R.id.image);
        view1.startAnimation(animation);

        //I decided that it would be more convenient to send the data to different fragments by two different buttons and not by only one
        urlButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Here I check if the editText is empty
                if (urlET1.getText().toString().isEmpty()) {
                    Snackbar.make(viewSB, getString(R.string.message), Snackbar.LENGTH_SHORT).setAction(getString(R.string.close), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
                } else {
                    text1 = urlET1.getText().toString();
                    //firstly I send information to the MainActivity, not directly to the fragment
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.receiveUrl1(text1);
                    //Another advanced interface element - snackbar
                    Snackbar.make(viewSB, getString(R.string.messagePage1), Snackbar.LENGTH_SHORT).setAction(getString(R.string.close), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
                }

            }
        });

        urlButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (urlET2.getText().toString().isEmpty()) {
                    Snackbar.make(viewSB, getString(R.string.message), Snackbar.LENGTH_SHORT).setAction(getString(R.string.close), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
                } else {
                    text2 = urlET2.getText().toString();
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.receiveUrl2(text2);

                    Snackbar.make(viewSB, getString(R.string.messagePage2), Snackbar.LENGTH_SHORT).setAction(getString(R.string.close), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
                }

            }
        });


        return view;
    }


}
