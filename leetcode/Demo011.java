package StageOne;

import java.util.ArrayList;
import java.util.List;

public class Demo011 {
	public static void main(String[] args) {
		int n = 3;
		/*********method one********/
		char[] chars = new char[n*2];
		List<String> list1 = new ArrayList<>();
		generateAll(chars,0,list1);
		System.out.println(list1.toString());
		/*********method two********/
		List<String> list2 = new ArrayList<>();
		backtrack(list2,"",0,0,n);
		System.out.println(list2.toString());
	}
	
	public static void generateAll(char[] list,int pos, List<String> lists) {
		if(pos==list.length) {
			if(valid(list))
				lists.add(new String(list));
		} else {
			list[pos] = '(';
			generateAll(list,pos+1,lists);
			list[pos] = ')';
			generateAll(list,pos+1,lists);
		}
	}
	
	public static void backtrack(List<String> ans, String cur, int open, int close, int max) {
		if(cur.length()==max*2) {
			ans.add(cur);
			return ;
		}
		
		if(open < max)
			backtrack(ans, cur+"(", open+1, close, max);
		if(close < open) 
			backtrack(ans, cur+")", open, close+1, max);
	}
	
	public static boolean valid(char[] list) {
		int n = 0;
		for(char c : list) {
			if(c=='(') n++;
			if(c==')') n--;
			if(n<0) return false;//如果在添加中途就出现了不匹配的情况，提前退出
		}
		return n==0;
	}
}
