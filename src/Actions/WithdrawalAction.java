package Actions;

import dao.CheckBalanceDAOImpl;
import dao.WithdrawCashDAOImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class WithdrawalAction {
    public static void WithdrawalAttempt() {

        System.out.print("Enter the amount you want to withdraw   :   ");
        Scanner scan = new Scanner(System.in);

        BigDecimal amountToWithdraw = scan.nextBigDecimal();

        withdrawMoney(amountToWithdraw);
    }

    private static void withdrawMoney(BigDecimal amountToWithdraw) {

        CheckBalanceDAOImpl checkBalance = new CheckBalanceDAOImpl();
        BigDecimal balance = checkBalance.getBalance();
        if (balance.compareTo(amountToWithdraw) >= 0) {
            WithdrawCashDAOImpl withdrawCashDAOImplObj = new WithdrawCashDAOImpl();

            //update floating point numbers to Bigdecimal for precision in entire project


            withdrawCashDAOImplObj.UpdateBalanceForWithdrawal(balance.subtract(amountToWithdraw));


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
