package org.tuhsd.fbla;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class EventsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);

        WebView eventswv = (WebView) rootView.findViewById(R.id.events_webView);
        eventswv.setWebViewClient(new WebViewClient());
        WebSettings webSettings = eventswv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        eventswv.loadUrl("file:///android_asset/events.html");

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(3);
    }/**/

}