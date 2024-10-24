package br.calebe.ticketmachine;

import org.junit.jupiter.api.Test;

import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;

import static org.junit.jupiter.api.Assertions.*;

public class TicketMachineTest {

    @Test
    public void testSaldoInicial() {
        TicketMachine tm = new TicketMachine(5);
        assertEquals(0, tm.getSaldo(), "O saldo inicial deve ser zero.");
    }

    @Test
    public void testInserirValorValido() {
        TicketMachine tm = new TicketMachine(5);
        try {
            tm.inserir(5);
            assertEquals(5, tm.getSaldo());
        } catch (PapelMoedaInvalidaException e) {
            fail("Exceção não esperada: " + e.getMessage());
        }
    }
}
