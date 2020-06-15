package com.loiane.estruturadados.fila;

import java.util.LinkedList;
import java.util.Queue;

public class FilaUsandoQueueAula23 {
    public static void main(String[] args) {
        // com o tipo Queue o bojeto fila não terá acesso ao metodos de LinkedList
        Queue<Integer> fila = new LinkedList<Integer>();
        
        fila.add(1);
        fila.add(2);
        
        System.out.println(fila);
        
        System.out.println(fila.peek());
        
        System.out.println(fila.remove());
        
        System.out.println(fila);
    }
}
