package com.loiane.estruturadados.fila;

import static org.junit.Assert.*;

import org.junit.Test;

import com.loiane.estruturadados.pilha.Paciente;

public class FilaComPrioridadeTest {

    @Test
    public void deveOrdenarOAtendimentoPorPrioridade() {
        FilaComPrioridade<Paciente> fila = new FilaComPrioridade<Paciente>();
        fila.enfileira(new Paciente("A", 3));
        fila.enfileira(new Paciente("B", 1));
        fila.enfileira(new Paciente("C", 2));
        assertEquals("B", fila.espiar().getNome());
        fila.desenfileira();
        assertEquals("C", fila.espiar().getNome());
        fila.desenfileira();
        assertEquals("A", fila.espiar().getNome());
    }

}
