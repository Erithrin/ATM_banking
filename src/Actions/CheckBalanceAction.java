package Actions;

import dao.CheckBalanceDAOImpl;

public class CheckBalanceAction {
    public static void displayBalance() {
        CheckBalanceDAOImpl checkBal = new CheckBalanceDAOImpl();
        float balance = checkBal.getBalance();
        System.out.println("My current balance is : " +balance);
    }
}
