package StageOne;

import java.util.Random;

public class Demo96 {
	public static void main(String[] args) {
		//产生测试数据
		int times = 100000;
		int[] nums = new int[times];
		for(int i=0;i<times;i++) {
			Random r = new Random();
			double flag = r.nextDouble();
			nums[i] = flag > 0.5 ? r.nextInt() * 100 + 1 : r.nextInt() * (-100) + 1;
		}
		System.out.println(maxSubArray(nums));
		System.out.println(maxSubArray2(nums));
		System.out.println(maxSubArray3(nums));
	}
	
	public static int maxSubArray(int[] nums) {
		long beginTime = System.currentTimeMillis();
		int  max = Integer.MIN_VALUE,
				len = nums.length;
		if(len==0) return 0;
		for(int i=0;i<len;i++) {
			int sum = nums[i];
			for(int j=i+1;j<len;j++) {
				if(max<sum) 
					max = sum;
				sum += nums[j];				
			}
			if(max<sum) 
				max = sum;
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-beginTime+"ms");
		return max;
	}
	
	/**
	 * 贪心算法
	 * @param nums
	 * @return
	 */
	public static int maxSubArray2(int[] nums) {
		long beginTime = System.currentTimeMillis();
		int cur = nums[0],
				max = nums[0],
				len = nums.length;
		
		for(int i=1;i<len;i++) {
			cur = Math.max(nums[i],cur+nums[i]);
			max = Math.max(max, cur);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-beginTime+"ms");
		return max;
	}
	
	/**
	 * ka算法！！最快
	 * @param nums
	 * @return
	 */
	public static int maxSubArray3(int[] nums) {
		long beginTime = System.currentTimeMillis();
		int max = nums[0], len = nums.length;
		for(int i = 1; i < len;i++) {
			if(nums[i - 1] > 0)
				nums[i] += nums[i-1];
			
			max = Math.max(nums[i], max);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-beginTime+"ms");
		return max;
	}
}
