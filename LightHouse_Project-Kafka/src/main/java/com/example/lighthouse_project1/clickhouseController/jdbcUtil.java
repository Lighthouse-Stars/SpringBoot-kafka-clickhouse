package com.example.lighthouse_project1.clickhouseController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcUtil {
    private Connection con = null;
    private PreparedStatement ps = null;

    public jdbcUtil() {
    }

    public Connection createCon() throws ClassNotFoundException {

        try {
            this.con = DriverManager.getConnection("jdbc:clickhouse://192.168.131.131:8123/test");
        } catch (SQLException var2) {
            var2.printStackTrace();
            System.out.println("连接失败！");
        }

        return this.con;
    }

    public PreparedStatement createPreparedStament(String sql) throws ClassNotFoundException {
        Connection con = this.createCon();

        try {
            this.ps = con.prepareStatement(sql);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return this.ps;
    }

    public void close() {
        if (this.ps != null) {
            try {
                this.ps.close();
            } catch (SQLException var3) {
                var3.printStackTrace();
            }
        }

        if (this.con != null) {
            try {
                this.con.close();
            } catch (SQLException var2) {
                var2.printStackTrace();
            }
        }

    }

    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException var3) {
                var3.printStackTrace();
            }
        }

        this.close();
    }

    static {
        try {
            Class.forName("ru.yandex.clickhouse.ClickHouseDriver");
        } catch (ClassNotFoundException var1) {
            var1.printStackTrace();
        }

        System.out.println("已经注册Driver接口");
    }
}
