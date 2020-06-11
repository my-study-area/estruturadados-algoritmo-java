package com.loiane.estruturadados.pilha.labs;

import com.loiane.estruturadados.pilha.Pilha;

public class Exercicio05 {

    public static void main(String[] args) {
        System.out.println(verificaPalindromo("ABCBA"));
        System.out.println(verificaPalindromo("ABCDE"));
    }
    
    public static boolean verificaPalindromo(String texto) {
        Pilha<Character> pilha = new Pilha<Character>();
        for (int i = 0; i < texto.length(); i++) {
            pilha.empilha(texto.charAt(i));
        }
        StringBuffer palavraInversa = new StringBuffer();
        while(!pilha.estaVazia()) {
            palavraInversa.append(pilha.desempilha());
        }
        return palavraInversa.toString().equals(texto);
    }
}
