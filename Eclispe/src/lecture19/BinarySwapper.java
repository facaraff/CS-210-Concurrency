package lecture19;

public class BinarySwapper {
	
	public static void main(String[] args) throws InterruptedException {
		
		BinaryArray a = new BinaryArray(10);
		BinaryArray b = new BinaryArray(10);
		
		a.atomicSetStateAtIndex(0, true);
		
		boolean n = a.atomicGetStateAtIndex(0);
		System.out.println("array a[0] current: " + n);
		
		n = b.atomicGetStateAtIndex(0);
		System.out.println("array b[0] current: " + n);
		
		a.atomicSwap(b, 0, 0);
		
		n = a.atomicGetStateAtIndex(0);
		System.out.println("array a[0] current: " + n);
		
		n = b.atomicGetStateAtIndex(0);
		System.out.println("array b[0] current: " + n);
	
		// threads
		Swapper s1 = new Swapper("s1", a, b);
		Thread t1 = new Thread(s1);
		Swapper s2 = new Swapper("s2", b, a);
		Thread t2 = new Thread(s2);
		
		t1.start();
		t2.start();
		
		Thread.sleep(2000);
		
		t1.interrupt();
		t2.interrupt();
		
		t1.join();
		t2.join();
	}

}
