/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import storeInfo.*;

/**
 *
 * @author d
 */
public class InforServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
  //      try {
   String one=request.getParameter("pro");
            int quantity=Integer.parseInt(request.getParameter("quanti"));
           double pri=Double.parseDouble(request.getParameter("mon"));
            boolean addFlag=false;
           
            HttpSession session=request.getSession();
            HashMap<String,ShopInfo> shopping=(HashMap<String,ShopInfo>) session.getAttribute("Usershopping");
            
            if(shopping!=null){
                System.out.println("shopping is not null");
                  for(String name:shopping.keySet()){
                if(name.equals(one)){
                    shopping.get(one).increQuantity(quantity);
                    addFlag=true;
                }
            }
            if(!addFlag){
             shopping.put(one, new ShopInfo(one,quantity,pri));
             addFlag=false;
            }
            }else{
                System.out.println("shopping is null");
           shopping=new HashMap<String,ShopInfo>();
            for(String name:shopping.keySet()){
                if(name.equals(one)){
                    shopping.get(one).increQuantity(quantity);
                    addFlag=true;
                }
            }
            if(!addFlag){
             shopping.put(one, new ShopInfo(one,quantity,pri));
             addFlag=false;
            }
        }
    
            session.setAttribute("Usershopping", shopping);
            Cookie coming=new Cookie("come","come");
            coming.setMaxAge(60*60*24);
            response.addCookie(coming);
           
 
            
   //         System.out.println("forwatd");
            //to DB
     /*       MyDb db=new MyDb();
            Connection con=db.getCon();
         Statement stmt=con.createStatement();
         for(ShopInfo shop:shopping){
              stmt.executeUpdate("insert into CART (product_Name,number,sum_price) values"
                 + " ("+shop.getProduct()+","+shop.getQuantity()+","+shop.getPrice()+")");
                 }
         PrintWriter out=response.getWriter();
         out.println("insert seccessfully");
            System.out.println("sucessfully");
           }   catch (SQLException ex) {
            Logger.getLogger(InforServlet.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InforServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(InforServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InforServlet.class.getName()).log(Level.SEVERE, null, ex);
        }*/ 
       String url="/cartView.jsp";
            
           RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }
        
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }
}
