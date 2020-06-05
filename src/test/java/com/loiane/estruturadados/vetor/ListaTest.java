package com.loiane.estruturadados.vetor;

import static org.junit.Assert.*;

import org.junit.Test;

import com.loiane.estruturadados.model.Contato;

public class ListaTest {

    @Test
    public void deveConfigurarOTamanhoDoVetor() {
        Lista<String> lista = new Lista<String>(2);
        assertEquals(2, lista.getElementos().length);
    }

    @Test
    public void adicionaNovoElemento() {
        Lista<String> lista = new Lista<String>(2);
        boolean expected = lista.adiciona("elemento 01");
        assertEquals(true, expected);
    }

    @Test
    public void aumentaTamanhoDoVetorAoAdicionarNovoElemento() {
        Lista<Integer> lista = new Lista<Integer>(2);
        lista.adiciona(1);
        int expected = 1;
        assertEquals(expected, lista.tamanho());
    }

    @Test
    public void adicionaDoisNovosElementos() {
        Lista<Integer> lista = new Lista<Integer>(2);
        lista.adiciona(1);
        lista.adiciona(2);
        assertEquals(2, lista.tamanho());
        assertEquals(1,lista.getElementos()[0]);
        assertEquals(2,lista.getElementos()[1]);
    }

    @Test
    public void adicionaNovoElementoNaPosicaoZero() {
        Lista<Contato> lista = new Lista<Contato>(3);
        Contato c1 = new Contato("Nome1", "rua 1", "111-111");
        Contato c2 = new Contato("Nome2", "rua 2", "222-222");
        Contato c3 = new Contato("Nome3", "rua 3", "333-333");
        lista.adiciona(c2);
        lista.adiciona(c3);
        assertEquals(true, lista.adiciona(0, c1));
        assertEquals(0, lista.busca(c1));
        assertEquals(1, lista.busca(c2));
        assertEquals(2, lista.busca(c3));
    }

    @Test
    public void deveExibirOsElementosDoVetor() {
        Lista<Integer> lista = new Lista<Integer>(2);
        lista.adiciona(1);
        lista.adiciona(2);
        String expected = "[1, 2]";
        assertEquals(expected, lista.toString());
    }

    @Test
    public void deveExibirOsElementosDeUmVetorDeTamanhoZero() {
        Lista<Integer> lista = new Lista<Integer>(2);
        String expected = "[]";
        assertEquals(expected, lista.toString());
    }

