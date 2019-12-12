package q0035_BinarySearch;

public class SearchInsertPosition {
	/**
	 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	你可以假设数组中无重复元素。
	
	输入: [1,3,5,6], 5
	输出: 2
	
	输入: [1,3,5,6], 0
	输出: 0
	 */
	public static int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0) return 0;
		int start = 0;
		int end = nums.length-1;
		if(target<nums[start]) return 0;
		if(target>nums[end]) return end+1;
		while(start+1<end){
			int mid = start + (end-start)/2;
			if(nums[mid] == target) return mid;
			if(nums[mid]>target){
				end = mid;
			}else{
				start = mid;
			}
		}
		if(nums[end] < target) return end+1;
        else if(nums[start]>= target) return start;
        else return end;
		
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,9};
		int result = searchInsert(nums,2);
		System.out.println(result);
	}
}
