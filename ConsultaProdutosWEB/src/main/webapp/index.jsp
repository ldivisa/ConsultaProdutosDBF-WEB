<%@page import="java.lang.String"%>
<%@page import="java.util.Objects"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Collection"%>
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
<!--        <h4>1)Digite o código do produto que deseja pesquisar ou scaneie o EAN13 da etiqueta do produto - 2)Aperte "ENTER" no teclado:</h4>-->
<!--         ou clique no botão "OK".-->
<%
ArrayList<String> alChecados=new ArrayList<>();  
alChecados.removeAll(alChecados);
      if ((ArrayList<String>) session.getAttribute("alChecados")!=null)
                alChecados =(ArrayList<String>) session.getAttribute("alChecados");
    String red="";
    String quad="";
    String ean="";
    String opcoes="";
    Boolean esconder=true;
    String esconderCb="";
    String estoquePositivo="";
    String limiteCodigo="";
    String[] check=null;
    int limiteContagem;
    
        check=(String[]) request.getParameterValues("checkBoxes");
       
       if (check!=null)       {
            alChecados.removeAll(alChecados);
            for (int i = 0 ; i <= check.length-1; i++){
                  alChecados.add(check[i]);
            }}
            else{
            alChecados.removeAll(alChecados);
        }
       session.setAttribute("alChecados", alChecados);
       //out.print("\n Gravando sessao com "+alChecados.size()+" itens");
       if (alChecados.contains("red")){
                    red="checked=\"on\"";
                    //out.print("Array--red checked on");
                } else{
                    red="";
                }
       if (alChecados.contains("quad")){
                    quad="checked=\"on\"";   
                    //out.print("Array--quad checked on");
                } else{
                    quad="";
                }
        if (alChecados.contains("estoquePositivo")){
                    estoquePositivo="checked=\"on\"";   
                    //out.print("Array--quad checked on");
                } else{
                    estoquePositivo="";
                }        
                
        if (alChecados.contains("ean")){
                    ean="checked=\"on\"";   
                    //out.print("Array--quad checked on");
                } else{
                    ean="";
                }
        if (alChecados.contains("limiteCodigo")){
                    limiteCodigo="checked=\"on\"";
                    //out.print("Array--quad checked on");
                } else{
                    limiteCodigo="";
                 }
                 
        if (alChecados.contains("opcoes")){
                    opcoes="checked=\"on\"";
                    esconder=false;
                    esconderCb=(esconder?"hidden":"checkbox");
                    //out.print("Array--quad checked on");
                } else{
                    opcoes="";
                }
