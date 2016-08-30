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

public class OG_news extends Fragment {
	private TextView OG_xw, OG_tl;
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
		View OGView = inflater.inflate(R.layout.xw_news, container, false);
		OG_xw = (TextView) OGView.findViewById(R.id.xw_news);
		OG_tl = (TextView) OGView.findViewById(R.id.xw_title);
		GetTitle_XW OG_Title = new GetTitle_XW(this);
		ArrayList<String> arrayList1 = OG_Title.getTitls_XW(pos);
		s1 = arrayList1.toArray(new String[arrayList1.size()]);

		GetNews_XW OG_news = new GetNews_XW(this);
		ArrayList<String> arrayList2 = OG_news.getNews_XW(pos);
		s2 = arrayList2.toArray(new String[arrayList2.size()]);

		OG_tl.setText(s1[0]);
		OG_xw.setText(s2[0]);

		pl_btn = (Button) OGView.findViewById(R.id.quick_btn);
		pl_btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				new AlertDialog.Builder(getActivity()).setTitle("评论一下").setView(new EditText(getActivity()))
						.setPositiveButton("确定", null).setNegativeButton("取消", null).show();

			}
		});
		return OGView;
	}
}
