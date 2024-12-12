<%@ page language="java"  contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.consultaprodutos.Produtos" %>
<!DOCTYPE html>

<jsp:useBean id="Produto" class="com.mycompany.consultaprodutos.Produtos" scope="session">
    
    
            
    
        
<html>
        
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    </head>
    <body>
        <h2>Entre com o códgo ou EAN13 do produto...</h2>
        <form action="index.jsp" method="GET">
        <input type="text" id="codigo" name="codigo" /><!-- comment -->
        <button type="button" id="enviar" name="enviar" onclick="submit">OK</button>
        </form>
        
 
 <% 
     String codigo= (String) request.getParameter("codigo");
     
     Produtos produto = (Produtos) session.getAttribute("codigo");
     if (produto==null) 
             produto = new Produtos(); 
 
    
    
        if (codigo!=null){
            out.print("Há codigo");
        }
        else{
            out.print("Sem nada");

     }
out.print(codigo);
 %>   
    
        
        
    
    </body>
 <%
 session.setAttribute("codigo", codigo);
 %>
</jsp:useBean>
    
</html>
