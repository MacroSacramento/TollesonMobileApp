package org.tuhsd.fbla;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TeacherFragment extends Fragment {

    public static String url = "file:///android_asset/teacher" + ".html";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teacher, container, false);

        WebView teacherwv = (WebView) rootView.findViewById(R.id.teacher_webView);
        teacherwv.setWebViewClient(new WebViewClient());
        WebSettings webSettings = teacherwv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        teacherwv.loadUrl(url);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(4);
    }/**/

}