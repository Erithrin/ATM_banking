package dao;

import DBUtility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepositMoneyDAOImpl implements DepositMoneyDAO {

    @Override
    public void depositCash(float amountToBeDeposited, float currentBalance) {


        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("Update bank_balance set balance = ?");
            ps.setFloat(1, Float.sum(amountToBeDeposited, currentBalance));

            ps.executeUpdate();

            ps.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
