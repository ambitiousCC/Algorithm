package StageOne;

public class Demo92 {
	public static void main(String[] args) {
		String haystack = "mississippi";				
		String needle = "pi";
		System.out.println(strStr(haystack,needle));
	}
	
	public static int strStr(String haystack, String needle) {
		if("".equals(needle)) return 0;
		char[] hayChars = haystack.toCharArray();
		char[] needleChars = needle.toCharArray();
		int len = hayChars.length;
		int len2 = needleChars.length;
		if(len<len2) return -1;
		char start = needle.charAt(0);
		boolean flag = true;//没有想到会直接输出
		for(int i=0;i<len;i++) {
			if(hayChars[i]==start) {
				int length = 0;
				if(i+len2>len) length = len;
				if(i+len2<=len) length = i+len2;
				for(int j=i;j<length;j++) {
					flag = true;//没有想到失败以后需要重新赋值
					System.out.println(hayChars[j]+" "+needleChars[j-i]);
					if(hayChars[j]!=needleChars[j-i]) {
						flag = false;
						break;
					}
				}
				if(flag&&i+len2<=len) //如果是最后一次判断，flag没有被判刑，也会返回值，注意长度
					return i;
			}
		}
		return -1;
	}
}
