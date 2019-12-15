package StageOne;

import java.util.Stack;

public class Demo8 {
	public static void main(String[] args) {
		System.out.println(isValid("([)]"));
	}
	
	public static boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
            	showpush(stack,')');
            else if(c=='{')
            	showpush(stack,'}');
            else if(c=='[')
            	showpush(stack,']');
            else if(stack.empty()||c!=showpop(stack))	//ע��pop()������ջ����Ԫ�ر������ҳ�Ϊ�Ż�ֵ
                return false;
        }
        return stack.empty();
	}
	public static void showpush(Stack<Character> st, char a) {
        st.push(new Character(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }
 
    public static char showpop(Stack<Character> st) {
        System.out.print("pop -> ");
        Character a = (Character) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
        return a;
    }
}
