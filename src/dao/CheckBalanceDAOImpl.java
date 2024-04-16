package dao;

import DBUtility.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckBalanceDAOImpl implements CheckBalanceDAO {
    public BigDecimal getBalance() {

        BigDecimal balance = BigDecimal.ZERO;
        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select balance from bank_balance");

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                balance = rs.getBigDecimal("balance");
            }
            return balance;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;

    }
}
