package com.example.tiyu.support;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.example.tiyu.R;
import com.example.tiyu.tp.JD_list;
import com.example.tiyu.tp.ZX_list;

import android.annotation.SuppressLint;

@SuppressLint("DefaultLocale")
public class GePic_TP {
	private XmlPullParser parser;

	public GePic_TP(JD_list jd_list) {
		this.parser = jd_list.getResources().getXml(R.xml.jdjt);
	}

	public GePic_TP(ZX_list zx_list) {
		this.parser = zx_list.getResources().getXml(R.xml.zxzt);
	}

	public ArrayList<String> getPicList_TP() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			int event = parser.getEventType();
			while (event != XmlPullParser.END_DOCUMENT) {
				switch (event) {
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("pic")) {
						if (parser.getAttributeValue(1).equals("t")) {
							list.add(parser.nextText());
						}
					}
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
