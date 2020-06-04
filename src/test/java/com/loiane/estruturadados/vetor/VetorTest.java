package com.loiane.estruturadados.vetor;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class VetorTest {

    private Vetor vetor;

    @Before
    public void init() {
        vetor = new Vetor(5);
    }

	@Test
	public void deveConfigurarOTamanhoNoConstrutor() {
		int expected = 5;

		assertEquals(expected, vetor.getElementos().length);
	}

	@Test
	public void adicionaNovoElemento() {
		String expected = "elemento 01";
		vetor.adiciona("elemento 01");

		assertEquals(expected, vetor.getElementos()[0]);
	}

	@Test
	public void adicionaDoisNovosElementos() {
		String expectedElement1 = "elemento 01";
		String expectedElement2 = "elemento 02";
		vetor.adiciona("elemento 01");
		vetor.adiciona("elemento 02");

		assertEquals(expectedElement1, vetor.getElementos()[0]);
		assertEquals(expectedElement2, vetor.getElementos()[1]);
	}

	@Test
	public void deveMostrarOTamanhoDeElementosOcupadosNoVetor() {
		vetor.adiciona("elemnto 01");
		vetor.adiciona("elemnto 02");
		assertEquals(2, vetor.tamanho());
	}

	@Test
	public void deveExibirOsElementosDoVetor() {
		vetor.adiciona("elemento 01");
		vetor.adiciona("elemento 02");
		String expected = "[elemento 01, elemento 02]";
		assertEquals(expected, vetor.toString());
	}

	@Test
	public void deveExibirOsElementosDeUmVetorDeTamanhoZero() {
		String expected = "[]";
		assertEquals(expected, vetor.toString());
	}

	@Test
	public void buscaElementoPelaPosicao() {
		vetor.adiciona("elemento 01");
		vetor.adiciona("elemento 02");
		vetor.adiciona("elemento 03");
		String expected = "elemento 01";
		assertEquals(expected, vetor.busca(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void buscaElementoPelaPosicaoInexistente() {
		vetor.busca(1);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void buscaElementoPelaPosicaoInexistente2() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Posição inválida.");
		vetor.busca(9);
	}

	@Test
	public void buscaElementoPeloConteudoDoElementoExistente() {
		vetor.adiciona("elemento 01");
		vetor.adiciona("elemento 02");
		vetor.adiciona("elemento 03");
		int expected = 0;
		assertEquals(expected, vetor.busca("elemento 01"));
		assertEquals(1, vetor.busca("elemento 02"));
		assertEquals(2, vetor.busca("elemento 03"));
	}

	@Test
	public void buscaElementoPeloConteudoDoElementoNaoExistente() {
		vetor.adiciona("elemento 01");
		vetor.adiciona("elemento 02");
		vetor.adiciona("elemento 03");
		int expected = -1;
		assertEquals(expected, vetor.busca("elemento 00"));
	}

	@Test
	public void adicionaNovoElementoNaPosicaoZero() {
		vetor.adiciona("B");
		vetor.adiciona("C");
		boolean expected = true;
		assertEquals(expected, vetor.adiciona(0, "A"));
		assertEquals("A", vetor.busca(0));
		assertEquals(3, vetor.tamanho());
	}

	@Test
	public void adicionaNovoElementoNaPosicaoTres() {
		vetor.adiciona("A");
		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("E");
		boolean expected = true;
		assertEquals(expected, vetor.adiciona(3, "D"));
		assertEquals("D", vetor.busca(3));
		assertEquals(5, vetor.tamanho());
		assertEquals("E", vetor.busca(4));
	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaNovoElementoNaPosicaoNaoExistente() {
		vetor.adiciona(4, "posição inexistente");
	}

	@Test
	public void adicionaNovoElementoNaPosicaoNaoExistente2() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Posição inválida.");
		vetor.adiciona(11, "posição inexistente");
	}

	@Test
	public void adicionaMaisCapacidadeAoVetorAdicionandoElementoNoFinal() {
		vetor.adiciona("A");
		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("D");
		vetor.adiciona("E");
		vetor.adiciona("F");

		assertEquals(10, vetor.getElementos().length);
	}

	@Test
	public void adicionaMaisCapacidadeAoVetorAdicionandoElementoNaPosicaoZero() {
		vetor.adiciona(0, "A");
		vetor.adiciona(1, "B");
		vetor.adiciona(2, "C");
		vetor.adiciona(0, "D");

		assertEquals(5, vetor.getElementos().length);
	}

	@Test
	public void removeElementoDoVetorPorPosicao() {
		vetor.adiciona(0, "A");
		vetor.adiciona(1, "B");
		vetor.adiciona(2, "C");
		vetor.adiciona(3, "D");

		vetor.remove(0);
		assertEquals(3, vetor.tamanho());
		assertEquals(-1, vetor.busca("A"));
		assertEquals(0, vetor.busca("B"));
		assertEquals(1, vetor.busca("C"));
		assertEquals(2, vetor.busca("D"));
	}

	@Test
	public void removeElementoDoVetorPorTextoDoElemento() {
		vetor.adiciona(0, "A");
		vetor.adiciona(1, "B");
		vetor.adiciona(2, "C");
		vetor.adiciona(3, "D");

		vetor.remove("A");
		assertEquals(3, vetor.tamanho());
		assertEquals("B", vetor.getElementos()[0]);
		assertEquals("C", vetor.getElementos()[1]);
		assertEquals("D", vetor.getElementos()[2]);
	}
}
