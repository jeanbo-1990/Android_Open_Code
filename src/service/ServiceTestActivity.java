package service;

import main.BaseActivity;
import service.ServiceTest.MyBindService;

import com.example.android_open_code.R;
import com.example.android_open_code.R.layout;
import com.example.android_open_code.R.menu;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceTestActivity extends BaseActivity implements OnClickListener {
	
	private Button btn_startService;
	private Button btn_stopService;
	private Button btn_bindService;
	private Button btn_unbindService;
	
	private ServiceConnection connection=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			showToast("unBind");
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			MyBindService bindService=(MyBindService)service;
			String strResult=bindService.showName("jeanbo");
			showToast(strResult);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_test);
		initView();
		viewOperate();
	}
	
	/**
	 * 初始化页面控件
	 */
	private void initView(){
		btn_startService=(Button) findViewById(R.id.btn_startService);
		btn_stopService=(Button) findViewById(R.id.btn_stopService);
		btn_bindService=(Button) findViewById(R.id.btn_bindService);
		btn_unbindService=(Button) findViewById(R.id.btn_unbindService);
	}
	
	/**
	 * 控件设置
	 */
	private void viewOperate(){
		btn_startService.setOnClickListener(this);
		btn_stopService.setOnClickListener(this);
		btn_bindService.setOnClickListener(this);
		btn_unbindService.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent=new Intent(ServiceTestActivity.this,ServiceTest.class);
		switch (v.getId()) {
		// startservice
		case R.id.btn_startService:
			startService(intent);
			break;
		// stopservice
		case R.id.btn_stopService:
			stopService(intent);
			break;
		// bindservice
		case R.id.btn_bindService:
			bindService(intent, connection, Service.BIND_AUTO_CREATE);
			break;
		// unbindservice
		case R.id.btn_unbindService:
			
			unbindService(connection);
			break;

		default:
			break;
		}
	}
}
