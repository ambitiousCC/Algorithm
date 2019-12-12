package henu;

/**
 * 太多需要注意的地方
 * @author Administrator
 *
 */
public class Demo6 {
	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
	}
	
	public static int myAtoi(String str) {
		str = str.trim();
		String numStr = "";
		char l;
		char[] cs;
		
		//*过滤空字符
		if(str==null ||!"".equals(str)) {
			cs = str.toCharArray();
			l = cs[0];
			numStr += l;
		} else {
			return 0;
		}
		//判断是否为有效数字位
		if(Character.compare(l, '+')==0||
				Character.compare(l, '-')==0||
					Character.isDigit(l)) {
			for(int i=1;i<cs.length;i++) {
				if(!Character.isDigit(cs[i])) {
					break;
				}
				numStr += cs[i];
			}
			//*过滤单字符
			if(numStr.length()==1&&!Character.isDigit(numStr.charAt(0)))
				return 0;
			//*判断数字是否越界
			double d = Double.valueOf(numStr);
			if(d<Integer.MIN_VALUE)
				numStr = Integer.MIN_VALUE+"";
			else if (d>Integer.MAX_VALUE)
				numStr = Integer.MAX_VALUE+"";
		} else {
			numStr = "0";
		}
			
		return Integer.valueOf(numStr);
	}
}
