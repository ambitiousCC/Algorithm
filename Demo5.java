package StageOne;

public class Demo5 {
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
	
	 public static int reverse(int n) {
	        if(n>Integer.MAX_VALUE||(n*-1.0)>Integer.MAX_VALUE)
	            return 0;
			boolean flag = false;
			if(n<0) {
				n = n * -1;
				flag = true;
			}
			
			if(flag) {
				return  __reverse(n) * -1;
			} else {
				return  __reverse(n);
			}	
		}
		
		public static int __reverse(int n) {
			char[] cs = (n+"").toCharArray();
			int len = cs.length;
			char[] cs2 = new char[len];
			for(int j=0;j<len;j++) {
				cs2[j] = cs[j];
			}
			for(int i=0;i<len/2;i++) {
				cs2[i] = cs[len-i-1];
			}
			for(int j=0;j<len/2;j++) {
				cs2[len-j-1] = cs[j];
			}
			
			String after = "";
			for(int i=0;i<cs2.length;i++) {
				after += cs2[i];
			}
	        double num = Double.valueOf(after);
	        if(num>Integer.MAX_VALUE||(num*-1.0)>Integer.MAX_VALUE)
	            return 0;
	        else
	            return Integer.valueOf(after);
		}
}
