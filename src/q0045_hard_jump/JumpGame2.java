package q0045_hard_jump;

public class JumpGame2 {
	/**
	Q0045: 给定一个非负整数数组，你最初位于数组的第一个位置。

	数组中的每个元素代表你在该位置可以跳跃的最大长度。
	
	你的目标是使用最少的跳跃次数到达数组的最后一个位置。
	
	示例:
	
	输入: [2,3,1,1,4]
	输出: 2
	解释: 跳到最后一个位置的最小跳跃数是 2。
	     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
	 */
	public static int jump(int[] nums) {
        if(nums == null || nums.length <=1) return 0;
        int currMax = 0; //当前这一步能走到的最远位置
        int nextMax = 0; //下面的节点可能走到的最远位置
        int step = 0;
        //每个元素的下标，在内层循环里面都会遍历到，直到最后一个
        int index = 0;
        while(index <= currMax){
        	while(index <= currMax){
        		nextMax = Math.max(nextMax, index + nums[index]);
        		index++;
        	}
        	currMax = nextMax;
        	step++;
        	if(currMax >= nums.length-1) return step;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,6,3,1,1,1,1};
		int result = jump(nums);
		System.out.println(result);
	}
}
