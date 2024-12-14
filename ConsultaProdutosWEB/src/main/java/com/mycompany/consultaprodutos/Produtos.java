/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultaprodutos;

/**
 *
 * @author Luiz
 */
public class Produtos implements Comparable<Produtos>{
    
    private String codigo;
    private String nome;
    private String EAN13;
    private double preco;
    private double estoque;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produtos{" + "codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + ", estoque=" + estoque + '}';
    }

    public String getEAN13() {
        return EAN13;
    }

    public void setEAN13(String EAN13) {
        this.EAN13 = EAN13;
    }

    @Override
    public int compareTo(Produtos o) {
        /*if (Integer.parseInt(this.codigo) > (Integer.parseInt(o.getCodigo())))
        return 1;
        else 
        if (Integer.parseInt(this.codigo) < (Integer.parseInt(o.getCodigo())))
        return -1;
        else
        return 0;*/
        if (this.nome.compareToIgnoreCase(o.getNome())>0)
            return 1;
        else
            if (this.nome.compareToIgnoreCase(o.getNome())<0)
            return -1;
        else
                return 0;
    }
}