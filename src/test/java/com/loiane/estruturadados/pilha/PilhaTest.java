package com.loiane.estruturadados.pilha;

import static org.junit.Assert.*;

import org.junit.Test;

public class PilhaTest {

    @Test
    public void defineCapacidadeDaPilhaParaTres() {
        int capacidade = 3;
        Pilha<Integer> pilha = new Pilha<Integer>(3);
        assertEquals(capacidade, pilha.getElementos().length);
    }
    
    @Test
    public void defineCapacidadeDaPilhaParaCinco() {
        int capacidade = 5;
        Pilha<Integer> pilha = new Pilha<Integer>(5);
        assertEquals(capacidade, pilha.getElementos().length);
    }
    
    @Test
    public void defineCapacidadePadraoDaPilhaParaDez() {
        int capacidade = 10;
        Pilha<Integer> pilha = new Pilha<Integer>();
        assertEquals(capacidade, pilha.getElementos().length);
    }

    @Test
    public void empilhaUmElementoNoFinal() {
        Pilha<Integer> pilha = new Pilha<Integer>();
        pilha.empilha(1);
        assertEquals(1, pilha.tamanho());
        assertEquals(1, pilha.getElementos()[0]);
    }

    @Test
    public void verificaSeAPilhaEstaVazia() {
        Pilha<Integer> pilha = new Pilha<Integer>();
        assertEquals(true, pilha.estaVazia());
    }

    @Test
    public void verificaSeAPilhaNaoEstaVazia() {
        Pilha<Integer> pilha = new Pilha<Integer>();
        pilha.empilha(1);
        assertEquals(false, pilha.estaVazia());
    }

    @Test
    public void deveRetornarOElementoDoTopo() {
        Pilha<Integer> pilha = new Pilha<Integer>();
        pilha.empilha(1);
        pilha.empilha(2);
        pilha.empilha(3);
        assertEquals(new Integer(3), pilha.topo());
    }

    @Test
    public void deveRetornarNullquandoAPilhaEstaVazia() {
        Pilha<Integer> pilha = new Pilha<Integer>();
        assertEquals(null, pilha.topo());
    }
}
