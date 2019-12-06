package num_0031_hard;

import java.util.Arrays;

public class NextPermutation2 {
	/**
	 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的数。
	如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
	12642 - 14226
	321 - 123
	 */
	public static void nextPermutation(int[] nums) {
		 if(nums == null || nums.length == 0) return;
		 int firstSmall = nums.length - 2;
		 while(firstSmall >= 0){
        	if(nums[firstSmall] < nums[firstSmall + 1]) break;
        	firstSmall --;
         }
		 if(firstSmall == -1){
			 reverse(nums,0,nums.length-1);
			 return;
		 }
		 
		 int firstLarge = -1;
		 for(int i=nums.length-1; i>firstSmall; i--){
			 if(nums[i] > nums[firstSmall]){
				 firstLarge = i;
				 break;
			 }
		 }
		 
		 swap(nums, firstSmall, firstLarge);
		 reverse(nums, firstSmall+1, nums.length-1);
    }
	
	public static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i++] = nums[j];
		nums[j--] = tmp;
	}
	
	public static void reverse(int[] nums, int i, int j){
		while(i<j){
			swap(nums, i++, j--);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,7,4,3,1};
		nextPermutation(nums);
		for(int i : nums){
        	System.out.println(i);
        }
	}
}
