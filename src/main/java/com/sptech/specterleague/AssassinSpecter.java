package com.sptech.specterleague;

/** Assassin: some, volta e explode o combo. */
public class AssassinSpecter extends SpecterIA {
    private int combosExecutados; // estado próprio, também encapsulado

    public AssassinSpecter(MemoriaDeCombate memoria) {
        super(memoria);
    }

    @Override
    public void executarTurno() {
        if (!gastarEnergia(25)) {
            return;
        }
        combosExecutados++;
        registrarAcao("Assassin: stealth -> combo #" + combosExecutados + " (-25 energia)");
    }

    public int getCombosExecutados() {
        return combosExecutados;
    }
}
