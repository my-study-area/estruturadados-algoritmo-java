package com.loiane.estruturadados.pilha;

public class ConversorDecimalBinario {

    private ConversorDecimalBinario() {}

    public static String converter(int numero) {
        if (numero == 0) {
            return "0";
        }
        Pilha<Integer> binarioInvertido = new Pilha<Integer>();
        StringBuilder numeroBinario = new StringBuilder();
        int resto;
        while (numero > 0) {
            resto = numero % 2;
            binarioInvertido.empilha(resto);
            numero /= 2;
        }

        while (!binarioInvertido.estaVazia()) {
            numeroBinario.append(binarioInvertido.desempilha());
        }

        return numeroBinario.toString();
    }
}
