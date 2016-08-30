package com.example.tiyu.gd;

import com.example.tiyu.R;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class More_work extends Fragment {
	private LinearLayout yj_l, gx_l, gy_l;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View MoreView = inflater.inflate(R.layout.more, container, false);

		yj_l = (LinearLayout) MoreView.findViewById(R.id.yj_btn);
		gx_l = (LinearLayout) MoreView.findViewById(R.id.gx_btn);
		gy_l = (LinearLayout) MoreView.findViewById(R.id.gy_btn);
		yj_l.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
				fragmentTransaction.replace(R.id.realcontent, new More_yj()).commit();
			}
		});

		gx_l.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "已经是最新版本", Toast.LENGTH_SHORT).show();
			}
		});

		gy_l.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		return MoreView;
	}
}
