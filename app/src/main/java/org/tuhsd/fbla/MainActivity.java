package org.tuhsd.fbla;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.Object;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private WebView mWebView = null;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Fragment fragment = new PlaceholderFragment();

        switch (position) {
            case 0:
                fragment = new PlaceholderFragment();
                break;
            case 1:
                fragment = new LunchFragment();
                break;
            case 2:
                fragment = new EventsFragment();
                break;
            case 3:
                fragment = new TeacherFragment();
                break;
            case 4:
                fragment = new AboutFragment();
                break;
            case 5:
                fragment = new FacebookFragment();
        }

        fragChanger(fragment);

    }

    public void fragChanger(Fragment frag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, frag)
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
            case 6:
                mTitle = getString(R.string.title_section6);
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            restoreActionBar();
            return false;
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return false;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setContentView(View view) {
        mTitle = getString(R.string.title_section2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(mTitle);
        Fragment fragment = new LunchFragment();
        fragChanger(fragment);
    }

    public void setEventView(View view) {
        mTitle = getString(R.string.title_section3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(mTitle);
        Fragment fragment = new EventsFragment();
        fragChanger(fragment);
    }

    public void setTeacherView(View view) {
        mTitle = getString(R.string.title_section4);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(mTitle);
        Fragment fragment = new TeacherFragment();
        fragChanger(fragment);
    }

    public void setAboutView(View view) {
        mTitle = getString(R.string.title_section5);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(mTitle);
        Fragment fragment = new AboutFragment();
        fragChanger(fragment);
    }

    public void setFacebookView(View view) {
        mTitle = getString(R.string.title_section6);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(mTitle);
        Fragment fragment = new FacebookFragment();
        fragChanger(fragment);
    }

    public class NewWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(url.contains(TeacherFragment.url)) {
                view.loadUrl(url);
            } else {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
            return true;
        }
    }

}
