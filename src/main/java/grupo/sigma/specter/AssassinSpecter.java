package grupo.sigma.specter;

import grupo.sigma.MemoriaDeCombate;

public class AssassinSpecter extends SpecterIA {
    private int combosExecutados;

    public AssassinSpecter(MemoriaDeCombate memoria) {
        super(memoria);
    }

    public int getCombosExecutados() {
        return combosExecutados;
    }

    @Override
    public void executarTurno() {
        if (!gastarEnergia(45)) {
            return;
        }
        combosExecutados++;
        registrarAcao("Assassin entra em stealth e explode o combo " + combosExecutados + "!");
    }
}
