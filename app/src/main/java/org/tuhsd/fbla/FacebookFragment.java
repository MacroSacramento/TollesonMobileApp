package org.tuhsd.fbla;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Marco Sarmiento on 3/13/2015.
 */
public class FacebookFragment extends android.support.v4.app.Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_facebook, container, false);

        WebView facebookswv = (WebView) rootView.findViewById(R.id.facebook_webView);
        facebookswv.setWebViewClient(new WebViewClient());
        WebSettings webSettings = facebookswv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        facebookswv.loadUrl("https://m.facebook.com/tuhsd");

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(6);
    }/**/


}
