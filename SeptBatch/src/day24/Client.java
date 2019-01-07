package day24;

public class Client {

	public static void main(String[] args) {
		stack mystack = new stack(5);
		mystack.push(10);
		mystack.display();
		mystack.push(20);
		mystack.display();
		mystack.pop();
		mystack.display();

	}

}
