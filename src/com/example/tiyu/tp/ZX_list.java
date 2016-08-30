package com.example.tiyu.tp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.tiyu.R;
import com.example.tiyu.support.GePic_TP;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ZX_list extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		String[] from = new String[] { "cover", "cover_title" };
		int[] to = new int[] { R.id.cover, R.id.cover_title };

		GePic_TP getPic = new GePic_TP(this);
		ArrayList<String> arrayList = getPic.getPicList_TP();
		String[] s = arrayList.toArray(new String[arrayList.size()]);

		View ZXView = inflater.inflate(R.layout.main_list, container, false);
		ListView mListView = (ListView) ZXView.findViewById(R.id.mListView);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < s.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("cover", R.drawable.m1_1+i*3);
			item.put("cover_title", s[i]);
			list.add(item);
		}

		SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.tp_list_item, from, to);
		mListView.setAdapter(adapter);
		return ZXView;

	}
}
