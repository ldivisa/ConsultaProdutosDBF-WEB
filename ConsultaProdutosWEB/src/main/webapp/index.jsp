<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="org.ahocorasick.trie.Emit"%>
<%@page import="java.util.Collection"%>
<%@page import="org.ahocorasick.trie.Trie"%>
<%@page import="com.mycompany.consultaprodutos.ProdutosComparatorMb"%>
<%@page import="com.mycompany.consultaprodutos.ProdutosComparatorEstoque"%>
<%@page import="com.mycompany.consultaprodutos.ProdutosComparatorEan13"%>
<%@page import="com.mycompany.consultaprodutos.ProdutosComparatorPreco"%>
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

<jsp:useBean id="Produto" class="com.mycompany.consultaprodutos.Produtos" scope="session" />

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <title>Consulta a preços</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h4>1)Digite o código do produto que deseja pesquisar ou scaneie o EAN13 da etiqueta do produto.</h4>
        <h5>2)Aperte "ENTER" no teclado ou clique no botão "OK".
        <form  action="index.jsp" method="post">
        <input type="text" name="codigoProduto" autofocus /><!-- comment -->
        <button>OK</button>
        <br><!-- comment -->
        </form>
     <%
     String codigo;
     codigo = request.getParameter("codigoProduto");
     Produtos produtos =null;
     produtos=(Produtos) session.getAttribute("produtos");
     if (produtos==null) 
            produtos = new Produtos(); 
     List<Produtos> listaProdutos;
     ConsultaProdutos consulta = new ConsultaProdutos();
     listaProdutos = consulta.ConsultarProduto();
    String ordenacao= request.getParameter("ordenacao");
    if ((codigo!=null)&&(listaProdutos!=null)){
    StringUtils util = new StringUtils();
                String[] itens = util.split(codigo, " ");
                ArrayList<String> palavrasPesquisadas = new ArrayList<>();
                for(String i:itens){
                    palavrasPesquisadas.add(i);
                }
        if(ordenacao==null){
        if (codigo.matches("[0-9]+")){
                        ordenacao="codigo";   }
                        else{
                        ordenacao="descricao";}
        }
        if (ordenacao.equalsIgnoreCase("codigo")){
            Collections.sort(listaProdutos,new ProdutosComparatorCodigo());}
        if (ordenacao.equalsIgnoreCase("descricao")){
            Collections.sort(listaProdutos,new ProdutosComparatorDescricao());}
        if (ordenacao.equalsIgnoreCase("ean13")){
            Collections.sort(listaProdutos,new ProdutosComparatorEan13());}
        if (ordenacao.equalsIgnoreCase("preco")){
            Collections.sort(listaProdutos,new ProdutosComparatorPreco());}
        if (ordenacao.equalsIgnoreCase("estoque")){
            Collections.sort(listaProdutos,new ProdutosComparatorEstoque());}    
        if (ordenacao.equalsIgnoreCase("mb")){
            Collections.sort(listaProdutos,new ProdutosComparatorMb());}        
         codigo = request.getParameter("codigoProduto");
         out.print("<table><thead><tr><td><a href=\"index.jsp?ordenacao=codigo&codigoProduto="+codigo+"\" class=\"link\">Código</a></td>"+
                "<td><a href=\"index.jsp?ordenacao=ean13&codigoProduto="+codigo+"\" class=\"link\" >EAN13</a></td>"+
                "<td><a href=\"index.jsp?ordenacao=descricao&codigoProduto="+codigo+"\" class=\"link\">Descritivo</a></td>"+
                "<td><a href=\"index.jsp?ordenacao=preco&codigoProduto="+codigo+"\" class=\"link\">Preço</a></td>"+
                "<td><a href=\"index.jsp?ordenacao=estoque&codigoProduto="+codigo+"\" class=\"link\">Estoque</a></td>"+
                "<td><a href=\"index.jsp?ordenacao=mb&codigoProduto="+codigo+"\" class=\"link\">M.B.</a></td></tr></thead><tbody>");
         for(int i=0;i<listaProdutos.size();i++){
         int contadorSimilaridade=0;
                for (String s:palavrasPesquisadas){
                    if (listaProdutos.get(i).getNome().contains(s.toUpperCase())){
                        contadorSimilaridade++;}
         }
         if ((contadorSimilaridade==palavrasPesquisadas.size())||((listaProdutos.get(i).getCodigo().contains(codigo))||(listaProdutos.get(i).getEAN13().contains(codigo)))){
                    out.println("<tr>");
                    out.println("<td> "+listaProdutos.get(i).getCodigo()+"</td>");
                    out.println("<td> "+listaProdutos.get(i).getEAN13()+"</td>");
                    out.println("<td> "+listaProdutos.get(i).getNome()+"</td>");
                    out.println("<td> "+NumberFormat.getCurrencyInstance().format(listaProdutos.get(i).getPreco())+"</td>");
                    out.println("<td> "+NumberFormat.getNumberInstance().format(listaProdutos.get(i).getEstoque())+"</td>");
                    out.println("<td> "+NumberFormat.getCurrencyInstance().format(listaProdutos.get(i).getPreco()-listaProdutos.get(i).getCusto())+"</td>");
                    out.println("</tr>");   
                }
            }
    out.print("</tbody></table></body>");
         }
    session.setAttribute("codigo", request.getParameter("codigoProduto"));
    session.setAttribute("listaProdutos", listaProdutos);
%>

</html>
