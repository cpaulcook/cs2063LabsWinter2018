package course.labs.graphicslab;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class BubbleActivity extends Activity {

	private static final String TAG = "Lab7";

	// The Main view
	private RelativeLayout mFrame;

	// Bubble image's bitmap
	private Bitmap mBitmap;

	// Display dimensions
	private int mDisplayWidth, mDisplayHeight;

    // Gesture Detector
    private GestureDetector mGestureDetector;

    // A TextView to hold the current number of bubbles
    private TextView mBubbleCountTextView;

	// Sound variables

	// SoundPool
	private SoundPool mSoundPool;
	// ID for the bubble popping sound
	private int mSoundID;
	// Audio volume
	private float mStreamVolume;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		// Set up user interface
		mFrame = (RelativeLayout) findViewById(R.id.frame);
        mBubbleCountTextView = (TextView) findViewById(R.id.count);

		// Load basic bubble Bitmap
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.b64);

	}

	@Override
	protected void onResume() {
		super.onResume();

		// Manage bubble popping sound
		// Use AudioManager.STREAM_MUSIC as stream type

		AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

		mStreamVolume = (float) audioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC)
				/ audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

		// TODO - make a new SoundPool, allowing up to 10 streams
        // Store this as mSoundPool


		// TODO - set a SoundPool OnLoadCompletedListener that calls
		// setupGestureDetector()


		// TODO - load the sound from res/raw/bubble_pop.wav
        // Store this as mSoundID


	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {

			// Get the size of the display so this View knows where borders are
			mDisplayWidth = mFrame.getWidth();
			mDisplayHeight = mFrame.getHeight();

		}
	}

	// Set up GestureDetector
	private void setupGestureDetector() {

		mGestureDetector = new GestureDetector(this,
		new GestureDetector.SimpleOnGestureListener() {

			// If a fling gesture starts on a BubbleView then change the
			// BubbleView's velocity based on x and y velocity from
            // this gesture

			@Override
			public boolean onFling(MotionEvent event1, MotionEvent event2,
					float velocityX, float velocityY) {

				// TODO - Implement onFling actions.
				// (See comment above for expected behaviour.)
				// You can get all Views in mFrame one at a time
				// using the ViewGroup.getChildAt() method.




				return true;
			}

			// If a single tap intersects a BubbleView, then pop the BubbleView
			// Otherwise, create a new BubbleView at the tap's location and add
			// it to mFrame. Hint: Don't forget to start the movement of the
			// BubbleView.
			// Also update the number of bubbles displayed in the appropriate TextView

			@Override
			public boolean onSingleTapConfirmed(MotionEvent event) {

				// TODO - Implement onSingleTapConfirmed actions.
                // (See comment above for expected behaviour.)
                // You can get all Views in mFrame using the
				// ViewGroup.getChildCount() method




				return true;
			}
		});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		// TODO - Delegate the touch to the gestureDetector


        // Remove this when you're done the above todo
        return true || false;
		
	}

	@Override
	protected void onPause() {

		// TODO - Release all SoundPool resources


		super.onPause();
	}

	// BubbleView is a View that displays a bubble.
	// This class handles animating, drawing, and popping amongst other actions.
	// A new BubbleView is created for each bubble on the display

	public class BubbleView extends View {

		private static final int BITMAP_SIZE = 64;
		private static final int REFRESH_RATE = 40;
		private final Paint mPainter = new Paint();
		private ScheduledFuture<?> mMoverFuture;
		private int mScaledBitmapSize;
		private Bitmap mScaledBitmap;

		// location and direction of the bubble
		private float mXPos, mYPos, mRadius;

        // Speed of bubble
        private float mDx, mDy;

        // Rotation and speed of rotation of the bubble
        private long mRotate, mDRotate;

		BubbleView(Context context, float x, float y) {
			super(context);

			// Create a new random number generator to
			// randomize size, rotation, speed and direction
			Random r = new Random();

			// Creates the bubble bitmap for this BubbleView
			createScaledBitmap(r);

			// Radius of the Bitmap
			mRadius = mScaledBitmapSize / 2;

			// Adjust position to center the bubble under user's finger
			mXPos = x - mRadius;
			mYPos = y - mRadius;

			// Set the BubbleView's speed and direction
			setSpeedAndDirection(r);

			// Set the BubbleView's rotation
			setRotation(r);

			mPainter.setAntiAlias(true);

		}

		private void setRotation(Random r) {
			// TODO - set rotation in range [1..5]


		}

		private void setSpeedAndDirection(Random r) {
			// TODO - Set mDx and mDy to indicate movement direction and speed
			// Limit speed in the x and y direction to [-3..3] pixels per movement.


		}

		private void createScaledBitmap(Random r) {

            // TODO - set scaled bitmap size (mScaledBitmapSize) in range [2..4] * BITMAP_SIZE


			// TODO - create the scaled bitmap (mScaledBitmap) using size set above


		}

		// Start moving the BubbleView & updating the display
		private void startMovement() {

			// Creates a WorkerThread
			ScheduledExecutorService executor = Executors
					.newScheduledThreadPool(1);

			// Execute the run() in Worker Thread every REFRESH_RATE
			// milliseconds
			// Save reference to this job in mMoverFuture
			mMoverFuture = executor.scheduleWithFixedDelay(new Runnable() {
				@Override
				public void run() {

					// TODO - implement movement logic.
					// Each time this method is run the BubbleView should
					// move one step. (Use moveWhileOnScreen() to do this.)
					// If the BubbleView exits the display, stop the BubbleView's
					// Worker Thread. (Use stopMovement() to do this.) Otherwise,
					// request that the BubbleView be redrawn.



				}
			}, 0, REFRESH_RATE, TimeUnit.MILLISECONDS);
		}

		// Returns true if the BubbleView intersects position (x,y)
		private synchronized boolean intersects(float x, float y) {
            float centerX = mXPos + mRadius;
            float centerY = mYPos + mRadius;

			// TODO - Return true if the BubbleView intersects position (x,y)



            // Remove this when you're done the above todo
            return false;
		}

		// Cancel the Bubble's movement
		// Remove Bubble from mFrame
		// Play pop sound if the BubbleView was popped

		private void stopMovement(final boolean wasPopped) {

			if (null != mMoverFuture) {

				if (!mMoverFuture.isDone()) {
					mMoverFuture.cancel(true);
				}

				// This work will be performed on the UI Thread
				mFrame.post(new Runnable() {
					@Override
					public void run() {
						// TODO - Remove the BubbleView from mFrame


						// TODO - Update the TextView displaying the number of bubbles


						// TODO - If the bubble was popped by user,
						// play the popping sound



					}
				});
			}
		}

		// Change the Bubble's speed and direction
		private synchronized void deflect(float velocityX, float velocityY) {
			mDx = velocityX / REFRESH_RATE;
			mDy = velocityY / REFRESH_RATE;
		}

		// Draw the Bubble at its current location
		@Override
		protected synchronized void onDraw(Canvas canvas) {

			// TODO - save the canvas


			// TODO - increase the rotation of the original image by mDRotate


			// TODO Rotate the canvas by current rotation
			// Hint - Rotate around the bubble's center, not its position


			// TODO - draw the bitmap at it's new location


			// TODO - restore the canvas


			
		}

		// Returns true if the BubbleView is still on the screen after the move
		// operation
		private synchronized boolean moveWhileOnScreen() {

			// TODO - Move the BubbleView


			return isInView();

		}

		// Return true if the BubbleView is still on the screen after the move
		// operation
		private boolean isInView() {

			// TODO - Return true if the BubbleView is still on the screen after
			// the move operation



            // Remove this when you're done the above todo
            return false;
		}
	}


}