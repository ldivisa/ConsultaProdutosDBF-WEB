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
        int p1 = (int) Math.round((o1.getPreco()-o1.getCusto())*100);
        int p2 = (int) Math.round((o2.getPreco()-o1.getCusto())*100);
        
        return (p2-p1);
    }
    
}
