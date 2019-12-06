package q0046_Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation1 {
	/**
	Q0046_recursion 给定一个没有重复数字的序列，返回其所有可能的全排列。
	输入: [1,2,3]
	输出:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
	*/
	public static List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return res;
		}
		List<Integer> curList = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		boolean[] used = new boolean[nums.length];
		//上面几行用于定义好需要用的集合和其他参数，之后进入helper方法
		helper(res, curList, nums, used);
		return res;
    }
	
	public static void helper(List<List<Integer>> res, List<Integer> curList, int[] nums, boolean[] used){
		if(curList.size() == nums.length){
			res.add( new ArrayList<Integer>(curList));
			return;
		}else{
			for(int i=0; i<nums.length; i++){
				if(used[i] == false){
					curList.add(nums[i]);
					used[i] = true;
					helper(res, curList, nums, used);
					used[i] = false;
					curList.remove(curList.size()-1);
					
				}
			}
		}
	}
	
	public static void permuteHelper1(List<List<Integer>> res, List<Integer> curList, int[] nums, Set<Integer> set){
		if(curList.size() == nums.length){
			//跳出递归的条件
			res.add(new ArrayList<Integer>(curList));
		}else{
			for(int i=0;i<nums.length;i++){
				//当hashset里面不包含当前被遍历的元素时
				if(!set.contains(nums[i])){
					//curList和set都加入当前元素
					curList.add(nums[i]);
					set.add(nums[i]);
					//找到curList的最后一个元素
					int last = curList.size() - 1;
					permuteHelper1(res, curList, nums, set);
					//curList和set都去掉当前元素
					set.remove(nums[i]);
					curList.remove(last);
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute1(nums));
	}
}
