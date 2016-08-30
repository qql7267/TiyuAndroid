package com.example.tiyu.support;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.example.tiyu.R;
import com.example.tiyu.sc.Day_list;
import com.example.tiyu.sc.Week_list;


public class GetMatch_SC {
	private XmlPullParser parser;


	public GetMatch_SC(Day_list day_list) {
		this.parser = day_list.getResources().getXml(R.xml.day_match);
	}
	
	public GetMatch_SC(Week_list week_list) {
		this.parser = week_list.getResources().getXml(R.xml.week_match);
	}

	public ArrayList<String> getMatch_SC() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			int event = parser.getEventType();
			while (event != XmlPullParser.END_DOCUMENT) {
				switch (event) {
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("match")) {
						list.add(parser.getAttributeValue(0));
						list.add(parser.getAttributeValue(1));
						list.add(parser.getAttributeValue(2));
						list.add(parser.getAttributeValue(3));
						list.add(parser.nextText());
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
		return list;
	}
}
