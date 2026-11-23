package com.sptech.specterleague;

/** Warden: controla o ritmo, segura a linha e estabiliza o sync. */
public class WardenSpecter extends SpecterIA {

    public WardenSpecter(MemoriaDeCombate memoria) {
        super(memoria);
    }

    @Override
    public void executarTurno() {
        if (!estaAtivo()) {
            registrarAcao("Warden: fora de combate");
            return;
        }

        if (getEnergia() < 40) {
            recuperarEnergia(15);
            estabilizarSincronia();
            registrarAcao("Warden: segura a linha e estabiliza o sync (+15 energia)");
            return;
        }

        if (!gastarEnergia(5)) {
            return;
        }
        registrarAcao("Warden: barreira de ritmo absorve o impacto (-5 energia)");
    }
}
