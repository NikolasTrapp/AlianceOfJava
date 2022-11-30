package personagens;

import acoes.Efeito;
import equipamentos.Equipamento;

public class Ladino extends Personagem{


    public Ladino() {
    }

    public Ladino(int hp, String nome, int mp, int danoBase, Efeito efeito) {
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


