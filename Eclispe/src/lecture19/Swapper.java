package lecture19;


import java.util.Random;

public class Swapper implements Runnable{
	
	private BinaryArray one, two;
	private int length;
	private String name;
	
	Swapper(String name, BinaryArray one, BinaryArray two){
		this.name = name;
		this.one = one;
		this.two = two;
		this.length = one.getLength();
	}
	
	@Override
	public void run() {
		Random random = new Random();
		while(true){
			int randO = random.nextInt(length);
			int randD = random.nextInt(length);
			one.atomicSwap(two, randO, randD);
			System.out.println(name + " swapped");
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				System.out.println(name + " was interrupted!");
				break;
			}
		}
	}
}