package org.learning.javaBank;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private String userName;
    private BigDecimal balance;

    public BankAccount(String accountNumber, String userName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.balance = balance;
    }

    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("User Name: " + userName);
        System.out.println("Account Balance: " + formatPrice(balance));
    }

    public void makeDeposit() {
        System.out.println("Insert amount to deposit");
        Scanner scan = new Scanner(System.in);
        BigDecimal deposit = new BigDecimal(scan.nextLine());
        System.out.println("Amount deposited: " + formatPrice(deposit));
        balance = balance.add(deposit);
        System.out.println("New Balance: " + formatPrice(balance));
    }

    public void makeWithdrawal() {
        System.out.println("Insert amount to withdraw");
        Scanner scan = new Scanner(System.in);
        BigDecimal withdrawal = new BigDecimal(scan.nextLine());

        while (withdrawal.compareTo(balance) > 0) {
            System.out.println("Your withdrawal exceeds your available balance");
            withdrawal = new BigDecimal(scan.nextLine());
        }

        System.out.println("Amount withdrawn: " + formatPrice(withdrawal));
        balance = balance.subtract(withdrawal);
        System.out.println("New Balance: " + formatPrice(balance));
    }

    public String formatPrice(BigDecimal number) {
        return NumberFormat.getCurrencyInstance().format(number);
    }
}
