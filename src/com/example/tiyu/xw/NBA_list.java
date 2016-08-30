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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class NBA_list extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		String[] from = new String[] { "title" };
		int[] to = new int[] { R.id.title };

		GetList_XW NBA_list = new GetList_XW(this);
		ArrayList<String> arrayList = NBA_list.getList_XW();
		String[] titles = arrayList.toArray(new String[arrayList.size()]);

		View NBAView = inflater.inflate(R.layout.main_list, container, false);
		ListView mListView = (ListView) NBAView.findViewById(R.id.mListView);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < titles.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("title", titles[i]);
			list.add(item);
		}

		SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.xw_list_item, from, to);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new MyItemCLickListener());
		return NBAView;
	}

	private class MyItemCLickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Bundle bundle = new Bundle();
			bundle.putInt("pos", position);
			NBA_news nba_n = new NBA_news();
			nba_n.setArguments(bundle);
			getActivity().getFragmentManager().beginTransaction().replace(R.id.realcontent, nba_n).commit();
		}
	}

}
