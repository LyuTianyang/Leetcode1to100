package q0088_easy;

import java.util.Arrays;
/**
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
*/
public class MergeTwoArrays {
	/**
	  
	 nums1 = {3,4,5,0,0}
	 nums2 = {1,2}
	 
	 第一个while循环结束之后：
	 nums1 = {3,4,3,4,5}
	 nums2 = {1,2}
	 
	 第一个while循环结束之后：
	 nums1 = {1,2,3,4,5}
	 nums2 = {1,2}
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		while(i>=0 && j>=0){
			//比较nums1[i],nums2[j] 哪个大
			nums1[k--] = nums1[i]>=nums2[j]?nums1[i--]:nums2[j--];
		}
		while(j>=0){
			nums1[k--] = nums2[j--];
		}
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,7,0,0,0,0,0};
		int[] nums2 = {2,5,6,8};
		merge(nums1,3,nums2,4);
		for(int num : nums1){
			System.out.println(num);
		}
		
	}
}
