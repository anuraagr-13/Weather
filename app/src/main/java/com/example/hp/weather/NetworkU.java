package com.example.hp.weather;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by HP on 18-03-2018.
 */

public class NetworkU {
    private static final String TAG = "NetworkU";
    private final static String WEATHERDB_BASE_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/190795";

    private final static String API_KEY = "aQMG1AeQjo788PzhW44ajsd9XV4g7whU";
    private final static String METRIC_VALUE="true";

    private final static String PARAM_API_KEY = "apikey";

    private final static String PARAM_METRIC="metric";

    public static URL buildUrlForWeather() {
        Uri builtUri = Uri.parse(WEATHERDB_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_API_KEY, API_KEY)
                .appendQueryParameter(PARAM_METRIC,METRIC_VALUE)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "buildUrlForWeather: url: " + url);
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnecton = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnecton.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnecton.disconnect();
        }
    }
}


