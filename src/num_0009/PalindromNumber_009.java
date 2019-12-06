package num_0009;

public class PalindromNumber_009 {
	/**
	判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

	示例 1:
	
	输入: 121
	输出: true
	示例 2:
	
	输入: -121
	输出: false
	解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
	示例 3:
	
	输入: 10
	输出: false
	解释: 从右向左读, 为 01 。因此它不是一个回文数。
	 */
	public static boolean isPalindrom(int x){
		if(x<0) return false;
		if(x>=0 && x<10) return true;
		int num = x;
		int div = 1; 
		//算出x是几位数
		while(num/div >=10){
			div = div * 10;
		}
		while(num>0){
			int left = num/div;
			int right = num%10;
			if(left!=right) return false;
			num = (num - left*div)/10;
			div = div/100;
			
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrom(123321));
	}
}
