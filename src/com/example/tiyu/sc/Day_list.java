package com.example.tiyu.sc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.tiyu.R;
import com.example.tiyu.support.GetMatch_SC;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Day_list extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		String[] from = new String[] { "team1", "team2", "score1", "score2", "m_type" };
		int[] to = new int[] { R.id.team1, R.id.team2, R.id.score1, R.id.score2, R.id.m_type };

		GetMatch_SC getMatch = new GetMatch_SC(this);
		ArrayList<String> arrayList = getMatch.getMatch_SC();
		String[] s = arrayList.toArray(new String[arrayList.size()]);

		View DayView = inflater.inflate(R.layout.main_list, container, false);
		ListView mListView = (ListView) DayView.findViewById(R.id.mListView);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < s.length; i += 5) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("team1", s[i]);
			item.put("team2", s[i + 1]);
			item.put("score1", s[i + 2]);
			item.put("score2", s[i + 3]);
			item.put("m_type", s[i + 4]);
			list.add(item);
		}
		SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.match_list_item, from, to);
		mListView.setAdapter(adapter);
		return DayView;

	}
}