package dao;

import DBUtility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckBalanceDAOImpl implements CheckBalanceDAO {
    public float getBalance() {

        float balance = 0;
        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select balance from bank_balance");

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                balance = rs.getFloat("balance");
            }
            return balance;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;

    }
}
