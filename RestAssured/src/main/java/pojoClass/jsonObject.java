package pojoClass;

import java.util.Random;

import org.json.simple.JSONObject;

public class jsonObject {
	
public Object jsonObjectmethod() {
	Random ran = new Random();
	int ranNum = ran.nextInt(100);
	
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Stack");
	jobj.put("projectName", "overflow"+ranNum);
	jobj.put("status", "ongoing");
	jobj.put("teamSize", 25);
	return jobj;
}
}
