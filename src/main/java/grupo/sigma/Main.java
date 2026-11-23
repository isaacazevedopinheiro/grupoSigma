package grupo.sigma;

import grupo.sigma.specter.AssassinSpecter;
import grupo.sigma.specter.OverclockSpecter;
import grupo.sigma.specter.SpecterIA;
import grupo.sigma.specter.WardenSpecter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SpecterIA> squad = List.of(
                new WardenSpecter(new MemoriaDeCombate()),
                new AssassinSpecter(new MemoriaDeCombate()),
                new OverclockSpecter(new MemoriaDeCombate())
        );

        for (int turno = 1; turno <= 3; turno++) {
            System.out.println("=== Turno " + turno + " ===");
            for (SpecterIA specter : squad) {
                specter.executarTurno();
                System.out.printf("%s | ativo=%s | sincronizado=%s | acoes=%d | ultima=%s%n",
                        specter.getClass().getSimpleName(),
                        specter.estaAtivo(),
                        specter.estaSincronizado(),
                        specter.getMemoria().getTotalAcoes(),
                        specter.getMemoria().getUltimaAcao());
            }
            System.out.println();
        }

        System.out.println("=== Resultado final ===");
        for (SpecterIA specter : squad) {
            System.out.printf("%s | ativo=%s | sincronizado=%s | historico=%s%n",
                    specter.getClass().getSimpleName(),
                    specter.estaAtivo(),
                    specter.estaSincronizado(),
                    specter.getMemoria().getAcoes());
        }
    }
}
