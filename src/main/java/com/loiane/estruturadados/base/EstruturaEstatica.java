package com.loiane.estruturadados.base;

public class EstruturaEstatica<T> {
    protected T[] elementos;
    private int tamanho;

    public EstruturaEstatica() {
        this(10);
    }
    
    public EstruturaEstatica(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        tamanho = 0;
    }
    
    public Object[] getElementos() {
        return this.elementos;
    }

    public int tamanho() {
        return this.tamanho;
    }

    protected boolean adiciona(T elemento) {
        aumentaCapacidade();
        this.elementos[tamanho] = elemento;
        tamanho++;
        return true;
    }


    protected boolean adiciona(int posicao, T elemento) {
        validaPosicao(posicao);
        aumentaCapacidade();
        for (int i = tamanho; i > posicao;i--) {
            if (i > posicao) {
                this.elementos[i] = this.elementos[i-1];
            }
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    private void validaPosicao(int posicao) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posição Inválida");
        }
     }

    private void aumentaCapacidade() {
        if (this.tamanho == this.getElementos().length) {
            T[] estruturaEstaticaAumentada = (T[]) new Object[this.tamanho * 2];
            for (int i = 0; i < elementos.length; i++) {
                estruturaEstaticaAumentada[i] = this.elementos[i];
            }
            this.elementos = estruturaEstaticaAumentada;
        }
    }

    public void remove(int posicao) {
        validaPosicao(posicao);
        for (int i = posicao; i < this.tamanho -1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho --;
    }


    public boolean estaVazia() {
        return this.tamanho < 1;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("[");
        if (this.tamanho > 0) {
            for (int i = 0; i < tamanho - 1; i++) { 
                text.append(this.elementos[i]);
                text.append(", ");
            }
            text.append(this.elementos[tamanho - 1]);
        }
        text.append("]");
        return text.toString();
    }
}
