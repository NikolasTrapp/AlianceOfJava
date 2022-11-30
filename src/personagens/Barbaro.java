package personagens;

import acoes.Efeito;
import equipamentos.Equipamento;

public class Barbaro extends Personagem{


    public Barbaro() {
    }

    public Barbaro(int hp, String nome, int mp, int danoBase, Efeito efeito) {
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


