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
public class ProdutosComparatorMb implements Comparator<Produtos>{

    @Override
    public int compare(Produtos o1, Produtos o2) {
        int p1 = (int) Math.round(100*   (o1.getPreco()-o1.getCusto()));
        int p2 = (int) Math.round(100* (o2.getPreco()-o2.getCusto()));
        
        return (p2-p1);
    }
    
}
