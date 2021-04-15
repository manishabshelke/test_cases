package com.qa.convert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONObject;
import org.json.XML;

public class xmlfileToJsonfile {

	public static void main(String[] args) throws IOException {
	
		File xmlfile= new File("C:\\Users\\Manisha\\Desktop\\ShareScreen\\com.qa.demo\\TestCaseResult.xml");
		
		byte[] b=Files.readAllBytes(xmlfile.toPath());

		String xml=new String(b);
		
		JSONObject obj=XML.toJSONObject(xml);
		
		System.out.println(obj);
		
	}

}
