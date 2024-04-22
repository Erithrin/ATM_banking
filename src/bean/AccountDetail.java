package bean;

public class AccountDetail {

    private long account_number;
    private String password;
    private String salt;

    public AccountDetail(long account_number) {
        this.account_number = account_number;
    }

    public AccountDetail(long account_number, String password, String salt) {
        this.account_number = account_number;
        this.password = password;
        this.salt = salt;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


}
