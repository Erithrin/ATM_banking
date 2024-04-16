package Start;

import Actions.CheckBalanceAction;
import Actions.DepositAction;
import Actions.WithdrawalAction;

import java.util.Scanner;

public class UserActivity {
    public static void chooseActions() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Bank of America!! Choose your options below\n\n");
        System.out.println("Choose 1 to WITHDRAW\n" +
                "Choose 2 for DEPOSIT\n" +
                "Choose 3 for CHECKING BALANCE\n" +
                "Choose 4 to EXIT");


        System.out.println("Enter your option : ");
        try {
            int optionChosen = scan.nextInt();
            performAction(optionChosen);

        } catch (Exception e) {
            System.out.println("OOPS! Something went wrong. Please try again with correct option");
            chooseActions();
        }


    }

    private static void performAction(int optionChosen) {
        switch (optionChosen) {

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
