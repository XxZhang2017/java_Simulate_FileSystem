/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import storeInfo.Cart;
import storeInfo.CusInfo;
import storeInfo.MyDb;
import storeInfo.ShopInfo;
import java.lang.Object.*;
import storeInfo.OrderInfo;
import storeInfo.OrderReview;


/**
 *
 * @author d
 */
public class yourOrder extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String cardNumber=request.getParameter("userCard");
        Connection con;
        Statement st;
        OrderReview userOrder;
           HttpSession mySession=request.getSession();
       try{ 
         try{ 
             Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
           st=con.createStatement();
           String query="SELECT order_num, product_Name, number, sum_price, T_price" 
               +"FROM orderinfo join cart on order_num=o_ID "+               
                "WHERE card_num=?";
           PreparedStatement pre=con.prepareStatement(query);
           if(cardNumber!=null){
               pre.setInt(1, Integer.parseInt(cardNumber));
           }
          
           ResultSet rs=pre.executeQuery(query);
           if(rs.next()){
               userOrder=new OrderReview();
               rs.beforeFirst();
         while(rs.next()){
            
             Cart cart=new Cart();
             cart.setOrderNum(rs.getInt(1));
             cart.setPro_Name(rs.getString(2));
             cart.setNumber(rs.getInt(3));
             cart.setSum_price(rs.getDouble(4));
             userOrder.getCartItem().add(cart);
             userOrder.setSumUp(rs.getDouble(5));        
         }         
         mySession.setAttribute("userOrder", userOrder);
           }
           }catch(SQLException e){ }  
           
           }catch (ClassNotFoundException ex) {
                Logger.getLogger(yourOrder.class.getName()).log(Level.SEVERE, null, ex);
            }       
           String url="/ReadOrder.jsp";
           RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
         dispatcher.forward(request, response);
    }
}
