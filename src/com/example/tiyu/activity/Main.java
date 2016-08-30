package com.example.tiyu.activity;

import com.example.tiyu.R;
import com.example.tiyu.gd.More_work;
import com.example.tiyu.sc.Day_list;
import com.example.tiyu.sc.Week_list;
import com.example.tiyu.tp.JD_list;
import com.example.tiyu.tp.ZX_list;
import com.example.tiyu.xw.CBA_list;
import com.example.tiyu.xw.HOT_list;
import com.example.tiyu.xw.NBA_list;
import com.example.tiyu.xw.OG_list;
import com.example.tiyu.xw.ZC_list;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

@SuppressLint({ "InflateParams", "RtlHardcoded" })
public class Main extends FragmentActivity implements OnItemClickListener {
	private boolean flag1 = true, flag2 = false, flag3 = false;
	private DrawerLayout mDrawerLayout;
	private ListView mLv;
	private TabHost mTabHost;
	private String[] str;
	private String[] tags_xw = new String[] { "OG", "ZC", "HOT", "NBA", "CBA" };
	private String[] titles_xw = new String[] { "奥运会", "中超", "热门", "NBA", "CBA" };
	private String[] tags_tp = new String[] { "ZXZT", "JDJT" };
	private String[] titles_tp = new String[] { "最新组图", "经典镜头" };
	private String[] tags_sc = new String[] { "D_Match", "W_Match" };
	private String[] titles_sc = new String[] { "今日赛程", "本周赛程" };
	private String[] tags_gd = new String[] { " " };
	private String[] titles_gd = new String[] { " " };
	private ImageView menu_BTN;
	public String[] NBA_str;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 左拉菜单部分
		mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout1);
		mDrawerLayout.setDrawerListener(new DrawerListener() {

			@Override
			public void onDrawerStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDrawerSlide(View arg0, float arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDrawerOpened(View arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDrawerClosed(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		mDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
			}

			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
			}
		});
		mLv = (ListView) findViewById(R.id.id_lv);
		str = new String[] { "查看新闻", "经典瞬间", "赛程提醒", "更多精彩" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.drawer_list_item, str);
		mLv.setAdapter(adapter);
		mLv.setOnItemClickListener(this);
		// 选项卡的部分
		setSilidingMenu(tags_xw, titles_xw);
		mTabHost.setCurrentTab(2);
		// 菜单按钮
		menu_BTN = (ImageView) findViewById(R.id.menu_btn);
		menu_BTN.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mDrawerLayout.openDrawer(Gravity.LEFT);
			}
		});
	}

	private class MyTabChangedListener implements OnTabChangeListener {// 选项卡
		public void onTabChanged(String tabTag) {
			FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
			if (tabTag.equalsIgnoreCase(tags_xw[0]) && flag1) {
				fragmentTransaction.replace(R.id.realcontent, new OG_list(), tags_xw[0]);
			} else if (tabTag.equalsIgnoreCase(tags_xw[1]) && flag1) {
				fragmentTransaction.replace(R.id.realcontent, new ZC_list(), tags_xw[1]);
			} else if (tabTag.equalsIgnoreCase(tags_xw[2]) && flag1) {
				fragmentTransaction.replace(R.id.realcontent, new HOT_list(), tags_xw[2]);
			} else if (tabTag.equalsIgnoreCase(tags_xw[3]) && flag1) {
				fragmentTransaction.replace(R.id.realcontent, new NBA_list(), tags_xw[3]);
			} else if (tabTag.equalsIgnoreCase(tags_xw[4]) && flag1) {
				fragmentTransaction.replace(R.id.realcontent, new CBA_list(), tags_xw[4]);
			} else if (tabTag.equalsIgnoreCase(tags_xw[0]) && flag2) {
				fragmentTransaction.replace(R.id.realcontent, new ZX_list(), tags_tp[0]);
			} else if (tabTag.equalsIgnoreCase(tags_xw[1]) && flag2) {
				fragmentTransaction.replace(R.id.realcontent, new JD_list(), tags_tp[1]);
			} else if (tabTag.equalsIgnoreCase(tags_xw[0]) && flag3) {
				fragmentTransaction.replace(R.id.realcontent, new Day_list(), tags_sc[0]);
			} else if (tabTag.equalsIgnoreCase(tags_xw[1]) && flag3) {
				fragmentTransaction.replace(R.id.realcontent, new Week_list(), tags_sc[1]);
			}
			fragmentTransaction.commit();
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parebt, View view, int position, long id) {// 左拉菜单
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		switch (position) {
		case 0:
			flag1 = true;
			flag2 = false;
			flag3 = false;
			mTabHost.getTabWidget().removeAllViews();
			setSilidingMenu(tags_xw, titles_xw);
			mTabHost.setCurrentTab(2);
			fragmentTransaction.replace(R.id.realcontent, new HOT_list()).commit();
			break;
		case 1:
			flag1 = false;
			flag2 = true;
			flag3 = false;
			mTabHost.getTabWidget().removeAllViews();
			setSilidingMenu(tags_tp, titles_tp);
			mTabHost.setCurrentTab(1);
			fragmentTransaction.replace(R.id.realcontent, new JD_list()).commit();
			break;
		case 2:
			flag1 = false;
			flag2 = false;
			flag3 = true;
			mTabHost.getTabWidget().removeAllViews();
			setSilidingMenu(tags_sc, titles_sc);
			mTabHost.setCurrentTab(1);
			fragmentTransaction.replace(R.id.realcontent, new Week_list()).commit();
			break;
		case 3:
			flag1 = false;
			flag2 = false;
			flag3 = false;   
			mTabHost.getTabWidget().removeAllViews();
			setSilidingMenu(tags_gd, titles_gd);
			mTabHost.getCurrentTab();
			mTabHost.setCurrentTab(0);
			fragmentTransaction.replace(R.id.realcontent, new More_work()).commit();
			break;
		}
		setTitle(str[position]);
		mDrawerLayout.closeDrawers();
	}

	public void setSilidingMenu(String tags[], String titles[]) {
		mTabHost = (TabHost) findViewById(R.id.mTabHost);
		mTabHost.setup();
		for (int i = 0; i < titles.length; i++) {
			TabSpec tabSpec = mTabHost.newTabSpec(tags[i]);
			View view = getLayoutInflater().inflate(R.layout.tab_item, null);
			TextView titleView = (TextView) view.findViewById(R.id.title);
			titleView.setText(titles[i]);
			tabSpec.setIndicator(view);
			tabSpec.setContent(R.id.realcontent);
			mTabHost.addTab(tabSpec);
		}
		mTabHost.setOnTabChangedListener(new MyTabChangedListener());
	}

}