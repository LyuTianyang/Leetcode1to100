package num_0006;

public class ZigZagCoversion {
	/**
	 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

	比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
	L   C   I   R
	E T O E S I I G
	E   D   H   N
	之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
	
	输入: s = "LEETCODEISHIRING", numRows = 3
	输出: "LCIRETOESIIGEDHN"
	
	 */
	public static String convert(String s, int numRows) {
		if(s==null || s.length() <=1) return s;
		if(numRows<=1) return s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for(int j = 0; j<numRows; j++){
			sb[j] = new StringBuilder();
		}
		char[] c = s.toCharArray();
		//字符串长度
		int len = s.length();
		//字符串下标
		int i = 0;
		while(i<len){
			for(int idx = 0; idx<numRows && i<len; idx++){
				sb[idx].append(c[i++]);
			}
			
			for(int idx=numRows-2; idx>=1 && i<len; idx--){
				sb[idx].append(c[i++]);
			}
		}
		for(int j=1; j<numRows; j++){
			sb[0].append(sb[j]);
		}
		return sb[0].toString();
	}
	
	public static void main(String[] args) {
		String result = convert("LEETCODEISHIRING",4);
		System.out.println(result);
	}
}
