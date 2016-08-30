package com.example.tiyu.xw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.tiyu.R;
import com.example.tiyu.support.GetList_XW;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class CBA_list extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		String[] from = new String[] { "title" };
		int[] to = new int[] { R.id.title };
		
		GetList_XW CBA_list = new GetList_XW(this);
		ArrayList<String> arrayList = CBA_list.getList_XW();
		String[] titles = arrayList.toArray(new String[arrayList.size()]);

		View CBAView = inflater.inflate(R.layout.main_list, container, false);
		ListView mListView = (ListView) CBAView.findViewById(R.id.mListView);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < titles.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("title", titles[i]);
			list.add(item);
		}

		SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.xw_list_item, from, to);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new MyItemCLickListener());
		return CBAView;
	}

	private class MyItemCLickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Bundle bundle = new Bundle();
			bundle.putInt("pos", position);
			bundle.putString("awd", String.valueOf(position));
			CBA_news cba_n=new CBA_news();
			cba_n.setArguments(bundle);
			getActivity().getFragmentManager().beginTransaction().replace(R.id.realcontent, cba_n).commit();
		}
	}
}
