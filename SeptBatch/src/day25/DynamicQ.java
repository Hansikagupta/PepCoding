package day25;

public class DynamicQ<T> extends Q<T> {

	DynamicQ(int cap) {
		super(cap);
	}

	@Override
	void enqueue(T val) {
		if (size == arr.length) {
//			T[] oldArr;
//			oldArr = (T[]) new Object[arr.length];
//			for (int i = 0; i < arr.length; i++) {
//				oldArr[i] = arr[i];
//
//			}
			
			//SS WAY
			T[] oldArr = arr;
			arr = (T[]) new Object[oldArr.length * 2];
			for (int i = front, count = 1; count <= size; count++, i = (i + 1) % oldArr.length) {
				arr[count - 1] = oldArr[i];
			}
			front = 0;
		}

		super.enqueue(val);
	}

}
