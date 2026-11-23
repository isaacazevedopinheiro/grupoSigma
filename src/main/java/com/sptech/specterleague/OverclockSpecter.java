package com.sptech.specterleague;

/** Overclock (bônus): arrisca tudo pela velocidade. */
public class OverclockSpecter extends SpecterIA {
    private int aceleracoes;

    public OverclockSpecter(MemoriaDeCombate memoria) {
        super(memoria);
    }

    @Override
    public void executarTurno() {
        if (!gastarEnergia(40)) {
            return;
        }
        aceleracoes++;
        registrarAcao("Overclock: clock em " + aceleracoes + "x, arrisca tudo (-40 energia)");
        if (getEnergia() < 20) {
            marcarDesync("clock estourou no turno " + aceleracoes);
        }
    }

    public int getAceleracoes() {
        return aceleracoes;
    }
}
