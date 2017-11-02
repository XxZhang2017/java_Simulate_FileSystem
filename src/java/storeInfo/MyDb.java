/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeInfo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author d
 */
public class MyDb {
 Connection con;

    public Connection getCon() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
   //     Class.forName("com.mysql.jdbc.Driver").newInstance();
       con= DriverManager.getConnection("jdbc:mysql://localhost/test?"+"user=root&password= ");
        return con;
    }
 
}
