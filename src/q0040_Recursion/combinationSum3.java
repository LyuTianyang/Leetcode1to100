package q0040_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum3 {
	/**
	candidates {1,2,3,4,5,6,7,8,9}
	给定一个数字 x，要求使用 k 个数字求和可以得到 x，数字从1-9中选择，不能重复。
	例如 k = 3, x = 9时输出：[[1,2,6], [1,3,5], [2,3,4]]
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        if(candidates == null || candidates.length == 0 || target<= 0) return res;
        int index = 0;
        Arrays.sort(candidates);
        helper(candidates, k, target, index, res, curList);
        return res;
	}

	//数组，target，index(数组下标)，返回值results，currentSeq当前的组合
	private static void helper(int[] candidates, int k, int target, int index,
			List<List<Integer>> res, List<Integer> curList) {
		if(target == 0 && curList.size() == k){
			res.add(new ArrayList<Integer>(curList));
		}else if(target > 0){
			for(int i = index; i<candidates.length; i++){
				if(i != index && candidates[i] == candidates[i-1]) continue;
				curList.add(candidates[i]);
				//和之前不同，使用i+1
				helper(candidates,k, target-candidates[i],i+1,res,curList);
				curList.remove(curList.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = {1,2,3,4,5,6,7,8,9};
		int target = 9;
		List<List<Integer>> results = combinationSum2(candidates,target, 3);
		System.out.println(results);
	}
}
