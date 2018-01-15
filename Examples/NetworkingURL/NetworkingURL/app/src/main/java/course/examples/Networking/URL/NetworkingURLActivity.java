package course.examples.Networking.URL;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkingURLActivity extends Activity {
	private TextView mTextView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		mTextView = (TextView) findViewById(R.id.textView1);

		final Button loadButton = (Button) findViewById(R.id.button1);
		loadButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
                // Check if there is a network connection
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    new HttpGetTask().execute();
                } else {
                    Toast.makeText(NetworkingURLActivity.this,
                            R.string.no_network,
                            Toast.LENGTH_SHORT).show();
                }
			}
		});
	}

	private class HttpGetTask extends AsyncTask<Void, Void, String> {

		private static final String TAG = "HttpGetTask";
        // Get JSON data describing all earthquakes that occurred in the
        // last day. See documentation here:
        // http://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php
		private static final String URL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson";

		@Override
		protected String doInBackground(Void... params) {
			String data = "";
			HttpURLConnection httpUrlConnection = null;

			try {
				httpUrlConnection = (HttpURLConnection) new URL(URL)
						.openConnection();

				InputStream in = new BufferedInputStream(
						httpUrlConnection.getInputStream());

				data = readStream(in);

			} catch (MalformedURLException exception) {
				Log.e(TAG, "MalformedURLException");
			} catch (IOException exception) {
				Log.e(TAG, "IOException");
			} finally {
				if (null != httpUrlConnection)
					httpUrlConnection.disconnect();
			}
			return data;
		}

		@Override
		protected void onPostExecute(String result) {
			mTextView.setText(result);
		}

		private String readStream(InputStream in) {
            BufferedReader reader = null;
            StringBuilder data = new StringBuilder("");
            try {
                reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null) {
                    data.append(line);
                }
            } catch (IOException e) {
                Log.e(TAG, "IOException");
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return processJSON(data.toString());
        }

        private String processJSON(String data) {
            String result = "";
            try {
                JSONObject jsonObject = new JSONObject(data);
                JSONArray jsonArray = jsonObject.getJSONArray("features");

                for (int i=0; i < jsonArray.length(); i++)
                {
                    try {
                        JSONObject oneObject = jsonArray.getJSONObject(i);
                        JSONObject properties = oneObject.getJSONObject("properties");
                        String place = properties.getString("place");
                        result = result + place + "\n";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
		}
	}
}