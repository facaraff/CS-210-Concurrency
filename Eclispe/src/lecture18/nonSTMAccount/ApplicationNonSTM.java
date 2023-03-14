package lecture18.nonSTMAccount;

public class ApplicationNonSTM {
    public static void main(String[] args) throws InterruptedException {
        AccountNonSTM[] accounts = new AccountNonSTM[3];
        accounts[0] = new AccountNonSTM(100);
        accounts[1] = new AccountNonSTM(100);
        accounts[2] = new AccountNonSTM(100);
        Thread t1 = new Thread(new TransactionsNonSTM(accounts));
        Thread t2 = new Thread(new TransactionsNonSTM(accounts));
        Thread t3 = new Thread(new TransactionsNonSTM(accounts));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("I am done!");
        System.out.println(accounts[0].getBalance());
        System.out.println(accounts[1].getBalance());
        System.out.println(accounts[2].getBalance());
    }
}
