package q0040_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	/**
	给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	candidates 中的每个数字在每个组合中只能使用一次。
	说明：
	所有数字（包括目标数）都是正整数。
	解集不能包含重复的组合。 
	
	示例
	输入: candidates = [10,1,2,7,6,1,5], target = 8,
	所求解集为:
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	]
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        if(candidates == null || candidates.length == 0 || target<= 0) return res;
        int index = 0;
        Arrays.sort(candidates);
        helper(candidates, target, index, res, curList);
        return res;
	}

	//数组，target，index(数组下标)，返回值results，currentSeq当前的组合
	private static void helper(int[] candidates, int target, int index,
			List<List<Integer>> res, List<Integer> curList) {
		if(target == 0){
			res.add(new ArrayList<Integer>(curList));
		}else if(target > 0){
			for(int i = index; i<candidates.length; i++){
				if(i != index && candidates[i] == candidates[i-1]) continue;
				curList.add(candidates[i]);
				//和之前不同，使用i+1
				helper(candidates,target-candidates[i],i+1,res,curList);
				curList.remove(curList.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> results = combinationSum2(candidates,target);
		System.out.println(results);
	}
}
