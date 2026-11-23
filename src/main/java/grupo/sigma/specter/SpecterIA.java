package grupo.sigma.specter;

import grupo.sigma.MemoriaDeCombate;

public abstract class SpecterIA {
    private int energia;
    private MemoriaDeCombate memoria; // composição: TEM UMA
    private Boolean sincronizado;

    public SpecterIA(MemoriaDeCombate memoria) {
        this.energia = 100;
        this.memoria = memoria;
    }

    public abstract void executarTurno(); // abstração + gancho de polimorfismo

    public void receberDano(int valor) {
        if (valor < 0) return;
        energia = Math.max(0, energia - valor);
    }

    public Boolean estaAtivo(){
        if (energia > 0){
            return true;
        }

        return false;
    }

    public int getEnergia() {
        return energia;
    }

    public MemoriaDeCombate getMemoria() {
        return memoria;
    }

    public Boolean getSincronizado() {
        return sincronizado;
    }



}
