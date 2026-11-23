package grupo.sigma;

import grupo.sigma.specter.SpecterIA;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<SpecterIA> specters = List.of(
                new WardenSpecter(new MemoriaDeCombate()),
                new AssassinSpecter(new MemoriaDeCombate()),
                new OverclockSpecter(new MemoriaDeCombate())
        );




        System.out.println();
    }
}


