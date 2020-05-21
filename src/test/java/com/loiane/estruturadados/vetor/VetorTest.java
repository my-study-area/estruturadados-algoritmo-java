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

}



