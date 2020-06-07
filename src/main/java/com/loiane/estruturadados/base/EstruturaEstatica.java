package com.loiane.estruturadados.base;

public class EstruturaEstatica<T> {
    protected T[] elementos;
    protected int tamanho;

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
        this.elementos[tamanho] = elemento;
        tamanho++;
        return true;
    }

    protected boolean adiciona(int posicao, T elemento) {
        for (int i = tamanho; i > posicao;i--) {
            if (i > posicao) {
                this.elementos[i] = this.elementos[i-1];
            }
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    
}
