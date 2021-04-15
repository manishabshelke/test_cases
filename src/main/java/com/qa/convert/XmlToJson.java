package com.qa.convert;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class XmlToJson {
	
	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String TEST_XML_STRING =
        "<?xml version=\"1.0\" ?><testcases><totalTests>8</totalTests><passed>8</passed><failed>0</failed><skipped>0</skipped><duration>0</duration></testcases>";

    public static void main(String[] args) {
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    }
}
 