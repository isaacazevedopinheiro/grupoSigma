package grupo.sigma.specter;

import grupo.sigma.MemoriaDeCombate;

public class WardenSpecter extends SpecterIA {
    public WardenSpecter(MemoriaDeCombate memoria) {
        super(memoria);
    }

    @Override
    public void executarTurno() {
        estabilizarSincronia();
        if (!gastarEnergia(10)) {
            return;
        }
        recuperarEnergia(15);
        registrarAcao("Warden segura a linha e controla o ritmo");
    }
}
