package com.example.xmldemo;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.example.xmldemo.xmlparse.PullXmlUtil;
import com.example.xmldemo.xmlparse.SaxHandler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends Activity {
     Context  context=MainActivity.this;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		InputStream  is=context.getResources().openRawResource(R.raw.form);
		PullXmlUtil  pull=new PullXmlUtil();
		pull.handlXml(is);
		
		SAXParserFactory  factory=SAXParserFactory.newInstance();
		try {
			SAXParser  saxparser=factory.newSAXParser();
			
			SaxHandler  saxhandler=new SaxHandler();
//			reader.setContentHandler(saxhandler);
			try {
				is=context.getResources().openRawResource(R.raw.update);
				saxparser.parse(is,saxhandler);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
