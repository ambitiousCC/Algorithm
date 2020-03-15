package StageOne;

import java.util.List;
import java.util.ArrayList;
public class Demo006 {
	public static void main(String[] args) {
		String[] strs = {"aaa","aa","aaa"};
		System.out.println(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		String publicStr = "";
		List<Character> list = new ArrayList<>();
		if(strs.length==0)
			return "";
		for(int j=0;j<strs[0].length();j++) {
			list.add(strs[0].charAt(j));
		}
		for(int j=1;j<strs.length;j++) {
			if(list.size()==0)
				return publicStr;
			list = updateList(strs[j],list);
		}
		for(int j=0;j<list.size();j++) {
			publicStr += (char)list.get(j)+"";
		}
		return publicStr;
	}
	
	public static List<Character> updateList(String strs, List<Character> list) {
		List<Character> list2 = new ArrayList<>();
		for(int i = 0;i<strs.length();i++) {
			char c = strs.charAt(i);
			System.out.println(i);
			if(i<list.size()) {
				char getLi = (char)list.get(i);
				if(Character.compare(c, getLi) == 0) {
					list2.add(list.get(i));
				} else {
					if(i==0)
						return list2;
					break;
				}
			}
		}
		return list2;
	}
}
