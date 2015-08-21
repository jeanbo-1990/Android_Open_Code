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
	 * ϵͳĬ�ϲ���
	 */
	private Button btn_system;

	/**
	 * �Զ��岼��
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
	 * ��ʼ������
	 */
	private void initView() {
		btn_system = (Button) findViewById(R.id.btn_system);
		btn_customer = (Button) findViewById(R.id.btn_customer);
	}

	/**
	 * �ؼ�����
	 */
	private void viewOperate() {
		btn_system.setOnClickListener(this);
		btn_customer.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// ����tickerText,��ͷ
		Notification notification = new Notification(R.drawable.open_code_app,
				"����һ����Ϣ", System.currentTimeMillis());
		// ���õ����תҳ��
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				new Intent(this, ClickShowResult.class),
				notification.flags |= Notification.FLAG_AUTO_CANCEL);
		switch (v.getId()) {
		// ϵͳĬ����ʽ����֪ͨ
		case R.id.btn_system:
			// ����չ������
			notification
					.setLatestEventInfo(this, "ϵͳ��ʽ֪ͨ", "���", pendingIntent);
			notificationManager.notify(123, notification);
			break;
		// �Զ��岼��
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
