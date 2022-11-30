package personagens;

// Ladino, Mago, Paladino, Barbaro, Monge

// Zumbi, Esqueleto, Urso, Globin, Troll, Ork, Lobo

// Dragão, Golem, Rei Troll


import acoes.Efeito;

public class Guerreiro extends Personagem{


    public Guerreiro() {
    }

    public Guerreiro(int hp, String nome, int mp, int xp, int xpBar, int level, int danoBase, Efeito efeito) {
        super(hp, nome, mp, xp, xpBar, level, danoBase, efeito);
    }


    @Override
    public void mostrarAtaques() {

    }

    @Override
    public void mostrarAtributos() {

    }
}
