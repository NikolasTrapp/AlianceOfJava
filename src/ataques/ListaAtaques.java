package ataques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import equipamentos.Equipamento;
import equipamentos.Raridade;
import equipamentos.Tipo;

public class ListaAtaques {


    public static ArrayList<Efeito> efeitos = new ArrayList<>(
            Arrays.asList(
                    new Efeito("Nenhum", 0, 99, TipoEfeito.ATAQUE),
                    new Efeito("Chamas", 2, 3, TipoEfeito.ATAQUE),
                    new Efeito("Sangramento",3, 3, TipoEfeito.ATAQUE),
                    new Efeito("Envenenamento", 2, 4, TipoEfeito.ATAQUE),
                    new Efeito("Decomposição", 4, 2, TipoEfeito.ATAQUE),
                    new Efeito("Congelamento", 0, 3, TipoEfeito.STATUS),
                    new Efeito("Paralizia", 0, 3, TipoEfeito.STATUS),
                    new Efeito("Atordoamento", 0, 3, TipoEfeito.STATUS),
                    new Efeito("Regeneração", 5, 2, TipoEfeito.BUFF),
                    new Efeito("Invencivel", 0, 1, TipoEfeito.BUFF),
                    new Efeito("Força divina", 10, 1, TipoEfeito.BUFF),
//                    new Efeito("Tirar efeito", 0, 1, TipoEfeito.BUFF),
                    new Efeito("Fraqueza", 2, 1, TipoEfeito.DEBUFF)
            )
    );

    public static ArrayList<AtaqueBasico> ataquesBasicos = new ArrayList<>(
            Arrays.asList(
                    new AtaqueBasico("Soco", 12, 5, 12, 0, new String[] {"Guerreiro", "Barbaro", "Monge"}, 1, pegarEfeito("Nenhum")),
                    new AtaqueBasico("Chute", 15, 5, 12, 0, new String[] {"Guerreiro", "Barbaro", "Monge"}, 1, pegarEfeito("Nenhum")),
                    new AtaqueBasico("Cajadada", 17, 5, 12, 0, new String[] {"Mago", "Bardo", "Monge", "Bardo", "Clérigo"}, 1, pegarEfeito("Nenhum")),
                    new AtaqueBasico("Espadada", 20, 5, 12, 0, new String[] {"Guerreiro"}, 1, pegarEfeito("Nenhum")),
                    new AtaqueBasico("Facada", 16, 5, 12, 0, new String[] {"Ladino"}, 1, pegarEfeito("Nenhum")),
                    new AtaqueBasico("Machadada", 21, 5, 12, 0, new String[] {"Barbaro"}, 1, pegarEfeito("Nenhum")),
                    new AtaqueBasico("Cabeçada", 11, 5, 12, 0, new String[] {"Barbaro", "Guerreiro", "Bardo"}, 2, pegarEfeito("Nenhum")),
                    new AtaqueBasico("Camaçada de pau", 19, 5, 12, 0, new String[] {"Mago", "Monje"}, 2, pegarEfeito("Nenhum")),
                    new AtaqueBasico("Investida", 13, 5, 12, 0, new String[] {"Mago", "Bardo"}, 1, pegarEfeito("Nenhum"))
            )
    );
    public static ArrayList<AtaqueEspecial> ataquesEspecial = new ArrayList<>(
            Arrays.asList(
                    new AtaqueEspecial("Golpe duplo", 60, 1, 0, 100, pegarEfeito("Nenhum"), 6, new String[] {"Monge", "Guerreiro", "Barbaro"}, 1),
                    new AtaqueEspecial("Nocoute", 40, 1, 0, 100, pegarEfeito("Atordoamento"), 6, new String[] {"Monge", "Guerreiro", "Barbaro"}, 3),
                    new AtaqueEspecial("Adormecer", 35, 1, 0, 100, pegarEfeito("Atordoamento"), 6, new String[] {"Monge", "Guerreiro", "Barbaro"}, 4),
                    new AtaqueEspecial("Jogo sujo", 55, 1, 0, 100, pegarEfeito("Nenhum"), 6, new String[] {"Ladino"}, 1),
                    new AtaqueEspecial("Ataque giratório", 57, 1, 0, 100, pegarEfeito("Nenhum"), 6, new String[] {"Barbaro"}, 5),
                    new AtaqueEspecial("Bola de fogo", 40, 1, 0, 100, pegarEfeito("Chamas"), 6, new String[] {"Mago"}, 1),
                    new AtaqueEspecial("Espinhos de gelo", 59, 1, 0, 100, pegarEfeito("Congelamento"), 6, new String[] {"Mago"}, 1),
                    new AtaqueEspecial("Purificação", 37, 1, 0, 100, pegarEfeito("Regeneração"), 6, new String[] {"Clérigo"}, 1),
                    new AtaqueEspecial("Envenenar", 45, 1, 0, 100, pegarEfeito("Envenenamento"), 6, new String[] {"Clérigo"}, 1),
                    new AtaqueEspecial("Cantar", 33, 1, 0, 100, pegarEfeito("Atordoamento"), 6, new String[] {"Bardo"}, 1),
                    new AtaqueEspecial("Sangramento", 52, 1, 0, 100, pegarEfeito("Sangramento"), 6, new String[] {"Ladino"}, 1)
            )
    );

