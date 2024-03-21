public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create accounts
        bank.addAccount(new BankAccount(12345, "John Doe"));
        bank.addAccount(new BankAccount(54321, "Jane Smith"));

        // Create and start client threads
        Thread client1 = new Thread(new Client(bank, 12345));
        Thread client2 = new Thread(new Client(bank, 54321));
        Thread client3 = new Thread(new Client(bank, 98765)); // Invalid account

        client1.start();
        client2.start();
        client3.start();
    }
}