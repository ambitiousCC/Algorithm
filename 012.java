package StageOne;

public class Demo94 {
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 2;
		System.out.println(searchInsert(nums,target));
		System.out.println(searchInsert2(nums,target));
	}
	
	public static int searchInsert(int[] nums, int target) {
		//����
		int len = nums.length;
		if(len==0) return -1;
		for(int i=0;i<len;i++) {
			if(nums[i]==target) 
				return i;
		}
		//������
		for(int j=0;j<len;j++) {
			if(nums[j]<target&&len==(j+1))
				return len;
			else if (nums[j]<target&&nums[j+1]>target)
				return j+1;
			else if (nums[0]>target)
				return 0;
		}
		
		return -1;
	}
	
	public static int searchInsert2(int[] nums, int target) {
		int len = nums.length;
		if(nums[len -1] < target) {
			return len;
		}
		
		int left = 0;
		int right = len - 1;
		
		while(left <= right) {
			int mid = (left + right) /2;
			
			if(nums[mid]==target) {
				return mid;
			} else if (nums[mid] < target) {
				//��ʱ��λ��ҪС�ڣ����Ը�����߽�
				left = mid + 1;
			} else if (nums[mid] > target) {
				//��ʱ��λ�����ڣ������ұ߽�
				right = mid - 1;
			}
		}
		
		return left;
	}
}
