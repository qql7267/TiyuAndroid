package com.example.tiyu.xw;

import java.util.ArrayList;

import com.example.tiyu.R;
import com.example.tiyu.support.GetNews_XW;
import com.example.tiyu.support.GetTitle_XW;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HOT_news extends Fragment {
	private TextView HOT_xw, HOT_tl;
	private Button pl_btn;
	private int pos;
	private String[] s1, s2;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getArguments();
		if (bundle != null)
			pos = bundle.getInt("pos");
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View HOTView = inflater.inflate(R.layout.xw_news, container, false);
		HOT_xw = (TextView) HOTView.findViewById(R.id.xw_news);
		HOT_tl = (TextView) HOTView.findViewById(R.id.xw_title);
		GetTitle_XW HOT_Title = new GetTitle_XW(this);
		ArrayList<String> arrayList1 = HOT_Title.getTitls_XW(pos);
		s1 = arrayList1.toArray(new String[arrayList1.size()]);

		GetNews_XW HOT_news = new GetNews_XW(this);
		ArrayList<String> arrayList2 = HOT_news.getNews_XW(pos);
		s2 = arrayList2.toArray(new String[arrayList2.size()]);

		HOT_tl.setText(s1[0]);
		HOT_xw.setText(s2[0]);

		pl_btn = (Button) HOTView.findViewById(R.id.quick_btn);
		pl_btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				new AlertDialog.Builder(getActivity()).setTitle("评论一下").setView(new EditText(getActivity()))
						.setPositiveButton("确定", null).setNegativeButton("取消", null).show();

			}
		});
		return HOTView;
	}
}
