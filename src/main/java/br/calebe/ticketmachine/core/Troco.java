package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int[] valores = {100, 50, 20, 10, 5, 2};
        
        // Para cada valor de cédula disponível, calcular quantas cédulas são necessárias
        for (int i = 0; i < valores.length; i++) {
            int quantidade = valor / valores[i];
            if (quantidade > 0) {
                papeisMoeda[i] = new PapelMoeda(valores[i], quantidade);
                valor %= valores[i];  // Atualiza o valor restante
            }
        }
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;
        private int currentIndex = 5;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            while (currentIndex >= 0) {
                if (troco.papeisMoeda[currentIndex] != null) {
                    return true;
                }
                currentIndex--;
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            if (hasNext()) {
                ret = troco.papeisMoeda[currentIndex];
                troco.papeisMoeda[currentIndex] = null;
                currentIndex--;
            }
            return ret;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operação de remoção não suportada.");
        }
    }
}
