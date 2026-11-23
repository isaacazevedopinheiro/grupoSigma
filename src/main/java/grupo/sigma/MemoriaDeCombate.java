package grupo.sigma;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemoriaDeCombate {
    private final List<String> acoes = new ArrayList<>();

    public void registrar(String acao) {
        acoes.add(Objects.requireNonNull(acao, "acao não pode ser nula"));
    }

    public List<String> getAcoes() {
        return List.copyOf(acoes);
    }

    public String getUltimaAcao() {
        return acoes.isEmpty() ? "" : acoes.get(acoes.size() - 1);
    }

    public int getTotalAcoes() {
        return acoes.size();
    }
}
