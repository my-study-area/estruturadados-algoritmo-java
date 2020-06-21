package com.loiane.estruturadados.pilha;

public class ConversorDecimalBinario {

    public static String converter(int numero) {
        if (numero == 0) {
            return "0";
        }
        Pilha<Integer> binarioInvertido = new Pilha<Integer>();
        String numeroBinario = "";
        int resto;
        while (numero > 0) {
            resto = numero % 2;
            binarioInvertido.empilha(resto);
            numero /= 2;
        }

        while (!binarioInvertido.estaVazia()) {
            numeroBinario += binarioInvertido.desempilha();
        }

        return numeroBinario;
    }
}
