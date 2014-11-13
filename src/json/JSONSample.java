package json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author caikc
 * the first sample to test jsonobject 
 */
public class JSONSample {
	private static JSONObject createObject(){
		JSONObject jo = new JSONObject();
		jo.put("name", "a");
		jo.put("pw", 3);
		jo.put("id", 1);
		return jo;
	}
	
	public static void main(String[] args) {
		JSONObject jo = JSONSample.createObject();
		
		//成功打出json 格式正确  通过对象的方法 弄出json的格式  其实就是一些符号的添加而已
		System.out.println(jo);
		
		//类的一些属性
		System.out.println(jo.isArray());
		System.out.println(jo.isEmpty());
		System.out.println(jo.isNullObject());
		
		//添加属性 put和element有什么不同呢
		jo.put("minage", 1);
		jo.element("maxage", 55);
		System.out.println(jo);
		
		//jsonarray 数组添加通过确定index 进行添加 可以直接添加进jsonobject中 通过getjsonarray 提取出来
		JSONArray ja = new JSONArray();
		ja.add(0, "first");
		ja.add(1, "second");
		System.out.println(ja);
		jo.element("jsonarray", ja);
		ja = jo.getJSONArray("jsonarray");
		
		System.out.println(jo);
		System.out.println(ja);
		System.out.println(ja.isArray());
		
		//其他也可以直接提取 拿到具体的key就可以了
		System.out.println(jo.getString("name"));
		
		//字符转换后再 变为jsonobject
		String s = jo.toString();
		JSONObject njo = JSONObject.fromObject(s);
		System.out.println(njo);
	}
}
