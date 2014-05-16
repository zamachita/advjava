/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author chaiwat
 */
public class JavaDerby {
    
    private Connection con;
    private Statement stmt;
    
    public void initConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con  = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;user=app;password=app");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void test() {
        try {
            String sql = "select * from CUSTOMER";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(":: " + rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        JavaDerby obj = new JavaDerby();
        obj.initConnection();
        obj.test();
    }
    
}
