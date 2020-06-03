package com.loiane.estruturadados.vetor;

import static org.junit.Assert.*;

import org.junit.Test;

import com.loiane.estruturadados.model.Contato;

public class VetorObjectoTest {

	@Test
	public void deveConfigurarOTamanhoDoVetor() {
		VetorObjeto vetor = new VetorObjeto(2);
		assertEquals(2, vetor.getElementos().length);
	}

	@Test
	public void adicionaNovoElemento() {
		VetorObjeto vetor = new VetorObjeto(2);
		boolean expected = vetor.adiciona(1);
		assertEquals(true, expected);
	}

	@Test
	public void aumentaTamanhoDoVetorAoAdicionarNovoElemento() {
		VetorObjeto vetor = new VetorObjeto(2);
		vetor.adiciona(1);
		int expected = 1;
		assertEquals(expected, vetor.tamanho());
	}

	@Test
	public void adicionaDoisNovosElementos() {
		VetorObjeto vetor = new VetorObjeto(2);
		vetor.adiciona(1);
		vetor.adiciona(2);
		assertEquals(2, vetor.tamanho());
		assertEquals(1,vetor.getElementos()[0]);
		assertEquals(2,vetor.getElementos()[1]);
	}

	@Test
	public void adicionaNovoElementoNaPosicaoZero() {
		VetorObjeto vetor = new VetorObjeto(3);
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
		VetorObjeto vetor = new VetorObjeto(2);
		vetor.adiciona(1);
		vetor.adiciona(2);
		String expected = "[1, 2]";
		assertEquals(expected, vetor.toString());
	}

	@Test
	public void deveExibirOsElementosDeUmVetorDeTamanhoZero() {
		VetorObjeto vetor = new VetorObjeto(10);
		String expected = "[]";
		assertEquals(expected, vetor.toString());
	}

	@Test
	public void buscaElementoPelaPosicao() {
		VetorObjeto vetor = new VetorObjeto(3);
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
		VetorObjeto vetor = new VetorObjeto(3);
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
		VetorObjeto vetor = new VetorObjeto(3);
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
		VetorObjeto vetor = new VetorObjeto(3);
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
		VetorObjeto vetor = new VetorObjeto(3);
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		vetor.adiciona(c1);
		assertEquals(-1, vetor.busca(c2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaNovoElementoNaPosicaoMenorQueZero() {
		VetorObjeto vetor = new VetorObjeto(3);
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		Contato c3 = new Contato("Nome3", "rua 3", "333-333");
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(-2,c3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaNovoElementoNaPosicaoMaiorQueOTamanhoDoVetor() {
		VetorObjeto vetor = new VetorObjeto(3);
		Contato c1 = new Contato("Nome1", "rua 1", "111-111");
		Contato c2 = new Contato("Nome2", "rua 2", "222-222");
		Contato c3 = new Contato("Nome3", "rua 3", "333-333");
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(4, c3);
	}

	@Test
	public void aumentaOTmanhoDoVetorAoAdicionarNovoElementoNaPosicaoZero() {
		VetorObjeto vetor = new VetorObjeto(3);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);
		vetor.adiciona(3.0);
		assertEquals(true, vetor.adiciona(0, 1.0));
	}

	@Test
	public void aumentaOTmanhoDoVetorAoAdicionarNovoElementoNoFinal() {
		VetorObjeto vetor = new VetorObjeto(3);
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);
		assertEquals(true, vetor.adiciona(4.0));
	}


	@Test
	public void removeElementoDoVetorPorPosicao() {
		VetorObjeto vetor = new VetorObjeto(3);
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);

		vetor.remove(0);
		assertEquals(2, vetor.tamanho());
		assertEquals(2.0, vetor.busca(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeElementoDoVetorPorPosicaoMaiorQueOTamanho() {
		VetorObjeto vetor = new VetorObjeto(3);
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);

		vetor.remove(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeElementoDoVetorPorPosicaoNegativa() {
		VetorObjeto vetor = new VetorObjeto(3);
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);

		vetor.remove(-1);
	}

	@Test
	public void removeElementoDoVetorPorElemento() {
		VetorObjeto vetor = new VetorObjeto(3);
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);

		vetor.remove(2.0);
		assertEquals(2, vetor.tamanho());
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeElementoInexistenteDoVetor() {
		VetorObjeto vetor = new VetorObjeto(3);
		vetor.adiciona(1.0);
		vetor.adiciona(2.0);
		vetor.adiciona(3.0);

		vetor.remove(4.0);
		assertEquals(3, vetor.tamanho());
	}
}
