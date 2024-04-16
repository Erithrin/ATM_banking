package dao;

import java.math.BigDecimal;

public interface DepositMoneyDAO {


    void depositCash(BigDecimal amountToBeDeposited, BigDecimal currentBalance) ;
}
