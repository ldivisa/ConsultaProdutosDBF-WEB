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
public class ProdutosComparatorDescricao implements Comparator<Produtos>{

    @Override
    public int compare(Produtos o1, Produtos o2) {
            return (o1.compareTo(o2));
    }
    
}
