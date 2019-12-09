package tools;

public class Utils {
	public static void printNumArray(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			if(i==0) {
				System.out.print("["+nums[i]);
			} else if (i==nums.length-1) {
				System.out.println(","+nums[i]+"]");
			} else {
				System.out.print(","+nums[i]);
			}
		}
	}
}
