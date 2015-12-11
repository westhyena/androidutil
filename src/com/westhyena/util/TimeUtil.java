package com.westhyena.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.format.DateFormat;

public class TimeUtil {

	public static Date UnixTimeToDate(long unixTimestamp) {
		Date date = new Date();
		date.setTime(unixTimestamp*1000);
		return date;
	}
	
	public static String UnixTimeToString(long unixTimestamp) {
		return UnixTimeToDate(unixTimestamp).toLocaleString();
	}
	
	public static long GetUnixTimestamp() {
		return System.currentTimeMillis()/1000L;
	}
}
