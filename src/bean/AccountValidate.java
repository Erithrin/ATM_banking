package bean;

public class AccountValidate {

    private long accountNumber;
    private String password;

    public AccountValidate(long accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //Use a VARCHAR or CHAR data type to store the hashed password.
    //When a user logs in, hash the entered password and compare it with the stored hash.
    //If they match, grant access; otherwise, deny access.


}
