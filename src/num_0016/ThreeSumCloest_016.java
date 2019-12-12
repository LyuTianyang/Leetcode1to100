package num_0016;

import java.util.Arrays;

public class ThreeSumCloest_016 {
	/**
	给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

	例如，给定数组 nums = [-1,2,1,-4], 和 target = 1.
	
	与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
	 */
	public static int threeSumCloest(int[] nums, int target){
		if(nums == null || nums.length <= 2) return 0;
		Arrays.sort(nums);
		int res = nums[0]+nums[1]+nums[2]-target;
		if(res == 0) return target;
		int i = 0;
		int n = nums.length;
		while(i < n-2){
			int base = nums[i];
			int left = i+1;
			int right = n-1;
			while(left<right){
				int newRes = base+nums[left]+nums[right]-target;
				if(newRes == 0){
					return target;
				}
				if(Math.abs(newRes)<Math.abs(res)){
					res = newRes;
				}
				if(newRes<0){
					left++;
				}else if(newRes>0){
					right--;
				}
			}
			i++;
		}
		return target+res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{-1,0,1,1,2,3};
		System.out.println(threeSumCloest(nums,5));
	}
}
