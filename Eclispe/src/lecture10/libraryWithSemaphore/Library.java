package lecture10.libraryWithSemaphore;



import java.util.concurrent.Semaphore;

public class Library{
    static final int MAX_AVAIALABLE = 2;
    private boolean[] booksInUse = new boolean[MAX_AVAIALABLE];
    private Semaphore semaphore = new Semaphore(MAX_AVAIALABLE);
    public void borrowBook(String name) throws InterruptedException{
        System.out.println(name + " is waiting!");
        semaphore.acquire();
        System.out.println(name + " is trying to get a book!");
        takeFirstAvaialbleBook();
    }
    private synchronized void takeFirstAvaialbleBook() {
        for(int i=0; i<MAX_AVAIALABLE; i++)
            if (booksInUse[i] == false){
                booksInUse[i] = true;
                break;
            }
    }
    public void returnBook(String name) throws InterruptedException{
        System.out.println(name + " is trying to return a book!");
        returnFirstAvailableSlot();
        semaphore.release();
    }
    private synchronized void returnFirstAvailableSlot() {
        for(int i=0; i<MAX_AVAIALABLE; i++)
            if (booksInUse[i] == true){
                booksInUse[i] = false;
                break;
            }
    }
}
