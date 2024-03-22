import java.util.Map;
import java.util.HashMap;
public class Bank {

    private Map<Integer, BankAccount> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public synchronized void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public synchronized BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean deposit(int accountNumber, double amount) {
        boolean depositSuccessful = false; // Initialize to false
        if (depositSuccessful) {
            return true; // Deposit successful
          } else {
            return false; // Deposit failed
          }
      }

      public boolean withdraw(int accountNumber, double amount) {
        // Implement the logic for withdrawing the amount from the specified account
        // For example, you might fetch the account, check if there are sufficient funds,
        // deduct the amount from the balance, and return true if successful.
        // ...
      }
      

}