package com.example.xmldemo.xmlparse;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;
import android.util.Xml;

/**
 * @author xcr
 * @version ����ʱ�䣺2015-4-7 ����1:10:09
 * ��˵��
 */
public class PullXmlUtil {
	
	
	
	public  void  handlXml(InputStream is){
		 // ��android.util.Xml����һ��XmlPullParserʵ��
		XmlPullParser  parse=Xml.newPullParser();
		try {
			parse.setInput(is, "UTF-8");
			//������һ���¼�
			int eventType=parse.getEventType();
			while(eventType!=XmlPullParser.END_DOCUMENT){
				switch (eventType) {
				//�ĵ���ʼ�¼�
				case XmlPullParser.START_DOCUMENT:
					Log.i("pullxml", "XmlPullParser.START_DOCUMENT");
					break;
					//��ǩ�Ŀ�ʼ
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
