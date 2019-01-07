package day25;

public class AdapterClientQtoS {

	public static void main(String[] args) {
		AdapterQtoStack q = new AdapterQtoStack(5);
		q.push(1);
		q.push(3);
		System.out.println(q.pop());
		System.out.println(q.pop());

		
		
		q.push2(1);
		q.push2(3);
		System.out.println(q.pop2());
		System.out.println(q.pop2());

		
	}

}