%>
        <form  action="index.jsp" method="GET">
        <input type="text" name="codigoProduto" autofocus /><!-- comment -->
        <label class="switchBtn">
            <input type="checkbox" name="checkBoxes" value="opcoes" <%=opcoes%> >
            <div class="slide round">Opções</div>
        </label>
        <%
            if (!esconder){%>
        <label class="switchBtn">
            <input type="checkbox" name="checkBoxes" value="quad" <%=quad%> <%=esconder%>>
            <div class="slide round">Estoque</div>
        </label>
        <label class="switchBtn">
            <input type="checkbox" name="checkBoxes" value="ean" <%=ean%> <%=esconder%>>
            <div class="slide round">EAN</div>
        </label>
        
        <label class="switchBtn">
            <input type="checkbox" name="checkBoxes" value="estoquePositivo" <%=estoquePositivo%> <%=esconder%>>
            <div class="slide round">Estoque>0</div>
        </label>    
        <label class="switchBtn">
            <input type="checkbox" name="checkBoxes" value="red" <%=red%> <%=esconder%>  >
            <div class="slide round">M.b.</div>
        </label>
            
        <label class="switchBtn">
            <input type="checkbox" name="checkBoxes" value="limiteCodigo" <%=limiteCodigo%> <%=esconder%>  >
            <div class="slide round">MultiCOD</div>
        </label>
        <!--        <button>OK</button>-->
        <br><!-- comment -->
        <%}%>
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
     limiteContagem=listaProdutos.size();
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
                        ordenacao="codigo";  
                        if (limiteCodigo.contains("che")){
                        limiteContagem=listaProdutos.size();}
                        else{
                        limiteContagem=1;}    
                                    }
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
         String complementoCheckBoxes="";
    
         if(alChecados.contains("red"))
             complementoCheckBoxes+="&checkBoxes=red";
         
         if(alChecados.contains("quad"))
            complementoCheckBoxes+="&checkBoxes=quad";
          
         out.print("<table><thead><tr><td><a href=\"index.jsp?ordenacao=codigo&codigoProduto="+codigo+complementoCheckBoxes+"\" class=\"link\" accesskey=\"c\">Código</a></td>");
                if(alChecados.contains("ean"))
                out.print("<td><a href=\"index.jsp?ordenacao=ean13&codigoProduto="+codigo+complementoCheckBoxes+"\" class=\"link\" accesskey=\"b\">EAN13</a></td>");
                out.print("<td><a href=\"index.jsp?ordenacao=descricao&codigoProduto="+codigo+complementoCheckBoxes+"\" class=\"link\" accesskey=\"d\">Descritivo</a></td>"+
                "<td><a href=\"index.jsp?ordenacao=preco&codigoProduto="+codigo+complementoCheckBoxes+"\" class=\"link\" accesskey=\"p\">Preço</a></td>");
                if(alChecados.contains("quad"))
                       out.print("<td><a href=\"index.jsp?ordenacao=estoque&codigoProduto="+codigo+complementoCheckBoxes+"\" class=\"link\" accesskey=\"e\">Estoque</a></td>");
                if(alChecados.contains("red"))
                        out.print("<td><a href=\"index.jsp?ordenacao=mb&codigoProduto="+codigo+complementoCheckBoxes+"\" class=\"link\" accesskey=\"m\">M.B.</a></td></tr></thead><tbody>");
                        else
              out.print("</thead><tbody>");
                            //out.print("Limite:"+limiteContagem);
    for(int i=0;i<listaProdutos.size();i++){
         int contadorSimilaridade=0;
         int contadorExibicao=0;
                for (String s:palavrasPesquisadas){
                    if (listaProdutos.get(i).getNome().contains(s.toUpperCase())){
                        contadorSimilaridade++;}
         }
         if ((contadorSimilaridade==palavrasPesquisadas.size())||((listaProdutos.get(i).getCodigo().contains(codigo))||(listaProdutos.get(i).getEAN13().contains(codigo)))){
         if(!((estoquePositivo.contains("che"))&&(listaProdutos.get(i).getEstoque()<1.00))){
         contadorExibicao++;
         out.println("<tr>");
         out.println("<td> "+listaProdutos.get(i).getCodigo()+"</td>");
                    if(alChecados.contains("ean"))
                    out.println("<td> "+listaProdutos.get(i).getEAN13()+"</td>");
                    out.println("<td> "+listaProdutos.get(i).getNome()+"</td>");
                    out.println("<td> "+NumberFormat.getCurrencyInstance().format(listaProdutos.get(i).getPreco())+"</td>");
                    if(alChecados.contains("quad"))
                    out.println("<td> "+NumberFormat.getNumberInstance().format(listaProdutos.get(i).getEstoque())+"</td>");
                    
                    if(alChecados.contains("red"))
                              out.println("<td> "+NumberFormat.getCurrencyInstance().format(listaProdutos.get(i).getPreco()-listaProdutos.get(i).getCusto())+"</td>");
                        else
                              out.println("</tr>");
         
         }
         }
         if (contadorExibicao==limiteContagem){
         //out.print("hora de sair");
         break;
         }
         
         }          
            out.print("</tbody></table></body>");
         
    session.setAttribute("codigo", request.getParameter("codigoProduto"));
    session.setAttribute("listaProdutos", listaProdutos);
         }

     %>
</html>
