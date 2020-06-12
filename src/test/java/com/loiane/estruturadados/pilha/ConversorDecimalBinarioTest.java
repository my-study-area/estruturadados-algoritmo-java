package com.loiane.estruturadados.pilha;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConversorDecimalBinarioTest {

    @Test
    public void deveConverterZeroEmDecimalParaBinario() {
        String expected = "0";
        assertEquals(expected, ConversorDecimalBinario.converter(0));
    }

    @Test
    public void deveConverterDezEmDecimalParaBinario() {
        String expected = "1010";
        assertEquals(expected, ConversorDecimalBinario.converter(10));
        assertEquals("11111100011", ConversorDecimalBinario.converter(2019));
        assertEquals("100101010000000111100000", ConversorDecimalBinario.converter(9765344));
        assertEquals("1", ConversorDecimalBinario.converter(1));
        assertEquals("10", ConversorDecimalBinario.converter(2));
    }
}
