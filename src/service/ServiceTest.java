package service;

import com.example.android_open_code.R;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ServiceTest extends Service {

	String logName = "";
	
	private MyBindService myBindService=new MyBindService();

	class MyBindService extends Binder {
		public String showName(String name) {
			return "your name is:" + name;
		}
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		logName = getResources().getString(R.string.service_log);
		Log.i(logName, "onCreate");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.i(logName, "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i(logName, "onDestroy");
		super.onDestroy();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(logName, "onUnbind");
		return super.onUnbind(intent);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(logName, "onBind");
		return myBindService;
	}

}
