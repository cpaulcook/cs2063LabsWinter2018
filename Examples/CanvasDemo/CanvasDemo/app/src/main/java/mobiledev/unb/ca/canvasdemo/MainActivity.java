package mobiledev.unb.ca.canvasdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Display dimensions
    private int mDisplayWidth;
    private int mDisplayHeight;
    private RelativeLayout mFrame;
    //private Bitmap mBitmap;
    private static final int BITMAPSIZE = 64;
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrame = (RelativeLayout) findViewById(R.id.frame);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.b64);
        final BubbleView bv = new BubbleView(getApplicationContext(), bitmap);
        mFrame.addView(bv);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (bv.move()) {
                    bv.postInvalidate();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        Log.i(TAG, "InterruptedException");
                    }
                }
            }
        }).start();
    }

    private class BubbleView extends View {

        final private Bitmap mBitmap;

        private float mCurrX;
        private float mCurrY;

        private int mStepX;
        private int mStepY;
        private static final int MAXSTEP = 10;

        final private Paint mPainter = new Paint();

        public BubbleView(Context context, Bitmap bitmap) {
            super(context);

            this.mBitmap = Bitmap.createScaledBitmap(bitmap,
                    BITMAPSIZE, BITMAPSIZE, false);

            mDisplayWidth = mFrame.getWidth();
            mDisplayHeight = mFrame.getHeight();

            // Start in roughly the centre
            mCurrX = mDisplayWidth / 2;
            mCurrY = mDisplayHeight / 2;

            Random r = new Random();
            // Pick a random x and y step
            mStepX = r.nextInt(MAXSTEP) + 1;
            mStepY = r.nextInt(MAXSTEP) + 1;
            // Pick a random x and y direction to step
            mStepX = r.nextBoolean() ? mStepX : -mStepX;
            mStepY = r.nextBoolean() ? mStepY : -mStepY;

            mPainter.setAntiAlias(true);

        }

        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(mBitmap, mCurrX, mCurrY, mPainter);
        }

        private boolean move() {
            mCurrX = mCurrX + mStepX;
            mCurrY = mCurrY + mStepY;

            // Return true if the BubbleView is on the screen
            return mCurrX <= mDisplayWidth &&
                    mCurrX + BITMAPSIZE >= 0 &&
                    mCurrY <= mDisplayHeight &&
                    mCurrY + BITMAPSIZE >= 0;
        }
    }



}
