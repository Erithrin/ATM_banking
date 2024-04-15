package Actions;

import dao.CheckBalanceDAOImpl;
import dao.DepositMoneyDAOImpl;

import java.util.Scanner;

public class DepositAction {

    public static void depositMoneyAttempt() {

        System.out.println("How much $$ do you want to deposit?");

        Scanner scan = new Scanner(System.in);
        float amountToBeDeposited = scan.nextFloat();
        deposit(amountToBeDeposited);



    }

    private static void deposit(float amountToBeDeposited) {

        CheckBalanceDAOImpl checkBalance = new CheckBalanceDAOImpl();
        float currentBalance = checkBalance.getBalance();

        DepositMoneyDAOImpl deposit = new DepositMoneyDAOImpl();
        deposit.depositCash(amountToBeDeposited, currentBalance);


        System.out.println("The amount deposited is : " + amountToBeDeposited +
                "\nYour old balance was : " + currentBalance +
                "\nYour new balance is " + checkBalance.getBalance());


    }
}
