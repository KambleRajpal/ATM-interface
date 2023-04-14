import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        double balance = 1000.0;
        boolean quit = false;

        while (!quit) {
            System.out.println("Welcome to the ATM. Please select an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer");
            System.out.println("4. Quit");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume the new line character

            switch (option) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume the new line character

                    if (withdrawAmount > balance) {
                        System.out.println("Insufficient funds. Please try again.");
                        break;
                    }

                    balance -= withdrawAmount;
                    String withdrawTransaction = String.format("Withdraw: %.2f", withdrawAmount);
                    transactionHistory.add(withdrawTransaction);

                    System.out.printf("Successfully withdrew %.2f. Your new balance is %.2f.\n", withdrawAmount, balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume the new line character

                    balance += depositAmount;
                    String depositTransaction = String.format("Deposit: %.2f", depositAmount);
                    transactionHistory.add(depositTransaction);

                    System.out.printf("Successfully deposited %.2f. Your new balance is %.2f.\n", depositAmount, balance);
                    break;

                case 3:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume the new line character

                    if (transferAmount > balance) {
                        System.out.println("Insufficient funds. Please try again.");
                        break;
                    }

                    System.out.print("Enter account number to transfer to: ");
                    String recipientAccount = scanner.nextLine();

                    balance -= transferAmount;
                    String transferTransaction = String.format("Transfer: %.2f to %s", transferAmount, recipientAccount);
                    transactionHistory.add(transferTransaction);

                    System.out.printf("Successfully transferred %.2f to %s. Your new balance is %.2f.\n", transferAmount, recipientAccount, balance);
                    break;

                case 4:
                    quit = true;
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
            System.out.println();
        }
    }
}
