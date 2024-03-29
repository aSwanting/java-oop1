package org.learning.javaBank;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    static BankAccount newAccount;
    static Scanner scan = new Scanner(System.in);

    public static void generateAccount() {
        System.out.println("Enter user name to create bank account");
        String userName = scan.nextLine();
        String accountNumber = String.format("%04d", new Random().nextInt(1000));
        newAccount = new BankAccount(accountNumber, userName, new BigDecimal("1000"));
    }

    public static void bankMenu() {
        System.out.println("Select from the following options");
        System.out.println("Type '1' to check your balance");
        System.out.println("Type '2' to make a deposit");
        System.out.println("Type '3' to make a withdrawal");
        System.out.println("Type '0' to exit");
        String userChoice = scan.nextLine();

        switch (userChoice) {
            case "1":
                newAccount.printDetails();
                break;
            case "2":
                newAccount.makeDeposit();
                break;
            case "3":
                newAccount.makeWithdrawal();
                break;
            case "0":
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Bad input, please try again");
                bankMenu();
        }
        menuContinue();
    }

    public static void menuContinue() {
        System.out.println("Would you like to perform another operation? (y/n)");
        String userChoice = scan.nextLine();
        if (Objects.equals(userChoice, "y")) bankMenu();
        if (Objects.equals(userChoice, "n")) System.out.println("Goodbye");

        switch (userChoice) {
            case "y":
                bankMenu();
                break;
            case "n":
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Bad input, please try again");
                bankMenu();
        }
    }


    public static void main(String[] args) {
        generateAccount();
        bankMenu();

    }


}
