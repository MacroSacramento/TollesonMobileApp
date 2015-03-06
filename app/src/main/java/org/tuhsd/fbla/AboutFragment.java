package org.tuhsd.fbla;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        WebView abtwv = (WebView) rootView.findViewById(R.id.about_webView);
        abtwv.setWebViewClient(new WebViewClient());
        WebSettings webSettings = abtwv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        abtwv.loadUrl("file:///android_asset/about" + ".html");
        
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(5);
    }/**/

}