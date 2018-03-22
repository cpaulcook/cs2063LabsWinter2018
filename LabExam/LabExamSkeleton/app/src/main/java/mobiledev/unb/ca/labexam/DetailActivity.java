package mobiledev.unb.ca.labexam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String WIKIURL = "wikiurl";
    public static final String HASWIKIURL = "haswikiurl";
    public static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // TODO Get the intent that started this activity, and retrieve the extras that you
        // added to it.


        // TODO Set the latitude and longitude text views to hold the latitude and longitude,
        // respectively


        // TODO Get a reference for the wiki button. If there is no wiki URL
        // for this button, disable it, otherwise enable it. Set an onClickListener
        // such that when this button is clicked, an implicit intent is started
        // to open the wiki URL in a web browser. Be sure to check that there is
        // an application installed that can handle this intent before starting it.
        // If the intent can't be started, show a toast indicating this.
        //
        // Hints:
        //
        // https://developer.android.com/reference/android/content/Intent.html#resolveActivity(android.content.pm.PackageManager)
        //
        // https://developer.android.com/guide/components/intents-common.html#Browser
        //
        // https://developer.android.com/reference/android/net/Uri.html#parse(java.lang.String)
        //


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            // TODO Set the title of the action bar to be the name of the lake


        }

    }
}
