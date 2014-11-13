package util;

public class StringUtil {
	public static String[] StringSplit(String s){
		String[] array = s.split(",");
		return array;
	}
	
	public static void main(String[] args) {
		String s = "a,b,c,d,c,d,";
		String array[]= StringUtil.StringSplit(s);
		for(String temp:array){
			System.out.println(temp);
		}
	}
}
