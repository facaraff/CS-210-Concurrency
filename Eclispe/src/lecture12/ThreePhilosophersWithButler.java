package lecture12;

import java.util.concurrent.Semaphore;
import lecture11.Fork;

public class ThreePhilosophersWithButler {
	
    public static void main(String[] args) throws InterruptedException {
        int numberOfPhil = 3;
        boolean fairness = true; // if fairness is required then true, otherwise false
        Semaphore butler = new Semaphore(numberOfPhil-1, fairness);
        PhilosopherWithButler[] philosophers = new PhilosopherWithButler[numberOfPhil];
        Fork[] forkSet = new Fork[numberOfPhil];
        Thread[] threads = new Thread[numberOfPhil];
        
        for(int i = 0; i < numberOfPhil; i++){
            forkSet[i] = new Fork();
        }
        
        for (int i = 0; i<numberOfPhil; i++){
            int leftForkInd = i;
            int rightForkInd = (i+1)%forkSet.length;
            philosophers[i] = new PhilosopherWithButler(Integer.toString(i),
                                    forkSet[leftForkInd],
                                    forkSet[rightForkInd],
                                    butler);
            threads[i] = new Thread(philosophers[i]);
            threads[i].start();
        }
        
        System.out.println("Simulation started!");
        System.out.println("Main thread is sleeping!");
        Thread.sleep(10000);
        System.out.println("Main thread awake!");
        
        for(int i=0; i<numberOfPhil; i++){
            threads[i].interrupt();
        }
        
        System.out.println("All interrupted!");
        for(int i=0; i<numberOfPhil; i++){
            threads[i].join();
        }
        
        System.out.println("Simulation ended!");
    }
    
}
