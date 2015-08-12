package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);

		Intent intent = getIntent();
		String strPath = intent.getStringExtra("ProMenuPath");
		setListAdapter(new SimpleAdapter(MainActivity.this,
				getNextMenuData(strPath == null ? "" : strPath),
				android.R.layout.simple_list_item_1, new String[] { "title" },
				new int[] { android.R.id.text1 }));

		getListView().setTextFilterEnabled(true);
	}

	/**
	 * ��ȡ�˵� ����,����activity������
	 * 
	 * @return
	 */
	private List getNextMenuData(String path) {
		List<Map> myData = new ArrayList<Map>();

		Intent intent = new Intent(Intent.ACTION_MAIN, null);
		intent.addCategory(utils.Constants.INTENT_FILTER_CATEGORY);
		PackageManager pm = getPackageManager();
		List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);

		if (list == null) {
			return myData;
		}

		// �����洢�Ѿ����ڵĲ˵�
		List<String> exitList = new ArrayList<String>();
		for (ResolveInfo resolveInfo : list) {
			CharSequence label = resolveInfo.loadLabel(pm);
			if (label == null || label.equals("")) {
				continue;
			}

			// path��Ĳ˵�
			String strLabel = "";

			// ����ǵ�һ�����������ǵ�һ����Ҫ��pathǰ���ȫ��ȥ��
			if (path.equals("")) {
				strLabel = label.toString();
			} else {
				// strLabel = label.toString().substring(
				// label.toString().indexOf(path + "/"));
				strLabel = label.toString().substring((path + "/").length());
			}

			String[] strList = strLabel.toString().split("/");

			String menu = strList[0];
			// ������������ظ������
			if (exitList.contains(menu)) {
				continue;
			}
			exitList.add(menu);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", menu);
			// ����¼����ǲ˵�����ô����ת�¼��˵�,������ת����Ӧ��ҳ��
			Intent goIntent = new Intent();
			if (strList.length > 1) {
				goIntent.setClass(this, MainActivity.class);
				goIntent.putExtra("ProMenuPath", menu);

			} else {
				goIntent.setClassName(resolveInfo.activityInfo.packageName,
						resolveInfo.activityInfo.name);
			}
			map.put("intent", goIntent);

			myData.add(map);
		}
		return myData;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		// super.onListItemClick(l, v, position, id);
		Map<String, Object> map = (Map<String, Object>) l
				.getItemAtPosition(position);
		Intent intent = (Intent) map.get("intent");
		startActivity(intent);
	}

}
