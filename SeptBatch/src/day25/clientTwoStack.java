package day25;

public class clientTwoStack {

	public static void main(String[] args) {
		TwosStacks my2stk = new TwosStacks(6);
		my2stk.push1(10);
		my2stk.pop1();		
		my2stk.push1(20);
		my2stk.top1();	
		my2stk.push1(30);
		my2stk.top1();
		my2stk.push2(10);
		my2stk.pop2();
		my2stk.push2(20);
		my2stk.top2();
		my2stk.push2(30);
		my2stk.push2(40);
		my2stk.push2(50);
		my2stk.push2(600);


		my2stk.top2();
		
		my2stk.display();
	

	}

}
