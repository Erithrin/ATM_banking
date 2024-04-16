package dao;

import DBUtility.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepositMoneyDAOImpl implements DepositMoneyDAO {

    @Override
    public void depositCash(BigDecimal amountToBeDeposited, BigDecimal currentBalance) {


        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("Update bank_balance set balance = ?");
            ps.setBigDecimal(1, amountToBeDeposited.add(currentBalance));

            ps.executeUpdate();

            ps.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
