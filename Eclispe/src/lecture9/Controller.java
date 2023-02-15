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
    
    public Controller (int n){
        capacity = spacesLeft = n;
    }

    public synchronized void enter() throws InterruptedException {
        while (spacesLeft == 0){//wait for a space to become available
            wait();
        }
        spacesLeft--;
        notifyAll(); //without this, people in the queue will never be awaken to enter
    }

    public synchronized void leave() throws InterruptedException {
        while (spacesLeft == capacity){//wait for a car to get in the car park
            wait();
        }
        spacesLeft++;
        notifyAll();//alert thread in the queue that can now leave
    }
}
