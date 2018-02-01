package mobiledev.unb.ca.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 1 Get the ArrayList of Courses from the DataModel
        // (Ideally we would do this loading off of the main thread. We'll get to that
        // in the next lab. Today we're focusing on displyaing scrolling lists.)

        // TODO 2 Get a reference to the RecyclerView and set its adapter
        // to be an instance of MyAdapter, which you will need to create
        // using the ArrayList of courses from above.

    }

    // The RecyclerView.Adapter class provides a layer of abstraction between the
    // RecyclerView's LayoutManager and the underlying data that is being displayed,
    // in this case the ArrayList of Course objects.
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private ArrayList<Course> mDataset;

        public MyAdapter(ArrayList<Course> myDataset) {
            mDataset = myDataset;
        }

        // ViewHolder represents an individual item to display. In this case
        // it will just be a single TextView (displaying the title of a course)
        // but RecyclerView gives us the flexibility to do more complex things
        // (e.g., display an image and some text).
        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mTextView;

            public ViewHolder(TextView v) {
                super(v);
                mTextView = v;
            }
        }

        // The inflate method of the LayoutInflater class can be used to obtain the
        // View object corresponding to an XML layout resource file. Here
        // onCreateViewHolder inflates the TextView corresponding to item_layout.xml
        // and uses it to instantiate a ViewHolder.
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_layout, parent, false);
            return new ViewHolder(v);
        }


        // onBindViewHolder binds a ViewHolder to the data at the specified
        // position in mDataset
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // TODO 3 Get the Course at index position in mDataSet
            // (Hint: you might need to declare this variable as final.)

            // TODO 4 Set the TextView in the ViewHolder (holder) to be the
            // title for this Course

            // TODO 5 Set the onClickListener for the TextView in the ViewHolder (holder) such
            // that when it is clicked, it creates an explicit intent to launch DetailActivity
            // HINT: You will need to put two extra pieces of information in this intent,
            // the Course title, and its description

        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

    }
}

