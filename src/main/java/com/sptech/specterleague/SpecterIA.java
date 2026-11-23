package com.sptech.specterleague;

import java.util.Objects;

/**
 * Contrato do duelista (+ estado compartilhado). Classe abstrata escolhida
 * em vez de interface porque energia, sincronia e memória são estado comum
 * a todas as classes; o ganho de comportamento fica em executarTurno().
 */
public abstract class SpecterIA {
    private static final int ENERGIA_MAXIMA = 100;

    private int energia;
    private boolean sincronizado;
    private final MemoriaDeCombate memoria; // composição: TEM UMA

    protected SpecterIA(MemoriaDeCombate memoria) {
        this.memoria = Objects.requireNonNull(memoria, "MemoriaDeCombate é obrigatória");
        this.energia = ENERGIA_MAXIMA;
        this.sincronizado = true;
    }

    /** Abstração + gancho de polimorfismo: cada subclasse responde diferente. */
    public abstract void executarTurno();

    public void receberDano(int valor) {
        if (valor <= 0 || !estaAtivo()) {
            return;
        }
        energia = Math.max(0, energia - valor);
        if (energia == 0) {
            marcarDesync("energia zerada");
        }
    }

    public boolean estaAtivo() {
        return energia > 0;
    }

    public boolean estaSincronizado() {
        return estaAtivo() && sincronizado;
    }

    public int getEnergia() {
        return energia;
    }

    public MemoriaDeCombate getMemoria() {
        return memoria;
    }

    /** Uso da composição: o specter delega o registro do turno à sua memória. */
    protected void registrarAcao(String acao) {
        memoria.registrar(acao);
    }

    protected boolean gastarEnergia(int custo) {
        if (custo < 0 || !estaAtivo()) {
            return false;
        }
        if (energia < custo) {
            energia = 0;
            marcarDesync("energia insuficiente para custo " + custo);
            return false;
        }
        energia -= custo;
        return true;
    }

    protected void recuperarEnergia(int quantia) {
        if (quantia <= 0 || !estaAtivo()) {
            return;
        }
        energia = Math.min(ENERGIA_MAXIMA, energia + quantia);
    }

    protected void marcarDesync(String motivo) {
        sincronizado = false;
        registrarAcao("DESYNC: " + motivo);
    }

    protected void estabilizarSincronia() {
        if (estaAtivo()) {
            sincronizado = true;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{energia=" + energia
                + ", sincronizado=" + estaSincronizado()
                + ", acoes=" + memoria.getTotalAcoes() + "}";
    }
}
