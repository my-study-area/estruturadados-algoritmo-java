package com.loiane.estruturadados.pilha;

public class ConversorDecimalBinario {

    public static String converter(int numero) {
        boolean continua = true;
        Pilha<String> valorBinarioInvertido = new Pilha<String>();
        while (continua) {
            if (numero % 2 == 1) {
                valorBinarioInvertido.empilha("1");
                numero = numero / 2;
            } else if (numero % 2 == 0) {
                valorBinarioInvertido.empilha("0");
                if (numero == 0) {
                    continua = false;
                }
                numero = numero / 2;
            }
        }

        String valorBinario = new String();
        while (!valorBinarioInvertido.estaVazia()) {
            valorBinario += valorBinarioInvertido.desempilha();
        }
        if (valorBinario.substring(0, 1).equalsIgnoreCase("0") && valorBinario.length() > 1) {
            return valorBinario.substring(1);
        }
        return valorBinario;
    }
}
