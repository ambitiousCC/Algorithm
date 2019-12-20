package StageOne;

import tools.Utils;

public class Demo1 {
	/**
	 * 注意返回的是下标而不是值
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {3,3};
		int target = 6;
		nums = twoSum(nums,target);
		Utils.printNumArray(nums);
	}
	
	public static int[] twoSum(int[] nums,int target) {
		int[] newNums = new int[2];
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(target==nums[i]+nums[j]) {
					newNums[0] = i;
					newNums[1] = j;
				}
			}
		}

		if(newNums[0]!=newNums[1]) {
			return newNums;
		} else {
			return null;
		}
	}
}
