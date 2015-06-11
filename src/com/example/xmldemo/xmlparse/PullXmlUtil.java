package com.example.xmldemo.xmlparse;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;
import android.util.Xml;

/**
 * @author xcr
 * @version 创建时间：2015-4-7 下午1:10:09
 * 类说明
 */
public class PullXmlUtil {
	
	
	
	public  void  handlXml(InputStream is){
		 // 由android.util.Xml创建一个XmlPullParser实例
		XmlPullParser  parse=Xml.newPullParser();
		try {
			parse.setInput(is, "UTF-8");
			//产生第一个事件
			int eventType=parse.getEventType();
			while(eventType!=XmlPullParser.END_DOCUMENT){
				switch (eventType) {
				//文档开始事件
				case XmlPullParser.START_DOCUMENT:
					Log.i("pullxml", "XmlPullParser.START_DOCUMENT");
					break;
					//标签的开始
				case XmlPullParser.START_TAG:
						Log.i("pullxml", parse.getName());
						int count=parse.getAttributeCount();
						for (int i = 0; i < count; i++) {
							Log.i("pullxml", parse.getAttributeName(i)+":"+parse.getAttributeValue(i));
						}
				      break;
				case XmlPullParser.END_TAG:
				      break;
				default:
					break;
				}
				try {
					eventType=parse.next();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
