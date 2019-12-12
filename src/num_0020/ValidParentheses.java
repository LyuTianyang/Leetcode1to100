package num_0020;

import java.util.Stack;

public class ValidParentheses {
	/**
	 * 给一个字符串，判断字符串中的括号是否能配对，() [] {}
	 * 使用栈
	 */
	public static boolean validParentheses(String s){
		Stack<Character> mark = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
				mark.push(s.charAt(i));
			}else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
				if(mark.isEmpty()) return false;
				char current = mark.pop();
				if(current == '(' && s.charAt(i) != ')') return false;
				if(current == '[' && s.charAt(i) != ']') return false;
				if(current == '{' && s.charAt(i) != '}') return false;
			}
		}
		if(mark.isEmpty()) return true;
		return false;
	}
	
	public static void main(String[] args) {
		boolean b = validParentheses("({})");
		System.out.println(b);
	}
}
