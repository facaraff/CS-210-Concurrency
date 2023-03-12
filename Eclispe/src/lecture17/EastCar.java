package lecture17;

import java.util.Random;

public class EastCar implements Runnable{
    private BridgeQueueFixed bridge;
    private String name;
    
    EastCar(String name, BridgeQueueFixed bridge){
        this.bridge = bridge;
        this.name = name;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        int randomInt = 0;
        while (true){
            try {
                System.out.println(name + " is adding to east queue.");
                bridge.eastEnter();
                randomInt = random.nextInt(1000); // up to 1 sec
                Thread.sleep(randomInt);
                bridge.eastExit();
                System.out.println(name + " has removed from east queue.");
                Thread.sleep(randomInt);
            } catch (InterruptedException ex) {
                System.out.println(name + " was interrupted. ");
                break;
            }
        }
    }
    
}
