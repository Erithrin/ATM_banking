package dao;

import DBUtility.DBUtil;
import bean.AccountDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {

    public AccountDetail getAccountDetails(long accountNumber) {


        String hashed_pass = "";
        String salt = "";

        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from from account_details where account_number = ?");
            ps.setLong(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                hashed_pass = rs.getString("password");
                salt = rs.getString("salt");
            }


            return new AccountDetail(accountNumber, hashed_pass, salt);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
