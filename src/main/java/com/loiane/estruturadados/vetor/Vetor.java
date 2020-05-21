package com.loiane.estruturadados.vetor;

import java.util.Arrays;

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

}
