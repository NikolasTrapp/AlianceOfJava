package ataques;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaAtaques {

    public static ArrayList<AtaqueBasico> ataquesBasicos = new ArrayList<>(
            Arrays.asList(
                    new AtaqueBasico("Soco", 12, 5, 12, "Guerreiro"),
                    new AtaqueBasico("Chute", 15, 8, 10, "Guerreiro")
            )
    );
    public static ArrayList<AtaqueEspecial> ataqueEspecial = new ArrayList<>();

}
