package dao;

import DBUtility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WithdrawCashDAOImpl implements WithdrawCashDAO {


    @Override
    public void UpdateBalanceForWithdrawal(float newBalance) {

        try (Connection conn = DBUtil.provideConnection()) {


            PreparedStatement ps = conn.prepareStatement("update bank_balance set balance = ?");

            ps.setFloat(1, newBalance);

            ps.executeUpdate();

            ps.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

}

