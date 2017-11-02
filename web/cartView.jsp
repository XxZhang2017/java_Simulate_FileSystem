<%-- 
    Document   : cartView
    Created on : Oct 17, 2017, 11:48:58 PM
    Author     : d
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="storeInfo.ShopInfo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your cart</title>
    </head>
    <body>
  
               <%
                  // if(session.getAttribute("Usershopping")==null){
                   
                  // }
             HashMap<String,ShopInfo> shopping=(HashMap<String,ShopInfo>)session.getAttribute("Usershopping");
            for(ShopInfo shop:shopping.values()){
                
           
            %>
          <table border="1">
              <tr>
                  <th>The product</th>
                  <th>The number</th>
                  <th>The price</th>
              </tr>
             
    
                     
                     <tr>
 
            </tr>
            
            <tr>
            <th><%= shop.getProduct()   %></th>
            <th><%= shop.getQuantity()   %></th>
            <th><%= shop.gettotal()   %></th>
            <th><for</th>
            <%  }  %>
            </tr>
            
    
        </table>
            <form action="index.jsp"><input type="submit" value="Go back" />
            </form>
            <form action="checking.jsp"><input type="submit" value="Place Order" />
            </form>
    </body>
</html>
