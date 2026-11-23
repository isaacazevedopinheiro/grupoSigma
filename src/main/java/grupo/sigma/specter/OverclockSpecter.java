package grupo.sigma.specter;

import grupo.sigma.MemoriaDeCombate;

public class OverclockSpecter extends SpecterIA {
    private int aceleracoes;

    public OverclockSpecter(MemoriaDeCombate memoria) {
        super(memoria);
    }

    public int getAceleracoes() {
        return aceleracoes;
    }

    @Override
    public void executarTurno() {
        if (!gastarEnergia(50)) {
            return;
        }
        aceleracoes++;
        registrarAcao("Overclock arrisca tudo e acelera o round " + aceleracoes + "!");
    }
}
