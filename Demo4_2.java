package StageOne;

import java.util.ArrayList;
import java.util.List;

public class Demo4_2 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(10));
	}
	
	public static boolean isPalindrome(int n) {
		if(n<=0)
			return false;
		List<Integer> list = new ArrayList<>();
		while(n/10!=0) {
			list.add(n%10);
			n/=10;
		}
		list.add(n);
		
		int len = list.size();
		for(int i=0;i<len;i++) {
			if(list.get(i)!=list.get(len-1-i))
				return false;
		}
		return true;
	}
}
