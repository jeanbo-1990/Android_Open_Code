package service;

import com.example.android_open_code.R;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

/**
 * 用于测试android.app.Service 的生命周期
 * @author wjb
 *
 */
public class ServiceLifeTime extends Service {
	
	/**
	 * log类型
	 */
	String strLogName="";

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		strLogName=getResources().getString(R.string.service_log);
		Log.i(strLogName, "ServiceLifeTime--onCreate");
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		Log.i(strLogName, "ServiceLifeTime--onStart");
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.i(strLogName, "ServiceLifeTime--onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i(strLogName, "ServiceLifeTime--onDestroy");
		super.onDestroy();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		Log.i(strLogName, "ServiceLifeTime--onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		Log.i(strLogName, "ServiceLifeTime--onLowMemory");
		super.onLowMemory();
	}

	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		Log.i(strLogName, "ServiceLifeTime--onTrimMemory");
		super.onTrimMemory(level);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(strLogName, "ServiceLifeTime--onBind");
		return null;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(strLogName, "ServiceLifeTime--onUnbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(strLogName, "ServiceLifeTime--onRebind");
		super.onRebind(intent);
	}

	@Override
	public void onTaskRemoved(Intent rootIntent) {
		// TODO Auto-generated method stub
		Log.i(strLogName, "ServiceLifeTime--onTaskRemoved");
		super.onTaskRemoved(rootIntent);
	}

}
