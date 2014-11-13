package json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.processors.JsonBeanProcessor;

/**
 * @author caikc the second example to transfer jsonobject to java object and
 *         transfer list to jsonobject every one can learn by themselves,but we
 *         should provide education with those do not.
 */
public class JSONSampleP {

	public static void main(String[] args) {
		//json转java对象
		JSONObject jo = JSONObject
		// .fromObject("{\"name\":\"a\",\"id\":2,\"password\":\"123\"}");  下面不用那么多的转义字符也是可以的
				//user必须为public  不然get set方法根本没拿到  估计是反射问题
				.fromObject("{name:'a',id:2,password:'123'}");
		User u = (User) JSONObject.toBean(jo, User.class);
		System.out.println(u);
		
		//java对象转json
		User newu = new User();
		newu.setId(1);
		newu.setName("a");
		System.out.println(JSONObject.fromObject(newu));

		//list对象转json 'object' is an array. Use JSONArray instead 要用array
		User new1 = new User();
		newu.setId(1);
		newu.setName("a");
		User new2 = new User();
		newu.setId(2);
		newu.setName("b");
		List<User> list = new ArrayList<User>();
		list.add(new1);
		list.add(new2);
		System.out.println(JSONArray.fromObject(list));
		
		//json转list
		JSONArray jas = new JSONArray();
		jas.add("{name:'a',id:2,password:'123'}");
		jas.add("{name:'a',id:2,password:'123'}");
		List list2 = (List) JSONArray.toCollection(jas,User.class);
		System.out.println(list2.toString());
		
	}
}
