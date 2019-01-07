package decemberClass1LL;

public class clientLL {

	public static void main(String[] args) throws Exception {
		// SSLL ll = new SSLL();

		SSLL one = new SSLL();
		SSLL two = new SSLL();

		one.addLastNode(96);
		one.addLastNode(26);
		one.addLastNode(36);
		one.addLastNode(56);
		one.addLastNode(56);
		one.addLastNode(66);

		two.addLastNode(10);
		two.addLastNode(100);
		two.addLastNode(200);
		two.addLastNode(300);
		two.addLastNode(400);
		two.addLastNode(500);
		two.addLastNode(700);
		two.addLastNode(800);
		two.addLastNode(860);

		two.addLastNode(900);
		two.addLastNode(1000);
		two.display();

		two.kRev(3);
		two.display();

//		SSLL merged = SSLL.mergeTwoLL(one, two);
//		merged.display();
//		merged.fold();
//		merged.display();
//
////		SSLL.mergeSortLL2(merged).display();
//
//		SSLL.mergeSort(merged).display();
//		SSLL.mergeSortLL(merged).display();

//		ll.addfirstNode(10);
//		ll.addfirstNode(20);
//		ll.addfirstNode(30);
//		ll.display();
//		
//		System.out.println(ll.getfirst());
//		System.out.println(ll.getlast());
//		System.out.println(ll.getat(1));
////		System.out.println(ll.getat(4));
//		
//		
//		ll.addAt(1, 40);
//		ll.display();
//		ll.addAt(5, 50);
//		ll.display();
//		ll.addAt(3, 100);
//		ll.display();
//		ll.addAt(30, 0);
//		ll.display();

//		ll.addLastNode(10);
//		ll.remlast();
//		ll.display();
//		ll.addLastNode(200);
//		ll.display();
//		
//		ll.remfirst();
//		ll.display();
//		ll.addLastNode(200);
//		ll.display();

//		ll.addLastNode(10);
//		ll.addLastNode(20);
//		ll.addLastNode(30);
//		ll.addLastNode(40);
//		ll.addLastNode(50);
//		ll.addLastNode(60);
//		ll.addLastNode(70);
////		ll.addLastNode(80);

//		ll.addLastNode(40);	
//		ll.addLastNode(30);
//		ll.addLastNode(20);
//	    ll.addLastNode(10);

		// ll.addfirstNode(90);

//		ll.display();
//		//ll.ReversePointerIterativeLL();
//		ll.ReverseDataIterativeLL();
//		ll.display();
//		ll.reversePointerRecursive();
//		ll.display();
//		//ll.displayRevRec();
//		System.out.println();
//		ll.display();
//		ll.reverseDataRec();
//		
//		ll.display();
//
//		
//		System.out.println(ll.getfirst());
//		ll.getlast();
//	//	ll.getat(3);
//		
//		ll.addAt(2, 1000);
//		
//		ll.display();
//		
////		ll.remat(3);
////		ll.display();
//
//		System.out.println(ll.isPalindrome());
//		
//		ll.fold();
//		ll.display();
//		//System.out.println(ll.mid());
//		System.out.println(ll.kfromLast(4));

	}

}
