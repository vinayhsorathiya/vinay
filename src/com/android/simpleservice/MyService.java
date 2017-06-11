package com.android.simpleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "My Service Started", 3000).show();
		
		super.onCreate();
	}
	
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "My Service Stopped", 3000).show();
		
		super.onDestroy();
	}
	
}
