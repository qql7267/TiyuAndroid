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

public class ZC_news extends Fragment {
	private TextView ZC_xw, ZC_tl;
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
		View ZCView = inflater.inflate(R.layout.xw_news, container, false);
		ZC_xw = (TextView) ZCView.findViewById(R.id.xw_news);
		ZC_tl = (TextView) ZCView.findViewById(R.id.xw_title);
		GetTitle_XW ZC_Title = new GetTitle_XW(this);
		ArrayList<String> arrayList1 = ZC_Title.getTitls_XW(pos);
		s1 = arrayList1.toArray(new String[arrayList1.size()]);

		GetNews_XW ZC_news = new GetNews_XW(this);
		ArrayList<String> arrayList2 = ZC_news.getNews_XW(pos);
		s2 = arrayList2.toArray(new String[arrayList2.size()]);

		ZC_tl.setText(s1[0]);
		ZC_xw.setText(s2[0]);

		pl_btn = (Button) ZCView.findViewById(R.id.quick_btn);
		pl_btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				new AlertDialog.Builder(getActivity()).setTitle("评论一下").setView(new EditText(getActivity()))
						.setPositiveButton("确定", null).setNegativeButton("取消", null).show();

			}
		});
		return ZCView;
	}
}
