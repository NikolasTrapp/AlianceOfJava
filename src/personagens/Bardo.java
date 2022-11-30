package personagens;

import acoes.Efeito;
import equipamentos.Equipamento;

public class Bardo extends Personagem{


    public Bardo() {
        setNome("Bardo");
        setHpBase(110);
        setHp(getHpBase());
        setDanoBase(10);
        setMp(13);
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
