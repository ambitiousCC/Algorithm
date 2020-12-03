import java.util.*;

public class backtrack {
        public static List<List<Integer>> res = new LinkedList<>();
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int sum = scan.nextInt();
            scan = new Scanner(System.in);
            int[] nums = new int[sum];
            for (int i=0;i<sum;i++) {
                nums[i] = scan.nextInt();
            }
            res = permute(nums);
            System.out.println(res);
        }

        public static List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>();
            backtrackTest(nums,track);
            return res;
        }

        public static void backtrackTest(int[] nums, LinkedList<Integer> track)  {
            //结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return ;
            }

            for (int i=0;i<nums.length;i++) {
                if (track.contains(nums[i]))
                    continue; //不合法的操作
                
                track.add(nums[i]);//先序遍历
                //下一层决策树
                backtrackTest(nums, track);
                //取消选择
                track.removeLast();//后续操作
            }
        }
}