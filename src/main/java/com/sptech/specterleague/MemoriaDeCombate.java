package com.sptech.specterleague;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Histórico de combate do specter: guarda o que aconteceu, sem conhecer
 * regras de classe, energia ou sincronia. Corpo e histórico separados.
 */
public class MemoriaDeCombate {
    private final List<String> acoes = new ArrayList<>();

    public void registrar(String acao) {
        if (acao == null || acao.isBlank()) {
            return;
        }
        acoes.add(acao.trim());
    }

    /** Cópia somente-leitura: ninguém fora da memória altera o histórico. */
    public List<String> getAcoes() {
        return Collections.unmodifiableList(acoes);
    }

    public String getUltimaAcao() {
        return acoes.isEmpty() ? "(sem ações registradas)" : acoes.get(acoes.size() - 1);
    }

    public int getTotalAcoes() {
        return acoes.size();
    }
}
