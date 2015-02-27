package com.example.sample;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = "SRINIVASARAO";
	protected boolean Set = true;
	Button b1;
	String s = null;
	Intent intent;
	Context mcontext = MainActivity.this;
	AlertDialog builder;
	public static Button positiveButton;
	Button negativeButton;
	public static Handler uiHandler;
	public String bugreportaction = "com.samsung.scare.BugReport_action";

	// String name2 =mcontext.getPackageManager().toString();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.button1);
		// Log.d(TAG,"package name 2:"+name2);

		uiHandler = new Handler(MainActivity.this.getMainLooper());
		/*
		 * Intent i=new Intent("com.samsung.bugfragmentservice_action");
		 * startService(i);
		 */

		// showNoConnectionDialog(this);
		/*
		 * Intent i=new Intent("com.samsung.scare.bugreportservice");
		 * 
		 * startService(i);
		 */
		/*
		 * new Thread(new Runnable() { public void run() {
		 * 
		 * try{ Thread.sleep(1000); }catch(InterruptedException e) {
		 * e.printStackTrace(); } Intent i=new
		 * Intent("com.samsung.scare.bugreportservice");
		 * 
		 * startService(i); } }).start();
		 */

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				/*Log.d(TAG, "before serivce is started");
				
				
							Intent i=new Intent("com.samsung.scare.bugreportservice");

							startService(i);
							Log.d(TAG, "After serivce is started");*/
						
			
				
				
				/*new Thread(new Runnable() {

					@Override
					public void run() {
					//	try{
							Log.d(TAG, "#srinu serivce is started");
							//Thread.sleep(1000);
							uiHandler.post(new Runnable() {

								@Override
								public void run() {
									Log.d(TAG, "before serivce is started");
									Intent i=new Intent("com.samsung.scare.bugreportservice");

									startService(i);
									Log.d(TAG, "After serivce is started");
								}
							});

						}catch(InterruptedException e){
							e.printStackTrace();
						}



					}
				});*/
				showNoConnectionDialog(mcontext);



				/*
				 * new Thread(new Runnable() {
				 * 
				 * @Override public void run() { try{
				 * 
				 * Thread.sleep(5000); }catch(InterruptedException e) {
				 * e.printStackTrace(); }
				 * 
				 * } }).start();
				 */

				/*Intent i = new Intent("com.action.srinu");
				startService(i);*/
				/*
				 * new Thread(new Runnable() { public void run() {
				 * 
				 * try { Thread.sleep(1000);
				 * 
				 * Intent i = new Intent( "com.samsung.scare.bugreportservice");
				 * 
				 * startService(i); Thread.sleep(3000);
				 * 
				 * uiHandler.post(new Runnable() {
				 * 
				 * @Override public void run() { if(positiveButton!=null)
				 * positiveButton.setEnabled(true); else Log.d(TAG,"wrong");
				 * 
				 * }
				 * 
				 * });
				 * 
				 * } catch (InterruptedException e) { e.printStackTrace(); }
				 * 
				 * } }).start();
				 */

			}
		});

	}

	public void showNoConnectionDialog(Context ctx) {

		AlertDialog alertDialog = new AlertDialog.Builder(this)
		.setMessage("message")
		.setCancelable(true)
		.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				Intent i = new Intent(
						"com.samsung.scare.BugReport_action");
				i.addCategory(Intent.CATEGORY_DEFAULT);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

				i.putExtra("openFragment", "bugreport");
				i.putExtra("app_name", "Contacts");
				i.putExtra("crash_info",
						"My name is srinivasa Rao.");

				startActivity(i);
			}
		})
		.setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				return;
			}
		}).create();

		alertDialog.setOnShowListener(new OnShowListener() {
			@Override
			public void onShow(DialogInterface dialog) {
				Log.d(TAG, "show is called:");
				//
				positiveButton = ((AlertDialog) dialog)
						.getButton(AlertDialog.BUTTON_POSITIVE);
				negativeButton = ((AlertDialog) dialog)
						.getButton(AlertDialog.BUTTON_NEGATIVE);
				Log.d(TAG, "positiveButton:" + positiveButton);
				Log.d(TAG, "negativeButton:" + negativeButton);

				
				
				new Thread(new Runnable() {
					public void run() {
						Log.d(TAG, "before Thread is sleep 3sec" + positiveButton);  
						//try {
							//Thread.sleep(5000);
							Log.d(TAG, "after Thread is sleep 3sec" + positiveButton);  

							uiHandler.post(new Runnable() {

								@Override
								public void run() {
									synchronized (this) {
									if (positiveButton != null) {
										Log.d(TAG, "before disable");
										positiveButton.setEnabled(false);
										Log.d(TAG, "after disable");
									}
									}
								}
							});
						/*}catch (InterruptedException e) {
							e.printStackTrace();
						}*/

					}
				}).start();



	

				new Thread(new Runnable() {
					public void run() {
						Log.d(TAG, "before Thread is sleep 3sec" + positiveButton);  
						try {
							Thread.sleep(5000);
							Log.d(TAG, "after Thread is sleep 3sec" + positiveButton);  

							uiHandler.post(new Runnable() {

								@Override
								public void run() {
									
										
								
									if(positiveButton!=null)
									{

										Log.d(TAG, "before Enable the button");
										positiveButton.setEnabled(true);
										Log.d(TAG, "after  Enable the button");
									}

								}
							});
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}).start();



			}
		});

		Log.d(TAG, "before show is called" + positiveButton);
		alertDialog.show();

		Log.d(TAG, "after show is called" + positiveButton);
		new Thread(new Runnable() {

		@Override
		public void run() {
		try{
				Log.d(TAG, "#srinu serivce is started");
				Thread.sleep(1000);
				uiHandler.post(new Runnable() {

					@Override
					public void run() {
						Log.d(TAG, "before serivce is started");
						Intent i=new Intent("com.samsung.scare.bugreportservice");

						mcontext.startService(i);
						Log.d(TAG, "After serivce is started");
					}
				});

			}catch(InterruptedException e){
				e.printStackTrace();
			}



		}
	});

		/*new Thread(new Runnable() {
			public void run() {
				Log.d(TAG, "before Thread is sleep 3sec" + positiveButton);  
				//try {
					//Thread.sleep(3000);
					Log.d(TAG, "after Thread is sleep 3sec" + positiveButton);  

					uiHandler.post(new Runnable() {

						@Override
						public void run() {
						if(positiveButton!=null)
						{

							Log.d(TAG, "before Enable the button");
							positiveButton.setEnabled(false);
							Log.d(TAG, "after  Enable the button");
							}

						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}).start();*/

		/*
		 * if(positiveButton!=null) positiveButton.setEnabled(true); else
		 * Log.d(TAG,"wrong");
		 */
		/*
		 * uiHandler.post(new Runnable() {
		 * 
		 * @Override public void run() { if(positiveButton!=null)
		 * positiveButton.setEnabled(true); else Log.d(TAG,"wrong");
		 * 
		 * }
		 * 
		 * });
		 */

	}

}
