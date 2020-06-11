package com.loiane.estruturadados.pilha;

import static org.junit.Assert.*;
import org.junit.Test;

public class SimboloBalanceadoTest {
    @Test
    public void deveRetornarTrueSeAExpressaoForBalanceada() {
        String expressao1 = "(A+B)";
        String expressao2 = "A+B";
        assertEquals(true, SimboloBalanceado.verificar(expressao1));
        assertEquals(true, SimboloBalanceado.verificar(expressao2));
    }

    @Test
    public void deveRetornarFalseSeAExpressaoNaoForBalanceada() {
        String expressao1 = "(A+B]";
        String expressao2 = "(A+B[[])";
        String expressao3 = ")(A+B[[])";
        assertEquals(false, SimboloBalanceado.verificar(expressao1));
        assertEquals(false, SimboloBalanceado.verificar(expressao2));
        assertEquals(false, SimboloBalanceado.verificar(expressao3));
    }
}
