package lecture10;

public class Library{
	
    static final int MAX_AVAIALABLE = 2;
    private boolean[] booksInUse = new boolean[MAX_AVAIALABLE];
    
    public synchronized void borrowBook(String name) throws InterruptedException{
        System.out.println(name + " is waiting!");
        while(areAllTrue()){//are all the books being taken?
            wait();//if so, then wait!
        }//if not, take the book and release to lock! (notify the waiting threads)
        System.out.println(name + " is trying to get a book!");
        takeFirstAvaialbleBook();
        notifyAll();
    }
    private boolean areAllTrue(){// no need to synchronise this -> it's only called from a synchronised method!
        for(boolean b : booksInUse) if(!b) return false;
        return true;
    }
    private void takeFirstAvaialbleBook() {
        for(int i=0; i<MAX_AVAIALABLE; i++)
            if (booksInUse[i] == false){
                booksInUse[i] = true;
                break;
            }
    }
    public synchronized void returnBook(String name)
            throws InterruptedException{
        System.out.println(name + " is trying to return a book!");
        returnFirstAvailableSlot();
        notifyAll();
    }
    private void returnFirstAvailableSlot() {
        for(int i=0; i<MAX_AVAIALABLE; i++)
            if (booksInUse[i] == true){
                booksInUse[i] = false;
                break;
            }
    }
}
