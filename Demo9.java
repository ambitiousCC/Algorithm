package StageOne;

public class Demo9 {
	public static void main(String[] args) {
		int[] nums = {1,5,8,3,3,4};
		System.out.println(removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
		nums = sortArray(nums);
		if(nums.length==0) return 0;
		int i = 0;
		for(int j=1;j<nums.length;j++) {
			if(nums[i]!=nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}
	
	public static int[] sortArray(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums;
	}
}
