package mobiledev.unb.ca.labexam;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String WORD = "word";
    public static final String DEFINITION = "definition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // TODO Get the intent that started this activity, and get the word and definition
        // extras from it.


        // TODO Set the definition TextView to be the definition


        // TODO Set the title of the action bar to be the word
        //
        // Hint: Note the location of the word (being defined) in the detail activity in
        // the lab exam write-up. This portion of an Activity is the action bar. You can get
        // a reference to the action bar here using getSupportActionBar(). There is a link to
        // documentation on this method in the "Hints" section of the write-up.


    }
}
