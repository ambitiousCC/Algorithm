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
		boolean flag = true;//û���뵽��ֱ�����
		for(int i=0;i<len;i++) {
			if(hayChars[i]==start) {
				int length = 0;
				if(i+len2>len) length = len;
				if(i+len2<=len) length = i+len2;
				for(int j=i;j<length;j++) {
					flag = true;//û���뵽ʧ���Ժ���Ҫ���¸�ֵ
					System.out.println(hayChars[j]+" "+needleChars[j-i]);
					if(hayChars[j]!=needleChars[j-i]) {
						flag = false;
						break;
					}
				}
				if(flag&&i+len2<=len) //��������һ���жϣ�flagû�б����̣�Ҳ�᷵��ֵ��ע�ⳤ��
					return i;
			}
		}
		return -1;
	}
}
