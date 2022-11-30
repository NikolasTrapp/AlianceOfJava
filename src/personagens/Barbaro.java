package personagens;

import acoes.Efeito;
import equipamentos.Equipamento;

public class Barbaro extends Personagem{



    public Barbaro() {
        setNome("Bárbaro");
        setHpBase(140);
        setHp(getHpBase());
        setDanoBase(18);
        setMp(10);
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

    @Override
    public String imprimirAtributos() {
        return String.format("%nNome: %s%nHP: %d%nDano base: %d%nMP: %d%n", getNome(), getHpBase(), getDanoBase(), getMp());
    }
}


