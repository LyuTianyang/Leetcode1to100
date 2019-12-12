package num_0031_hard;

import java.util.Arrays;

public class NextPermutation {
	/**
	 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的数。
	如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
	12642 - 14226
	321 - 123
	 */
	public static void nextPermutation(int[] nums){
        if(nums == null || nums.length == 0) return;
        int replace = nums.length - 2;
        while(replace >= 0){
        	if(nums[replace] < nums[replace + 1]) break;
        	replace --;
        }
        if(replace < 0){ // 最大数的情况下，如3,2,1
        	Arrays.sort(nums);
        	return;
        }
        int largerIdx = replace + 1;
        while(largerIdx < nums.length && nums[largerIdx] > nums[replace]){
        	largerIdx++;
        }
        largerIdx = largerIdx-1;
        int tmp = nums[replace];
        nums[replace] = nums[largerIdx];
        nums[largerIdx] = tmp;
        Arrays.sort(nums, replace+1, nums.length);
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,6,4,2};
		nextPermutation(nums);
		for(int i : nums){
        	System.out.println(i);
        }
	}
}
