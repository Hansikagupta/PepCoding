package day25;

public class DynamicClientStack {

	public static void main(String[] args) {
		Stack mystk = new DynamicStack(5);
		mystk.push(10);
		mystk.push(10);
		mystk.push(10);
		mystk.push(10);
		mystk.push(20);
		mystk.push(20);
		mystk.push(60);
		mystk.display();

	}

}
