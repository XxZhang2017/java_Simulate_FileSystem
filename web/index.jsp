<%-- 
    Document   : index
    Created on : Oct 14, 2017, 10:51:03 AM
    Author     : d
--%>

<%@page import="java.util.HashMap"%>
<%@include file="header.html" %>
<%@page import="java.util.ArrayList"%>
<%@page import="storeInfo.ShopInfo"%>
<%@page import="java.io.PrintWriter"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
    </head>
   
    <body>
       <%
            
      Cookie[] ck=request.getCookies();
              for(int i=0;i<ck.length;i++){
      if(ck[i].getName().equals("come")&&ck[i].getValue().equals("come")&&session.getAttribute("Usershopping")!=null){
           out.print("Your have :");
            HashMap<String,ShopInfo> shopping=(HashMap<String,ShopInfo>)session.getAttribute("Usershopping");
            for(ShopInfo shop:shopping.values()){
                out.println("<li>");
                out.println(  shop.getQuantity()+"     "+shop.getProduct());
                 out.println("</li>");
            }
      }
      out.print("</br>");
     }
        %>
   <table style="width:100%" border=1>
       <tr>
           <th>Produce Name</th>
           <th>Price</th>
           <th>Quantity</th>
           <th></th>
       </tr>
   <tr>
       <td> Apple<input type="hidden" name="pro" value="apple" form="ap_" /></td>
       <td>3.3<input type="hidden" name="mon" value="3.3" form="ap_" /></td>
  <td> 
       <select name="quanti" form="ap_">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <input type="hidden" name="come" value="come" form="ap_"/>
            </select>
  </td>
  <td><form action="shopInfo" method="GET" id="ap_"><input type="submit" name="Add" value="Add To Cart" /></form></td>
   <tr>
       <td>  Banana <input type="hidden" name="pro" value="banana" form="ba_" /></td>
  <td>0.89<input type="hidden" name="mon" value="0.89" form="ba_" /></td>
  <td>
      <select name="quanti" form="ba_">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <input type="hidden" name="come" value="come" form="ba_"/>
            </select>
  </td>
  <td><form action="shopInfo" method="GET" id="ba_"><input type="submit" name="Add" value="Add To Cart" /></form></td>
  </tr>
  <tr>
      <td></td>
      
      <td></td>
      <td></td>
      <td></td>
  </tr>
  
 </table>
    
             
</body>
<%@include file="footer.html" %>

</html>