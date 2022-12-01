package ataques;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaAtaques {

    public static ArrayList<AtaqueBasico> ataquesBasicos = new ArrayList<>(
            Arrays.asList(
                    new AtaqueBasico("Soco", 12, 5, 12, "Guerreiro", 1),
                    new AtaqueBasico("Chute", 15, 8, 10, "Guerreiro", 1),
                    new AtaqueBasico("Cabeçada", 20, 10, 10, "Guerreiro", 1),
                    new AtaqueBasico("Joelhada", 13, 10, 10, "Guerreiro", 1)
            )
    );
    public static ArrayList<AtaqueEspecial> ataqueEspecial = new ArrayList<>(
            Arrays.asList(
                    new AtaqueEspecial("Jogo sujo", 30, 1, 0, Efeito.NENHUM, 2, "Guerreiro", 1)
            )
    );

}
