package com.loiane.estruturadados.pilha.labs;

import java.util.Stack;

public class Exercicio07 {
    static int quantidadeDeDiscos = 3;
    static Stack<Integer> tower01 = new Stack<Integer>();
    static Stack<Integer> tower02 = new Stack<Integer>();
    static Stack<Integer> tower03 = new Stack<Integer>();
    static int numeroDeJogada = 0;

    public static void main(String[] args) {
        for (int i = quantidadeDeDiscos; i > 0; i--) {
            tower01.add(i);
        }
        torreDeHanoi(quantidadeDeDiscos, tower01, tower02, tower03);
    }

    public static void torreDeHanoi(int n, Stack<Integer> original, Stack<Integer> dest, Stack<Integer> aux) {
        if(n>0) {
            torreDeHanoi(n-1, original, aux, dest);
            dest.push(original.pop());
            System.out.println("---------");
            System.out.println("Jogada n: " + ++numeroDeJogada);
            System.out.println("Original: " + original);
            System.out.println("Destino: " + dest);
            System.out.println("Auxiliar: " + aux);
            torreDeHanoi(n-1, aux, dest, original);
        }
    }
}
