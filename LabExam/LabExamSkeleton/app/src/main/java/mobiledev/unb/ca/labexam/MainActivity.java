package mobiledev.unb.ca.labexam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private static final String TAG = "MainActivity";
    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the RecyclerView and configure it
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        // TODO Nothing to do here, just note that the shared preferences have
        // been gotten here; you'll use sharedPrefs later
        sharedPrefs = getPreferences(MODE_PRIVATE);

        // TODO Create an instance of LoadDataTask and execute it


    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<LakeInfo> mDataset;

        public MyAdapter(ArrayList<LakeInfo> myDataset) {
            mDataset = myDataset;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mTextView;
            public CheckBox mCheckBox;

            public ViewHolder(LinearLayout v) {
                super(v);
                mTextView = (TextView) v.findViewById(R.id.item_textview);
                mCheckBox = (CheckBox) v.findViewById(R.id.item_checkbox);
            }
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
            LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_layout, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // TODO Get the LakeInfo at index position in mDataSet
            // You might need to declare this variable as final.


            // TODO Set the TextView in the ViewHolder (holder) to be the
            // name of the lake in this LakeInfo


            // TODO: Nothing to do here; just leave this here and complete the other
            // todos in place.
            holder.mCheckBox.setOnCheckedChangeListener(null);

            // TODO SharedPreferences: Set the CheckBox in the ViewHolder
            // (holder) to be checked if the value stored in the shared
            // preferences for the id for this LakeInfo is true, and to
            // be not checked otherwise; if there is no value in the shared
            // preferences for this id, then the checkbox should not be checked
            // (i.e., assume a default value of false for ids that are not in
            // the shared preferences).
            //
            // Hints:
            //
            // https://developer.android.com/reference/android/content/SharedPreferences.html#getBoolean(java.lang.String,%20boolean)
            //
            // https://developer.android.com/reference/android/widget/CheckBox.html
            //
            // https://developer.android.com/reference/android/widget/CompoundButton.html#setChecked(boolean)
            //



            // TODO Set the onClickListener for the TextView in the ViewHolder (holder) such
            // that when it is clicked, it creates an explicit intent to launch DetailActivity
            // Hint: You will need to put extra pieces of information in this intent.



            // TODO: Complete the todos below in the OnCheckedChangedListener
            holder.mCheckBox.setOnCheckedChangeListener(
                    new CompoundButton.OnCheckedChangeListener() {

                        // This method is called when a CheckBox is clicked, and its status
                        // changes from checked to not checked, or from not checked to checked.
                        // isChecked will be true if the CheckBox is now checked, and false if
                        // the CheckBox is now not checked.
                        public void onCheckedChanged(CompoundButton v, boolean isChecked) {

                            // TODO SharedPreferences: Get a SharedPreferences.Editor
                            // for the SharedPreferences
                            //
                            // Hint: https://developer.android.com/reference/android/content/SharedPreferences.html#edit()
                            //

                            // TODO Shared Preferences: Set the value stored in the
                            // SharedPreferences for the id for this LakeInfo to be
                            // the value of isChecked
                            //
                            // Hint: https://developer.android.com/reference/android/content/SharedPreferences.Editor.html#putBoolean(java.lang.String,%20boolean)
                            //


                            // TODO SharedPreferences: Apply the changes from this editor
                            //
                            // Hint: https://developer.android.com/reference/android/content/SharedPreferences.Editor.html#apply()
                            //


                        }
                    }
            );
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }

    // TODO Complete the TODOs for LoadDataTask below
    // Note: This class must use DataModel to load the data on a worker/background thread, and
    // then set the data for the RecyclerView in MainActivity on the UI thread. You
    // should only implement doInBackground and onPostExecute.
    public class LoadDataTask extends AsyncTask<Void, Void, ArrayList<LakeInfo>> {

        protected ArrayList<LakeInfo> doInBackground(Void... params) {
            // TODO Use DataModel to load the data from the JSON assets file
            // and return the ArrayList of LakeInfos

            // Delete the return statement below when you are done this TODO
            // (It's only here so that the skeleton app will compile and run)
            return null;

        }

        protected void onPostExecute(ArrayList<LakeInfo> result) {
            // TODO Use result to set the adapter for the RecyclerView in MainActivity


        }
    }
}
