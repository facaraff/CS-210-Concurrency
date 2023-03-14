package lecture18.nonSTMAccount;

public class TransactionsNonSTM implements Runnable{
    
	private AccountNonSTM[] accounts;
    
    public TransactionsNonSTM(AccountNonSTM[] accounts){
        this.accounts = accounts;
    }
    
    @Override
    public void run() {
        for(int i =0; i<10; i++) {
            accounts[0].transfer(accounts[1], 5);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            accounts[1].transfer(accounts[2], 5);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            accounts[2].transfer(accounts[0], 5);
        }
    }
}
