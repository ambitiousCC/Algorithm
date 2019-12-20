package StageOne;

public class Demo95 {
	public static void main(String[] args) {
		String s = " H e llo wo r ld ";
		System.out.println(lengthOfLastWord(s));
	}
	
	public static int lengthOfLastWord(String s) {
		if("".equals(s)) return 0;
		String newStr = s.trim();
		newStr = newStr.substring(newStr.lastIndexOf(' ')+1);
		return newStr.length();
	}
}
