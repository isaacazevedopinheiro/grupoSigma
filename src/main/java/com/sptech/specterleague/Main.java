package com.sptech.specterleague;

import java.util.List;

/** Simulação curta do re-run do Night Cap: mesma chamada, três comportamentos. */
public class Main {

    public static void main(String[] args) {
        List<SpecterIA> squad = List.of(
                new WardenSpecter(new MemoriaDeCombate()),
                new AssassinSpecter(new MemoriaDeCombate()),
                new OverclockSpecter(new MemoriaDeCombate())
        );

        System.out.println("=== Night Cap: re-run 23h59 ===");
        rodarTurno(squad, 1);
        aplicarDano(squad, 30);
        rodarTurno(squad, 2);
        aplicarDano(squad, 25);
        rodarTurno(squad, 3);

        System.out.println("\n=== Status final ===");
        squad.forEach(System.out::println);

        System.out.println("\n=== Memoria de combate (ultima acao) ===");
        for (SpecterIA specter : squad) {
            System.out.println("- " + specter.getClass().getSimpleName()
                    + ": " + specter.getMemoria().getUltimaAcao());
        }
    }

    private static void rodarTurno(List<SpecterIA> squad, int numero) {
        System.out.println("\n-- Turno " + numero + " --");
        for (SpecterIA specter : squad) {
            // POLIMORFISMO: referência do tipo base chamando executarTurno();
            // quem decide o comportamento é o objeto concreto da lista.
            specter.executarTurno();
            System.out.println("  " + specter);
        }
    }

    private static void aplicarDano(List<SpecterIA> squad, int valor) {
        System.out.println("\nAtaque adversario: -" + valor + " energia");
        for (SpecterIA specter : squad) {
            specter.receberDano(valor);
        }
    }
}
