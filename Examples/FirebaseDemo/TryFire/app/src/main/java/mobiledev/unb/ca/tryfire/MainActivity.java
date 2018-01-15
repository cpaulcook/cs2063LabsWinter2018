package mobiledev.unb.ca.tryfire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Firebase myFirebaseRef;
    private EditText mEditText;
    private TextView mTextView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Setup Firebase
        Firebase.setAndroidContext(this);
        // Replace the string below with your Firebase URL
        myFirebaseRef = new Firebase("REPLACE WITH YOUR FIREBASE URL...");

        mEditText = (EditText) findViewById(R.id.editText);
        mTextView = (TextView) findViewById(R.id.textView);

        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    // Get the text in the EditText widget
                    String message = v.getText().toString();
                    // Store the text in Firebase with the key "message"
                    myFirebaseRef.child("message").setValue(message);
                    // Set the EditText to empty
                    v.setText("");
                }
                return false;
            }
        });

        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {
            // An event listener that listens for changes in the value of the key "message"
            // in Firebase
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.i(TAG, "onDataChange");
                // When the data has changed, get the new value
                Object v = snapshot.getValue();
                String text;
                // The data can be null, so check for that...
                if (v == null) {
                    text = "";
                }
                else {
                    text = v.toString();
                }
                // Update the TextView that displays the current message
                mTextView.setText(text);
            }
            @Override public void onCancelled(FirebaseError error) {
                Log.i(TAG, "onCancelled");
            }
        });
    }



}
