package com.loiane.estruturadados.vetor;

public class VetorObjeto {
	private Object[] elementos;
	private int tamanho = 0;

	public VetorObjeto(int capacidade) {
		elementos = new Object[capacidade];
	}

	public Object[] getElementos() {
		return elementos;
	}

	public int tamanho() {
		return tamanho;
	}

	public boolean adiciona(Object elemento) {
		this.aumentaCapacidade();
		elementos[tamanho] = elemento;
		tamanho++;
		return true;
	}

	public boolean adiciona(int posicao, Object elemento) {
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
			Object[] vetorAumentado = new Object[tamanho*2];
			for (int i = 0; i < elementos.length; i++) {
				vetorAumentado[i] = elementos[i];
			}
			this.elementos = vetorAumentado;
		}
	}

	public Object busca(int posicao) {
		if (posicao > tamanho || posicao < 0) {
			throw new IllegalArgumentException();
		}
		return this.elementos[posicao];
	}

	public int busca(Object elemento) {
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

	public void remove(Object elemento) {
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
}
