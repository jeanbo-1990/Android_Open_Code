package theme;

import main.BaseActivity;

import com.example.android_open_code.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThemeSwitchActivity extends BaseActivity implements OnClickListener {
	
	SharedPreferences sharedPreferences;
	
	private Button btn_theme1;
	private Button btn_theme2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		sharedPreferences=getSharedPreferences("theme", MODE_PRIVATE);
		int themeStyle= sharedPreferences.getInt("themeStyle", R.style.SwitchTheme1);
		setTheme(themeStyle);
		setContentView(R.layout.activity_theme_switch);
		initView();
	}
	
	/**
	 *  ”Õº≥ı ºªØ
	 */
	private void initView(){
		btn_theme1=(Button) findViewById(R.id.btn_theme1);
		btn_theme2=(Button) findViewById(R.id.btn_theme2);
		
		btn_theme1.setOnClickListener(this);
		btn_theme2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Editor editor=sharedPreferences.edit();
		switch (v.getId()) {
		case R.id.btn_theme1:
			editor.putInt("themeStyle", R.style.SwitchTheme1);
			editor.commit();
			break;
		case R.id.btn_theme2:
			editor.putInt("themeStyle", R.style.SwitchTheme2);
			editor.commit();
			break;

		default:
			break;
		}
	}
}
