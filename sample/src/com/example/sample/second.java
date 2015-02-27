package com.example.sample;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;


public class second extends Service {
	public Handler uiHandler;
	Context mcontext;
	private static final String TAG = "SRINIVASARAO";
	
@Override
public void onCreate() {
	// TODO Auto-generated method stub
	super.onCreate();
	
	new Thread(new Runnable() {
		public void run() {

			try {
				Log.d(TAG, "service is called before thread is going to sleep:" );
				Thread.sleep(3000);
				Log.d(TAG, "service is called after thread is going to sleep:" );
				MainActivity.uiHandler.post(new Runnable() {
					@Override
					public void run() {
						
						Log.d(TAG, "negativeButton:service is called");
						if(MainActivity.positiveButton!=null)
						{
							System.out.println("riht");
							MainActivity.positiveButton.setEnabled(true);
						}
						else
							System.out.println("wrong");

					}

				});

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}).start();
	
}

@Override
public IBinder onBind(Intent intent) {
	// TODO Auto-generated method stub
	return null;
}
}
