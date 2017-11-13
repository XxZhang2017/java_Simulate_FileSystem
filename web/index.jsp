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
                out.println(  shop.getQuantity()+"     "+shop.getProduct()+"     "+shop.getTotal());
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
       <td> orange<input type="hidden" name="pro" value="orange" form="or_" /></td>
       <td>1.3<input type="hidden" name="mon" value="1.3" form="or_" /></td>
  <td> 
       <select name="quanti" form="or_">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <input type="hidden" name="come" value="come" form="or_"/>
            </select>
  </td>
  <td><form action="shopInfo" method="GET" id="or_"><input type="submit" name="Add" value="Add To Cart" /></form></td>
   </tr>
   
      <tr>
       <td>Mango<input type="hidden" name="pro" value="mango" form="ma_" /></td>
       <td>2.5<input type="hidden" name="mon" value="2.5" form="ma_" /></td>
  <td> 
       <select name="quanti" form="ma_">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <input type="hidden" name="come" value="come" form="ma_"/>
            </select>
  </td>
  <td><form action="shopInfo" method="GET" id="ma_"><input type="submit" name="Add" value="Add To Cart" /></form></td>
   </tr>
   
      <tr>
       <td>Blueberry<input type="hidden" name="pro" value="blueberry" form="bl_" /></td>
       <td>4.5<input type="hidden" name="mon" value="4.5" form="bl_" /></td>
  <td> 
       <select name="quanti" form="bl_">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <input type="hidden" name="come" value="come" form="bl_"/>
            </select>
  </td>
  <td><form action="shopInfo" method="GET" id="bl_"><input type="submit" name="Add" value="Add To Cart" /></form></td>
   </tr>
   
      <tr>
       <td> peal<input type="hidden" name="pro" value="peal" form="el_" /></td>
       <td>2.6<input type="hidden" name="mon" value="2.6" form="el_" /></td>
  <td> 
       <select name="quanti" form="el_">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <input type="hidden" name="come" value="come" form="el_"/>
            </select>
  </td>
  <td><form action="shopInfo" method="GET" id="el_"><input type="submit" name="Add" value="Add To Cart" /></form></td>
   </tr>
   
     
   <tr>
       <td> Pineapple<input type="hidden" name="pro" value="pineapple" form="pine_" /></td>
       <td>4.2<input type="hidden" name="mon" value="4.2" form="pine_" /></td>
  <td> 
       <select name="quanti" form="pine_">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <input type="hidden" name="come" value="come" form="pine_"/>
            </select>
  </td>
  <td><form action="shopInfo" method="GET" id="pine_"><input type="submit" name="Add" value="Add To Cart" /></form></td>
   </tr>
   
      <tr>
       <td>Watermelon<input type="hidden" name="pro" value="watermelon" form="wa_" /></td>
       <td>5.6<input type="hidden" name="mon" value="5.6" form="wa_" /></td>
  <td> 
       <select name="quanti" form="wa_">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <input type="hidden" name="come" value="come" form="wa_"/>
            </select>
  </td>
  <td><form action="shopInfo" method="GET" id="wa_"><input type="submit" name="Add" value="Add To Cart" /></form></td>
   </tr>
   
      <tr>
       <td>Cherry<input type="hidden" name="pro" value="cherry" form="ch_" /></td>
       <td>3.2<input type="hidden" name="mon" value="3.2" form="ch_" /></td>
  <td> 
       <select name="quanti" form="ch_">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <input type="hidden" name="come" value="come" form="ch_"/>
            </select>
  </td>
  <td><form action="shopInfo" method="GET" id="ch_"><input type="submit" name="Add" value="Add To Cart" /></form></td>
   </tr>
   
   
 </table>
    
             
</body>
<%@include file="footer.html" %>

</html>