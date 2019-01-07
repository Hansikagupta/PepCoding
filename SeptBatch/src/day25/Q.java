package day25;

public class Q<T> {

	int size = 0, front = 0, rear;
	T[] arr;

	Q(int cap) {
		arr = (T[]) new Object[cap];
	}

	void enqueue(T val) {
		if (size == arr.length) {
			System.out.println("FULL");
			return;
		}
		rear = (size + front) % arr.length;
		arr[rear] = val;
		size++;
	}

	T dequeue() {
		if (size == 0) {
			System.out.println("EMPTY");
			return null;
		}
		T val = arr[front];
		arr[front] = null;
		front = (front + 1) % arr.length;
		size--;
		return val;
	}

	T front() {
		if (size == 0) {
			System.out.println("EMPTY");
			return null;
		}
		return arr[front];
	}

	boolean isEmpty() {
		return (size <= 0);
	}

	void display() {
		for (int i = front, count = 1; count <= size; count++, i = (i + 1) % arr.length) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
