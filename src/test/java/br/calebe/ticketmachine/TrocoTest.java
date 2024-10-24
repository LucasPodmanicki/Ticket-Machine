package br.calebe.ticketmachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.calebe.ticketmachine.core.Troco;
import br.calebe.ticketmachine.core.PapelMoeda;
import java.util.Iterator;

public class TrocoTest {

    @Test
    public void testTroco100() {
        Troco troco = new Troco(100);
        Iterator<PapelMoeda> iterator = troco.getIterator();
        assertTrue(iterator.hasNext());
        PapelMoeda pm = iterator.next();
        assertEquals(100, pm.getValor());
        assertEquals(1, pm.getQuantidade());
    }

    @Test
    public void testTrocoZero() {
        Troco troco = new Troco(0);
        Iterator<PapelMoeda> iterator = troco.getIterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTrocoComValorMenorQueCédula() {
        Troco troco = new Troco(3);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        // O único valor que deve ser retornado é 2
        assertTrue(iterator.hasNext());
        PapelMoeda moeda2 = iterator.next();
        assertEquals(2, moeda2.getValor());
        assertEquals(1, moeda2.getQuantidade());
        
        // Não deve haver mais cédulas
        assertFalse(iterator.hasNext());
    }
}
