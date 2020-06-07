package com.loiane.estruturadados.base;

import static org.junit.Assert.*;

import org.junit.Test;

import com.loiane.estruturadados.vetor.Lista;

public class EstruturaEstaticaTest {

    @Test
    public void defineCapacidadePadraoParaDez() {
        int expected = 10;
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica();
        assertEquals(expected, estruturaEstatica.getElementos().length);
    }
    
    @Test
    public void defineCapacidadeParaDois() {
        int expected = 2;
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(2);
        assertEquals(expected, estruturaEstatica.getElementos().length);
    }

    @Test
    public void adicionaNovoElemento() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(2);
        assertEquals(true, estruturaEstatica .adiciona(1));
    }

    @Test
    public void aumentaTamanhoDaEstruturaEstaticaAoAdicionarUmNovoElemento() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(2);
        estruturaEstatica.adiciona(1);
        int expected = 1;
        assertEquals(expected, estruturaEstatica.tamanho());
        estruturaEstatica.adiciona(2);
        expected = 2;
        assertEquals(expected, estruturaEstatica.tamanho());
    }
    
    @Test
    public void aumentaTamanhoDaEstruturaEstaticaAoAdicionarDoisNovosElementos() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(2);
        estruturaEstatica.adiciona(1);
        estruturaEstatica.adiciona(2);
        int expected = 2;
        assertEquals(expected, estruturaEstatica.tamanho());
        assertEquals(1, estruturaEstatica.getElementos()[0]);
        assertEquals(2, estruturaEstatica.getElementos()[1]);
    }
    
    @Test
    public void adicionaElementoNaPosicaoZero() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(3);
        int expected = 1;
        
        assertEquals(3, estruturaEstatica.getElementos().length);
        assertEquals(0, estruturaEstatica.tamanho());
        estruturaEstatica.adiciona(2);
        assertEquals(1, estruturaEstatica.tamanho());
        estruturaEstatica.adiciona(3);
        assertEquals(2, estruturaEstatica.tamanho());
        assertEquals(true, estruturaEstatica.adiciona(0, 1));
        assertEquals(1, estruturaEstatica.getElementos()[0]);
        assertEquals(2, estruturaEstatica.getElementos()[1]);
        assertEquals(3, estruturaEstatica.getElementos()[2]);
    }
}
