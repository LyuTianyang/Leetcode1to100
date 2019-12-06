package q0060_hard;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	/**
	Q0060给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
	按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
	
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	给定 n 和 k，返回第 k 个排列。
	k/fact[i-1]是指第几组(从0开始)，比如k/factorial[n-1-i] == 1时，说明是第1组，开头数字为2
	
	说明：
	给定 n 的范围是 [1, 9]。
	给定 k 的范围是[1,  n!]。
	示例 1:
	
	输入: n = 3, k = 3
	输出: "213"
	示例 2:
	
	输入: n = 4, k = 9
	输出: "2314"
	 */
	public static String getPermutation(int n, int k) {
		char[] result = new char[n];
		List<Integer> nums = new ArrayList<Integer>();
		int[] fact = new int[n];
		fact[0] = 1;
		//f[]里面放阶乘的结果
		for(int i=1;i<n;i++){
			fact[i] = fact[i-1]*i;
		}
		//nums里面放每一个数字
		for(int i=1;i<=n;i++){
			nums.add(i);
		}
		k--;//因为要用于下标的计算
		for(int i=0;i<n;i++){
			int group = nums.get(k/fact[n-1-i]);
			result[i] = Character.forDigit(group, 10);
			nums.remove(k/fact[n-1-i]);
			k = k%fact[n-1-i];
		}
		return String.valueOf(result);
    }
	
	public static String getPermutation1(int n, int k) {
		List<Integer> res = new ArrayList<Integer>();
		int[] fact = new int[n];
		fact[0] = 1;
		//f[]里面放阶乘的结果
		for(int i=1;i<n;i++){
			fact[i] = fact[i-1]*i;
		}
		//nums里面放每一个数字
		for(int i=1;i<=n;i++){
			res.add(i);
		}
		k = k-1;//因为要用于下标的计算
		StringBuilder sb = new StringBuilder();
		for(int i=n; i>0; i--){
			int group = k/fact[i-1];
			k = k%fact[i-1];
			sb.append(res.get(group));
			res.remove(group);
		}
		return sb.toString();
    }
	
	public static String getPermutation2(int n, int k) {
		List<Integer> res = new ArrayList<Integer>();
		int[] fact = new int[n];
		fact[0] = 1;
		//f[]里面放阶乘的结果
		for(int i=1;i<n;i++){
			fact[i] = fact[i-1]*i;
		}
		//nums里面放每一个数字
		for(int i=1;i<=n;i++){
			res.add(i);
		}
		k = k-1;//因为要用于下标的计算
		StringBuilder sb = new StringBuilder();
		for(int i=n-1; i>=0; i--){
			int group = k/fact[i];
			k = k%fact[i];
			sb.append(res.get(group));
			res.remove(group);
		}
		return sb.toString();
    }
	
	
	public static void main(String[] args) {
		String result = getPermutation1(5,9);
		System.out.println(result);
	}
}
