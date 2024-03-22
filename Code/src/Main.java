import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Bank bank = new Bank();
    Scanner scanner = new Scanner(System.in);

    // Get user input for account number
    System.out.print("Enter account number: ");
    int accountNumber = scanner.nextInt();

    // Transaction selection loop
    while (true) {
      System.out.println("\nMenu:");
      System.out.println("1. Deposit");
      System.out.println("2. Withdraw");
      System.out.println("3. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter deposit amount: ");
          double depositAmount = scanner.nextDouble();
          bank.deposit(accountNumber, depositAmount);
          System.out.println("Deposit successful!");
          break;
        case 2:
          System.out.print("Enter withdrawal amount: ");
          double withdrawalAmount = scanner.nextDouble();
          if (bank.withdraw(accountNumber, withdrawalAmount)) {
            System.out.println("Withdrawal successful!");
          } else {
            System.out.println("Insufficient funds or invalid amount.");
          }
          break;
        case 3:
          System.out.println("Exiting...");
          scanner.close(); // Close Scanner to avoid resource leaks
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }
}
