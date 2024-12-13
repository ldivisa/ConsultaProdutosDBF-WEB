<%@ page language="java"  contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.consultaprodutos.Produtos" %>

<% 
     String codigo= (String) request.getParameter("codigoProduto");
     out.print(codigo);
     Produtos produto = (Produtos) session.getAttribute("produtos");
     if (produto==null) 
             produto = new Produtos(); 
 
     if (codigo!=null){
            out.print("Há codigo");
        }
        else{
            out.print("Sem nada");

     }
out.print("\nCódigo->"+codigo);
 %> 