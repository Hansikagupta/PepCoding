package day25;

public class Queue {
	int size = 0, front = 0, rear;
	int[] arr;

	Queue(int cap) {
		arr = new int[cap];
	}

	void enqueue(int val) {
		if (size == arr.length) {
			System.out.println("FULL");
			return;
		}
		rear = (size + front) % arr.length;
		arr[rear] = val;
		size++;
	}

	int dequeue() {
		if (size == 0) {
			System.out.println("EMPTY");
			return -1;
		}
		int val = arr[front];
		arr[front] = 0;
		front = (front + 1) % arr.length;
		size--;
		return val;
	}

	int front() {
		if (size == 0) {
			System.out.println("EMPTY");
			return -1;
		}
		int val = arr[front];
		return val;
	}

	boolean isEmpty() {
		if (size > 0)
			return false;
		return true;
	}
	boolean isFull() {
	
		return size== arr.length;
	}

	void display() {
		for(int i = front, count = 1;count <= size ;count++, i = (i + 1)%arr.length) {
			System.out.print(arr[i] + " ");
		}
	}

}
