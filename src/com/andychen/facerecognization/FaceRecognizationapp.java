package com.andychen.facerecognization;

import android.app.Application;
import android.util.Log;

import com.iflytek.cloud.SpeechUtility;

public class FaceRecognizationapp extends Application{

	@Override
	public void onCreate() {
		SpeechUtility
		.createUtility(this, "appid=" + getString(R.string.app_id));
//		CrashHandler crashHandler = CrashHandler.getInstance();
//		crashHandler.init(getApplicationContext());
		super.onCreate();
	};
}
