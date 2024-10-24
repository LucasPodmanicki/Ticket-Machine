package br.calebe.ticketmachine;

import org.junit.jupiter.api.Test;

import br.calebe.ticketmachine.core.PapelMoeda;

import static org.junit.jupiter.api.Assertions.*;

public class PapelMoedaTest {

    @Test
    public void testCriacaoPapelMoeda() {
        PapelMoeda pm = new PapelMoeda(10, 5);
        assertEquals(10, pm.getValor());
        assertEquals(5, pm.getQuantidade());
    }

    @Test
    public void testValoresInvalidos() {
        PapelMoeda pm = new PapelMoeda(-10, -5);
        assertNotEquals(10, pm.getValor());
        assertNotEquals(5, pm.getQuantidade());
    }

    @Test
    public void testAlteracaoQuantidade() {
        PapelMoeda pm = new PapelMoeda(20, 3);
        assertEquals(3, pm.getQuantidade());
    }
}
