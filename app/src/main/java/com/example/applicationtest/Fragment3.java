package com.example.applicationtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab03, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        WebView myWebView = (WebView)  getActivity().findViewById(R.id.webview);
        myWebView.loadUrl("https://lolik.me/");
    }


}
