/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultaprodutos;

import java.util.Comparator;

/**
 *
 * @author Luiz
 */
public class ProdutosComparatorPreco implements Comparator<Produtos>{

    @Override
    public int compare(Produtos o1, Produtos o2) {
        String Preço1 = String.valueOf(o1.getPreco());
        String Preço2 = String.valueOf(o2.getPreco());
        
        return (Integer.parseInt(Preço1)- Integer.parseInt(Preço2));
    }
    
}
