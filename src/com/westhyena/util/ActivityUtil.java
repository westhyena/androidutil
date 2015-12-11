package com.westhyena.util;

import android.content.Context;
import android.widget.Toast;

public class ActivityUtil {

	public static String getResourceString(Context context, int id) {
		return context.getResources().getString(id);
	}
	
	public static void showToast(Context context, String text, int duration) {
		Toast.makeText(context, text, duration).show();
	}
	
}
