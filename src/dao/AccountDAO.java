package dao;

import bean.AccountDetail;

public interface AccountDAO {

    AccountDetail getAccountDetails(long accountNumber);
}
