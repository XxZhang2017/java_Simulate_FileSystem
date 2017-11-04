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

        String card=request.getParameter("card");
       String email=request.getParameter("email");
         String pro;
           int num;
           double sum;
           double total=0.0;
           String query;
           int order=Cart.orderGen();
           
           String cus;
       Connection con;
        Statement st;
               HttpSession mySession=request.getSession();
         HashMap<String,ShopInfo> shopping=(HashMap<String,ShopInfo>)mySession.getAttribute("Usershopping");
//       CusInfo cus=new CusInfo(email);
        try {
             Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            st=con.createStatement();
                query="INSERT INTO cusinfo (e_mail)"+
                             "VALUES ("+"'"+email+"')";
                st.executeUpdate(query);
              
       ResultSet rs=st.executeQuery("SELECT cus_ID FROM cusinfo WHERE e_mail="+"'"+email+"'");
         if(rs.next()){
            cus=rs.getString(1);
         if(shopping!=null){
             for(ShopInfo mysh:shopping.values()){
                 total+=mysh.gettotal();
 //                System.out.println("_____________ "+mysh.gettotal());
             }
         }         
            query="INSERT INTO orderinfo(order_num,card_num,cus_num,T_price)"
                    +"VALUES ('"+order+"', "
                           +"'"+Integer.parseInt(card)+"', "
                           +"'"+Integer.parseInt(cus)+"', "
                           +"'"+total+"') ";
        
             st.executeUpdate(query); 
             
             String preparedQuery ="INSERT INTO cart (o_ID,product_Name,number,sum_price)"
                   +"VALUES "+"(?, ?, ?, ?)";
             PreparedStatement ps = con.prepareStatement(preparedQuery);
   try{                   if(shopping!=null){
             for(ShopInfo mysh:shopping.values()){
                 
            ps.setInt(1,order);
            ps.setString(2, mysh.getProduct() );
            ps.setString(3,Integer.toString(mysh.getQuantity()));
            ps.setString(4, Double.toString(mysh.gettotal()));
            ps.executeUpdate();
             }
             ps.close();
                      }

                     
/*            query="INSERT INTO cart (number,o_ID,product_Name,sum_price)"
                   +"VALUES ('"+num+"', "
                           +"'"+order+"', "
                           +"'"+pro+"', "
                           +"'"+sum+"') ";
            st.executeUpdate(query);*/               
             
         } catch (SQLException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         rs.close();
         st.close();
         con.close();
         }catch (SQLException ex) {
                Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }   
       
    /*     try{
           Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            st=con.createStatement();
         if(shopping!=null){
             for(ShopInfo mysh:shopping.values()){
                 pro=mysh.getProduct();
                 num=mysh.getQuantity();
                 sum=mysh.gettotal();
                     
            query="INSERT INTO cart (number,o_ID,product_Name,sum_price)"
                   +"VALUES ('"+num+"', "
                           +"'"+order+"', "
                           +"'"+pro+"', "
                           +"'"+sum+"') ";
            st.executeUpdate(query);               
             }
            
            st.close();
            con.close();
            String url="/successful.jsp";
           RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
         
         }else{
           
                     PrintWriter out=response.getWriter();
                     out.println("<h1>Fair to get shopping obj</h1>");
          st.close();
            con.close();           
         }              
         
        
           
            
 //          RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
 //           dispatcher.forward(request, response);
             }catch (SQLException ex) {
                Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }catch (ClassNotFoundException ex) {
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
        
  //       }
            PrintWriter out=response.getWriter();
                     out.println("<h1>Fair to get shopping obj</h1>");
        
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
