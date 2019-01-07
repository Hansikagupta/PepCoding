package day25;

public class BalancedBracketsClient {
	private static class Pair {
		char open;
		char close;
	}

	public static void main(String[] args) {
		System.out.println(bbSS("[(af+5)]"));
		System.out.println(bb("([({af+5})]"));
		System.out.println(bb("[({af+5)]})"));
		System.out.println(bb("[])"));

	}

	public static boolean bb(String s) {
		Stack mystk = new Stack(s.length());
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				mystk.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (mystk.isEmpty()) {
					return false;
				} else {
					if (!foundPartner(c, mystk)) {
						return false;
					}
				}
			}
		}
		if (mystk.isEmpty()) {
			return true;
		} else
			return false;
	}

	public static boolean bbSS(String s) {
		Stack mystk = new Stack(s.length());
		for (char c : s.toCharArray()) {
			if ("({[".indexOf(c) != -1) {
				mystk.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (mystk.isEmpty()) {
					return false;
				} else if ("({[".indexOf(mystk.top()) != ")}]".indexOf(c)) {
					return false;
				}
				else mystk.pop();
			}
		}
		if (mystk.isEmpty()) {
			return true;
		} else
			return false;
	}

	private static boolean foundPartner(char c, Stack mystk) {
		if (c == ')' && mystk.top() != '(')
			return false;
		if (c == '}' && mystk.top() != '{')
			return false;
		if (c == ']' && mystk.top() != '[')
			return false;
		mystk.pop();
		return true;
	}

}
