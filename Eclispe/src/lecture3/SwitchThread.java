package lecture3;

//A simple toggle switch extending the Thread class
public class SwitchThread extends Thread{
// attributes to hold the state information
	
	private boolean signal;
	private String name;

	// constructor
	SwitchThread(String name){
		signal = false;
		this.name = name;
	}	

	// setters and getters
	public boolean getSignal(){
		return signal;
	}
	public String getGivenName(){
		return name;
	}

	// state changing actions
	public void down(){
		signal = true;
	}

	public void up(){
		signal = false;
	}

	// work that will be done by the thread
	public void run(){
		while(true){
			try{
				System.out.println("------");
				System.out.println(name);
				down();
				System.out.println(signal);
				Thread.sleep(2000); // sleep for 2 seconds
				up();
				System.out.println(signal);
			}
			catch(InterruptedException e){// if interrupted exit the thread appropriately 
				System.out.println("Interrupt occured!");
				break;
			}
		}
	
	}
}
