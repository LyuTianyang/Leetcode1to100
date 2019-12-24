package num_0012;

public class IntToRoman {
	/**
	 * {1000,900,500,400,100,90,50,40,10,9,5,4,1}; 
       {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
       I 1, V 5, X 10, L 50, C 100, D 500, M 1000
	   IV 4, IX 9, XL 40, XC 90, CD 400, CM 900
	   
	       字符         		 数值
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
		X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
		C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
	 */
	public static String intToRoman(int num) {
		if(num <= 0) return "";
		//用数组定义字典
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1}; 
        String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        //定义一个字符串
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<values.length; i++){
			int tmp = num/values[i];
			if(tmp == 0) continue;
			for(int j=0; j<tmp; j++){
				sb.append(strs[i]);
			}
			num = num - tmp*values[i];
			if(num == 0) break;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String result = intToRoman(3943);
		System.out.println(result);
	}
}
