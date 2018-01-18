package mobiledev.unb.ca.lab2activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ActivityOne extends Activity {

    // Strings will serve as keys when saving state between activities
    private static final String CREATE_VALUE = "create";
    private static final String START_VALUE = "start";
    private static final String RESUME_VALUE = "resume";
    private static final String RESTART_VALUE = "restart";

    // String for LogCat documentation
    private final static String TAG = "Lab 2 - Activity One";

    // HINT:
    // To track the number of times activity lifecycle methods
    // have been called for each respective Activity we will need
    // to increment a counter inside the method each time it is
    // called by the system. Below are the variables you will use
    // to increment during each lifecycle method call. We will be
    // tracking only these four lifecycle methods during this lab.
    private int mOnCreateCount = 0;
    private int mOnStartCount = 0;
    private int mOnResumeCount = 0;
    private int mOnRestartCount = 0;
    private Button mActivityTwoBtn;



    // TODO 2:
    // Declare four private TextView Objects above. The will contain counts of the
    // four lifecycle method calls indicated in the activity layout XML. To contain
    // references to Android SDK Object types, they must be programmatically
    // declared as instances of the object type, much like when
    // declaring an int, double, or String. All rules of Java continue
    // to apply.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        // HINT for 4:
        // This is how Android View layout resource references are obtained
        mActivityTwoBtn = (Button) findViewById(R.id.btnLaunchActivityTwo);
        mActivityTwoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // HINT for 3:
                // Intents are a way to announce to the Android operating system that
                // your application intends to perform some request. These requests
                // can be directly calling some specified Activity, as we will be doing
                // here, or it can announce the intent of having some particular
                // activity type respond to its request time; for instance indicating
                // it will need access to an email application activity. We will
                // investigate intents further in a future lab!
                Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);

                // TODO 3:
                // Launch the Activity using the above intent. For more information,
                // consult the Android API documentation for starting activities:
                // http://developer.android.com/reference/android/app/Activity.html#startActivity(android.content.Intent)

            }
        });

        // TODO 4:
        // Use the above Button resource reference example to capture TextView
        // references for mOnCreateText, mOnStartText, mOnResumeText, and
        // mOnRestartText


        // HINT for 6:
        // This checks whether or not a savedInstanceState currently exists
        // If it does, counter values will be loaded from its previous state
        if (savedInstanceState != null) {

            mOnCreateCount = savedInstanceState.getInt(CREATE_VALUE);

            // TODO 6:
            // If a savedInstanceState Bundle exists then there have already
            // been system calls made to activity lifecycle methods. We can
            // use this Bundle to set current values.
        }

        // TODO 8:
        // Increment mOnCreateCount

        updateCountsDisplay();
    }

    @Override
    public void onStart() {
        Log.i(TAG, "onStart() called");
        super.onStart();

        // TODO 8:
        // Increment mOnStartCount

        updateCountsDisplay();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume() called");
        super.onResume();

        // TODO 8:
        // Increment mOnResumeCount

        updateCountsDisplay();
    }

    @Override
    public void onRestart() {
        Log.i(TAG, "onRestart() called");
        super.onRestart();

        // TODO 8:
        // Increment mOnRestartCount

        updateCountsDisplay();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt(CREATE_VALUE, mOnCreateCount);

        // TODO 5:
        // Following the above example, save the current counters to a
        // savedInstanceState Bundle so they can be refreshed when
        // returning to this Activity. These behave as key:value pairs,
        // which you may be familiar with if you've taken Info 1103!


        // Must always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void updateCountsDisplay() {

        YourOnCreateTextVariableName.setText("onCreate() calls: " + mOnCreateCount);

        // TODO 7:
        // Update the TextView resources to the correct counter.
        // Follow the provided example.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_one, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
