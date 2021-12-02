package com.example.tabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Page2Fragment extends Fragment {

    WebView web2;
    String url2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page2_fragment, container, false);

        web2 = view.findViewById(R.id.web2);
        web2.loadUrl("https://corgiorgy.com/");
        return view;
    }


    public void receiveUrl2(String dato) {
        this.url2 = dato;
        // the same as in the Page1, if the fragment is null,I save that text to use when the fragment is instantiated.
        if (web2 != null) {
            web2.loadUrl(url2);
        }
    }
}




