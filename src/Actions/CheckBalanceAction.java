package Actions;

import dao.CheckBalanceDAOImpl;

import java.math.BigDecimal;

public class CheckBalanceAction {
    public static void displayBalance() {
        CheckBalanceDAOImpl checkBal = new CheckBalanceDAOImpl();
        BigDecimal balance = checkBal.getBalance();
        System.out.println("My current balance is : " +balance);
    }
}
