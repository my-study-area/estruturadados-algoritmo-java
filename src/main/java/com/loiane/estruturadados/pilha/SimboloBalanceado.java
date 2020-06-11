package com.loiane.estruturadados.pilha;

public class SimboloBalanceado {

    public static boolean verificar(String expressao) {
        final String ABRE = "([{";
        final String FECHA= ")]}";
        Pilha<Character> operadoresQueAbrem = new Pilha<Character>();
        Pilha<Character> operadoresQueFecham  = new Pilha<Character>();
        
        for (int i = 0; i < expressao.length(); i++) {
            char letra = expressao.charAt(i);
            if (ABRE.indexOf(letra) > -1) {
                operadoresQueAbrem.empilha(letra);
            } 
            if (FECHA.indexOf(letra) > -1) {
                operadoresQueFecham.empilha(letra);
            }
        }
        
        if (operadoresQueAbrem.tamanho() != operadoresQueFecham.tamanho()) {
            return false;
        }
        
        int indiceOperadorQueAbre, indiceOperadorQueFecha;
        char caractereDeOperadorAbre, caractereDeOperadorQueFecha;
        for (int i = 0; i < operadoresQueAbrem.tamanho(); i++) {
            caractereDeOperadorAbre = operadoresQueAbrem.desempilha();
            caractereDeOperadorQueFecha = operadoresQueFecham.desempilha();
            indiceOperadorQueAbre = ABRE.indexOf(caractereDeOperadorAbre);
            indiceOperadorQueFecha= FECHA.indexOf(caractereDeOperadorQueFecha);
            if (indiceOperadorQueAbre != indiceOperadorQueFecha ) {
                return false;
            }
        }
        return true;
    }
}
