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
	public void vetorJaEstaCheio() {
		Vetor vetor = new Vetor(1);
		
		assertEquals(true, vetor.adiciona("elemento 01"));
		assertEquals(false, vetor.adiciona("elemento 02"));
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
}



