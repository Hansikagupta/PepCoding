package day25;

public class AdapterQtoStack {
	private Queue dq;
	private Queue hq;
	//use 2 queues

	AdapterQtoStack(int cap) {
		dq = new Queue(cap);
		hq = new Queue(cap);	
	}
	//pop Efficient
	void push(int val) {
		hq.enqueue(val);
		while(dq.size > 0) {
			hq.enqueue(dq.dequeue());
		}
		Queue temp;
		temp = hq;
		hq = dq;
		dq = temp;
		
	}
	int top() {
		return dq.front();
	}
	int pop() {
		return dq.dequeue();
	}
	
	//Push Efficient
	void push2(int val) {
		dq.enqueue(val);
	}
	int top2() {
		while(dq.size >1) {
			hq.enqueue(dq.dequeue());
		}
		int val = dq.dequeue();
		hq.enqueue(val);
		
		Queue temp;
		temp = hq;
		hq = dq;
		dq = temp;
		
		return val;
		
	}
	int pop2() {
		while(dq.size >1) {
			hq.enqueue(dq.dequeue());
		}
		int val = dq.dequeue();
		Queue temp;
		temp = hq;
		hq = dq;
		dq = temp;
		
		return val;
		
	}
	
}
