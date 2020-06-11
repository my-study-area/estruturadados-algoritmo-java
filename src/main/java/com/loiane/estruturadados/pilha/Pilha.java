package com.loiane.estruturadados.pilha;

import com.loiane.estruturadados.base.EstruturaEstatica;

public class Pilha<T> extends EstruturaEstatica<T> {

    public Pilha(int capacidade) {
        super(capacidade);
    }

    public Pilha() {
        super(10);
    }

    public Object[] getElementos() {
        return super.getElementos();
    }

    public void empilha(T elemento) {
        super.adiciona(elemento);
    }

    public T topo() {
        if (super.tamanho() == 0) {
            return null;
        }
        return super.elementos[tamanho() - 1];
    }

    public T desempilha() {
        if (super.tamanho == 0) {
            return null;
        }
        return this.elementos[--super.tamanho];
    }
    
}
