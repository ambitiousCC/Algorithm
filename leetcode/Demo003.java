package StageOne;

public class Demo003 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(10));
	}
	public static boolean isPalindrome(int n) {
		String str = n +"";
		for(int i=0;i<str.length()/2;i++) {
			int judge = Character.compare(str.charAt(i), str.charAt(str.length()-1-i));
			if(judge!=0)
				return false;
		}
		return true;
	}
}
