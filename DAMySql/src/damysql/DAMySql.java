/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package damysql;

import java.sql.*;

/**
 *
 * @author ictrlab-admin
 */
public class DAMySql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String conStr = "jdbc:mysql://localhost:3306/productdb?user=root&password=";
        Connection con = DriverManager.getConnection(conStr);
        System.out.println("connection done");

        String stSel = "SELECT * FROM products ORDER BY prodname";

        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(stSel);

        rs.beforeFirst();
        while (rs.next()) {
            int prid = rs.getInt(1);
            String pname = rs.getString("prodname");
            double price = rs.getDouble(3);

            System.out.printf("%3d %-25s %10.2f\n", prid, pname, price);
        }
        // uncomment the code sections that you want to execute
//        /*
//        PreparedStatement psi;
//        String stIns = "INSERT INTO products(prodname, price) VALUES (?,?)";
//        psi = con.prepareStatement(stIns);
//        psi.setString(1, "new product");
//        psi.setDouble(2, 100.00);
//        psi.executeUpdate();
//
//        rs = stmt.executeQuery(stSel);
//        while (rs.next()) {
//            int prid = rs.getInt(1);
//            String pname = rs.getString(2);
//            double price = rs.getDouble("price");
//
//            System.out.printf("%3d %-25s %10.2f\n", prid, pname, price);
//        }
//        */
        /*
        rs.last();
        rs.deleteRow();
        rs.last();
        rs.deleteRow();
        rs = stmt.executeQuery(stSel);

        System.out.println("=========================================");
        rs.beforeFirst();

        while (rs.next()) {
            int prid = rs.getInt(1);
            String pname = rs.getString(2);
            double price = rs.getDouble("price");

            System.out.printf("%3d %-25s %10.2f\n", prid, pname, price);
        }
        */        
        /*
         rs.first();
         rs.updateString(2, "ballpen (pilot)");
         rs.updateRow();
         rs.absolute(6);
         double newpr = rs.getDouble(3) * 1.1;
         rs.updateDouble("price", newpr);
         rs.updateRow();

         PreparedStatement psu = 
         con.prepareStatement("UPDATE products SET price = 15 WHERE prodid = 2002");
         psu.executeUpdate();
         rs = stmt.executeQuery(stSel);
         System.out.println("=========================================");
         rs.beforeFirst();

         while (rs.next()) {
         int prid = rs.getInt(1);
         String pname = rs.getString(2);
         double price = rs.getDouble("price");

         System.out.printf("%3d %-25s %10.2f\n", prid, pname, price);
         }
        */        
        /*
         rs.moveToInsertRow();
         rs.updateString(2, "another product");
         rs.updateDouble(3, 555);
         rs.insertRow();

         rs = stmt.executeQuery(stSel);
         System.out.println("=========================================");
         rs.beforeFirst();

         while (rs.next()) {
            int prid = rs.getInt(1);
            String pname = rs.getString(2);
            double price = rs.getDouble("price");

            System.out.printf("%3d %-25s %10.2f\n", prid, pname, price);
         }
         */
        rs.close();

        con.close();
    }
}


