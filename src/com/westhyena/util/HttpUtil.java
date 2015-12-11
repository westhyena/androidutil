package com.westhyena.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;

public class HttpUtil {
	
	public static HttpURLConnection CreateGetRequest(String requestURL) {
		
		try {
			URL url = new URL(requestURL);
			
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setDoInput(true);
			return connection;
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	public static InputStream sendGetRequest(String requestURL) {
		
		try {
			
			HttpURLConnection connection = CreateGetRequest(requestURL);
			connection.connect();
			if (200 == connection.getResponseCode()) {
				return connection.getInputStream();
			} else {
				return null;
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private class GetRequestAsyncTask extends AsyncTask<String, Void, InputStream> {

		@Override
		protected InputStream doInBackground(String... params) {
			return sendGetRequest(params[0]);
		}
		
	}

}
