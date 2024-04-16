package dao;

import java.math.BigDecimal;

public interface WithdrawCashDAO {


    void UpdateBalanceForWithdrawal(BigDecimal amountToWithdraw) ;
}
