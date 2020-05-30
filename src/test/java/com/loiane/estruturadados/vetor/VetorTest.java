package com.loiane.estruturadados.vetor;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class VetorTest {
	@Test
	public void deveConfigurarOTamanhoNoConstrutor() {
		int expected = 5;
		Vetor vetor = new Vetor(5);

		assertEquals(expected, vetor.getElementos().length);
	}
	
	@Test
	public void adicionaNovoElemento() {
		String expected = "elemento 01";
		Vetor vetor = new Vetor(5);
		vetor.adiciona("elemento 01");
		
		assertEquals(expected, vetor.getElementos()[0]);
	}
	
	@Test
	public void adicionaDoisNovosElementos() {
		String expectedElement1 = "elemento 01";
		String expectedElement2 = "elemento 02";
		Vetor vetor = new Vetor(2);
		vetor.adiciona("elemento 01");
		vetor.adiciona("elemento 02");
		
		assertEquals(expectedElement1, vetor.getElementos()[0]);
		assertEquals(expectedElement2, vetor.getElementos()[1]);
	}
	
	@Test
	public void deveMostrarOTamanhoDeElementosOcupadosNoVetor() {
		Vetor vetor = new Vetor(5);
		vetor.adiciona("elemnto 01");
		vetor.adiciona("elemnto 02");
		assertEquals(2, vetor.tamanho());
	}
	
	@Test
	public void deveExibirOsElementosDoVetor() {
		Vetor vetor = new Vetor(5);
		vetor.adiciona("elemento 01");
		vetor.adiciona("elemento 02");
		String expected = "[elemento 01, elemento 02]";
		assertEquals(expected, vetor.toString());
	}
	
	@Test
	public void deveExibirOsElementosDeUmVetorDeTamanhoZero() {
		Vetor vetor = new Vetor(0);
//		vetor.adiciona("elemento 01");
//		vetor.adiciona("elemento 02");
		String expected = "[]";
		assertEquals(expected, vetor.toString());
	}

	@Test
	public void buscaElementoPelaPosicao() {
		Vetor vetor = new Vetor(3);
		vetor.adiciona("elemento 01");
		vetor.adiciona("elemento 02");
		vetor.adiciona("elemento 03");
		String expected = "elemento 01";
		assertEquals(expected, vetor.busca(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void buscaElementoPelaPosicaoInexistente() {
		Vetor vetor = new Vetor(3);
		vetor.busca(1);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void buscaElementoPelaPosicaoInexistente2() {
		Vetor vetor = new Vetor(3);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Posição inválida.");
		vetor.busca(9);
	}

	@Test
	public void buscaElementoPeloConteudoDoElementoExistente() {
		Vetor vetor = new Vetor(3);
		vetor.adiciona("elemento 01");
		vetor.adiciona("elemento 02");
		vetor.adiciona("elemento 03");
		int expected = 1;
		assertEquals(expected, vetor.busca("elemento 01"));
	}

	@Test
	public void buscaElementoPeloConteudoDoElementoNaoExistente() {
		Vetor vetor = new Vetor(3);
		vetor.adiciona("elemento 01");
		vetor.adiciona("elemento 02");
		vetor.adiciona("elemento 03");
		int expected = -1;
		assertEquals(expected, vetor.busca("elemento 00"));
	}
	
	@Test
	public void adicionaNovoElementoNaPosicaoZero() {
		Vetor vetor = new Vetor(10);
		vetor.adiciona("B");
		vetor.adiciona("C");
		boolean expected = true;
		assertEquals(expected, vetor.adiciona(0, "A"));
		assertEquals("A", vetor.busca(0));
		assertEquals(3, vetor.tamanho());
	}

	@Test
	public void adicionaNovoElementoNaPosicaoTres() {
		Vetor vetor = new Vetor(10);
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
		Vetor vetor = new Vetor(3);
		vetor.adiciona(4, "posição inexistente");
	}

	@Test
	public void adicionaNovoElementoNaPosicaoNaoExistente2() {
		Vetor vetor = new Vetor(10);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Posição inválida.");
		vetor.adiciona(11, "posição inexistente");
	}
	
	@Test
	public void adicionaMaisCapacidadeAoVetorAdicionandoElementoNoFinal() {
		Vetor vetor = new Vetor(3);
		vetor.adiciona("A");
		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("D");
		
		assertEquals(6, vetor.getElementos().length);
	}
	
	@Test
	public void adicionaMaisCapacidadeAoVetorAdicionandoElementoNaPosicaoZero() {
		Vetor vetor = new Vetor(3);
		vetor.adiciona(0, "A");
		vetor.adiciona(1, "B");
		vetor.adiciona(2, "C");
		vetor.adiciona(0, "D");

		assertEquals(6, vetor.getElementos().length);
	}
}



