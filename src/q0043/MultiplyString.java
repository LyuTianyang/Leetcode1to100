package q0043;

public class MultiplyString {
	/**
	 Q0043 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
	 
	 输入: num1 = "2", num2 = "3"
	 输出: "6"
	
	 输入: num1 = "123", num2 = "456"
	 输出: "56088"
	
	 */
	public static String multiply(String num1, String num2){
		if(num1 == null || num2 == null) return null;
		if(num1.length() == 0 || num2.length() == 0) return null;
		int len1 = num1.length();
		int len2 = num2.length();
		int[] result = new int[len1+len2];
		for(int i = len1-1; i>=0;i--){
			for(int j=len2-1;j>=0;j--){
				int tmp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
				//低位，在后面
				int posLow = i+j+1;
				//高位，在前面一位
				int posHigh = i+j;
				tmp += result[posLow];
				result[posLow] = tmp%10;
				result[posHigh] += tmp/10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int res: result){
			if(sb.length() != 0 || res!=0){
				sb.append(res);
			}
		}
		return (sb.length()==0)?"0":sb.toString();
    }
	
	public static String multiply1(String num1, String num2){
		if(num1 == null || num2 == null) return null;
		int len1 = num1.length();
		int len2 = num2.length();
		int[] result = new int[len1+len2];
		for(int i=len1-1; i>=0; i--){
			for(int j=len2-1; j>=0; j--){
				int tmp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
				int posLow = i+j+1;
				int posHigh = posLow-1;
				tmp += result[posLow];
				result[posLow] = tmp%10;
				result[posHigh] = tmp/10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int res: result){
			if(sb.length() !=0 || res != 0){
				sb.append(res);
			}
		}
		return (sb.length()==0)?"0":sb.toString();
	}
	
	public static void main(String[] args) {
		String result = multiply1("21", "51");
		System.out.println(result);
	}
}
