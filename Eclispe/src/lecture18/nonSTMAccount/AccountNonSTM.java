package lecture18.nonSTMAccount;

public class AccountNonSTM {
	
        private double balance;
        
        AccountNonSTM(double initBalance){
            balance = initBalance;
        }
        public double getBalance(){
            return balance;
        }
        public void addBalance(double amount){
            balance = balance + amount;
        }
        public void subtractBalance(double amount){
            balance = balance - amount;
        }
        public void transfer(AccountNonSTM to, double amount){
            subtractBalance(amount);
            to.addBalance(amount);
        }
    }

