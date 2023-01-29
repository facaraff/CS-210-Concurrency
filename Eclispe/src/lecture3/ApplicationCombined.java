package lecture3;

// tha main application
public class ApplicationCombined
{
  // it throws InterruptedException to properly shut down Threads.
  public static void main(String[] args) throws InterruptedException
  {
    // create new thread for switch runnable
    Thread togglerRunnable = new Thread(new SwitchRunnable("sw1")); 
    // create new thread for switch Thread
    Thread togglerThread = new SwitchThread("sw2"); 
    // start executing the thread
    togglerRunnable.start();
    togglerThread.start();
    // the main thread sleeps while switch keeps going
    Thread.sleep(5000); // for 5 secs
    // stopping the other thread
    togglerRunnable.interrupt();
    togglerRunnable.join();
    togglerThread.interrupt();
    togglerThread.join();
    // print message 
    System.out.print("Execution ended!");
    // exit program
  }
}
