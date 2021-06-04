package com.example.lighthouse_project1.clickhouseController;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deptDAO {

    private jdbcUtil jdbcUtil = new jdbcUtil();
    private PreparedStatement ps = null;
    public void add(int ID,String names,String location) throws ClassNotFoundException {
        String sql_insert = "insert into Dept (ID,Name,Location) values(?,?,?)";

        PreparedStatement ps ;
        ps = jdbcUtil.createPreparedStament(sql_insert);
        try {
            ps.setInt(1, ID);
            ps.setString(2, names);
            ps.setString(3, location);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

    }

}
