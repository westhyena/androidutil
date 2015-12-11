package com.westhyena.util;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONUtil {

	public static JSONObject ParseJSON(InputStream stream) {
		StringBuilder builder = new StringBuilder();
		byte[] buffer = new byte[4096];
		try {
			for (int n; (n = stream.read(buffer)) != -1;)
				builder.append(new String(buffer, 0, n));
			return new JSONObject(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
