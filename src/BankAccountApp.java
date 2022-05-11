import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountApp {
  public static void main(String[] args) {
    var accounts = new ArrayList<BankAccount>();
    accounts.add(new BankAccount(0, "Albert", 1000));
    accounts.add(new BankAccount(1, "Bruntilda", 2500));
    accounts.add(new BankAccount(2, "Capulet", 30003));

    System.out.println("Welcome to Cool Bank!");
    try (var scanner = new Scanner(System.in)) {
      BankAccount selected = selectAccount(scanner, accounts);
      System.out.println();
      if (selected != null) {
        mainMenu(scanner, accounts, selected);
      }
    }
    System.out.println("Goodbye!");
  }

  private static BankAccount selectAccount(Scanner scanner, ArrayList<BankAccount> accounts) {
    System.out.print("Are you an existing customer? (yes/no) ");
    String existing = scanner.nextLine().trim();
    if (existing.equalsIgnoreCase("yes")) {
      System.out.print("Account number: ");
      int accountNumber = Integer.parseInt(scanner.nextLine());
      BankAccount selected = findAccount(accounts, accountNumber);
      if (selected == null) {
        System.out.println("No such account found. This incident will be reported.");
      }
      return selected;
    } else {
      return new BankAccount();
    }
  }

  private static void mainMenu(Scanner scanner, ArrayList<BankAccount> accounts, BankAccount selected) {
    System.out.println("Hello %s!".formatted(selected.getName()));
    System.out.println();

    while (true) {
      System.out.println("-- Main Menu --");
      System.out.println("1: Check balance");
      System.out.println("2: Make withdrawal");
      System.out.println("3: Make deposit");
      System.out.println("4: Make transfer");
      System.out.println("0: Exit");
      System.out.print("> ");
      int choice = Integer.parseInt(scanner.nextLine());
      System.out.println();

      if (choice == 1) {
        checkBalance(selected);
      } else if (choice == 2) {
        makeWithdrawal(scanner, selected);
      } else if (choice == 3) {
        makeDeposit(scanner, selected);
      } else if (choice == 4) {
        makeTransfer(scanner, accounts, selected);
      } else {
        break;
      }
      System.out.println();
    }
  }

  private static void checkBalance(BankAccount selected) {
    System.out.println(selected);
  }

  private static void makeWithdrawal(Scanner scanner, BankAccount selected) {
    System.out.print("Withdraw amount: $");
    double amount = Double.parseDouble(scanner.nextLine());
    selected.withdrawal(amount);
    System.out.println(selected);
  }

  private static void makeDeposit(Scanner scanner, BankAccount selected) {
    System.out.print("Deposit amount: $");
    double amount = Double.parseDouble(scanner.nextLine());
    selected.deposit(amount);
    System.out.println(selected);
  }

  private static void makeTransfer(Scanner scanner, ArrayList<BankAccount> accounts, BankAccount selected) {
    System.out.print("Transfer to account number: ");
    int accountNumber = Integer.parseInt(scanner.nextLine());
    BankAccount target = findAccount(accounts, accountNumber);
    if (target == null) {
      System.out.println("No such account found.");
    } else {
      System.out.print("Transfer amount: $");
      double amount = Double.parseDouble(scanner.nextLine());
      selected.transfer(target, amount);
      System.out.println(selected);
      System.out.println(target);
    }
  }

  private static BankAccount findAccount(ArrayList<BankAccount> accounts, int accountNumber) {
    for (BankAccount account : accounts) {
      if (account.getAccountNumber() == accountNumber) {
        return account;
      }
    }
    return null;
  }
}
