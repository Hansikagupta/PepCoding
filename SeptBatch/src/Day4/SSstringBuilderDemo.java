package Day4;

public class SSstringBuilderDemo {
	public static void main(String[] args) {
//		Modify1("ABcdeF");
		Modify2("bdslk");
		Modify3("bdslk");


//		compress1("aaabbbcccadddeeffg");
//		compress2("aaabbbccadddeeffg");

	}

	private static char convertCase(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			ch = (char) ('A' + ch - 'a');
		} else {
			ch = (char) ('a' + ch - 'A');
		}
		return ch;

	}
	
	private static void Modify2(String s1) {
		StringBuilder sb = new StringBuilder(s1);
		for (int i = 0; i < sb.length(); i++) {
			if(i%2 == 0) {
				char temp =  (char) sb.charAt(i);
				temp++;
				sb.setCharAt(i,temp);				
			}
			else {
				char temp =  (char) sb.charAt(i);
				temp--;
				sb.setCharAt(i,temp);		
			}
		}
		String result = sb.toString();
		System.out.print(result);		
	}


	private static void Modify3(String s1) {
		StringBuilder sb = new StringBuilder(s1);
		char prev = sb.charAt(0);
		for (int i = 1; i < sb.length(); i++) {
			sb.setCharAt(i, convertCase(sb.charAt(i)));
		}

		String result = sb.toString();
		System.out.print(result);
	}

	private static void compress1(String s1) {
		StringBuilder sb = new StringBuilder("");
		char a = s1.charAt(0);
		sb.append(a);

		for (int i = 1; i < s1.length(); i++) {
			if (s1.charAt(i) == a) {
				continue;
			} else {
				a = s1.charAt(i);
				sb.append(a);
			}
		}
		String result = sb.toString();
		System.out.println(result);
	}

	private static void compress2(String s1) {
		StringBuilder sb = new StringBuilder("");
		char a = s1.charAt(0);
		sb.append(a);
		int count = 1;

		for (int i = 1; i < s1.length(); i++) {
			if (s1.charAt(i) == a) {
				count++;
				continue;
			} else {
				a = s1.charAt(i);
				sb.append(count);

				sb.append(a);

				count = 1;

			}
		}
		sb.append(count);

		String result = sb.toString();
		System.out.println(result);
	}

}
