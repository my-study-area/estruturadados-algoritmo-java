package com.loiane.estruturadados.vetor;

public class Vetor {
	private String[] elementos;
	private int tamanho;

	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}

	public String[] getElementos() {
		return elementos;
	}

	public void setElementos(String[] elementos) {
		this.elementos = elementos;
	}

//	public void adiciona(String elemento) {
//		for(int i = 0; i < this.elementos.length; i++) {
//			if (this.elementos[i] == null) {
//				this.elementos[i] = elemento;
//				return;
//			}
//		}
//	}

	public boolean adiciona(String elemento) {
		aumentaCapacidade();
		if (tamanho < this.elementos.length) {
			this.elementos[tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}

	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("[");
		for (int i = 0; i < tamanho -1; i++) {
			s.append(elementos[i]);
			s.append(", ");
		}

		if (this.tamanho > 0) {
			s.append(elementos[tamanho - 1]);
		}

		s.append("]");

		return s.toString();
	}

	public String busca(int posicao) {
		if (posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posição inválida.");
		}
		return elementos[posicao];
	}

	public int busca(String texto) {
		for (int i = 0; i < elementos.length; i++) {
			if (elementos[i] == texto) {
				return i;
			}
		}
		return -1;
	}

	public boolean adiciona(int posicao, String texto) {
		if (posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posição inválida.");
		}

		aumentaCapacidade();

		for (int i = tamanho -1 ; i >= posicao  ; i--) {
			this.elementos[i + 1] = this.elementos[i];
		}

		this.tamanho++;
		this.elementos[posicao] = texto;
		return true;
	}
	
	private void aumentaCapacidade() {
		if (tamanho == elementos.length) {
			String[] elementosNovos = new String[tamanho * 2];
			for (int i = 0; i < elementos.length; i++) {
				elementosNovos[i] = elementos[i];
			}
			elementos = elementosNovos;
		}
	}

	public void remove(int posicao) {
		for (int i = posicao; i < this.tamanho; i++) {
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
	}

	public void remove(String elemento) {
		int posicao = this.busca(elemento);
		this.remove(posicao);
	}
}
