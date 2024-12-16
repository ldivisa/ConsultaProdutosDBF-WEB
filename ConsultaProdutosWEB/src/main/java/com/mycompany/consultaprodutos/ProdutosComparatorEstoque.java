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
public class ProdutosComparatorEstoque implements Comparator<Produtos>{

    @Override
    public int compare(Produtos o1, Produtos o2) {
        int p1 = (int) Math.round(o1.getEstoque()*100);
        int p2 = (int) Math.round(o2.getEstoque()*100);
        return (p1-p2);
        
    }
    
}
