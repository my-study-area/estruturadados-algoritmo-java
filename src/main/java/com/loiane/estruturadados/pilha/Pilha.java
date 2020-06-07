package com.loiane.estruturadados.pilha;

public class Pilha<T> {

    public T[] elementos;

    public Pilha(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
    }

    public Pilha() {
        this(10);
    }

    public Object[] getElementos() {
        return elementos;
    }
    
}
