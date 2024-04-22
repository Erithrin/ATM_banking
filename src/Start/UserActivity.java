package Start;

import Actions.CheckBalanceAction;
import Actions.DepositAction;
import Actions.WithdrawalAction;
import bean.AccountDetail;
import dao.AccountDAO;
import dao.AccountDAOImpl;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Optional;
import java.util.Scanner;


public class UserActivity {
    public static void chooseActions() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Bank of America!! Choose your options below\n\n");


        //customising to include account validation
        System.out.println("Let's verify your account!");
        System.out.println("Enter your account number : ");
        long account_number = scan.nextInt();

        AccountDetail account = account_validation(account_number);

        //password validation
        System.out.println("Enter your password");
        String input_password = scan.nextLine();

        password_validation(input_password, account);


        System.out.println("Choose 1 to WITHDRAW\n" +
                "Choose 2 for DEPOSIT\n" +
                "Choose 3 for CHECKING BALANCE\n" +
                "Choose 4 to EXIT");


        System.out.println("Enter your option : ");
        try {
            int optionChosen = scan.nextInt();
            performAction(optionChosen);
            //chooseActions();

        } catch (Exception e) {
            System.out.println("OOPS! Something went wrong. Please try again with correct option");
            chooseActions();
        }


    }

    private static void password_validation(String enteredPassword, AccountDetail account) {
        validatePassword(enteredPassword, account.getPassword(), account.getSalt());

    }

    private static String hashPassword(String password, String salt) {

        return DigestUtils.sha256Hex(password + salt);
    }

    private static boolean validatePassword(String enteredPassword, String storedHash, String salt) {
        String computedHash = hashPassword(enteredPassword, salt);
        return computedHash.equals(storedHash);
    }


    private static AccountDetail account_validation(long account_number) {
        System.out.println("validating your account here!!");
        //fetching account details from the DB
        AccountDAO accDao = new AccountDAOImpl();
        AccountDetail acc = accDao.getAccountDetails(account_number);
        Optional<AccountDetail> optionalAccount = Optional.ofNullable(acc);
        if (optionalAccount.isPresent()) {
            System.out.println("account exists");
        } else {
            System.out.println("Account does not exist");

        }
        return acc;
        //get account object along wiht pasword
        //make user enter password
        //hashing


        //account length  = 5
        //account exists?
        //what if account does not exist?
        //wrong input?
        //account details - customer fname, lname, address, phone number


    }

    private static void performAction(int optionChosen) {
        switch (optionChosen) {

            //account validation using account number and PIN
            //transfer(): This method will allow users to transfer money between accounts.
            //https://www.math-cs.gordon.edu/local/courses/cs320/ATM_Example/Code.html
            case 1:
                WithdrawalAction.WithdrawalAttempt();
                break;

            case 2:
                DepositAction.depositMoneyAttempt();
                break;

            case 3:
                CheckBalanceAction.displayBalance();
                break;

            case 4:
                System.out.println("Thank you for choosing our services");
                System.exit(0);

            default:
                System.out.println("Um, I don't seem to understand your option. Please try again");
                chooseActions();

        }
    }
}
