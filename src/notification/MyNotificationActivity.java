package notification;

import main.BaseActivity;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.android_open_code.R;

public class MyNotificationActivity extends BaseActivity implements
		OnClickListener {

	/**
	 * 系统默认布局
	 */
	private Button btn_system;

	/**
	 * 自定义布局
	 */
	private Button btn_customer;

	private NotificationManager notificationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_mynotification);
		initView();
		viewOperate();

		notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		btn_system = (Button) findViewById(R.id.btn_system);
		btn_customer = (Button) findViewById(R.id.btn_customer);
	}

	/**
	 * 控件设置
	 */
	private void viewOperate() {
		btn_system.setOnClickListener(this);
		btn_customer.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// 设置tickerText,即头
		Notification notification = new Notification(R.drawable.open_code_app,
				"你有一条消息", System.currentTimeMillis());
		// 设置点击跳转页面
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				new Intent(this, ClickShowResult.class),
				notification.flags |= Notification.FLAG_AUTO_CANCEL);
		switch (v.getId()) {
		// 系统默认样式弹出通知
		case R.id.btn_system:
			// 设置展开内容
			notification
					.setLatestEventInfo(this, "系统样式通知", "你好", pendingIntent);
			notificationManager.notify(123, notification);
			break;
		// 自定义布局
		case R.id.btn_customer:
			notification.contentView = new RemoteViews(getPackageName(),
					R.layout.notification_customer);
			
			notification.contentIntent = pendingIntent;
			notificationManager.notify(123, notification);
			break;

		default:
			break;
		}
	}
}
