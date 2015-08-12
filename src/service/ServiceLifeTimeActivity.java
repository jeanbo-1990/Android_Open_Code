package service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.android_open_code.R;

public class ServiceLifeTimeActivity extends Activity implements
		OnClickListener {

	/**
	 * 启动
	 */
	private Button btn_startService;
	/**
	 * 绑定
	 */
	private Button btn_bindService;
	/**
	 * 停止
	 */
	private Button btn_stopService;
	/**
	 * 解除绑定
	 */
	private Button btn_unbindService;
	
	/**
	 * 服务链接
	 */
	private ServiceConnection connection=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_lifetime);

		initView();
		viewOperate();
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		btn_startService = (Button) findViewById(R.id.btn_startService);
		btn_bindService = (Button) findViewById(R.id.btn_bindService);
		btn_stopService = (Button) findViewById(R.id.btn_stopService);
		btn_unbindService = (Button) findViewById(R.id.btn_unbindService);
	}

	private void viewOperate() {
		btn_startService.setOnClickListener(this);
		btn_bindService.setOnClickListener(this);
		btn_stopService.setOnClickListener(this);
		btn_unbindService.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent =new Intent(ServiceLifeTimeActivity.this,ServiceLifeTime.class);
		switch (v.getId()) {
		// 启动
		case R.id.btn_startService:
			startService(intent);
			break;
		// 绑定
		case R.id.btn_bindService:
			bindService(intent, connection, Service.BIND_AUTO_CREATE);
			break;
		// 停止
		case R.id.btn_stopService:
			stopService(intent);
			break;
		// 取消绑定
		case R.id.btn_unbindService:
			unbindService(connection);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
