package lecture3;

// the main application (using Runnable instances)
public class ApplicationRunnable
{
  // it throws InterruptedException to properly shut down Threads.
  public static void main(String[] args) throws InterruptedException
  {
    // create new thread for switch
    Thread toggler = new Thread(new SwitchRunnable("sw1")); 
    // start executing the thread
    toggler.start();
    // the main thread sleeps while switch keeps going
    Thread.sleep(2000); // for 2 seconds
    // stopping the other thread
    toggler.interrupt();
    // allow toggler to finish what it is doing
    toggler.join();
    // print message 
    System.out.print("Execution ended!");
    // exit program
  }
}
