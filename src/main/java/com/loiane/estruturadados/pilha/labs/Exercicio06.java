package com.loiane.estruturadados.pilha.labs;

import com.loiane.estruturadados.pilha.SimboloBalanceado;

public class Exercicio06 {

    public static void main(String[] args) {
        imprimeResultado("(A+B)");
        imprimeResultado(")A+B)");
        imprimeResultado("(A+B])");
        imprimeResultado("(A+B((");
        imprimeResultado("A+B");
    }
    
    public static void imprimeResultado(String expressao) {
        System.out.println("A expressão " + expressao + " é balanceada? " + SimboloBalanceado.verificar(expressao));
    }
}
