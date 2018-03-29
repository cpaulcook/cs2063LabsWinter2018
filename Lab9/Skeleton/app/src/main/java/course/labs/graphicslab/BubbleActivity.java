package course.labs.graphicslab;

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
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

// TODO Nothing to do here; just note that BubbleActivity implements
// SensorEventListener
public class BubbleActivity extends Activity implements SensorEventListener {

	private static final String TAG = "BubbleActivity";

	// The Main view
	private RelativeLayout mFrame;

	// Bubble image's bitmap
	private Bitmap mBitmap;

	// Display dimensions
	private int mDisplayWidth, mDisplayHeight;

    // Gesture Detector
    private GestureDetector mGestureDetector;

    // A TextView to hold the player message
    private TextView mPlayerMessage;

    private static final int NO_FILTER = 0;
    private static final int LOW_PASS_FILTER = 1;
    private static final int HIGH_PASS_FILTER = 2;
    private int mFilter = NO_FILTER;

    // TODO Create members for a SensorManager and Sensor




    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		// Set up user interface
		mFrame = (RelativeLayout) findViewById(R.id.frame);

        // Set up text view
        mPlayerMessage = (TextView) findViewById(R.id.startMessage);

		// Load basic bubble Bitmap
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball);

        // TODO Get a SensorManager, and then use it to get an accelerometer
        // Sensor. Set the SensorManager and Sensor members that you defined
        // above appropriately. If the device does not have an accelerometer,
        // display a message indicating so and exit.



        // Calculate display size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // Subtract diameter of the ball from width and height
        mDisplayWidth = size.x - BubbleView.SCALED_BITMAP_SIZE;
        mDisplayHeight = size.y - BubbleView.SCALED_BITMAP_SIZE;

	}

	@Override
	protected void onResume() {
		super.onResume();

        // TODO Register a listener for the accelerometer




        setupGestureDetector();

    }

    public void onSensorChanged(SensorEvent event) {


            // TODO Apply a low- and high-pass filter to the raw sensor values



            // TODO If there is a BubbleView, use its setSpeedAndDirection() method
            // to set its speed and direction based on the sensor values and the
            // current setting of mFilter, which will be one of NO_FILTER,
            // LOW_PASS_FILTER, or HIGH_PASS_FILTER.

    }

    // TODO Nothing to do here, just note that onAccuracyChanged must be implemented
    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes. We will leave this unimplemented.
    }

	// Set up GestureDetector
	private void setupGestureDetector() {

		mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            // If there is a BubbleView, and a single tap intersects it, remove it.
            // If there are no BubbleViews, create a new BubbleView at the tap's location
            // and add it to mFrame.
			@Override
			public boolean onSingleTapConfirmed(MotionEvent event) {
                float x = event.getRawX();
                float y = event.getRawY();

                int numBubbles = mFrame.getChildCount();

                if (numBubbles != 0) {
                    BubbleView bv = (BubbleView) mFrame.getChildAt(0);
                    if (bv.intersects(x, y)) {
                        bv.stopMovement();
                     }
                 } else {
                    Context context = mFrame.getContext();
                    BubbleView bubbleView = new BubbleView(context, x, y);
                    mFrame.addView(bubbleView);
                    bubbleView.startMovement();
                    setPlayerMessage();
                }
				return true;
			}

            @Override
            public void onLongPress(MotionEvent e) {
                // Cycle through the filter options
                mFilter = (mFilter + 1) % 3;
                setPlayerMessage();
            }
        });
	}

    // Update the message that is displayed to the player
    public void setPlayerMessage() {
        String message;
        if (mFrame.getChildCount() == 0) {
            message = getString(R.string.start_message);
        }
        else {
            if (mFilter == NO_FILTER) {
                message = getString(R.string.no_filter_message);
            } else if (mFilter == LOW_PASS_FILTER) {
                message = getString(R.string.lowpass_filter_message);
            } else {
                message = getString(R.string.highpass_filter_message);
            }
        }
        mPlayerMessage.setText(message);
    }

	@Override
	public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
	}

	@Override
	protected void onPause() {
		super.onPause();

        // TODO Unregister the sensor event listener

	}

	// BubbleView is a View that displays a bubble.
	// This class handles animating, drawing, and popping amongst other actions.
	public class BubbleView extends View {

		private static final int BITMAP_SIZE = 64;
		private static final int REFRESH_RATE = 5;
		private final Paint mPainter = new Paint();
		private ScheduledFuture<?> mMoverFuture;
		private static final int SCALED_BITMAP_SIZE = BITMAP_SIZE* 2;
		private Bitmap mScaledBitmap;

		// location and direction of the bubble
		private float mXPos, mYPos, mRadius;

        // Speed of bubble
        public float mDx, mDy;

        // Rotation and speed of rotation of the bubble
        private long mRotate, mDRotate;

		BubbleView(Context context, float x, float y) {
			super(context);

			// Creates the bubble bitmap for this BubbleView
            mScaledBitmap = Bitmap.createScaledBitmap(mBitmap, SCALED_BITMAP_SIZE,
                    SCALED_BITMAP_SIZE, true);

			// Radius of the Bitmap
			mRadius = SCALED_BITMAP_SIZE / 2;

			// Adjust position to center the bubble under user's finger
			mXPos = x - mRadius;
			mYPos = y - mRadius;

            // Set speed to 0 initially; it will be updated soon based on sensor input
            mDx = 0;
            mDy = 0;

            // Set speed of rotation to 5
            mDRotate = 5;

			mPainter.setAntiAlias(true);

		}

        // setSpeedAndDirection called by onSensorChanged(), values based on
        // accelerometer data and scaled
        private void setSpeedAndDirection(float x, float y) {
            mDx = x;
            mDy = y;

            // TODO Once your app is working, experiment with alternative
            // ways of calculating mDx and mDy based on x and y to change
            // the "feel". Some ideas are shown below.

            // Uncomment this to make the ball go faster!
            //mDx = 2 * x;
            //mDy = 2 * y;

            // Uncomment this to make the ball accelerate based on sensor
            // input. You can also scale the contribution of x and y.
            //mDx = mDx + x;
            //mDy = mDy + y;

        }

		// Start moving the BubbleView & updating the display
		private void startMovement() {
			// Creates a WorkerThread
			ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

			// Execute the run() in Worker Thread every REFRESH_RATE
			// milliseconds
			// Save reference to this job in mMoverFuture
			mMoverFuture = executor.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    doMove();
                    BubbleView.this.postInvalidate();
                }
            }, 0, REFRESH_RATE, TimeUnit.MILLISECONDS);
		}

        private void stopMovement() {
            if (null != mMoverFuture) {

                if (!mMoverFuture.isDone()) {
                    mMoverFuture.cancel(true);
                }

                // This work will be performed on the UI Thread
                mFrame.post(new Runnable() {
                    @Override
                    public void run() {
                        mFrame.removeView(BubbleView.this);
                        setPlayerMessage();
                    }
                });
            }
        }

        // Return true if x and y intersect the position of the Bubble
		private synchronized boolean intersects(float x, float y) {
            float centerX = mXPos + mRadius;
            float centerY = mYPos + mRadius;
            return Math.sqrt(Math.pow(centerX - x, 2) + Math.pow(centerY - y, 2)) <= mRadius;

		}

		// Draw the Bubble at its current location
		@Override
		protected synchronized void onDraw(Canvas canvas) {
            canvas.save();
            mRotate = mRotate + mDRotate;
            canvas.rotate(mRotate, mXPos + mRadius, mYPos + mRadius);
            canvas.drawBitmap(mScaledBitmap, mXPos, mYPos, mPainter);
            canvas.restore();
		}

        // Move the Bubble
        private synchronized void doMove() {
            // Don't let the bubble go beyond the edge of the screen
            // Set the speed to 0 if the bubble hits an edge.
            mXPos = mXPos + mDx;
            if (mXPos >= mDisplayWidth) {
                mXPos = mDisplayWidth;
                mDx = 0;
            } else if (mXPos <= 0) {
                mXPos = 0;
                mDx = 0;
            }

            mYPos = mYPos + mDy;
            if (mYPos >= mDisplayHeight) {
                mYPos = mDisplayHeight;
                mDy = 0;
            } else if (mYPos <= 0) {
                mYPos = 0;
                mDy = 0;
            }

            //mXPos = Math.max(Math.min(mXPos + mDx, mDisplayWidth), 0.0f);
            //mYPos = Math.max(Math.min(mYPos + mDy, mDisplayHeight), 0.0f);
        }
	}


}