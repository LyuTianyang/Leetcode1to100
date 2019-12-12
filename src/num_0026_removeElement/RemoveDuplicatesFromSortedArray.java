package num_0026_removeElement;

public class RemoveDuplicatesFromSortedArray {

	/**
	 *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
	 *  [1,1,2,2,3,4,4]
	 *  不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
	 */
	public static int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
        int slow = 1;
         for(int fast = 1;fast<nums.length;fast++){
        	if(nums[fast-1]!=nums[fast]){
        		//nums[slow++] = nums[fast]; 这一行等于下面两行
        		nums[slow] = nums[fast];
        		slow++;
        	}
        }
		return slow;
    }
	
	public static int removeDuplicates1(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int count = 1;
		for(int i = 1; i<nums.length; i++){
			if(nums[i] != nums[i-1]){
				count = count+1;
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,2,2,3,4,4};
		int result = removeDuplicates1(nums);
		System.out.println(result);
	}
}
