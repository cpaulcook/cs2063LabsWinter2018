package mobiledev.unb.ca.lab4uielements;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A fragment representing a single Course detail screen.
 * This fragment is either contained in a {@link GeoDataListActivity}
 * in two-pane mode (on tablets) or a {@link GeoDataDetailActivity}
 * on handsets.
 */
public class GeoDataDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String TITLE = "title";
    public static final String LNG = "item_longitutde";
    public static final String LAT = "item_latitude";

    /**
     * The dummy content this fragment is presenting.
     */
    private String title;
    private String lng;
    private String lat;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GeoDataDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(LNG)) {

            title = getArguments().getString(TITLE);
            lng = getArguments().getString(LNG);
            lat = getArguments().getString(LAT);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle("Earthquake Details");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.geodata_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (lat != null && lng != null) {
            ((TextView) rootView.findViewById(R.id.course_detail)).setText("Title: " + title + "\n" +
                                                                            "Longitide: " + lng + "\n" +
                                                                            "Latitude: " + lat);
        }

        return rootView;
    }
}
