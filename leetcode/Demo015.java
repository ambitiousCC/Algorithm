package StageOne;

public class Demo015 {
	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		System.out.println(singleNumber(nums));
		System.out.println(singleNumber2(nums));
	}
	
	public static int singleNumber(int[] nums) {
		int l = nums.length;
		for(int i=0;i<l;i++) {
			boolean flag = true;//每次循环开始都要重新定义flag
			for(int j=0;j<l;j++) {
//				System.out.println(nums[i]+" "+nums[j]);
//				System.out.println(nums[i]==nums[j]&&i!=j);
				if(nums[i]==nums[j]&&i!=j) {
					flag = false;
				}
			}
			if(flag) {
				return nums[i];
			}
		}
		return 0;
	}
	
	public static int singleNumber2(int[] nums) {
		int l= nums.length;
		int result = 0;
		for(int i=0;i<l;i++) {
			result ^= nums[i];
		}
		return result;
	}
}
