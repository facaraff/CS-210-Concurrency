/*
 * Author: Fabio Caraffini 
 * 
 * Just an example to show how code get simplified when re-implementing the Ornamental Garden problem, which 
 * we have addressed in Lecture 9, by using semaphores.
 * 
 * Note that this is a strange use of this tool, as we have one thread acquiring and one thread releasing.
 * I suggest using semaphores where the methods are coordinated in the same thread.
 * 
 * */
package lecture10.carparkWithSemaphore;

import lecture9.Controller;

import java.util.concurrent.Semaphore;

public class SemaController extends Controller{
	
    private final Semaphore semaphore;

    SemaController(int capacity){
        super(capacity);
        this.semaphore = new Semaphore(capacity);
    }
    
    public int getSpaces() {
    	return semaphore.availablePermits();
    }

    public void enter() throws InterruptedException {
    		   semaphore.acquire();
    }

    public void leave() throws InterruptedException {
        if(getSpaces()<getCapacity())
        	semaphore.release();
    }

}
