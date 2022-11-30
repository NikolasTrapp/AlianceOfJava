package personagens;

import acoes.Efeito;

public class Mago extends Personagem{


    public Mago() {
    }

    public Mago(int hp, String nome, int mp, int xp, int xpBar, int level, int danoBase, Efeito efeito) {
        super(hp, nome, mp, xp, xpBar, level, danoBase, efeito);
    }


    @Override
    public void mostrarAtaques() {

    }

    @Override
    public void mostrarAtributos() {

    }
}

