package Actions;

import dao.CheckBalanceDAOImpl;
import dao.DepositMoneyDAOImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositAction {

    public static void depositMoneyAttempt() {

        System.out.println("How much $$ do you want to deposit?");

        Scanner scan = new Scanner(System.in);
        BigDecimal amountToBeDeposited = scan.nextBigDecimal();
        deposit(amountToBeDeposited);



    }

    private static void deposit(BigDecimal amountToBeDeposited) {

        CheckBalanceDAOImpl checkBalance = new CheckBalanceDAOImpl();
        BigDecimal currentBalance = checkBalance.getBalance();

        DepositMoneyDAOImpl deposit = new DepositMoneyDAOImpl();
        deposit.depositCash(amountToBeDeposited, currentBalance);


        System.out.println("The amount deposited is : " + amountToBeDeposited +
                "\nYour old balance was : " + currentBalance +
                "\nYour new balance is " + checkBalance.getBalance());


    }
}
