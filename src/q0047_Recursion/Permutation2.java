package q0047_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Permutation2 {
	/**
	Q0047_recursion 给定一个可包含重复数字的序列，返回所有不重复的全排列。
	输入: [1,1,2]
	输出:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]
	*/
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
		List<Integer> curList = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];
		helper(res, curList, nums, used);
		return res;
    }
	
	public static void helper(List<List<Integer>> res, List<Integer> curList, int[] nums, boolean[] used){
		if(curList.size() == nums.length){
			res.add(new ArrayList<Integer>(curList));
		}else{
			int pre = nums[0] - 1;
			for(int i=0; i<nums.length; i++){
				if(used[i] == false && nums[i]!=pre){
					pre = nums[i];
					curList.add(nums[i]);
					used[i] = true;
					helper(res, curList, nums, used);
					used[i] = false;
					curList.remove(curList.size()-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permuteUnique(nums));
	}
}
