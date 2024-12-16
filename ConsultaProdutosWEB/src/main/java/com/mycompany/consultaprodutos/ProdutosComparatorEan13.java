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
public class ProdutosComparatorEan13 implements Comparator<Produtos>{

    @Override
    public int compare(Produtos o1, Produtos o2) {
        String p1= (String) o1.getEAN13();
        String p2= (String) o2.getEAN13();
        if (p1.compareToIgnoreCase(p2)>0)
            return 1;
        if (p1.compareToIgnoreCase(p2)<0)
            return -1;
        return 0;
    }
    
}
