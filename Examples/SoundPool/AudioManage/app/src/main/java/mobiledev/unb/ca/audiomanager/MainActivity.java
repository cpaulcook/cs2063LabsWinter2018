package mobiledev.unb.ca.audiomanager;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SoundPool mSoundPool;
    private int mSoundId;
    private final String TAG = "TAG";
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the button and set it to initially not be enabled
        mButton = (Button) findViewById(R.id.button);
        mButton.setEnabled(false);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Play the sound when the button is clicked
                // See further documentation on SoundPool.play here:
                // http://developer.android.com/reference/android/media/SoundPool.html
                mSoundPool.play(mSoundId, 1, 1, 1, 0, 1);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Create a SoundPool
        SoundPool.Builder spb = new SoundPool.Builder();
        spb.setMaxStreams(1);
        spb.setAudioAttributes(new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build());
        mSoundPool = spb.build();

        // In Lab 7 we will be working with an older API level and will use this instead
        // of a SoundPool.Builder to create the SoundPool appropriately
        //mSoundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);

        // Load a bubble popping sound.
        // See further documentation on SoundPool.play here:
        // http://developer.android.com/reference/android/media/SoundPool.html
        mSoundId = mSoundPool.load(this, R.raw.bubble_pop, 1);

        // onLoadComplete will be called when the sound has finished loading
        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if (0 == status) {
                    // Enable the play button once the sound has loaded
                    mButton.setEnabled(true);
                }
                else {
                    Log.i(TAG, "Unable to load sound");
                    finish();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        // Disable the play button
        mButton.setEnabled(false);

        // Release sound pool resources
        if (null != mSoundPool) {
            mSoundPool.unload(mSoundId);
            mSoundPool.release();
            mSoundPool = null;
        }

        super.onPause();
    }
}
