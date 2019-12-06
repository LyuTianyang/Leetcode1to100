package q0067_easy;

public class AddBinary {
	/**
	 给定两个二进制字符串，返回他们的和（用二进制表示）。
	输入为非空字符串且只包含数字 1 和 0。
	
	示例 1:
	输入: a = "11", b = "1"
	输出: "100"
	
	示例 2:
	输入: a = "1010", b = "1011"
	输出: "10101"
	 */
	public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for(int i = a.length() -1,j=b.length() -1;i>=0 || j>=0; i--, j--){
        	int sum = carry;
        	// 判断i >= 0 j>=0的含义是有可能两个数字长度不一致，如果j<0的话则将其当做0来处理，否则获取其值，也就是 b.charAt(j) - '0'
        	sum += (i >= 0 ? a.charAt(i) - '0' : 0);
        	sum += (j >= 0 ? b.charAt(j) - '0' : 0);
        	ans.append(sum%2);// sum%2是在做二进制取模运算，比如sum=2，这时候将sum%2=0放入结果集中
        	carry = sum/2;// 这里是计算进位，比如sum=2，ca = 1，ca表示进位的意思，满2进1
        }
        ans.append(carry == 1? carry : "");//这一步表示是不是最后还有进位，比如1+1 = 10，10前面的1就是最后留存的进位，需要将其放进去
        return ans.reverse().toString();
    }
	
	public static String addBinary1(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for(int i=len1-1, j=len2-1; i>=0 || j>=0; i--, j--){
			int sum = carry;
			if(i>=0) sum += a.charAt(i)-'0';
			if(j>=0) sum += b.charAt(j)-'0';
			int tmp = sum%2;
			sb.append(tmp);
			carry = sum/2;
		}
		if(carry == 1) sb.append(carry);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		String result = addBinary1("1010", "1011");
		System.out.println(result);
	}
	
}
