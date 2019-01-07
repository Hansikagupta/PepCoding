package day25;

public class DynamicClientQ {

	public static void main(String[] args) {
		Q<Integer> myQ = new DynamicQ<>(5);
		myQ.enqueue(10);
		myQ.enqueue(20);
		myQ.enqueue(30);
		myQ.enqueue(40);
		myQ.display();
		
		myQ.dequeue();
		myQ.dequeue();
		myQ.display();

		myQ.enqueue(50);
		myQ.enqueue(60);
		myQ.enqueue(70);
		myQ.enqueue(80);

		myQ.display();

	}

}
