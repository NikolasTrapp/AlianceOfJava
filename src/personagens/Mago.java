package personagens;

import acoes.Efeito;
import equipamentos.Equipamento;

public class Mago extends Personagem{


    public Mago() {
        setNome("Mago");
        setHpBase(100);
        setHp(getHpBase());
        setDanoBase(12);
        setMp(15);
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

