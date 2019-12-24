package StageOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo016 {
	public static void main(String[] args) {
		String digits = "240";
		System.out.println(letterCombinations(digits).toString());
	}
	
	public static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if("".equals(digits)) return list;
		Map<Integer, String> map = new HashMap<Integer, String>();
		map = createMap(map);
		char[] cs = digits.toCharArray();
		int l = cs.length;
		for(int i=0;i<l;i++) {
			String c = cs[i] + "";
			int j = Integer.parseInt(c);
			if(j>=2&&j<=9)
				list = createListByBums((String)map.get(j),list);
			else 
				return list;
		}
		return list;
	}
	
	public static List<String> createListByBums(String strs, List<String> list) {
		char[] cs = strs.toCharArray();
		int l = cs.length;
		int ll = list.size();
		List<String> li = list;
		if(ll==0) {
			for(int i=0;i<l;i++) {
				li.add(cs[i]+"");
			}
			
		} else {
			List<String> li2 = new ArrayList<String>();
			
			for(int i=0;i<ll;i++) {
				for(int j=0;j<l;j++) {
					String css = cs[j] + "";
					li2.add((String)list.get(i)+css);
				}
			}
			li = li2;
		}
		
		return li;
	}
	
	public static Map<Integer,String> createMap(Map<Integer,String> map) {
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		return map;
	}
}
