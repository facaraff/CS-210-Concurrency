package lecture10.carParkWithSemaphore;

import lecture9.Entrance;
import lecture9.Exit;

public class CarParkApplication {
	
    public static void main(String[] args) throws InterruptedException {
    	
        SemaController controller = new SemaController(4);
        Entrance entrance = new Entrance(controller, "In");
        Exit exit = new Exit(controller, "Out");
        Thread arrThread = new Thread(entrance);
        Thread depThread = new Thread(exit);
        arrThread.start();
        depThread.start();
        Thread.sleep(5*10000);
        arrThread.interrupt();
        arrThread.join();
        depThread.interrupt();
        depThread.join();
    }

}