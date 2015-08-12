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
	 * 显示toast
	 * @param text 要显示的文本
	 */
	public void showToast(String text){
		Toast.makeText(this, text, 2*1000).show();
	}
	
	/**
	 * 显示toast
	 * @param text 要显示的文本
	 * @param duration 显示时长
	 */
	public void showToast(String text,int duration){
		Toast.makeText(this, text, duration).show();
	}
}
