package com.loiane.estruturadados.fila;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilaTest {

    @Test
    public void adicionaUmElementoNaFila() {
        Fila<String> fila = new Fila<String>();
        fila.enfileira("pessoa 01");
        assertEquals(1, fila.tamanho());
    }
    
    @Test
    public void espiarElementoNaFilaComDoisElementos() {
        Fila<String> fila = new Fila<String>();
        fila.enfileira("pessoa 01");
        fila.enfileira("pessoa 02");
        assertEquals("pessoa 01", fila.espiar());
    }
    
    @Test
    public void espiarElementoNaFilaComTresElementos() {
        Fila<String> fila = new Fila<String>();
        fila.enfileira("pessoa A");
        fila.enfileira("pessoa B");
        fila.enfileira("pessoa C");
        assertEquals("pessoa A", fila.espiar());
    }
    
    @Test
    public void desenfileiraElementoNaFilaComTresElementos() {
        Fila<String> fila = new Fila<String>();
        fila.enfileira("pessoa A");
        fila.enfileira("pessoa B");
        fila.enfileira("pessoa C");

        assertEquals("pessoa A", fila.desenfileira());
        assertEquals(2, fila.tamanho());
        assertEquals("pessoa B", fila.espiar());
        assertEquals(false, fila.estaVazia());
    }
}
