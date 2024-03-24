import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        try (Scanner scanner = new Scanner(System.in)) { // Scanner closed automatically

            while (true) {
                // Prompt for and read account number (once per loop iteration)
                System.out.print("Enter account number: ");
                int accountNumber = scanner.nextInt();

                // Display Menu
                System.out.println("\nMenu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. View account balance");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt(); // Read choice within the loop

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        executor.submit(() -> {
                            bank.deposit(accountNumber, depositAmount);
                            System.out.println("Deposit successful!");
                        });
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        executor.submit(() -> {
                            bank.withdraw(accountNumber, withdrawalAmount);
                            System.out.println("Withdrawal successful!");
                        });
                        break;
                    case 3:
                        // Use the previously captured account number
                        executor.submit(() -> {
                            double balance = bank.getBalance(accountNumber);
                            System.out.println("Your current balance: " + balance);
                        });
                        break;
                    case 4: // Exit option
                        System.out.println("Exiting application...");
                        executor.shutdown(); // Properly terminate the executor
                        return; // Exit the main method
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }

                // **Display menu and prompt for exit after each case**
                System.out.println("\nDo you want to exit? (y/n)");
                String exitChoice = scanner.next();

                if (exitChoice.equalsIgnoreCase("y")) {
                    break; // Exit the loop if user chooses 'y'
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // Handle potential exceptions during Scanner usage
        }

        System.out.println("Exited successfully."); // Optional message upon exiting
    }
}