    @Test
    public void buscaElementoPelaPosicao() {
        Lista<Contato> lista = new Lista<Contato>(3);
        Contato c1 = new Contato("Nome1", "rua 1", "111-111");
        Contato c2 = new Contato("Nome2", "rua 2", "222-222");
        Contato c3 = new Contato("Nome3", "rua 3", "333-333");
        lista.adiciona(c1);
        lista.adiciona(c2);
        lista.adiciona(c3);
        assertEquals(c2, lista.busca(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscaElementoPelaPosicaoMaiorQueTamanhoDoVetor() {
        Lista<Contato> lista = new Lista<Contato>(3);
        Contato c1 = new Contato("Nome1", "rua 1", "111-111");
        Contato c2 = new Contato("Nome2", "rua 2", "222-222");
        Contato c3 = new Contato("Nome3", "rua 3", "333-333");
        lista.adiciona(c1);
        lista.adiciona(c2);
        lista.adiciona(c3);
        assertEquals(c2, lista.busca(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscaElementoPelaPosicaoDeValorNegativo() {
        Lista<Contato> lista = new Lista<Contato>(3);
        Contato c1 = new Contato("Nome1", "rua 1", "111-111");
        Contato c2 = new Contato("Nome2", "rua 2", "222-222");
        Contato c3 = new Contato("Nome3", "rua 3", "333-333");
        lista.adiciona(c1);
        lista.adiciona(c2);
        lista.adiciona(c3);
        assertEquals(c2, lista.busca(-1));
    }

    @Test
    public void buscaElementoPeloValorExistente() {
        Lista<Contato> lista = new Lista<Contato>(3);
        Contato c1 = new Contato("Nome1", "rua 1", "111-111");
        Contato c2 = new Contato("Nome2", "rua 2", "222-222");
        Contato c3 = new Contato("Nome3", "rua 3", "333-333");
        lista.adiciona(c1);
        lista.adiciona(c2);
        lista.adiciona(c3);
        assertEquals(1, lista.busca(c2));
        assertEquals(0, lista.busca(c1));
        assertEquals(2, lista.busca(c3));
    }

    @Test
    public void buscaElementoPeloValorNaoExistente() {
        Lista<Contato> lista = new Lista<Contato>(3);
        Contato c1 = new Contato("Nome1", "rua 1", "111-111");
        Contato c2 = new Contato("Nome2", "rua 2", "222-222");
        lista.adiciona(c1);
        assertEquals(-1, lista.busca(c2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void adicionaNovoElementoNaPosicaoMenorQueZero() {
    Lista<Contato> lista = new Lista<Contato>(3);
        Contato c1 = new Contato("Nome1", "rua 1", "111-111");
        Contato c2 = new Contato("Nome2", "rua 2", "222-222");
        Contato c3 = new Contato("Nome3", "rua 3", "333-333");
        lista.adiciona(c1);
        lista.adiciona(c2);
        lista.adiciona(-2,c3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void adicionaNovoElementoNaPosicaoMaiorQueOTamanhoDoVetor() {
        Lista<Contato> lista = new Lista<Contato>(3);
        Contato c1 = new Contato("Nome1", "rua 1", "111-111");
        Contato c2 = new Contato("Nome2", "rua 2", "222-222");
        Contato c3 = new Contato("Nome3", "rua 3", "333-333");
        lista.adiciona(c1);
        lista.adiciona(c2);
        lista.adiciona(4, c3);
    }

    @Test
    public void aumentaOTmanhoDoVetorAoAdicionarNovoElementoNaPosicaoZero() {
        Lista<Double> lista = new Lista<Double>(3);
        lista.adiciona(2.0);
        lista.adiciona(3.0);
        assertEquals(true, lista.adiciona(0, 1.0));
    }

    @Test
    public void aumentaOTmanhoDoVetorAoAdicionarNovoElementoNoFinal() {
        Lista<Double> lista = new Lista<Double>(3);
        lista.adiciona(1.0);
        lista.adiciona(2.0);
        lista.adiciona(3.0);
        assertEquals(true, lista.adiciona(4.0));
    }


    @Test
    public void removeElementoDoVetorPorPosicao() {
        Lista<Double> lista = new Lista<Double>(3);
        lista.adiciona(1.0);
        lista.adiciona(2.0);
        lista.adiciona(3.0);

        lista.remove(0);
        assertEquals(2, lista.tamanho());
        assertEquals(new Double(2.0), lista.busca(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeElementoDoVetorPorPosicaoMaiorQueOTamanho() {
        Lista<Double> lista = new Lista<Double>(3);
        lista.adiciona(1.0);
        lista.adiciona(2.0);
        lista.adiciona(3.0);

        lista.remove(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeElementoDoVetorPorPosicaoNegativa() {
        Lista<Double> lista = new Lista<Double>(3);
        lista.adiciona(1.0);
        lista.adiciona(2.0);
        lista.adiciona(3.0);

        lista.remove(-1);
    }

    @Test
    public void removeElementoDoVetorPorElemento() {
        Lista<Double> lista = new Lista<Double>(3);
        lista.adiciona(1.0);
        lista.adiciona(2.0);
        lista.adiciona(3.0);

        lista.remove(2.0);
        assertEquals(2, lista.tamanho());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeElementoInexistenteDoVetor() {
        Lista<Double> lista = new Lista<Double>(3);
        lista.adiciona(1.0);
        lista.adiciona(2.0);
        lista.adiciona(3.0);

        lista.remove(4.0);
        assertEquals(3, lista.tamanho());
    }

    @Test
    public void verificaSeContemElemento() {
        Lista<Integer> lista = new Lista<Integer>(3);
        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);

        assertEquals(true, lista.contem(1));
    }

    @Test
    public void verificaSeNaoContemElemento() {
        Lista<Integer> lista = new Lista<Integer>(3);
        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);

        assertEquals(false, lista.contem(4));
    }

    @Test
    public void retornaOUltimoIndiceDoElementoPesquisadoNaLista() {
        Lista<Integer> lista = new Lista<Integer>(3);
        lista.adiciona(1);
        lista.adiciona(1);
        lista.adiciona(2);

        assertEquals(1, lista.ultimoIndice(1));
    }

    @Test
    public void retornaOUltimoIndiceDoElementoPesquisadoNaListaComDoisElementosRepetidos() {
        Lista<Integer> lista = new Lista<Integer>(3);
        lista.adiciona(1);
        lista.adiciona(1);

        assertEquals(1, lista.ultimoIndice(1));
    }

    @Test
    public void retornaMenosUmCasoAListaNaoPossuaOElemento() {
        Lista<Integer> lista = new Lista<Integer>(3);
        assertEquals(-1, lista.ultimoIndice(10));
    }

    @Test
    public void obtemUmElementoPassandoOindiceComoParametro() {
        Lista<Integer> lista = new Lista<Integer>(3);
        Integer n1 = new Integer(1);
        lista.adiciona(n1);
        lista.adiciona(2);
        lista.adiciona(3);
        assertEquals((Integer) 1, lista.obtem(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void obtemUmElementoPassandoOindiceInexistenteComoParametro() {
        Lista<Integer> lista = new Lista<Integer>(3);
        Integer n1 = new Integer(1);
        lista.adiciona(n1);
        lista.adiciona(2);
        lista.adiciona(3);
        lista.obtem(-1);
    }
}
