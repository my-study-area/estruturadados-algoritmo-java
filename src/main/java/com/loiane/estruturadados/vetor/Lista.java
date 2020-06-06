package com.loiane.estruturadados.vetor;

public class Lista<T> {
    private T[] elementos;
    private int tamanho = 0;

    public Lista(int capacidade) {
        elementos = (T[]) new Object[capacidade];
    }

    public Lista() {
        this(10);
    }

    public Object[] getElementos() {
        return elementos;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean adiciona(T elemento) {
        this.aumentaCapacidade();
        elementos[tamanho] = elemento;
        tamanho++;
        return true;
    }

    public boolean adiciona(int posicao, T elemento) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        aumentaCapacidade();
        for (int i = tamanho; i > posicao; i--) {
            this.elementos[i] = this.elementos[i -1];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    private void aumentaCapacidade() {
        if (tamanho == this.elementos.length) {
           T[] vetorAumentado = (T[]) new Object[tamanho*2];
            for (int i = 0; i < elementos.length; i++) {
                vetorAumentado[i] = elementos[i];
            }
            this.elementos = vetorAumentado;
        }
    }

    public T busca(int posicao) {
        if (posicao > tamanho || posicao < 0) {
            throw new IllegalArgumentException();
        }
        return (T) this.elementos[posicao];
    }

    public int busca(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int posicao) {
        if (posicao > tamanho || posicao < 0) {
            throw new IllegalArgumentException("Posição inexistente");
        }
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho --;
    }

    public void remove(T elemento) {
        int posicao = this.busca(elemento);
        this.remove(posicao);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("[");

        for (int i = 0; i < tamanho - 1; i++) {
            text.append(elementos[i]);
                text.append(", ");
        }

        if (tamanho > 0) {
            text.append(elementos[tamanho - 1]);
        }

        text.append("]");
        return text.toString();
    }

    public boolean contem(T elemento) {
//        int posicao = this.busca(elemento);
//        return posicao > -1;
        return this.busca(elemento) > -1;
    }

    public int ultimoIndice(T elemento) {
        for (int i = tamanho -1 ; i >= 0; i--) {
            if (elemento == this.elementos[i]) {
                return i;
            }
        }
        return -1;
    }

    public T obtem(int posicao) {
        return this.busca(posicao);
    }

    public void limpar() {
        //opção 01
        //this.elementos = (T[]) new Object[this.elementos.length];
        //this.tamanho = 0;

        //opçao 02
        //this.tamanho = 0;

        //opção 03
        for (int i = 0; i < elementos.length; i++) {
            this.elementos[i] = null;
        }
        this.tamanho = 0;
    }
}
