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

/**
 *
 * @author d
 */
public class CheckoutServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //deal with cart info o_ID  product_Name number sum_price
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    

 /*        String card=request.getParameter("card");
       String email=request.getParameter("email");
       Connection con;
     
       CusInfo cus=new CusInfo(email);
        try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                Statement st=con.createStatement();
                String query="INSRT INTO cusinfo (cus_ID, e_mail)"+
                             "VALUES ("+cus.getCusID()+", "+
                                     "'"+cus.getEmail()+"')";
                st.executeUpdate(query);
                con.close();
                
          
            
             }catch (SQLException ex) {
                Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }*/
       
         HttpSession mySession=request.getSession();
         HashMap<String,ShopInfo> shopping=(HashMap<String,ShopInfo>)mySession.getAttribute("Usershopping");
         if(shopping!=null){
 //custome infor obj
       String card=request.getParameter("card");
       String email=request.getParameter("email");
       Connection con;
     
       CusInfo cus=new CusInfo(email);
        try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                Statement st=con.createStatement();
                String query="INSERT INTO cusinfo (cus_ID, e_mail)"+
                             "VALUES ("+cus.getCusID()+", "+
                                     "'"+cus.getEmail()+"')";
                st.executeUpdate(query);
                 String pro;
           int num;
           double sum;
           int order=Cart.orderGen();
             for(ShopInfo mysh:shopping.values()){
                 pro=mysh.getProduct();
                 num=mysh.getQuantity();
                 sum=mysh.gettotal();
                     
            query="INSRT INTO cart (number,o_ID,product_Name,sum_price)"
                   +"VALUES ('"+num+"', "
                           +"'"+pro+"', "
                           +"'"+order+"', "
                           +"'"+sum+"') ";
                con.close();         
             }
             }catch (SQLException ex) {
                Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
       
 /*          Connection con;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test,","root","");
                Statement st=con.createStatement();
          
           String pro;
           int num;
           double sum;
           int order=Cart.orderGen();
             for(ShopInfo mysh:shopping.values()){
                 pro=mysh.getProduct();
                 num=mysh.getQuantity();
                 sum=mysh.gettotal();
                     
           String query="INSRT INTO cart (product_Name,num_instance,price)"
                   +"VALUES ('"+pro+"', "
                           +"'"+num+"', "
                           +"'"+sum+"') ";
        
           int rowCount=st.executeUpdate(query);
             }
             }catch (SQLException ex) {
                Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            //scope of session;
            //how to insert value;
*/
           String url="/successful.jsp";
            
           RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
       
           //scope of session;
           //how to insert value;
         }
         
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
  
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
