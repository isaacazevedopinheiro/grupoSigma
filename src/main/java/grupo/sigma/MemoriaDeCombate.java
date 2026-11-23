package grupo.sigma;

import java.util.List;

public class MemoriaDeCombate {
    private List<String> acoes;

    public void Registrar(String acao){
        acoes.add(acao);
    }

    public List<String> getAcoes() {
        return acoes;
    }

    public String getUltimaAcao(){
        return acoes.getLast();
    }


    public Integer getTotalAcoes(){
        Integer total = 0;
        for (String acoe : acoes) {
            total++;
        }

        return total;
    }


}
