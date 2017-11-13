<%-- 
    Document   : sucessful
    Created on : Nov 1, 2017, 2:53:05 PM
    Author     : d
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>order successful</title>
    </head>
    <body>
        <h1>Order successful</h1>
        <div>your order number is ${ordero.orId}</div>       
        <div>payment method is ${ordero.carNum}</div>
        <form action="yourOrder" type="text" name="userCard" >
        </form>
    </body>
</html>
