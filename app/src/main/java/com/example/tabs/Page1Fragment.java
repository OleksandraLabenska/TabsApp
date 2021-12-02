package com.example.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Page1Fragment extends Fragment {

    WebView web1;
    String url1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page1_fragment, container, false);

        web1 = view.findViewById(R.id.web1);
        //I added here few lines of code to check  whether the URL is null or no. without this check,
        // the fragment(Page 1) did not receive the data sent by the user from the main page.
        //what seemed strange to me is that for another fragment (Page2) there is no nessecity to add this check of URL, it already works fine without it.
        // this concept is still a little unclear to me
        if (url1 != null) {
            web1.loadUrl(url1);
        } else {
            web1.loadUrl("http://corndog.io/");
        }
        return view;
    }


    public void receiveUrl1(String data) {
        this.url1 = data;
        // if the fragment is null,I save that text to use when the fragment is instantiated.
        if (web1 != null) {
            web1.loadUrl(url1);
        }
    }
}