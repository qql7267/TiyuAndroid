package com.example.tiyu.support;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.example.tiyu.R;
import com.example.tiyu.xw.CBA_news;
import com.example.tiyu.xw.HOT_news;
import com.example.tiyu.xw.NBA_news;
import com.example.tiyu.xw.OG_news;
import com.example.tiyu.xw.ZC_news;

public class GetTitle_XW {
	private XmlPullParser parser;

	public GetTitle_XW(NBA_news nba_news) {
		this.parser = nba_news.getResources().getXml(R.xml.titles_nba);
	}

	public GetTitle_XW(CBA_news cba_news) {
		this.parser = cba_news.getResources().getXml(R.xml.titles_cba);
	}

	public GetTitle_XW(HOT_news hot_news) {
		this.parser = hot_news.getResources().getXml(R.xml.titles_hot);
	}

	public GetTitle_XW(OG_news og_news) {
		this.parser = og_news.getResources().getXml(R.xml.titles_og);
	}

	public GetTitle_XW(ZC_news zc_news) {
		this.parser = zc_news.getResources().getXml(R.xml.titles_zc);
	}

	public ArrayList<String> getTitls_XW(int pos) {
		ArrayList<String> list = new ArrayList<String>();
		String s = null;
		try {
			int event = parser.getEventType();
			int i = 0;
			while (event != XmlPullParser.END_DOCUMENT) {
				switch (event) {
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("title")) {
						if (i == pos) {
							s = parser.nextText();
							pos = -1;
						}
						i++;
					}
					break;
				}
				event = parser.next();
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		list.add(s);
		return list;
	}
}
