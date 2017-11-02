<%-- 
    Document   : cookie
    Created on : Oct 24, 2017, 9:01:45 AM
    Author     : d
--%>

<%@page import="java.util.HashMap"%>
<%@page import="storeInfo.ShopInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>checking out </title>
    </head>
    <body>
           <%
                  // if(session.getAttribute("Usershopping")==null){
                   
                  // }
             HashMap<String,ShopInfo> shopping=(HashMap<String,ShopInfo>)session.getAttribute("Usershopping");
          //debug
      //    shopping=new HashMap<String,ShopInfo>();
       //   shopping.put("apple", new ShopInfo("apple",12,0.88));
             if(shopping!=null){
             for(ShopInfo shop:shopping.values()){
                
           
            %>
            <h1>Your order shows as follow</h1>
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
             </tr>
              </table>
            <%  } }else{
          out.println("<h1>You have empty cart</h1>");
             } %>
           
            
            <form action="checkout">
                <label>credit card</label>
                </br>
                <input typy="number" name="card" />
                </br>
                <label>e-mail</label>
                </br>
                <input type="e-mail" name="email"  />
            <input type="submit" value="submit" />
        </form>
    </body>
</html>
