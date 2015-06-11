package com.example.xmldemo.xmlparse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

/**
 * @author xcr
 * @version 创建时间：2015-4-7 下午1:44:29
 * 类说明
 */
public class SaxHandler extends DefaultHandler {
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		Log.i("sax", "start");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		Log.i("sax", "end");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		Log.i("sax", "startElement:"+localName);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		Log.i("sax", "endElement:"+localName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String thestring=new String(ch, start, length);
		Log.i("sax", thestring.trim());
	}

}
