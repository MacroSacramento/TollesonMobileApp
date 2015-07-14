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

public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, null);

        WebView lunchwv = (WebView) rootView.findViewById(R.id.main_webView);
        lunchwv.setWebViewClient(new WebViewClient());
        WebSettings webSettings = lunchwv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        lunchwv.loadUrl("file:///android_asset/imagescroller.html");

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(1);
    }/**/


}