package notification;

import com.example.android_open_code.R;
import com.example.android_open_code.R.layout;
import com.example.android_open_code.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ClickShowResult extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_click_show_result);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.click_show_result, menu);
		return true;
	}

}
