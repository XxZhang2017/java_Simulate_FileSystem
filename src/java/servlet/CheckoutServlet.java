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
 //          Cart carto;
           CusInfo cusIo;
           OrderInfo ordero;
           
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
//customInfo obj; setAttri;
            cusIo=new CusInfo(email,Integer.parseInt(cus));
            mySession.setAttribute("cusIo", cusIo);
        
            if(shopping!=null){
             for(ShopInfo mysh:shopping.values()){
                 total+=mysh.getTotal();
             }
         }         
            ordero=new OrderInfo(order,Integer.parseInt(card),Integer.parseInt(cus),Double.toString(total));
            mySession.setAttribute("ordero", ordero);
            
            query="INSERT INTO orderinfo(order_num,card_num,cus_num,T_price)"
                    +"VALUES ('"+order+"', "
                           +"'"+Integer.parseInt(card)+"', "
                           +"'"+Integer.parseInt(cus)+"', "
                           +"'"+Double.toString(total)+"') ";
        
             st.executeUpdate(query); 
             
             String preparedQuery ="INSERT INTO cart (o_ID,product_Name,number,sum_price)"
                   +"VALUES "+"(?, ?, ?, ?)";
             PreparedStatement ps = con.prepareStatement(preparedQuery);
   try{                   
           if(shopping!=null){
           for(ShopInfo mysh:shopping.values()){
                 
            ps.setInt(1,order);
            ps.setString(2, mysh.getProduct() );
            ps.setString(3,Integer.toString(mysh.getQuantity()));
            ps.setString(4, Double.toString(mysh.getTotal()));
            ps.executeUpdate();
             }
             ps.close();
                      }
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
       mySession.removeAttribute("Usershopping");
         String url="/successful.jsp";
           RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
         dispatcher.forward(request, response);
        
         }
    
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
