package Day3;

public class StudyCharInt {
	public static void main(String[] args) {
		char ch = 's';
		int i = ch;
		System.out.println(i);
		
		int j = 98;
		char ch2 = (char)j;//We have to type cast
		System.out.println(ch2);
		
		checkCase(ch);
		convertCase(ch);
		
		
	}
	private static void checkCase(char ch) {
		if(ch >='a' && ch <='z') {
			System.out.println(ch+" small");		
		}
		else System.out.println(ch+" UpperCase");
	}
	private static void convertCase(char ch) {
		if(ch >='a' && ch <='z') {
			ch = (char)('A' + ch - 'a');
			System.out.println(ch);		
		}
		else {
			ch = (char)('a' + ch - 'A');
			System.out.println(ch);	
		}
	}


}
