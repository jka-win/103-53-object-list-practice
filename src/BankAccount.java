import java.math.BigDecimal;
import java.util.Scanner;

public class BankAccount {
  private static int nextAccountNumber = 0;
  private static Scanner scanner = new Scanner(System.in);

  private int accountNumber;
  private String name;
  private BigDecimal balance;

  public BankAccount(int accountNumber, String name, BigDecimal balance) {
    if (accountNumber >= nextAccountNumber) {
      nextAccountNumber = accountNumber + 1;
    }

    this.accountNumber = accountNumber;
    this.name = name;
    this.balance = balance;
  }

  public BankAccount(int accountNumber, String name, double balance) {
    this(accountNumber, name, BigDecimal.valueOf(balance));
  }

  public BankAccount() {
    System.out.println("Let's make a new account!");
    System.out.print("Name: ");
    name = scanner.nextLine();
    System.out.print("Balance: $");
    balance = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
    accountNumber = nextAccountNumber++;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public BigDecimal deposit(BigDecimal amount) {
    balance = balance.add(amount);
    return balance;
  }

  public BigDecimal deposit(double amount) {
    return deposit(BigDecimal.valueOf(amount));
  }

  public BigDecimal withdrawal(BigDecimal amount) {
    balance = balance.subtract(amount);
    return balance;
  }

  public BigDecimal withdrawal(double amount) {
    return withdrawal(BigDecimal.valueOf(amount));
  }

  public BigDecimal transfer(BankAccount target, BigDecimal amount) {
    withdrawal(amount);
    target.deposit(amount);
    return balance;
  }

  public BigDecimal transfer(BankAccount target, double amount) {
    return transfer(target, BigDecimal.valueOf(amount));
  }

  @Override
  public String toString() {
    return "%s's account balance: $%.2f"
        .formatted(name, balance);
  }
}
