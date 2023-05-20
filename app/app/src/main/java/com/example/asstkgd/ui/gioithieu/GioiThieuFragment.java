package com.example.asstkgd.ui.gioithieu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.asstkgd.R;


public class GioiThieuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GioiThieuFragment() {
        // Required empty public constructor
    }
    public static GioiThieuFragment newInstance(String param1, String param2) {
        GioiThieuFragment fragment = new GioiThieuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gioi_thieu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView mWebView = view.findViewById(R.id.list_web);

        // cho phép javascript hoạt động
        mWebView.getSettings().setJavaScriptEnabled(true);

//        final Activity activity = this;

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.d("zzzzzzzzz", "onProgressChanged: " + newProgress); // xem log tiến trình load
                super.onProgressChanged(view, newProgress);
            }
        });
        mWebView.setWebViewClient( new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
// hiển thị lỗi nếu có lỗi xảy ra
                Toast.makeText(getContext(), error.getDescription() , Toast.LENGTH_SHORT).show();
            }
        });
        mWebView.loadUrl("file:///android_asset/gioiThieu.html");

    }
}