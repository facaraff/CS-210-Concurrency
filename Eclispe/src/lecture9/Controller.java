package lecture9;


public class Controller {
    int spacesLeft;
    int capacity;
    
    public int getSpaces() {
        return spacesLeft;
    }
    public int getCapacity() {
        return capacity;
    }
    public void increment() {this.spacesLeft++;}
    public void decrement() {this.spacesLeft--;}
    
    public Controller (int n){
        capacity = spacesLeft = n;
    }

    public synchronized void enter()
        throws InterruptedException {
        while (spacesLeft == 0){
            wait();
        }
        spacesLeft--;
        notifyAll();
    }

    public synchronized void leave()
        throws InterruptedException {
        while (spacesLeft == capacity){
            wait();
        }
        spacesLeft++;
        notifyAll();
    }
}
