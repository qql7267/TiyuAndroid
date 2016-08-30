package com.example.tiyu.gd;

import com.example.tiyu.R;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class More_yj extends Fragment {
	private Button tj_btn, qx_btn;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View YJView = inflater.inflate(R.layout.yj_layout, container, false);
		tj_btn = (Button) YJView.findViewById(R.id.tj_btn);
		qx_btn = (Button) YJView.findViewById(R.id.qx_btn);
		tj_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
				fragmentTransaction.replace(R.id.realcontent, new More_work()).commit();

			}
		});
		qx_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
				fragmentTransaction.replace(R.id.realcontent, new More_work()).commit();
			}
		});
		return YJView;
	}
}
