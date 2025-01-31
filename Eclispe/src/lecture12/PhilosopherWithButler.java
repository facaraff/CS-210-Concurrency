package lecture12;

import java.util.concurrent.Semaphore;

import lecture11.Fork;

public class PhilosopherWithButler implements Runnable {
    private Fork leftFork;
    private Fork rightFork;
    private Semaphore butler;
    private String name;
    private double scaler = 1000;
    
    PhilosopherWithButler(String name, Fork left, Fork right, Semaphore butler){
        this.name = name;
        leftFork = left;
        rightFork = right;
        this.butler = butler;
    }
    
    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }
    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }
    public void sit() 
            throws InterruptedException{
        butler.acquire(); // acquire permit
        double random = Math.random();
        System.out.println(name + " is trying to sit down.");
        Thread.sleep((long) (random*scaler));
        System.out.println(name + " has sat down.");
    }
    private void eat() 
            throws InterruptedException {
        double random = Math.random();
        System.out.println(name + " is trying to eat.");
        Thread.sleep((long) (random*scaler));
        System.out.println(name + " has eaten.");
    }
    private void stand(){
        System.out.println(name + " has stood up.");
        butler.release(); // release permit
    }
    @Override
    public void run() {
        while(true){
            try {
                sit();
                leftFork.acquire();
                System.out.println(name + " has taken left fork.");
                rightFork.acquire();
                System.out.println(name + " has taken right fork.");
                eat();
                rightFork.release();
                System.out.println(name + " has released right fork.");
                leftFork.release();
                System.out.println(name + " has released left fork.");
                stand();
            } catch (InterruptedException ex) {
                System.out.println(name + " was interrupted!");
                break;
            }
        }
    }

    
}
