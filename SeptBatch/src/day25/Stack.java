package day25;

public class Stack {

		protected int tos = -1;
		protected int[] arr;

		public Stack(int cap) {
			arr = new int[cap];
		}
		
		public Stack() {
			this(2);
		}

		void push(int val) {
			if(tos == arr.length -1) {
				System.out.println("stack is full");
				return;
			}
			tos++;
			arr[tos] = val;
		}

		public int pop() {
			if (tos == -1) {
				System.out.println("stack is full");
				return -1;
			}
			
			int val = arr[tos];
			arr[tos] = 0;
			tos--;
			return val;
		}

		public int top() {
			if (tos == -1) {
				System.out.println("stack is full");
				return -1;
			}
			
			int val = arr[tos];
			return val;
		}

		public void display() {
			for (int i = tos; i >= 0; i--) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

		public int size() {
			return tos + 1;
		}
		public boolean isEmpty() {
			if(tos == -1) {
				return true;
			}
			else return false;
		}
	

}
