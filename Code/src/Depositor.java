public class Depositor implements Runnable {
    private Customer customer;
    private BankAccount account;
    private double amount;
    @Override
    public void run() {
        account.deposit(amount);
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }




}