    public static ArrayList<Ataque> ataquesBoss = new ArrayList<>(Arrays.asList(
            new AtaqueBasico("Golpe de pedra", 5, 0, 0, 0, new String[]{"Golem"}, 0, pegarEfeito("Nenhum")),
            new AtaqueBasico("Empurrão", 3, 10, 0, 0, new String[]{"Golem", "Rei troll"}, 0, pegarEfeito("Nenhum")),
            new AtaqueEspecial("Deslizamento de pedra", 15, 0, 0, 0,  pegarEfeito("Nenhum"), 0, new String[]{"Golem"}, 0),
            new AtaqueEspecial("Grito", 0, 0, 10, 0,  pegarEfeito("Atordoamento"), 0, new String[]{"Golem"}, 0),
            new AtaqueBasico("Espadada", 5, 0, 10, 0, new String[]{"Rei troll"}, 0, pegarEfeito("Sangramento")),
            new AtaqueEspecial("Envenenar", 3, 0, 15, 0,  pegarEfeito("Envenenamento"), 0, new String[]{"Rei troll"}, 0),
            new AtaqueBasico("Evadir", 3, 0, 15, 0, new String[]{"Rei troll"}, 0, pegarEfeito("Invencivel")),
            new AtaqueBasico("Mordida", 8, 0, 0, 0, new String[]{"Dragão"}, 0, pegarEfeito("Nenhum")),
            new AtaqueBasico("Arranhão", 8, 0, 15, 0, new String[]{"Dragão"}, 0, pegarEfeito("Sangramento")),
            new AtaqueEspecial("Bola de fogo", 8, 0, 15, 0,  pegarEfeito("Chamas"), 0, new String[]{"Dragão"}, 0),
            new AtaqueEspecial("Espinhos de gelo", 10, 1, 0, 100, pegarEfeito("Congelamento"), 6, new String[] {"Dragão"}, 1)
    ));

    public static ArrayList<Equipamento> equipamentos = new ArrayList<>(Arrays.asList(
            new Equipamento(Tipo.ATAQUE, "Espada de madeira", 3, 3, Raridade.COMUM),
            new Equipamento(Tipo.ATAQUE, "Espada de ferro", 4, 5, Raridade.INCOMUM),
            new Equipamento(Tipo.ATAQUE, "Espada de obisidana", 5, 7, Raridade.RARO),
            new Equipamento(Tipo.ATAQUE, "Luva de ferro", 3, 3, Raridade.EPICO),
            new Equipamento(Tipo.DEFESA, "Armadura de couro", 3, 3, Raridade.COMUM),
            new Equipamento(Tipo.DEFESA, "Armadura de malha", 4, 5, Raridade.INCOMUM),
            new Equipamento(Tipo.DEFESA, "Armadura de ferro", 5, 7, Raridade.RARO),
            new Equipamento(Tipo.DEFESA, "Helmo divino", 3, 15, Raridade.LENDARIO),
            new Equipamento(Tipo.ATAQUE, "Poção de força", 1, 30, Raridade.INCOMUM),
            new Equipamento(Tipo.CURA, "Poção de cura", 3, 15, Raridade.COMUM),
            new Equipamento(Tipo.CURA, "Poção de cura média", 3, 20, Raridade.INCOMUM),
            new Equipamento(Tipo.CURA, "Poção de cura grande", 3, 25, Raridade.RARO),
            new Equipamento(Tipo.ATAQUE, "Arco e flecha", 2, 8, Raridade.INCOMUM),
            new Equipamento(Tipo.DEFESA, "Manto divino", 3, 20, Raridade.EPICO),
            new Equipamento(Tipo.CURA, "Flauta sagrada", 4, 10, Raridade.COMUM)
    ));

    public static Efeito pegarEfeito(String nome){
        /**
         * Esta função recebe o nome do efeito como parâmetro e o encontra na lista de efeitos.
         *
         * @param nome O nome do efeito desejado.
         *
         * @return Um clone do efeito escolhido.
         */
        return efeitos.stream().filter(efeito -> efeito.getNome().equalsIgnoreCase(nome)).collect(Collectors.toCollection(ArrayList::new)).get(0);
    }

}