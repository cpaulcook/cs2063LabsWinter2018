package mobiledev.unb.ca.motioneventdemo;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onTouchEvent(MotionEvent event) {

        // Extract the action from the event
        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.i(TAG, "Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.i(TAG, "Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP):
                Log.i(TAG, "Action was UP");
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }
}
