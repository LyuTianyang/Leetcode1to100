package num_0027_removeElement;

public class RemoveElement {
	/**
	 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
	 * 返回移除后数组的新长度。
	 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
	 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4
	 */
	public static int removeElement(int[] nums, int val){
		if(nums == null || nums.length == 0) return 0;
		int slow = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] != val){
				nums[slow++] = nums[i];
			}
		}
		return slow;
	}
	
	public static int removeElement1(int[] nums, int val){
		if(nums == null || nums.length == 0) return 0;
		int count = 0;
		for(int i = 0; i<nums.length; i++){
			if(nums[i] != val){
				count = count+1;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{0,1,2,2,3,0,4,2};
		int result = removeElement1(nums,2);
		System.out.println(result);
	}
}
