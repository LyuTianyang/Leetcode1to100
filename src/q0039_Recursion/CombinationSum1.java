package q0039_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {
	/**
	给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的数字可以无限制重复被选取。
	说明：
	所有数字（包括 target）都是正整数。
	解集不能包含重复的组合。 
	
	输入: candidates = [2,3,6,7], target = 7,
	所求解集为:
	[
	  [7],
	  [2,2,3]
	]
	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        if(candidates == null || candidates.length == 0 || target<= 0){
        	return results;
        }
        Arrays.sort(candidates);
        int index = 0;
        helper(candidates, target, index, results, curList);
        return results;
	}
	//数组，target，index(数组下标)，返回值results，currentSeq当前的组合
	private static void helper(int[] candidates, int target, int index,
			List<List<Integer>> results, List<Integer> curList) {
		if(target == 0){
			results.add(new ArrayList<Integer>(curList));
		}else if(target > 0){
			for(int i = index; i<candidates.length; i++){
				if(candidates[i] > target) break;
				//加入当前值candidates[i]
				curList.add(candidates[i]);
				helper(candidates,target-candidates[i],i,results,curList);
				//去除最新加入的值candidates[i]
				curList.remove(curList.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = {1,2,3,4,5};
		int target = 7;
		List<List<Integer>> results = combinationSum(candidates,target);
		System.out.println(results);
	}
}
