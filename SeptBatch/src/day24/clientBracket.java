package day24;

public class clientBracket {

	public static void main(String[] args) {
		String exp = "((a+b) + c+ ())";
		String exp2 = "(a+b)";

		System.out.println(hasDuplicate(exp));
		System.out.println(hasDuplicate(exp2));

	}
	public static boolean hasDuplicate(String exp) {
		stack mystack = new stack(exp.length());
		for(int i = 0; i < exp.length(); i++) {
			int count = 0;		
			if(exp.charAt(i) == ')') {
				while(mystack.top() != '(') {
					mystack.pop();
					count++;
				}
				mystack.pop();
				if(count == 0) {
					System.out.print(" duplicacy found ");
					return true;
				}
			}
			else mystack.push(exp.charAt(i));			
		}
		System.out.print("NO duplicacy found ");
		return false;
	}
	//using char Array
	
	
}
