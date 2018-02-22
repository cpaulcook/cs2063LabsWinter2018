package mobiledev.unb.ca.trydb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DBHelper mDBHelper;
    private Button mAddButton;
    private EditText mSearchEditText;
    private EditText mItemEditText;
    private EditText mNumberEditText;
    private TextView mResultsTextView;
    private static final String TAG = "TAG";
    private ListView mListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO Nothing to do here, just note that a DBHelper has been instantiated
        mDBHelper = new DBHelper(this);
        mAddButton = (Button) findViewById(R.id.add_button);
        mSearchEditText = (EditText) findViewById(R.id.search_edit_text);
        mItemEditText = (EditText) findViewById(R.id.item_edit_text);
        mNumberEditText = (EditText) findViewById(R.id.number_edit_text);
        mResultsTextView = (TextView) findViewById(R.id.results_text_view);
        mListview = (ListView) findViewById(R.id.listview);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO Check if some text has been entered in both the item and number
                // EditTexts. If so, create and execute an AddTask, passing its
                // doInBackground method the text from these EditTetxs. If not,
                // display a toast indicating that the data entered was incomplete.


            }
        });

        mSearchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    // TODO v is the search EditText. (EditText is a subclass of TextView.)
                    // Get the text from this view. Create and execute a QueryTask passing
                    // its doInBackground method this text.


                }
                return false;
            }
        });
    }


    private class AddTask extends AsyncTask<String, Void, Void> {

        protected Void doInBackground(String... params) {
            // TODO Get the item and number that were passed to this method
            // as params. Add a corresponding row to the the database.


            return null;
        }

        protected void onPostExecute(Void result) {

            // TODO You will need to write a bit of extra code to get the
            // UI to behave nicely, e.g., showing and hiding the keyboard
            // at the right time, clearing text fields appropriately. Some
            // of that code will likely go here, but you might also make
            // changes elsewhere in the app. Exactly how you make the
            // UI behave is up to you, but you should make reasonable
            // choices.


        }
    }


    private class QueryTask extends AsyncTask<String, Void, Cursor> {
        protected Cursor doInBackground(String... params) {
            // TODO Get the query String from params. Query the database to
            // retrieve all rows that have an item that matches this query,
            // and return this Cursor object. Make sure that the results
            // are sorted appropriately.

            // Remove this return statement when you're done this part
            return null;

        }

        protected void onPostExecute(Cursor result) {
            // TODO Use a SimpleCursorAdapter to set the adapter for
            // the ListView (mListview) to be the Cursor passed
            // to onPostExecute. If there are no results, set the
            // results TextView to indicate that there are no results.
            //
            // Again, you might need to write a bit of extra code here,
            // or elsewhere, to get the UI to behave nicely.


        }
    }
}
