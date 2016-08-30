package com.example.tiyu.support;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.example.tiyu.R;
import com.example.tiyu.xw.CBA_list;
import com.example.tiyu.xw.HOT_list;
import com.example.tiyu.xw.NBA_list;
import com.example.tiyu.xw.OG_list;
import com.example.tiyu.xw.ZC_list;

public class GetList_XW {
	private XmlPullParser parser;

	public GetList_XW(NBA_list nba_list) {
		this.parser = nba_list.getResources().getXml(R.xml.titles_nba);
	}

	public GetList_XW(ZC_list zc_list) {
		this.parser = zc_list.getResources().getXml(R.xml.titles_zc);
	}

	public GetList_XW(OG_list og_list) {
		this.parser = og_list.getResources().getXml(R.xml.titles_og);
	}

	public GetList_XW(HOT_list hot_list) {
		this.parser = hot_list.getResources().getXml(R.xml.titles_hot);
	}

	public GetList_XW(CBA_list cba_list) {
		this.parser = cba_list.getResources().getXml(R.xml.titles_cba);
	}

	public ArrayList<String> getList_XW() {
		ArrayList<String> list = new ArrayList<String>();
		String s = null;
		try {
			int event = parser.getEventType();
			while (event != XmlPullParser.END_DOCUMENT) {
				boolean flag = false;
				switch (event) {
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("title")) {
						s = parser.nextText();
						flag = true;
					}
					break;
				}
				if (flag) {
					list.add(s);
					s = null;
				}
				event = parser.next();
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;

	}
}
