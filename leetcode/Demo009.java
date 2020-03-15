package StageOne;

public class Demo009 {
	public static void main(String[] args) {
		int[] nums = {1,3,4,5,6,7};
		int val = 3;
		System.out.println(removeElements(nums,val));
	}
	
	public static int removeElements(int[] nums, int val) {
		if(nums.length==0) return 0;
		int i = 0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j]!=val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
}
