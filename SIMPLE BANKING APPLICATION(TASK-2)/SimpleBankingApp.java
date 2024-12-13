package javaProjects;

import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

public class SimpleBankingApp {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Simple Banking Application ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using the banking application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolderName = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();
        sc.nextLine(); 

        Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    private static void depositMoney() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            sc.nextLine(); 
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            sc.nextLine(); 
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Current Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
