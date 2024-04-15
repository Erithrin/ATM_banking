package Actions;

import dao.CheckBalanceDAOImpl;
import dao.WithdrawCashDAOImpl;

import java.util.Scanner;

public class WithdrawalAction {
    public static void WithdrawalAttempt() {

        System.out.print("Enter the amount you want to withdraw   :   ");
        Scanner scan = new Scanner(System.in);

        float amountToWithdraw = scan.nextFloat();

        withdrawMoney(amountToWithdraw);
    }

    private static void withdrawMoney(float amountToWithdraw) {

        CheckBalanceDAOImpl checkBalance = new CheckBalanceDAOImpl();
        float balance = checkBalance.getBalance();
        if (Float.compare(balance, amountToWithdraw) >= 0) {
            WithdrawCashDAOImpl withdrawCashDAOImplObj = new WithdrawCashDAOImpl();
            System.out.println("update floating point numbers to Bigdecimal for precision in entire project");

            //update floating point numbers to Bigdecimal for precision in entire project


            withdrawCashDAOImplObj.UpdateBalanceForWithdrawal(balance - amountToWithdraw);


            System.out.println("Your old balance was : " + balance +
                    "\nYour new balance is : " + checkBalance.getBalance() +
                    "\nAmount withdrawn successfully : " + amountToWithdraw
            );


        } else {
            System.out.println("You do not have enough balance to withdraw.");
            System.exit(0);

        }

    }
}
