package lecture6;

public class Garden {
    public static final int MAX = 100;
    private Counter counter;
    private Turnstile west;
    private Turnstile east;

    public int getCount(){
        if (counter!=null)
            return counter.getValue();
        else
            return 0;
    }

    public void go() throws InterruptedException{
    	//create a new counter
    	counter = new Counter();
    	// create Turnstiles
        west = new Turnstile(counter);
        east = new Turnstile(counter);
        // create threads
        Thread westThread = new Thread(west, "west");
        Thread eastThread = new Thread(east, "east");
        // start threads
        westThread.start();
        eastThread.start();
        // wait for threads to die
        westThread.join();
        eastThread.join();
    }

}
