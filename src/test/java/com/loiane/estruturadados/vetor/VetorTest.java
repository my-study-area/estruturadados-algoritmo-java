package com.loiane.estruturadados.vetor;

import static org.junit.Assert.*;

import org.junit.Test;

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

}



