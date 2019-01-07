package day25;

public class DynamicStack extends Stack {
	public DynamicStack(int cap) {
		super(cap);
	}

	void push(int val) {
		if (tos == arr.length - 1) {
			int[] oldArr = arr;
			arr = new int[arr.length * 2];
			for (int i = 0; i < oldArr.length; i++) {
				arr[i] = oldArr[i];
			}
		}
		super.push(val);
	}

}
