package main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	/**
	 * ��ʾtoast
	 * @param text Ҫ��ʾ���ı�
	 */
	public void showToast(String text){
		Toast.makeText(this, text, 2*1000).show();
	}
	
	/**
	 * ��ʾtoast
	 * @param text Ҫ��ʾ���ı�
	 * @param duration ��ʾʱ��
	 */
	public void showToast(String text,int duration){
		Toast.makeText(this, text, duration).show();
	}
}
