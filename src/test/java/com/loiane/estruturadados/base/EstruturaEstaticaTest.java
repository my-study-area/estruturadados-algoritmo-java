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

    @Test(expected = IllegalArgumentException.class)
    public void validaPosicaoAoAdicionarElementoNaPosicaoMenorQueZero() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(3);

        estruturaEstatica.adiciona(-1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validaPosicaoAoAdicionarElementoNaPosicaoMaiorQueOTamanho() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(3);
        
        estruturaEstatica.adiciona(10, 2);
    }

    @Test
    public void aumentaCapacidadeDaEstruturaAoAdicionarNovoElementoMaiorQueACapacidade() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(3);
        estruturaEstatica.adiciona(1);
        estruturaEstatica.adiciona(2);
        estruturaEstatica.adiciona(3);

        assertEquals(3, estruturaEstatica.getElementos().length);
        estruturaEstatica.adiciona(4);
        assertEquals(6, estruturaEstatica.getElementos().length);
        assertEquals(4, estruturaEstatica.tamanho());
    }
    
    @Test
    public void aumentaCapacidadeDaEstruturaAoAdicionarNovoElementoPorPosicaoMaiorQueACapacidade() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(3);
        estruturaEstatica.adiciona(0, 1);
        estruturaEstatica.adiciona(1, 2);
        estruturaEstatica.adiciona(2, 3);
        
        assertEquals(3, estruturaEstatica.getElementos().length);
        estruturaEstatica.adiciona(3, 4);
        assertEquals(6, estruturaEstatica.getElementos().length);
        assertEquals(4, estruturaEstatica.tamanho());
    }

    @Test
    public void removeElementoPorPosicao() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(3);
        estruturaEstatica.adiciona(1);
        estruturaEstatica.adiciona(2);
        estruturaEstatica.adiciona(3);
        assertEquals(3, estruturaEstatica.tamanho());
        estruturaEstatica.remove(1);
        assertEquals(3, estruturaEstatica.getElementos()[1]);
        assertEquals(2, estruturaEstatica.tamanho());
    }

    @Test(expected = IllegalArgumentException.class)
    public void validaPosicaoAoRemeverElementoComPosicaoMenorQueZero() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(3);
        estruturaEstatica.adiciona(1);
        estruturaEstatica.adiciona(2);
        estruturaEstatica.adiciona(3);
        estruturaEstatica.remove(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validaPosicaoAoRemeverElementoNaPosicaoMaiorQueOTamanho() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(3);
        estruturaEstatica.adiciona(1);
        estruturaEstatica.adiciona(2);
        estruturaEstatica.adiciona(3);
        estruturaEstatica.remove(4);
    }

    @Test
    public void deveExibirOselementosDaEstruturaEstaticaDeTamanhoZero() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(3);
        assertEquals("[]", estruturaEstatica.toString());
    }

    @Test
    public void deveExibirOselementosDaEstruturaEstaticaDeTamanhoTres() {
        EstruturaEstatica<Integer> estruturaEstatica = new EstruturaEstatica<Integer>(3);
        estruturaEstatica.adiciona(1);
        estruturaEstatica.adiciona(2);
        estruturaEstatica.adiciona(3);
        assertEquals("[1, 2, 3]", estruturaEstatica.toString());
    }
}
