package com.loiane.estruturadados.vetor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.loiane.estruturadados.model.Contato;

public class VetorObjectoTest {

    private VetorObjeto vetor;

    @Before
    public void init() {
        vetor = new VetorObjeto(2);
    }

	@Test
	public void deveConfigurarOTamanhoDoVetor() {
		assertEquals(2, vetor.getElementos().length);
	}

	@Test
	public void adicionaNovoElemento() {
		boolean expected = vetor.adiciona(1);
		assertEquals(true, expected);
	}

	@Test
	public void aumentaTamanhoDoVetorAoAdicionarNovoElemento() {
		vetor.adiciona(1);
		int expected = 1;
		assertEquals(expected, vetor.tamanho());
	}

	@Test
	public void adicionaDoisNovosElementos() {
		vetor.adiciona(1);
		vetor.adiciona(2);
		assertEquals(2, vetor.tamanho());
		assertEquals(1,vetor.getElementos()[0]);
		assertEquals(2,vetor.getElementos()[1]);
	}

	@Test
	public void adicionaNovoElementoNaPosicaoZero() {
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		Contato c3 = new Contato("Nome3", "rua 3", "333-333");
		vetor.adiciona(c2);
		vetor.adiciona(c3);
		assertEquals(true, vetor.adiciona(0, c1));
		assertEquals(0, vetor.busca(c1));
		assertEquals(1, vetor.busca(c2));
		assertEquals(2, vetor.busca(c3));
	}

	@Test
	public void deveExibirOsElementosDoVetor() {
		vetor.adiciona(1);
		vetor.adiciona(2);
		String expected = "[1, 2]";
		assertEquals(expected, vetor.toString());
	}

	@Test
	public void deveExibirOsElementosDeUmVetorDeTamanhoZero() {
		String expected = "[]";
		assertEquals(expected, vetor.toString());
	}

	@Test
	public void buscaElementoPelaPosicao() {
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		Contato c3 = new Contato("Nome3", "rua 3", "333-333");
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(c3);
		assertEquals(c2, vetor.busca(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void buscaElementoPelaPosicaoMaiorQueTamanhoDoVetor() {
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		Contato c3 = new Contato("Nome3", "rua 3", "333-333");
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(c3);
		assertEquals(c2, vetor.busca(4));
	}

	@Test(expected = IllegalArgumentException.class)
	public void buscaElementoPelaPosicaoDeValorNegativo() {
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		Contato c3 = new Contato("Nome3", "rua 3", "333-333");
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(c3);
		assertEquals(c2, vetor.busca(-1));
	}

	@Test
	public void buscaElementoPeloValorExistente() {
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		Contato c3 = new Contato("Nome3", "rua 3", "333-333");
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(c3);
		assertEquals(1, vetor.busca(c2));
		assertEquals(0, vetor.busca(c1));
		assertEquals(2, vetor.busca(c3));
	}

	@Test
	public void buscaElementoPeloValorNaoExistente() {
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		vetor.adiciona(c1);
		assertEquals(-1, vetor.busca(c2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaNovoElementoNaPosicaoMenorQueZero() {
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		Contato c3 = new Contato("Nome3", "rua 3", "333-333");
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(-2,c3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaNovoElementoNaPosicaoMaiorQueOTamanhoDoVetor() {
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		Contato c3 = new Contato("Nome3", "rua 3", "333-333");
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(4, c3);
	}

	@Test
	public void aumentaOTmanhoDoVetorAoAdicionarNovoElementoNaPosicaoZero() {
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);
		vetor.adiciona(3.0);
		assertEquals(true, vetor.adiciona(0, 1.0));
	}

	@Test
	public void aumentaOTmanhoDoVetorAoAdicionarNovoElementoNoFinal() {
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);
		assertEquals(true, vetor.adiciona(4.0));
	}


	@Test
	public void removeElementoDoVetorPorPosicao() {
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);

		vetor.remove(0);
		assertEquals(2, vetor.tamanho());
		assertEquals(2.0, vetor.busca(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeElementoDoVetorPorPosicaoMaiorQueOTamanho() {
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);

		vetor.remove(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeElementoDoVetorPorPosicaoNegativa() {
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);

		vetor.remove(-1);
	}

	@Test
	public void removeElementoDoVetorPorElemento() {
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);

		vetor.remove(2.0);
		assertEquals(2, vetor.tamanho());
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeElementoInexistenteDoVetor() {
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);

		vetor.remove(4.0);
		assertEquals(3, vetor.tamanho());
	}
}
