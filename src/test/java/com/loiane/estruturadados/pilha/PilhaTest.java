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
}
