package personagens;

// Ladino, Mago, Paladino, Barbaro, Monge

// Zumbi, Esqueleto, Urso, Globin, Troll, Ork, Lobo

// Dragão, Golem, Rei Troll


import acoes.Efeito;
import equipamentos.Equipamento;

public class Guerreiro extends Personagem{


    public Guerreiro() {
    }

    public Guerreiro(int hp, String nome, int mp, int danoBase, Efeito efeito) {
        super(hp, nome, mp, danoBase, efeito);
    }


    @Override
    public void mostrarAtaques() {

    }

    @Override
    public void mostrarAtributos() {

    }

    @Override
    public void tomarDano(int dano) {
        setHp(getHp()-dano);
    }
}
