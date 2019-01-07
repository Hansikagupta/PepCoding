package day25;

public class ddid {

	public static void main(String[] args) {
		ddid("iidddii");

	}

	private static void ddid(String s) {
		String ans = "";
		Stack mystk = new Stack(s.length());
		int start = 1;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'd') {	
					mystk.push(start);
					start++;
				
			}
			else if(s.charAt(i) == 'i') {
				mystk.push(start);
				start++;
				while(mystk.isEmpty() == false) {
					System.out.print(mystk.top() + " "); 
					mystk.pop();
				}
				
			}
		
		}
		while(mystk.isEmpty() == false) {
			System.out.print(mystk.top() + " "); 
			mystk.pop();
		}
	}

}
