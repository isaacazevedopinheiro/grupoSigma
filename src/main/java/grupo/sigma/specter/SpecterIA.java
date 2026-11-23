package grupo.sigma.specter;

import grupo.sigma.MemoriaDeCombate;
import java.util.Objects;

public abstract class SpecterIA {
    private static final int ENERGIA_MAXIMA = 100;

    private int energia;
    private boolean sincronizado;
    private final MemoriaDeCombate memoria;

    public SpecterIA(MemoriaDeCombate memoria) {
        this.memoria = Objects.requireNonNull(memoria, "memoria não pode ser nula");
        this.energia = ENERGIA_MAXIMA;
        this.sincronizado = true;
    }

    public abstract void executarTurno();

    public void receberDano(int valor) {
        if (valor <= 0 || !estaAtivo()) {
            return;
        }
        energia = Math.max(0, energia - valor);
        if (energia == 0) {
            marcarDesync("energia esgotada por dano");
            return;
        }
        registrarAcao("Dano recebido: " + valor + " | energia restante: " + energia);
    }

    public boolean estaAtivo() {
        return energia > 0 && sincronizado;
    }

    public boolean estaSincronizado() {
        return sincronizado;
    }

    public MemoriaDeCombate getMemoria() {
        return memoria;
    }

    protected boolean gastarEnergia(int custo) {
        if (custo <= 0 || !estaAtivo()) {
            return false;
        }
        if (custo > energia) {
            energia = 0;
            marcarDesync("energia insuficiente para o turno");
            return false;
        }
        energia -= custo;
        if (energia == 0) {
            marcarDesync("energia esgotada no turno");
            return false;
        }
        return true;
    }

    protected void recuperarEnergia(int valor) {
        if (valor <= 0 || !sincronizado) {
            return;
        }
        energia = Math.min(ENERGIA_MAXIMA, energia + valor);
    }

    protected void registrarAcao(String acao) {
        memoria.registrar(acao);
    }

    protected void marcarDesync(String motivo) {
        sincronizado = false;
        registrarAcao("DESYNC: " + motivo);
    }

    protected void estabilizarSincronia() {
        if (energia > 0 && !sincronizado) {
            sincronizado = true;
            registrarAcao("Sincronia estabilizada");
        }
    }
}
