package com.westhyena.util;

import java.io.IOException;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

public class PushManager {
	
	private static PushManager sInstance;
	public static PushManager getInstance() {
		if (null == sInstance) {
			sInstance = new PushManager();
		}
		return sInstance;
	}
	
	GoogleCloudMessaging mGcm;
	String mRegistrationID;
	
	String mSenderID;
	
	public void Initialize(String senderID) {
		mSenderID = senderID;
	}
	
	public boolean HasRegistratioID() {
		if (null == mRegistrationID) return false;
		if (mRegistrationID.isEmpty()) return false;
		return true;
	}

	public boolean checkPlayServiceAvailable(Activity activity, int requestCode) {
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
	      if (resultCode != ConnectionResult.SUCCESS) {
	         if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
	            GooglePlayServicesUtil.getErrorDialog(resultCode, activity, requestCode).show();
	         }
	         else {
	         }
	         return false;
	      }
	      return true;
	}
	
	
	public void registerInBackground(Context context, RegisterListener listener) {
		new RegisterAsync(context, listener).execute();
	}
	
	public class RegisterAsync extends AsyncTask<Void, Void, String> {
		Context mContext;
		RegisterListener mListener;
		
		public RegisterAsync(Context context, RegisterListener listener) {
			mContext = context;
			mListener = listener;
		}
		
		@Override
		protected String doInBackground(Void... params) {
			String msg = "";
			try {
				if (null == mGcm) {
					mGcm = GoogleCloudMessaging.getInstance(mContext);
				}
				
				mRegistrationID = mGcm.register(mSenderID);
			} catch (IOException e) {
				e.printStackTrace();
				msg = e.getMessage();
			}
			return msg;
		}
		
		@Override
		protected void onPostExecute(String msg) {
			if (msg.isEmpty()) {
				mListener.onRegister(mRegistrationID);
			} else {
				mListener.onFailed(msg);
			}
		}
	}
	
	public interface RegisterListener {
		public void onRegister(String registrationID);
		public void onFailed(String error);
	}
}
