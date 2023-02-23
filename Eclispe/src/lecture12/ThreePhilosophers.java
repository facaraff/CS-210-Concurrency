package lecture12;


import lecture11.Fork;
import lecture11.Philosopher;

public class ThreePhilosophers {
	
    public static void main(String[] args) throws InterruptedException {
        
    	int numberOfPhil = 3;
        Philosopher[] philosophers = new Philosopher[numberOfPhil];
        Fork[] forkSet = new Fork[numberOfPhil];
        Thread[] threads = new Thread[numberOfPhil];
        
        for(int i = 0; i < numberOfPhil; i++){
            forkSet[i] = new Fork();
        }
        
        System.out.println("Simulation started!");
        for (int i = 0; i<numberOfPhil; i++){
            int leftForkInd = i;
            int rightForkInd = (i+1)%forkSet.length;
            
            // this if block is used to break the wait-for-cycle condition
            if (i%2 != 0){
                // flip the fork allocation
                leftForkInd = (i+1)%forkSet.length;
                rightForkInd = i;
            }//note that this solution can lead to starvation - fairness problem
            
            philosophers[i] = new Philosopher(Integer.toString(i),forkSet[leftForkInd],forkSet[rightForkInd]);
            threads[i] = new Thread(philosophers[i]);
            threads[i].start();
        }
        
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
