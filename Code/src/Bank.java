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
}