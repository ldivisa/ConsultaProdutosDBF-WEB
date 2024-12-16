/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.consultaprodutos;
import com.linuxense.javadbf.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Luiz
 */
public class ConsultaProdutos {
public String caminhoDados = "/consultaProdutos/produtos.dbf";
public String codigo,ordenacao;
public List<Produtos> listaProdutos;
//"C:/Users/luiz.souza/Downloads/produtos.dbf"
//this.caminhoDados =("/consultaProdutos/produtos.dbf");*/
    
    public void ConsultaProdutos(){
        }
    
    public ArrayList<Produtos> ConsultarProdutoArray() {
                ArrayList<Produtos> listagem = new ArrayList<>();
                DBFReader reader = null;
		try {

			// create a DBFReader object
			//reader = new DBFReader(new FileInputStream(args[0]));
                        //reader = new DBFReader(new FileInputStream("Y:/dados/produtos.dbf"));
                        //reader = new DBFReader(new FileInputStream("/consultaProdutos/produtos.dbf"));
                        reader = new DBFReader(new FileInputStream(caminhoDados));

			// get the field count if you want for some reasons like the following

			int numberOfFields = reader.getFieldCount()-1;
                         // System.out.print("Numero de campos: "+numberOfFields+"\n");
			// use this count to fetch all field information
			// if required

			for (int i = 0; i < numberOfFields; i++) {

				DBFField field = reader.getField(i);

				// do something with it if you want
				// refer the JavaDoc API reference for more details
				//
				//System.out.println(field.getName());
			}
                        

			// Now, lets us start reading the rows

			Object[] rowObjects;

			while ((rowObjects = reader.nextRecord()) != null) {
                           // if (codigo.equals(rowObjects[0].toString()))
                            //{
                            Produtos produto = new Produtos();
                                        produto.setCodigo(rowObjects[0].toString());
                                        produto.setNome((String) rowObjects[2]);
                                        if (rowObjects[1].toString().isEmpty()){
                                            produto.setEAN13("0");} else {
                                        produto.setEAN13(rowObjects[1].toString());}
                                        produto.setCusto(Double.valueOf(rowObjects[6].toString()));
                                        produto.setPreco(Double.valueOf(rowObjects[7].toString()));
                                        produto.setEstoque(Double.valueOf(rowObjects[5].toString()));
                                        listagem.add(produto);
                            //} else
                           // {
                            //System.out.println("\n Não achei o codigo"+codigo);
                           // }
                                
				/*for (int i = 0; i < rowObjects.length; i++) {
					System.out.println(rowObjects[i]);
                                              				}*/
			}

			// By now, we have iterated through all of the rows

		} 
                catch (FileNotFoundException ex)
                {
                 JOptionPane.showMessageDialog(null, "Não encontrei o arquivo: "+ex);
                 }
                catch (DBFException e) {
			JOptionPane.showMessageDialog(null, "Nao encontrei o arquivo: "+e);
		}
                
		finally {
			DBFUtils.close(reader);
		}
	return listagem;
        }
    
    public List<Produtos> ConsultarProduto() {
                List<Produtos> listagem = new ArrayList<>();
                DBFReader reader = null;
		try {

			// create a DBFReader object
			//reader = new DBFReader(new FileInputStream(args[0]));
                        reader = new DBFReader(new FileInputStream(caminhoDados));

			// get the field count if you want for some reasons like the following

			int numberOfFields = reader.getFieldCount()-1;
                         // System.out.print("Numero de campos: "+numberOfFields+"\n");
			// use this count to fetch all field information
			// if required

			for (int i = 0; i < numberOfFields; i++) {

				DBFField field = reader.getField(i);

			Object[] rowObjects;

			while ((rowObjects = reader.nextRecord()) != null) {
                           // if (codigo.equals(rowObjects[0].toString()))
                            //{
                            Produtos produto = new Produtos();
                                        produto.setCodigo(rowObjects[0].toString());
                                        produto.setNome((String) rowObjects[2]);
                                        if (rowObjects[1].toString().isEmpty()){
                                            produto.setEAN13("0");} else {
                                        produto.setEAN13(rowObjects[1].toString());}
                                        produto.setCusto(Double.valueOf(rowObjects[6].toString()));
                                        produto.setPreco(Double.valueOf(rowObjects[7].toString()));
                                        produto.setEstoque(Double.valueOf(rowObjects[5].toString()));
                                        listagem.add(produto);
                            //} else
                           // {
                            //System.out.println("\n Não achei o codigo"+codigo);
                           // }
                                
				/*for (int i = 0; i < rowObjects.length; i++) {
					System.out.println(rowObjects[i]);
                                              				}*/
			}
			// By now, we have iterated through all of the rows

		}} 
                    catch (FileNotFoundException ex)
                {
                 out.print( "Não encontrei o arquivo: "+ex);
                 }
                catch (DBFException e) {
		out.print("Nao encontrei o arquivo: "+e);
		}
                
		finally {
			DBFUtils.close(reader);
		}
	return listagem;
        }
   }