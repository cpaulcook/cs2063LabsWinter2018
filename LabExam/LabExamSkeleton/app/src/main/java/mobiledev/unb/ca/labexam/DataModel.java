package mobiledev.unb.ca.labexam;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataModel {

    private ArrayList<LakeInfo> mEntries = new ArrayList<>();
    private static final String DATAFILE = "nblakes.json";

    public DataModel(Context context) {
        AssetManager assetManager = context.getAssets();

        // Read the contents of the data file into a StringBuffer
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        try {
            br = new BufferedReader(new InputStreamReader(assetManager.open(DATAFILE)));
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Process the JSON data to populate mEntries
        String jsonString = sb.toString();

        try {

            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i=0; i < jsonArray.length(); i++) {

                // Create a JSON Object from individual JSON Array element
                JSONArray element = jsonArray.getJSONArray(i);

                String id = element.getString(0);
                String name = element.getString(1);
                String latitude = element.getString(2);
                String longitude = element.getString(3);
                String wikiLink = element.getString(4);

                LakeInfo lakeInfo =
                        new LakeInfo(id, name, latitude, longitude, wikiLink);

                // Add new Course to courses ArrayList
                mEntries.add(lakeInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<LakeInfo> getEntries() {
        return mEntries;
    }

}
