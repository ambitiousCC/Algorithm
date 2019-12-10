package StageOne;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) {
//		@SuppressWarnings("resource")
//		Scanner scan = new Scanner(System.in);
//		String str = scan.nextLine();
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		//list save char
		//find from list to judge whether equal
		//count and return the length of chars
		System.out.println(s);
		
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		if(" ".equals(s)||s.length()==1) {
			return 1;
		}
		while(i<s.length()-1&&!" ".equals(s)) {
			//如何使他最终跳出循环
			System.out.println("i1:"+i);
			List<Character> li = new ArrayList<Character>();
			li.add(s.charAt(i));
			for(int j=i+1;j<s.length();j++) {
				System.out.println("i2:"+i);
				System.out.println("j:"+j);
				if(isNotAlreadyHave(li,s.charAt(j))&&j<s.length()-1) {
					li.add(s.charAt(j));
				}else if(isNotAlreadyHave(li,s.charAt(j))&&j==s.length()-1) {
					li.add(s.charAt(j));
					list.add(li.size());
				}else {
					list.add(li.size());
					break;
				}
			}
			i++;
			
			//致命bug：找到下一个时应该仍然从当前位置开始判断
		}
		return longestLength(list);
	}
	
	public static boolean isNotAlreadyHave(List<Character> li, char c) {
		boolean flag = true;
		for(int i=0;i<li.size();i++) {
			char cli = (char)li.get(i);
			//两个字符相等
			if(Character.compare(cli, c)==0) {
				flag = false;
			}
		}
		return flag;
	}
	
	public static int longestLength(List list) {
		int max = 0;
		for(int i=0;i<list.size();i++) {
			int j = (int)list.get(i);
			if(j>max) {
				max = j;
			}
		}
		return max;
	}
}
