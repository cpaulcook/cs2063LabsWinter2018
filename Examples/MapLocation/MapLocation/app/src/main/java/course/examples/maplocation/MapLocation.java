package course.examples.maplocation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MapLocation extends Activity {

    private final String TAG = "MapLocation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        // Required call through to Activity.onCreate()
        // Restore any saved instance state
        super.onCreate(savedInstanceState);
        
        // Set content view
        setContentView(R.layout.main);

        // Initialize UI elements
        final EditText addrText = (EditText) findViewById(R.id.location);
        final Button button = (Button) findViewById(R.id.mapButton);

        // Link UI elements to actions in code        
        button.setOnClickListener(new OnClickListener() {
            
            // Called when user clicks the Show Map button
            public void onClick(View v) {
                try {
                    
                    // Process text for network transmission
                    String address = addrText.getText().toString();
                    address = address.replace(' ', '+');
                    
                    // Create Intent object for starting Google Maps application 
                    Intent geoIntent = new Intent(
                            android.content.Intent.ACTION_VIEW, Uri
                                    .parse("geo:0,0?q=" + address));

                    if (geoIntent.resolveActivity(getPackageManager()) != null) {
                        // Use the Intent to start the Maps application using Activity.startActivity()
                        startActivity(geoIntent);
                    }
                    
                } catch (Exception e) {
                    // Log any error messages to LogCat using Log.e()
                    Log.e(TAG, e.toString());
                }
            }
        });
    }

}
