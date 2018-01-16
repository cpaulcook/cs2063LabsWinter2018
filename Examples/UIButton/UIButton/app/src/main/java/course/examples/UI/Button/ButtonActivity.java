package course.examples.UI.Button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ButtonActivity extends Activity {
	int count = 0;
    static final String STATE_COUNT = "STATE_COUNT";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // If the savedInstanceState Bundle isn't null, retrieve the stored count
        // Note that the text of the Button is maintained across configuration changes
        // because freezesText="true" for the Button in main.xml
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(STATE_COUNT);
        }

        // Get a reference to the Press Me Button
        final Button button = (Button) findViewById(R.id.button);

        // Set an OnClickListener on this Button
        // Called each time the user clicks the Button
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Maintain a count of user presses
				// Display count as text on the Button
				button.setText("Got Pressed:" + ++count);
			}
		});
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_COUNT, count);
        super.onSaveInstanceState(savedInstanceState);
    }
}