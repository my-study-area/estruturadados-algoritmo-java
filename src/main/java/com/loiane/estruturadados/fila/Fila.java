package com.loiane.estruturadados.fila;

import com.loiane.estruturadados.base.EstruturaEstatica;

public class Fila<T> extends EstruturaEstatica<T>{

    public Fila() {
        super();
    }

    public Fila(int capacidade) {
        super(capacidade);
    }

    public void enfileira(T elemento) {
        super.adiciona(elemento);
    }

    public T espiar() {
        return (T) super.getElementos()[0];
    }

    public T desenfileira() {
        T elemento = (T) super.getElementos()[0];
        super.remove(0);
        return elemento;
    }
}
