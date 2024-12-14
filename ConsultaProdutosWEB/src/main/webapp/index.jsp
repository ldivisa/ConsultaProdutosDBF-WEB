<%@page import="java.util.Arrays"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="com.mycompany.consultaprodutos.ConsultaProdutos"%>
<%@page import="com.mycompany.consultaprodutos.ProdutosComparatorCodigo"%>
<%@page import="com.mycompany.consultaprodutos.ProdutosComparatorDescricao"%>
<%@ page language="java"  contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="com.mycompany.consultaprodutos.Produtos" %>
<%@ page import="com.mycompany.consultaprodutos.ConsultaProdutos"%>
<!DOCTYPE html>

<jsp:useBean id="Produto" class="com.mycompany.consultaprodutos.Produtos" scope="session">
</jsp:useBean>     
<html>
        
    <head>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <title>Consulta a preços</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    </head>
    <body>
        <h2>Entre com o código ou EAN13 do produto...</h2>
        <form  action="index.jsp" method="post">
        <input type="text" name="codigoProduto" autofocus /><!-- comment -->
        
        <button>OK</button>
        <br><!-- comment -->
        
       
        </form>
        
<% 
     String codigo;
     codigo = request.getParameter("codigoProduto");
     
     Produtos produtos = (Produtos) session.getAttribute("produtos");
     if (produtos==null) 
            produtos = new Produtos(); 
     
     List<Produtos> listaProdutos;
     listaProdutos =(List<Produtos>) session.getAttribute("listaProdutos");     
     
        if (listaProdutos==null){
            ConsultaProdutos consulta = new ConsultaProdutos();
             listaProdutos = consulta.ConsultarProduto();
             session.setAttribute("listaProdutos", listaProdutos);
    }
     
     
     
if ((codigo!=null)&&(listaProdutos!=null)){
        if (codigo.matches("[0-9]+")){
            Collections.sort(listaProdutos,new ProdutosComparatorCodigo());}
            else{
            Collections.sort(listaProdutos,new ProdutosComparatorDescricao());
    }
        %>
        <table>
            <thead>
                <tr>
                    <td>Código</td>
                    <td>EAN13</td>
                    <td>Descritivo</td>
                    <td>Preço</td>
                    <td>Estoque</td>
                </tr>
            </thead>

        <%        
        
        for(int i=0;i<listaProdutos.size();i++){
        
        if ((listaProdutos.get(i).getCodigo().contains(codigo))||(listaProdutos.get(i).getNome().contains(codigo.toUpperCase()))||(listaProdutos.get(i).getEAN13().contains(codigo)))
        
        {
        out.print("<tr>");
            out.print("<td> "+listaProdutos.get(i).getCodigo()+"</td>");
            out.print("<td> "+listaProdutos.get(i).getEAN13()+"</td>");
            out.print("<td> "+listaProdutos.get(i).getNome()+"</td>");
            out.print("<td> "+NumberFormat.getCurrencyInstance().format(listaProdutos.get(i).getPreco())+"</td>");
            out.print("<td> "+NumberFormat.getNumberInstance().format(listaProdutos.get(i).getEstoque())+"</td>");
        out.print("</tr>");   
            }
                                                }
                }
    

 %> 
 
 
    
        
        
    
    </body>
 <%
 session.setAttribute("codigo", request.getParameter("codigoProduto"));
 session.setAttribute("listaProdutos", listaProdutos);
 %>

    
</html>
