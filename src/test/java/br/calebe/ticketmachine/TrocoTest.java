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
}
